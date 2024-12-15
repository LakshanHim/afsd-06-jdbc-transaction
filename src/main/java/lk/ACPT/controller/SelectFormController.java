package lk.ACPT.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SelectFormController {

    @FXML
    private AnchorPane root1;

    @FXML
    void btnVehi(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root1.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Select-type.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

    }

}
