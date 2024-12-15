package lk.ACPT.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ACPT.dto.OrderDetailDto;
import lk.ACPT.dto.OrderDto;
import lk.ACPT.dto.VehicleDto;
import lk.ACPT.model.OrderModel;
import lk.ACPT.model.VehicleModel;
import lk.ACPT.tm.ItemTM;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController {
    @FXML
    private AnchorPane root5;

    @FXML
    private TextField txtids;

    @FXML
    private Label setValue;

    @FXML
    private TableView<ItemTM> tblCart;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtOnHand;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root5.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Select-type.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    private List<ItemTM> itemTMS;
    private ArrayList<OrderDetailDto> orderDetailDtos;

    private double subTotal = 0;

    @FXML
    void btnAddCart(ActionEvent event) {
        int qty = Integer.parseInt(txtQty.getText());
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        double unitPrice = Double.parseDouble(txtPrice.getText());
        int onHand = Integer.parseInt(txtOnHand.getText());
        double total = unitPrice * onHand;

        //update label
        subTotal+=total;
        setValue.setText("Subtotal: " + subTotal);


        itemTMS.add(new ItemTM(brand,model,qty,unitPrice,total));
        tblCart.setItems(FXCollections.observableList(itemTMS));


        int id = Integer.parseInt(txtids.getText());
        orderDetailDtos.add(new OrderDetailDto(id, onHand ,total));
    }

    @FXML
    void Search(ActionEvent event) {
        int id = Integer.parseInt(txtids.getText());
        VehicleDto search =  VehicleModel.SearchForm(id);
        txtBrand.setText(search.getBrand());
        txtModel.setText(search.getModel());
        txtQty.setText(String.valueOf(search.getQty()));
        txtPrice.setText(String.valueOf(search.getPrice()));
    }

    @FXML
    void btnPlaceOrder(ActionEvent event) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String format = formatter.format(date);

        try {
            boolean orderPlace = OrderModel.placeOrder(new OrderDto(format,subTotal,orderDetailDtos));
            if(orderPlace){
                System.out.println("Order Placed successfully");
            }
            else{
                System.out.println("Order Placed failed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void initialize() {
        tblCart.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblCart.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblCart.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblCart.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblCart.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));


        itemTMS = new ArrayList<>();
        orderDetailDtos = new ArrayList<>();
    }

}
