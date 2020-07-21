package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utility.UserData;

public class LoginController {

    @FXML
    private TextField tf_login;

    @FXML
    private PasswordField pf_login;
    @FXML
    void loginAction(ActionEvent event) {
        boolean isLogged = UserData.users.stream().anyMatch(
                user -> user.getEmail().equals(tf_login.getText())&&
                user.getPassword().equals(pf_login.getText()));
        if (isLogged){
            System.out.println("zalogowano");
            tf_login.setStyle(null);
            pf_login.setStyle(null);
        }else {
            System.out.println("niezalogowano");
            tf_login.clear();
            pf_login.clear();
            tf_login.setStyle("-fx-border-color:red; -fx-border-width:3px");
            pf_login.setStyle("-fx-border-color: red; -fx-border-width:3px");
        }
    }

}
