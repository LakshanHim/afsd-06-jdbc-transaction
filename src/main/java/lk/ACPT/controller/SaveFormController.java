package lk.ACPT.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ACPT.dto.VehicleDto;
import lk.ACPT.model.VehicleModel;

import java.io.IOException;
import java.sql.SQLException;


public class SaveFormController {

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
    private AnchorPane root3;

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root3.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Select-type.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    @FXML
    void btnSave(ActionEvent event) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(txtId.getText());
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());

        boolean b = VehicleModel.SaveForm(new VehicleDto(id,brand,model,qty,price));
        if (b) {
            System.out.println("data added...");
        }
        else {
            System.out.println("data not added...");
        }
    }

}
