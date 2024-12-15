package lk.ACPT.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class LoginPageController {

    @FXML
    private TextField txtName;

    @FXML
    private AnchorPane root;

    @FXML
    private PasswordField txtPass;

    @FXML
    void btnSign(ActionEvent event) throws IOException {
        String name = txtName.getText();
        String pass = txtPass.getText();

        String dbPassword = "password123";
        String dbUserName = "admin";

        if (pass.equals(dbPassword) && name.equals(dbUserName)) {
            Stage stage = (Stage) this.root.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Select-form.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } else {
            txtPass.clear();
            Stage stage = (Stage) txtName.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.setHeaderText("Error");
            alert.setContentText(" Enter password & username wrong ");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.out.println("ok");
            }

        }
    }

}