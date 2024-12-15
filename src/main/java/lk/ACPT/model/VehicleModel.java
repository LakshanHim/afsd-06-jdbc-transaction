package lk.ACPT.model;

import javafx.scene.control.Alert;
import lk.ACPT.db.DBConnection;
import lk.ACPT.dto.VehicleDto;
import lk.ACPT.tm.VehicleTM;

import java.sql.*;
import java.util.ArrayList;

public class VehicleModel {

    public static boolean SaveForm(VehicleDto vehicleDto) {
        //load driver class to RAM
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            //dynamic quary is
            // write sql quary
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vehicle value(?,?,?,?,?)");
            preparedStatement.setObject(1, vehicleDto.getId());
            preparedStatement.setObject(2, vehicleDto.getBrand());
            preparedStatement.setObject(3, vehicleDto.getModel());
            preparedStatement.setObject(4, vehicleDto.getQty());
            preparedStatement.setObject(5, vehicleDto.getPrice());

            //execute Quary
            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean DeleteForm(int id) {
        //load driver class to RAM
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            //dynamic quary is
            // write sql quary
            PreparedStatement preparedStatement = connection.prepareStatement("delete from vehicle where id = ?;");
            preparedStatement.setObject(1, id);

            //execute Quary
            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static VehicleDto SearchForm(int id) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicle where id=?");
            preparedStatement.setObject(1, id);

            //update quary eke anne resultSet ekek
            //return wenne boolean value ekek
            ResultSet resultSet = preparedStatement.executeQuery();

            VehicleDto dto = new VehicleDto();

            if (resultSet.next()) {
                       dto.setBrand(resultSet.getString(2));
                        dto.setModel(resultSet.getString(3));
                        dto.setQty(resultSet.getInt(4));
                        dto.setPrice(resultSet.getDouble(5));
            }
            return dto;
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("An error occurred");
            errorAlert.setContentText("Something went wrong. Please try again.");
            errorAlert.showAndWait();
        }
        return null;
    }

    public static boolean UpdateForm(VehicleDto vehicleDto) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            //dynamic quary is
            // write sql quary
            PreparedStatement preparedStatement = connection.prepareStatement("update vehicle set brand=?, model=?, qty=?, price=? where id=? ");
            preparedStatement.setObject(1,vehicleDto.getBrand());
            preparedStatement.setObject(2,vehicleDto.getModel());
            preparedStatement.setObject(3,vehicleDto.getQty());
            preparedStatement.setObject(4,vehicleDto.getPrice());
            preparedStatement.setObject(5,vehicleDto.getId());
            
            //execute Quary
            int i = preparedStatement.executeUpdate();

            if(i>0){
                return true;
            }
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("An error occurred");
            errorAlert.setContentText("Something went wrong. Please try again.");
            errorAlert.showAndWait();
        }
        return false;
    }

    public static ArrayList<VehicleTM> LoadForm() {
        ArrayList<VehicleTM> tms = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicle");
            //update quary eke anne resultSet ekek
            //return wenne boolean value ekek
            ResultSet resultSet = preparedStatement.executeQuery();

            //table object model danw

            while (resultSet.next()) {
                tms.add(new VehicleTM(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5)));
            }
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("An error occurred");
            errorAlert.setContentText("Something went wrong. Please try again.");
            errorAlert.showAndWait();
        }
        return tms;
    }
}


