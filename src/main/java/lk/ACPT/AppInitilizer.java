package lk.ACPT;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitilizer extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/Login-page.fxml"));
        Scene scene = new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}