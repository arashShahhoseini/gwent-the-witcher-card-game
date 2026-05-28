package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import view.History;
import view.Login;
import view.Main;
import view.Profile;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileController {
    @FXML
    private Label rank;
    @FXML
    private Label labelInvis;
    @FXML
    private TextField userNameCh;
    @FXML
    private TextField nickNameCh;
    @FXML
    private TextField emailCh;
    @FXML
    private PasswordField passwordCh;
    @FXML
    private PasswordField repeatPasswordCh;

    // information
    @FXML
    private Label losses;
    @FXML
    private Label wins;
    @FXML
    private Label draws;
    @FXML
    private Label matches;
    @FXML
    private Label topScore;
    @FXML
    private Label nickName;
    @FXML
    private Label userName;

    @FXML
    public void initialize() {
        // Add an event handler to the text field to handle the Enter key press
        userNameCh.setOnAction(event -> handleEnterKeyPressUserName());
        nickNameCh.setOnAction(event -> handleEnterKeyPressNickName());
        emailCh.setOnAction(event -> handleEnterKeyPressEmail());
        passwordCh.setOnAction(event -> handleEnterKeyPressPassword());
        repeatPasswordCh.setOnAction(event -> handleEnterKeyPressRepeatPasswordCh());

        User user = User.getLoggedInUser();
        userName.setText(user.getUsername());
        nickName.setText(user.getNickname());
        topScore.setText(Integer.toString(user.getHighestScore()));
        matches.setText(Integer.toString(user.getMatches()));
        draws.setText(Integer.toString(user.getDraws()));
        wins.setText(Integer.toString(user.getWins()));
        losses.setText(Integer.toString(user.getLoose()));
        rank.setText(Integer.toString(user.getRank()));
    }

    private void handleEnterKeyPressUserName() {
        // Duplicate name
        if (User.getUserByName(userNameCh.getText()) != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Duplicate username");
            alert.setContentText("please choose another username");
            alert.show();

            return;
        }
        // invalid username
        String regexPatternUsername = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$";
        if (!(getCommandMatcher(userNameCh.getText(), regexPatternUsername)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("invalid username");
            alert.setContentText("Username must contains uppercase, lowercase and number");
            alert.show();

            return;
        }

        User user = User.getLoggedInUser();
        user.setUsername(userNameCh.getText());
        initialize();
    }

    private void handleEnterKeyPressNickName() {
        User user = User.getLoggedInUser();
        user.setNickname(nickNameCh.getText());
        initialize();
    }

    private void handleEnterKeyPressEmail() {
        // invalid email
        String regexPatternEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!(getCommandMatcher(emailCh.getText(), regexPatternEmail)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("invalid email");
            alert.setContentText("please inout correct email");
            alert.show();

            return;
        }
        User user = User.getLoggedInUser();
        user.setEmail(emailCh.getText());
        initialize();
    }

    private void handleEnterKeyPressPassword() {
        repeatPasswordCh.requestFocus();
    }

    private void handleEnterKeyPressRepeatPasswordCh() {
        User user = User.getLoggedInUser();

        // invalid password
        String regexPatternPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*]).+$";
        if (!(getCommandMatcher(passwordCh.getText(), regexPatternPassword)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("invalid password");
            alert.setContentText("Password must contains uppercase, lowercase," +
                    " number and special character");
            alert.show();

            return;
        }
        // Weak password
        if (passwordCh.getText().length() < 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("Password length is less than 8");
            alert.show();

            return;
        }
        if (passwordCh.getText().chars().noneMatch(Character::isUpperCase)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("password doesnt have uppercase");
            alert.show();

            return;
        }
        if (passwordCh.getText().chars().noneMatch(Character::isLowerCase)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("password doesnt have lowercase");
            alert.show();

            return;
        }
        String regexPatternNumber = ".*\\d.*";
        if (!(getCommandMatcher(passwordCh.getText(), regexPatternNumber)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("password doesnt have number");
            alert.show();

            return;
        }
        String regexPatternSpecialCharacter = ".*[!@#$%^&*].*";
        if (!(getCommandMatcher(passwordCh.getText(), regexPatternSpecialCharacter)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("password without special character");
            alert.setHeaderText("please input at least one of this (!@#$%^&*)");
            alert.show();

            return;
        }

        // Password mismatch and its repetition:
        if ( !passwordCh.getText().equals(repeatPasswordCh.getText()) ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mismatch");
            alert.setContentText("repeat password mismatch to password");
            alert.show();

            return;
        }

        user.setPassword(passwordCh.getText());
        initialize();

    }

    public void openChanges() {
        labelInvis.setVisible(!labelInvis.isVisible());

        // username ch
        userNameCh.setVisible(!userNameCh.isVisible());

        // nickname ch
        nickNameCh.setVisible(!nickNameCh.isVisible());

        // email ch
        emailCh.setVisible(!emailCh.isVisible());

        // password ch
        passwordCh.setVisible(!passwordCh.isVisible());

        repeatPasswordCh.setVisible(!repeatPasswordCh.isVisible());
    }

    public void exitMenu() {
        Main main = new Main();
        try {
            main.start(Profile.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Matcher getCommandMatcher(String input, String regex) {

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(input);
    }

    public void history() throws Exception {
        History history = new History();
        history.start(Login.getStage());
    }
}