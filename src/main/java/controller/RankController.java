package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.User;
import view.Main;

import java.util.ArrayList;

public class RankController {

    @FXML
    private Button first;
    @FXML
    private Button second;
    @FXML
    private Button third;
    @FXML
    private Button forth;
    @FXML
    private Button fifth;
    @FXML
    private Button sixth;
    @FXML
    private Button seventh;
    @FXML
    private Button eighth;
    @FXML
    private Button ninth;
    @FXML
    private Button tenth;
    @FXML
    private void initialize() {
        User user = new User("ali", "", "", "", "", "");
        user.setHighestScore(5);
        User user2 = new User("mohsen", "", "", "", "", "");
        user2.setHighestScore(51);
        User user3 = new User("arash", "", "", "", "", "");
        user3.setHighestScore(10);
        User user4 = new User("reza", "", "", "", "", "");
        user4.setHighestScore(1);
        User user5 = new User("hossein", "", "", "", "", "");
        user5.setHighestScore(32);
        User user6 = new User("sahand", "", "", "", "", "");
        user6.setHighestScore(45);
        User user7 = new User("mohamad", "", "", "", "", "");
        user7.setHighestScore(4);
        User user8 = new User("gholam", "", "", "", "", "");
        user8.setHighestScore(11);
        User user9 = new User("avin", "", "", "", "", "");
        user9.setHighestScore(4);
        User user10 = new User("amin", "", "", "", "", "");
        user10.setHighestScore(21);

        setLeaderBoard();
    }

    private void setLeaderBoard() {

        ArrayList<User> players = sortByScores();

        int i = 0;
        for (User player:
                players) {
            if (i == 0)
                first.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            else if (i == 1)
                second.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            else if (i == 2)
                third.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            else if (i == 3)
                forth.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            else if (i == 4)
                fifth.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            else if (i == 5)
                sixth.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            else if (i == 6)
                seventh.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            else if (i == 7)
                eighth.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            else if (i == 8)
                ninth.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            else if (i == 9)
                tenth.setText(i + 1 + "." + player.getUsername() + " : " + player.getHighestScore());
            i ++;
        }
    }

    private ArrayList<User> sortByScores() {

        ArrayList<User> players = User.getAllUsers();

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {

                if (players.get(j).getHighestScore() > players.get(i).getHighestScore()) {

                    User temp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, temp);
                }
            }
        }

        return players;
    }

    public void back() {

        Main mainMenu = new Main();
        try {
            mainMenu.start(Main.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}