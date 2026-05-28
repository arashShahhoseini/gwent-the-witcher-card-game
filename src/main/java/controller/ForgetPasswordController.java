package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import view.ForgetPassword;
import view.Login;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// copied

public class ForgetPasswordController {
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField repeatNewPassword;
    @FXML
    private TextField username;
    @FXML
    private Label securityQuestion;
    @FXML
    private TextField securityAnswer;

    public void initialize() {
        securityAnswer.setOnAction(event -> handleEnterSecurityAnswer());
        repeatNewPassword.setOnAction(event -> handleEnterRepeatNewPassword());
    }

    private void handleEnterRepeatNewPassword() {
        User user = User.getUserByName(username.getText());
        // invalid password
        String regexPatternPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*]).+$";
        if (!(getCommandMatcher(newPassword.getText(), regexPatternPassword)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("invalid password");
            alert.setContentText("Password must contains uppercase, lowercase," +
                    " number and special character");
            alert.show();

            return;
        }
        // Weak password
        if (newPassword.getText().length() < 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("Password length is less than 8");
            alert.show();

            return;
        }
        if (newPassword.getText().chars().noneMatch(Character::isUpperCase)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("password doesnt have uppercase");
            alert.show();

            return;
        }
        if (newPassword.getText().chars().noneMatch(Character::isLowerCase)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("password doesnt have lowercase");
            alert.show();

            return;
        }
        String regexPatternNumber = ".*\\d.*";
        if (!(getCommandMatcher(newPassword.getText(), regexPatternNumber)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("password doesnt have number");
            alert.show();

            return;
        }
        String regexPatternSpecialCharacter = ".*[!@#$%^&*].*";
        if (!(getCommandMatcher(newPassword.getText(), regexPatternSpecialCharacter)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("password without special character");
            alert.setHeaderText("please input at least one of this (!@#$%^&*)");
            alert.show();

            return;
        }
        if (newPassword.getText().equals(repeatNewPassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Your password change successfully");
            alert.setContentText("your new password is"+newPassword.getText());
            alert.show();

            Login login = new Login();
            try {
                login.start(ForgetPassword.stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your repeat password is not new password");
            alert.setContentText("please try again");
            alert.show();
        }
    }

    private void handleEnterSecurityAnswer() {
        User user = User.getUserByName(username.getText());
        if (securityAnswer.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty answer");
            alert.setContentText("please input your answer");
            alert.show();
        } else if (user != null) {
            if (!user.getSecurityAnswer().equals(securityAnswer.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong answer");
                alert.setContentText("please input correct answer");
                alert.show();
            } else {
                newPassword.setVisible(true);
                repeatNewPassword.setVisible(true);
            }
        }

    }

    public void showQuestion() {
        User user = User.getUserByName(username.getText());
        if (user == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("don't exit account with this username");
            alert.setContentText("please input correct username");
            alert.show();
        } else {
            securityQuestion.setText(user.getSecurityQuestion());
            securityQuestion.setVisible(true);
            securityAnswer.setVisible(true);
        }
    }

    public void backToLogin() {
        Login login = new Login();
        try {
            login.start(ForgetPassword.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Matcher getCommandMatcher(String input, String regex) {

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(input);
    }
}