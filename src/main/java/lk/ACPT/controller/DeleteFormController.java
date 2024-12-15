package lk.ACPT.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ACPT.model.VehicleModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFormController {

    @FXML
    private TextField txtid;

    @FXML
    void btnCancle(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    private AnchorPane root4;

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root4.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Select-type.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    void btnDelete(ActionEvent event) {
        int id = Integer.parseInt(txtid.getText());

        boolean b= VehicleModel.DeleteForm(id);
        if (b) {
            System.out.println("Data Deleted");
        }
        else {
            System.out.println("Data Not Deleted");
        }


    }

}
