package controller;

import view.*;
import view.PreGameMenu;
import view.Profile;

public class MainController {

    public void goToGame() {
        PreGameMenu preGameMenu = new PreGameMenu();
        try {
            preGameMenu.start(Main.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void goToProfile() {
        Profile profile = new Profile();
        try {
            profile.start(Login.getStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void logOut() {
        Login login = new Login();
        try {
            login.start(Main.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ranking() {
        Rank rank = new Rank();
        try {
            rank.start(Login.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}