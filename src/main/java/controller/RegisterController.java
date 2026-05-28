package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;
import view.Login;
import view.Register;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// merged

public class RegisterController {
    @FXML
    private TextField nickName;
    @FXML
    private TextField email;
    @FXML
    private TextField answer1;
    @FXML
    private TextField answer2;
    @FXML
    private TextField answer3;
    @FXML
    private PasswordField repeatPassword;
    @FXML
    private PasswordField password;
    @FXML
    private TextField userName;

    @FXML
    public void initialize() {
        userName.setOnAction(event -> handleEnterKeyPressUserName());
        nickName.setOnAction(event -> handleEnterKeyPressNickName());
        email.setOnAction(event -> handleEnterKeyPressEmail());
        password.setOnAction(event -> handleEnterKeyPressPassword());
    }

    public void setUserName(String name) {
        userName.setText(name);
    }
    public String getUserName() {
        return userName.getText();
    }

    private void handleEnterKeyPressUserName() {
        nickName.requestFocus();
    }

    private void handleEnterKeyPressNickName() {
        email.requestFocus();
    }

    private void handleEnterKeyPressEmail() {
        password.requestFocus();
    }

    private void handleEnterKeyPressPassword() {
        repeatPassword.requestFocus();
    }

    public void register() {

        // Duplicate name
        if (User.getUserByName(userName.getText()) != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Duplicate username");
            alert.setContentText("please choose another username");
            alert.show();

            return;
        }
        // invalid username
        String regexPatternUsername = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$";
        if (!(getCommandMatcher(userName.getText(), regexPatternUsername)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("invalid username");
            alert.setContentText("Username must contains uppercase, lowercase and number");
            alert.show();

            return;
        }
        // invalid email
        String regexPatternEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!(getCommandMatcher(email.getText(), regexPatternEmail)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("invalid email");
            alert.setContentText("please inout correct email");
            alert.show();

            return;
        }
        // invalid password
        String regexPatternPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*]).+$";
        if (!(getCommandMatcher(password.getText(), regexPatternPassword)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("invalid password");
            alert.setContentText("Password must contains uppercase, lowercase," +
                    " number and special character");
            alert.show();

            return;
        }
        // Weak password
        if (password.getText().length() < 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("Password length is less than 8");
            alert.show();

            return;
        }
        if (password.getText().chars().noneMatch(Character::isUpperCase)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("password doesnt have uppercase");
            alert.show();

            return;
        }
        if (password.getText().chars().noneMatch(Character::isLowerCase)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("password doesnt have lowercase");
            alert.show();

            return;
        }
        String regexPatternNumber = ".*\\d.*";
        if (!(getCommandMatcher(password.getText(), regexPatternNumber)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("weak password");
            alert.setContentText("password doesnt have number");
            alert.show();

            return;
        }
        String regexPatternSpecialCharacter = ".*[!@#$%^&*].*";
        if (!(getCommandMatcher(password.getText(), regexPatternSpecialCharacter)).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("password without special character");
            alert.setHeaderText("please input at least one of this (!@#$%^&*)");
            alert.show();

            return;
        }

        // Password mismatch and its repetition:
        if ( !password.getText().equals(repeatPassword.getText()) ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mismatch");
            alert.setContentText("repeat password mismatch to password");
            alert.show();

            return;
        }
        String securityQuestion = "";
        String securityAnswer = "";
        boolean setSecurityQuestion = false;
        if (!answer1.getText().isEmpty()) {

            setSecurityQuestion = true;
            securityQuestion = "do have little sister ?";
            securityAnswer = answer1.getText();
        } else if (!answer2.getText().isEmpty()) {

            setSecurityQuestion = true;
            securityQuestion = "whats yours cars color ?";
            securityAnswer = answer2.getText();
        } else if (!answer3.getText().isEmpty()) {

            setSecurityQuestion = true;
            securityQuestion = "whats your favorite food ?";
            securityAnswer = answer3.getText();
        }
        if (!setSecurityQuestion) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Security Question");
            alert.setContentText("please set security question");
            alert.show();

            return;
        }

        new User(userName.getText(), password.getText(), nickName.getText(), email.getText()
                , securityQuestion, securityAnswer);

        userName.setText("");
        nickName.setText("");
        email.setText("");
        password.setText("");
        repeatPassword.setText("");
        answer1.setText("");
        answer2.setText("");
        answer3.setText("");

        Login login = new Login();
        try {
            login.start(Register.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Matcher getCommandMatcher(String input, String regex) {

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(input);
    }

    public void goToLoginMenu() {
        Login login = new Login();
        try {
            login.start(Register.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void generateRandomName() {
        int length = 8;
        String U = generateRandomString(length);
        userName.setText(U);
    }

    public void generateRandomPassword() {
        int length = 8;
        String P = generateRandomString(length);
        password.setText(P);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Password");
        alert.setHeaderText("password generated");
        alert.setContentText("your password is: " + P);
        alert.showAndWait();
    }

    private static String generateRandomString(int length) {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        String allChars = uppercaseLetters + lowercaseLetters + numbers + specialChars;

        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        password.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));
        password.append(lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        for (int i = 0; i < length - 4; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        List<Character> characters = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(characters, new SecureRandom());
        StringBuilder sb = new StringBuilder(characters.size());
        characters.forEach(sb::append);
        return sb.toString();
    }
}