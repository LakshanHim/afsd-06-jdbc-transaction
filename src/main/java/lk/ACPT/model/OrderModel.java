package lk.ACPT.model;

import lk.ACPT.db.DBConnection;
import lk.ACPT.dto.OrderDetailDto;
import lk.ACPT.dto.OrderDto;

import java.sql.*;

public class OrderModel {

    public static boolean placeOrder(OrderDto orderDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        //disable auto commit feature
        connection.setAutoCommit(false);

        PreparedStatement stm1 = connection.prepareStatement("insert into orders(orderDate,amount) values(?,?)", Statement.RETURN_GENERATED_KEYS);
        stm1.setObject(1,orderDto.getOrderDate());
        stm1.setObject(2,orderDto.getSubTotal());
        int orderSave  = stm1.executeUpdate();

        if (orderSave>0){

            ResultSet generatedKeys = stm1.getGeneratedKeys();

            if(generatedKeys.next()){
                int id= generatedKeys.getInt(1);

                //save-----> order details
                for(OrderDetailDto dto:orderDto.getOrderDetailDtos()){
                    PreparedStatement stm2 = connection.prepareStatement("insert into order_details(oid,vid,qty,price) values(?,?,?,?)");
                    stm2.setObject(1,id);
                    stm2.setObject(2,dto.getVehicleId());
                    stm2.setObject(3,dto.getQty());
                    stm2.setObject(4,dto.getPrice());

                    int orderDetailsSave = stm2.executeUpdate();

                    if (orderDetailsSave>0){
                        PreparedStatement stm3 = connection.prepareStatement("update vehicle set qty=qty-? where id=? ");
                        stm3.setObject(1,dto.getQty());
                        stm3.setObject(2,dto.getVehicleId());

                        int vehicletableUpdate = stm3.executeUpdate();
                        if (vehicletableUpdate<=0){
                            connection.rollback();
                            connection.setAutoCommit(true);
                            return false;
                        }
                    }
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

        }else{
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }


    }


}
