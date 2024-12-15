package lk.ACPT.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ACPT.model.VehicleModel;
import lk.ACPT.tm.VehicleTM;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadViewController {
// implements Initializable
    @FXML
    private TableView<VehicleTM> tblVehicle;

    @FXML
    private AnchorPane root6;

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root6.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Select-type.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    void btnLoad(ActionEvent event) {
        ArrayList<VehicleTM> tms =VehicleModel.LoadForm();
        //configure fx table
        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        tblVehicle.setItems(FXCollections.observableList(tms));

    }
    public void initialize() {
        // Load data for the TableView
        ArrayList<VehicleTM> tms = VehicleModel.LoadForm();

        // Configure TableView columns
        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        // Set data into the TableView
        tblVehicle.setItems(FXCollections.observableList(tms));
    }
//    @FXML
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afsd_06", "root", "acpt");
//
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicle");
//            //update quary eke anne resultSet ekek
//            //return wenne boolean value ekek
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            //table object model danw
//            ArrayList<VehicleTM> tms = new ArrayList<>();
//            while (resultSet.next()) {
//                tms.add(new VehicleTM(resultSet.getInt(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getInt(4),
//                        resultSet.getDouble(5)));
//            }
//            //configure fx table
//            tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
//            tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
//            tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
//            tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
//            tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
//
//            tblVehicle.setItems(FXCollections.observableList(tms));
//        } catch (Exception e) {
//            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
//            errorAlert.setHeaderText("An error occurred");
//            errorAlert.setContentText("Something went wrong. Please try again.");
//            errorAlert.showAndWait();
//        }
//    }


//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        // Load data for the TableView
//        ArrayList<VehicleTM> tms = VehicleModel.LoadForm();
//
//        // Configure TableView columns
//        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
//        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
//        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
//        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
//        tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
//
//        // Set data into the TableView
//        tblVehicle.setItems(FXCollections.observableList(tms));
//    }
}
