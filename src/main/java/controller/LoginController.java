package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utility.UserData;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utility.UserData;

import java.io.IOException;
import java.security.Key;

public class LoginController {
    @FXML
    private TextField tf_login;
    @FXML
    private PasswordField pf_login;
    // metoda dostarczająca logikę do logowania użytkownika
    private void login() throws IOException {
        boolean isLogged = UserData.users.stream()
                .anyMatch(user ->
                        user.getEmail().equals(tf_login.getText()) &&
                                user.getPassword().equals(pf_login.getText()));
        if(isLogged){
            System.out.println("zalogowano");
            tf_login.setStyle(null);
            pf_login.setStyle(null);
            //wywołanie nowego okna
            Stage primaryStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("/view/companyView.fxml"));
            // stawienie właściwości okna aplikacji
            primaryStage.setTitle("Logowanie");
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
            //zamknięcie okna logowania na obiekcie typu Stage
            Stage loginStage = (Stage) tf_login.getScene().getWindow();
            loginStage.close();
        } else {
            System.out.println("niezalogowano");
            tf_login.clear();
            pf_login.clear();
            tf_login.setStyle("-fx-border-color: red; -fx-border-width: 3px");
            pf_login.setStyle("-fx-border-color: red; -fx-border-width: 3px");
        }
    }
    @FXML   // kliknięcie na button (button)
    void loginAction(ActionEvent event) throws IOException {
        login();
    }
    @FXML   // wciśnięce Enter w dowolnym miejscu na oknie aplikacji (vbox)
    void keyLoginAction(KeyEvent event) throws IOException {
        if(event.getCode() == KeyCode.ENTER) {
            login();
        } else if(event.getCode() == KeyCode.ESCAPE){
            Platform.exit();    // zamknięcie okna aplikacji wywołanie metody close()
        }
    }
}
