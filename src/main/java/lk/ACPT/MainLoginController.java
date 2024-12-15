package lk.ACPT;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainLoginController {
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtName2;


    @FXML
    void save(ActionEvent event) {
//        String firstName = txtName.getText();
//        System.out.println(firstName);

        int num1 = Integer.parseInt(txtName.getText());
        int num2 = Integer.parseInt(txtName2.getText());

        int total = num1 + num2;
        System.out.println(total);
    }
}
