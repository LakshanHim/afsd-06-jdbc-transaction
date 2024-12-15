package lk.ACPT.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectTypeController {

    @FXML
    private AnchorPane root2;

    @FXML
    void btnAdd(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root2.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Save-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

    }

    @FXML
    void btnDelete(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root2.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Delete-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

    }

    @FXML
    void btnUpdate(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root2.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Update-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

    }

    @FXML
    void btnView(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root2.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Load-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

    }
    @FXML
    void btnOrder(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root2.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Order-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

    }

}
