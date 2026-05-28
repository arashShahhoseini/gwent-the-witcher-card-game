package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;

public class Login extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        Login.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Gwent");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        // make admin
        User.setLoggedInUser(new User("a", "a", "a", "a", "a", "a"));
    }

    public static Stage getStage() {
        return stage;
    }
}