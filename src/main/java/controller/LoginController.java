package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.User;
import view.*;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public void initialize() {
        username.setOnAction(event -> handleEnterKeyPressUserName());
        password.setOnAction(event -> {
            try {
                handleEnterKeyPressPassword();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

    private void handleEnterKeyPressPassword() throws Exception {
        login(null);
    }

    private void handleEnterKeyPressUserName() {
        password.requestFocus();
    }

    public void forgetPassword() {
        ForgetPassword forgetPassword = new ForgetPassword();
        try {
            forgetPassword.start(Login.getStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void login(MouseEvent mouseEvent) throws Exception {

        User user = User.getUserByName(username.getText());
        if (user == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong username");
            alert.setContentText("please enter correct username");
            alert.show();
        } else {
            if (!user.getPassword().equals(password.getText())) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong password");
                alert.setContentText("please enter correct password");
                alert.show();
            } else {
                User.setLoggedInUser(user);
                Main main  = new Main();
                main.start(Login.getStage());
            }
        }
    }

    public void register() {
        Register register = new Register();
        try {
            register.start(Login.getStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}