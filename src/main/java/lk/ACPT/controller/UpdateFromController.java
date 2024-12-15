package lk.ACPT.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ACPT.dto.VehicleDto;
import lk.ACPT.model.VehicleModel;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class UpdateFromController {

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    void btnCancle(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    private AnchorPane root5;

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root5.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Select-type.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    void btnSearch(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());

        VehicleDto dto =  VehicleModel.SearchForm(id);
        txtBrand.setText(dto.getBrand());
        txtModel.setText(dto.getModel());
        txtQty.setText(String.valueOf(dto.getQty()));
        txtPrice.setText(String.valueOf(dto.getPrice()));
    }


    @FXML
    void btnUpdate(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(txtPrice.getText());

        boolean b = VehicleModel.UpdateForm(new VehicleDto(id,brand, model, qty, price));

        if (b) {
            System.out.println("Updated....");
        }
        else {
            System.out.println("Not Updated....");
        }


    }

}
