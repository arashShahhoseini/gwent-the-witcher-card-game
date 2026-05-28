package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.HistoryData;
import model.User;
import view.Login;
import view.Main;

import java.util.ArrayList;

public class HistoryController {
    @FXML
    private Label enemy1;
    @FXML
    private Label date1;
    @FXML
    private Label yourScore1;
    @FXML
    private Label enemyScore1;
    @FXML
    private Label winner1;
    @FXML
    private Label enemy2;
    @FXML
    private Label date2;
    @FXML
    private Label yourScore2;
    @FXML
    private Label enemyScore2;
    @FXML
    private Label winner2;
    @FXML
    private Label enemy3;
    @FXML
    private Label date3;
    @FXML
    private Label yourScore3;
    @FXML
    private Label enemyScore3;
    @FXML
    private Label winner3;
    @FXML
    private Label enemy4;
    @FXML
    private Label date4;
    @FXML
    private Label yourScore4;
    @FXML
    private Label enemyScore4;
    @FXML
    private Label winner4;
    @FXML
    private Label enemy5;
    @FXML
    private Label date5;
    @FXML
    private Label yourScore5;
    @FXML
    private Label enemyScore5;
    @FXML
    private Label winner5;
    @FXML
    private Label enemy6;
    @FXML
    private Label date6;
    @FXML
    private Label yourScore6;
    @FXML
    private Label enemyScore6;
    @FXML
    private Label winner6;
    @FXML
    private Label enemy7;
    @FXML
    private Label date7;
    @FXML
    private Label yourScore7;
    @FXML
    private Label enemyScore7;
    @FXML
    private Label winner7;
    @FXML
    private Label enemy8;
    @FXML
    private Label date8;
    @FXML
    private Label yourScore8;
    @FXML
    private Label enemyScore8;
    @FXML
    private Label winner8;
    @FXML
    private Label enemy9;
    @FXML
    private Label date9;
    @FXML
    private Label yourScore9;
    @FXML
    private Label enemyScore9;
    @FXML
    private Label winner9;
    @FXML
    private Label enemy10;
    @FXML
    private Label date10;
    @FXML
    private Label yourScore10;
    @FXML
    private Label enemyScore10;
    @FXML
    private Label winner10;

    @FXML
    public void initialize() {
        int size;
        User user = User.getLoggedInUser();
        ArrayList<HistoryData> all = new ArrayList<>();
        all.add(new HistoryData("ali", "2024/1/4", 50, 12, "ali"));
        all.add(new HistoryData("arash", "2014/1/12", 50, 14, "arash"));
        all.add(new HistoryData("ahmad", "2023/10/4", 34, 123, "ahmad"));
        all.add(new HistoryData("gholam", "2024/6/4", 6, 12, "gholam"));
        all.add(new HistoryData("reza", "2023/1/4", 45, 3, "reza"));
        size = all.size();


        if (size == 1){
            enemy1.setText(all.get(0).getEnemyName());
            date1.setText(all.get(0).getDate());
            yourScore1.setText(String.valueOf(all.get(0).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(0).getEnemyScore()));
            winner1.setText(all.get(0).getWinner());

        } else if (size == 2) {
            enemy1.setText(all.get(size-1).getEnemyName());
            date1.setText(all.get(size-1).getDate());
            yourScore1.setText(String.valueOf(all.get(size-1).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(size-1).getEnemyScore()));
            winner1.setText(all.get(size-1).getWinner());
            // 2
            enemy2.setText(all.get(0).getEnemyName());
            date2.setText(all.get(0).getDate());
            yourScore2.setText(String.valueOf(all.get(0).getYourScore()));
            enemyScore2.setText(String.valueOf(all.get(0).getEnemyScore()));
            winner2.setText(all.get(0).getWinner());

        } else if (size == 3) {
            enemy1.setText(all.get(size-1).getEnemyName());
            date1.setText(all.get(size-1).getDate());
            yourScore1.setText(String.valueOf(all.get(size-1).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(size-1).getEnemyScore()));
            winner1.setText(all.get(size-1).getWinner());
            // 2
            enemy2.setText(all.get(size-2).getEnemyName());
            date2.setText(all.get(size-2).getDate());
            yourScore2.setText(String.valueOf(all.get(size-2).getYourScore()));
            enemyScore2.setText(String.valueOf(all.get(size-2).getEnemyScore()));
            winner2.setText(all.get(size-2).getWinner());
            // 3
            enemy3.setText(all.get(0).getEnemyName());
            date3.setText(all.get(0).getDate());
            yourScore3.setText(String.valueOf(all.get(0).getYourScore()));
            enemyScore3.setText(String.valueOf(all.get(0).getEnemyScore()));
            winner3.setText(all.get(0).getWinner());

        } else if (size == 4) {
            // 1
            enemy1.setText(all.get(size-1).getEnemyName());
            date1.setText(all.get(size-1).getDate());
            yourScore1.setText(String.valueOf(all.get(size-1).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(size-1).getEnemyScore()));
            winner1.setText(all.get(size-1).getWinner());
            // 2
            enemy2.setText(all.get(size-2).getEnemyName());
            date2.setText(all.get(size-2).getDate());
            yourScore2.setText(String.valueOf(all.get(size-2).getYourScore()));
            enemyScore2.setText(String.valueOf(all.get(size-2).getEnemyScore()));
            winner2.setText(all.get(size-2).getWinner());
            // 3
            enemy3.setText(all.get(size-3).getEnemyName());
            date3.setText(all.get(size-3).getDate());
            yourScore3.setText(String.valueOf(all.get(size-3).getYourScore()));
            enemyScore3.setText(String.valueOf(all.get(size-3).getEnemyScore()));
            winner3.setText(all.get(size-3).getWinner());
            // 4
            enemy4.setText(all.get(0).getEnemyName());
            date4.setText(all.get(0).getDate());
            yourScore4.setText(String.valueOf(all.get(0).getYourScore()));
            enemyScore4.setText(String.valueOf(all.get(0).getEnemyScore()));
            winner4.setText(all.get(0).getWinner());

        } else if (size == 5) {
            // 1
            enemy1.setText(all.get(size-1).getEnemyName());
            date1.setText(all.get(size-1).getDate());
            yourScore1.setText(String.valueOf(all.get(size-1).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(size-1).getEnemyScore()));
            winner1.setText(all.get(size-1).getWinner());
            // 2
            enemy2.setText(all.get(size-2).getEnemyName());
            date2.setText(all.get(size-2).getDate());
            yourScore2.setText(String.valueOf(all.get(size-2).getYourScore()));
            enemyScore2.setText(String.valueOf(all.get(size-2).getEnemyScore()));
            winner2.setText(all.get(size-2).getWinner());
            // 3
            enemy3.setText(all.get(size-3).getEnemyName());
            date3.setText(all.get(size-3).getDate());
            yourScore3.setText(String.valueOf(all.get(size-3).getYourScore()));
            enemyScore3.setText(String.valueOf(all.get(size-3).getEnemyScore()));
            winner3.setText(all.get(size-3).getWinner());
            // 4
            enemy4.setText(all.get(size-4).getEnemyName());
            date4.setText(all.get(size-4).getDate());
            yourScore4.setText(String.valueOf(all.get(size-4).getYourScore()));
            enemyScore4.setText(String.valueOf(all.get(size-4).getEnemyScore()));
            winner4.setText(all.get(size-4).getWinner());
            // 5
            enemy5.setText(all.get(0).getEnemyName());
            date5.setText(all.get(0).getDate());
            yourScore5.setText(String.valueOf(all.get(0).getYourScore()));
            enemyScore5.setText(String.valueOf(all.get(0).getEnemyScore()));
            winner5.setText(all.get(0).getWinner());

        } else if (size == 6) {
            // 1
            enemy1.setText(all.get(size-1).getEnemyName());
            date1.setText(all.get(size-1).getDate());
            yourScore1.setText(String.valueOf(all.get(size-1).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(size-1).getEnemyScore()));
            winner1.setText(all.get(size-1).getWinner());
            // 2
            enemy2.setText(all.get(size-2).getEnemyName());
            date2.setText(all.get(size-2).getDate());
            yourScore2.setText(String.valueOf(all.get(size-2).getYourScore()));
            enemyScore2.setText(String.valueOf(all.get(size-2).getEnemyScore()));
            winner2.setText(all.get(size-2).getWinner());
            // 3
            enemy3.setText(all.get(size-3).getEnemyName());
            date3.setText(all.get(size-3).getDate());
            yourScore3.setText(String.valueOf(all.get(size-3).getYourScore()));
            enemyScore3.setText(String.valueOf(all.get(size-3).getEnemyScore()));
            winner3.setText(all.get(size-3).getWinner());
            // 4
            enemy4.setText(all.get(size-4).getEnemyName());
            date4.setText(all.get(size-4).getDate());
            yourScore4.setText(String.valueOf(all.get(size-4).getYourScore()));
            enemyScore4.setText(String.valueOf(all.get(size-4).getEnemyScore()));
            winner4.setText(all.get(size-4).getWinner());
            // 5
            enemy5.setText(all.get(size-5).getEnemyName());
            date5.setText(all.get(size-5).getDate());
            yourScore5.setText(String.valueOf(all.get(size-5).getYourScore()));
            enemyScore5.setText(String.valueOf(all.get(size-5).getEnemyScore()));
            winner5.setText(all.get(size-5).getWinner());
            // 6
            enemy6.setText(all.get(0).getEnemyName());
            date6.setText(all.get(0).getDate());
            yourScore6.setText(String.valueOf(all.get(0).getYourScore()));
            enemyScore6.setText(String.valueOf(all.get(0).getEnemyScore()));
            winner6.setText(all.get(0).getWinner());

        } else if (size == 7) {
            // 1
            enemy1.setText(all.get(size-1).getEnemyName());
            date1.setText(all.get(size-1).getDate());
            yourScore1.setText(String.valueOf(all.get(size-1).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(size-1).getEnemyScore()));
            winner1.setText(all.get(size-1).getWinner());
            // 2
            enemy2.setText(all.get(size-2).getEnemyName());
            date2.setText(all.get(size-2).getDate());
            yourScore2.setText(String.valueOf(all.get(size-2).getYourScore()));
            enemyScore2.setText(String.valueOf(all.get(size-2).getEnemyScore()));
            winner2.setText(all.get(size-2).getWinner());
            // 3
            enemy3.setText(all.get(size-3).getEnemyName());
            date3.setText(all.get(size-3).getDate());
            yourScore3.setText(String.valueOf(all.get(size-3).getYourScore()));
            enemyScore3.setText(String.valueOf(all.get(size-3).getEnemyScore()));
            winner3.setText(all.get(size-3).getWinner());
            // 4
            enemy4.setText(all.get(size-4).getEnemyName());
            date4.setText(all.get(size-4).getDate());
            yourScore4.setText(String.valueOf(all.get(size-4).getYourScore()));
            enemyScore4.setText(String.valueOf(all.get(size-4).getEnemyScore()));
            winner4.setText(all.get(size-4).getWinner());
            // 5
            enemy5.setText(all.get(size-5).getEnemyName());
            date5.setText(all.get(size-5).getDate());
            yourScore5.setText(String.valueOf(all.get(size-5).getYourScore()));
            enemyScore5.setText(String.valueOf(all.get(size-5).getEnemyScore()));
            winner5.setText(all.get(size-5).getWinner());
            // 6
            enemy6.setText(all.get(size-6).getEnemyName());
            date6.setText(all.get(size-6).getDate());
            yourScore6.setText(String.valueOf(all.get(size-6).getYourScore()));
            enemyScore6.setText(String.valueOf(all.get(size-6).getEnemyScore()));
            winner6.setText(all.get(size-6).getWinner());
            // 7
            enemy7.setText(all.get(0).getEnemyName());
            date7.setText(all.get(0).getDate());
            yourScore7.setText(String.valueOf(all.get(0).getYourScore()));
            enemyScore7.setText(String.valueOf(all.get(0).getEnemyScore()));
            winner7.setText(all.get(0).getWinner());

        } else if (size == 8) {
            // 1
            enemy1.setText(all.get(size-1).getEnemyName());
            date1.setText(all.get(size-1).getDate());
            yourScore1.setText(String.valueOf(all.get(size-1).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(size-1).getEnemyScore()));
            winner1.setText(all.get(size-1).getWinner());
            // 2
            enemy2.setText(all.get(size-2).getEnemyName());
            date2.setText(all.get(size-2).getDate());
            yourScore2.setText(String.valueOf(all.get(size-2).getYourScore()));
            enemyScore2.setText(String.valueOf(all.get(size-2).getEnemyScore()));
            winner2.setText(all.get(size-2).getWinner());
            // 3
            enemy3.setText(all.get(size-3).getEnemyName());
            date3.setText(all.get(size-3).getDate());
            yourScore3.setText(String.valueOf(all.get(size-3).getYourScore()));
            enemyScore3.setText(String.valueOf(all.get(size-3).getEnemyScore()));
            winner3.setText(all.get(size-3).getWinner());
            // 4
            enemy4.setText(all.get(size-4).getEnemyName());
            date4.setText(all.get(size-4).getDate());
            yourScore4.setText(String.valueOf(all.get(size-4).getYourScore()));
            enemyScore4.setText(String.valueOf(all.get(size-4).getEnemyScore()));
            winner4.setText(all.get(size-4).getWinner());
            // 5
            enemy5.setText(all.get(size-5).getEnemyName());
            date5.setText(all.get(size-5).getDate());
            yourScore5.setText(String.valueOf(all.get(size-5).getYourScore()));
            enemyScore5.setText(String.valueOf(all.get(size-5).getEnemyScore()));
            winner5.setText(all.get(size-5).getWinner());
            // 6
            enemy6.setText(all.get(size-6).getEnemyName());
            date6.setText(all.get(size-6).getDate());
            yourScore6.setText(String.valueOf(all.get(size-6).getYourScore()));
            enemyScore6.setText(String.valueOf(all.get(size-6).getEnemyScore()));
            winner6.setText(all.get(size-6).getWinner());
            // 7
            enemy7.setText(all.get(size-7).getEnemyName());
            date7.setText(all.get(size-7).getDate());
            yourScore7.setText(String.valueOf(all.get(size-7).getYourScore()));
            enemyScore7.setText(String.valueOf(all.get(size-7).getEnemyScore()));
            winner7.setText(all.get(size-7).getWinner());
            // 8
            enemy8.setText(all.get(0).getEnemyName());
            date8.setText(all.get(0).getDate());
            yourScore8.setText(String.valueOf(all.get(0).getYourScore()));
            enemyScore8.setText(String.valueOf(all.get(0).getEnemyScore()));
            winner8.setText(all.get(0).getWinner());
        } else if (size == 9) {
            // 1
            enemy1.setText(all.get(size-1).getEnemyName());
            date1.setText(all.get(size-1).getDate());
            yourScore1.setText(String.valueOf(all.get(size-1).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(size-1).getEnemyScore()));
            winner1.setText(all.get(size-1).getWinner());
            // 2
            enemy2.setText(all.get(size-2).getEnemyName());
            date2.setText(all.get(size-2).getDate());
            yourScore2.setText(String.valueOf(all.get(size-2).getYourScore()));
            enemyScore2.setText(String.valueOf(all.get(size-2).getEnemyScore()));
            winner2.setText(all.get(size-2).getWinner());
            // 3
            enemy3.setText(all.get(size-3).getEnemyName());
            date3.setText(all.get(size-3).getDate());
            yourScore3.setText(String.valueOf(all.get(size-3).getYourScore()));
            enemyScore3.setText(String.valueOf(all.get(size-3).getEnemyScore()));
            winner3.setText(all.get(size-3).getWinner());
            // 4
            enemy4.setText(all.get(size-4).getEnemyName());
            date4.setText(all.get(size-4).getDate());

            yourScore4.setText(String.valueOf(all.get(size-4).getYourScore()));
            enemyScore4.setText(String.valueOf(all.get(size-4).getEnemyScore()));
            winner4.setText(all.get(size-4).getWinner());
            // 5
            enemy5.setText(all.get(size-5).getEnemyName());
            date5.setText(all.get(size-5).getDate());
            yourScore5.setText(String.valueOf(all.get(size-5).getYourScore()));
            enemyScore5.setText(String.valueOf(all.get(size-5).getEnemyScore()));
            winner5.setText(all.get(size-5).getWinner());
            // 6
            enemy6.setText(all.get(size-6).getEnemyName());
            date6.setText(all.get(size-6).getDate());
            yourScore6.setText(String.valueOf(all.get(size-6).getYourScore()));
            enemyScore6.setText(String.valueOf(all.get(size-6).getEnemyScore()));
            winner6.setText(all.get(size-6).getWinner());
            // 7
            enemy7.setText(all.get(size-7).getEnemyName());
            date7.setText(all.get(size-7).getDate());
            yourScore7.setText(String.valueOf(all.get(size-7).getYourScore()));
            enemyScore7.setText(String.valueOf(all.get(size-7).getEnemyScore()));
            winner7.setText(all.get(size-7).getWinner());
            // 8
            enemy8.setText(all.get(size-8).getEnemyName());
            date8.setText(all.get(size-8).getDate());
            yourScore8.setText(String.valueOf(all.get(size-8).getYourScore()));
            enemyScore8.setText(String.valueOf(all.get(size-8).getEnemyScore()));
            winner8.setText(all.get(size-8).getWinner());
            // 9
            enemy9.setText(all.get(0).getEnemyName());
            date9.setText(all.get(0).getDate());
            yourScore9.setText(String.valueOf(all.get(0).getYourScore()));
            enemyScore9.setText(String.valueOf(all.get(0).getEnemyScore()));
            winner9.setText(all.get(0).getWinner());
        } else if (size >= 10) {
            // 1
            enemy1.setText(all.get(size-1).getEnemyName());
            date1.setText(all.get(size-1).getDate());
            yourScore1.setText(String.valueOf(all.get(size-1).getYourScore()));
            enemyScore1.setText(String.valueOf(all.get(size-1).getEnemyScore()));
            winner1.setText(all.get(size-1).getWinner());
            // 2
            enemy2.setText(all.get(size-2).getEnemyName());
            date2.setText(all.get(size-2).getDate());
            yourScore2.setText(String.valueOf(all.get(size-2).getYourScore()));
            enemyScore2.setText(String.valueOf(all.get(size-2).getEnemyScore()));
            winner2.setText(all.get(size-2).getWinner());
            // 3
            enemy3.setText(all.get(size-3).getEnemyName());
            date3.setText(all.get(size-3).getDate());
            yourScore3.setText(String.valueOf(all.get(size-3).getYourScore()));
            enemyScore3.setText(String.valueOf(all.get(size-3).getEnemyScore()));
            winner3.setText(all.get(size-3).getWinner());
            // 4
            enemy4.setText(all.get(size-4).getEnemyName());
            date4.setText(all.get(size-4).getDate());
            yourScore4.setText(String.valueOf(all.get(size-4).getYourScore()));
            enemyScore4.setText(String.valueOf(all.get(size-4).getEnemyScore()));
            winner4.setText(all.get(size-4).getWinner());
            // 5
            enemy5.setText(all.get(size-5).getEnemyName());
            date5.setText(all.get(size-5).getDate());
            yourScore5.setText(String.valueOf(all.get(size-5).getYourScore()));
            enemyScore5.setText(String.valueOf(all.get(size-5).getEnemyScore()));
            winner5.setText(all.get(size-5).getWinner());
            // 6
            enemy6.setText(all.get(size-6).getEnemyName());
            date6.setText(all.get(size-6).getDate());
            yourScore6.setText(String.valueOf(all.get(size-6).getYourScore()));
            enemyScore6.setText(String.valueOf(all.get(size-6).getEnemyScore()));
            winner6.setText(all.get(size-6).getWinner());
            // 7

            enemy7.setText(all.get(size-7).getEnemyName());
            date7.setText(all.get(size-7).getDate());
            yourScore7.setText(String.valueOf(all.get(size-7).getYourScore()));
            enemyScore7.setText(String.valueOf(all.get(size-7).getEnemyScore()));
            winner7.setText(all.get(size-7).getWinner());
            // 8
            enemy8.setText(all.get(size-8).getEnemyName());
            date8.setText(all.get(size-8).getDate());
            yourScore8.setText(String.valueOf(all.get(size-8).getYourScore()));
            enemyScore8.setText(String.valueOf(all.get(size-8).getEnemyScore()));
            winner8.setText(all.get(size-8).getWinner());
            // 9
            enemy9.setText(all.get(size-9).getEnemyName());
            date9.setText(all.get(size-9).getDate());
            yourScore9.setText(String.valueOf(all.get(size-9).getYourScore()));
            enemyScore9.setText(String.valueOf(all.get(size-9).getEnemyScore()));
            winner9.setText(all.get(size-9).getWinner());
            // 10
            enemy10.setText(all.get(size-10).getEnemyName());
            date10.setText(all.get(size-10).getDate());
            yourScore10.setText(String.valueOf(all.get(size-10).getYourScore()));
            enemyScore10.setText(String.valueOf(all.get(size-10).getEnemyScore()));
            winner10.setText(all.get(size-10).getWinner());
        }
    }
    public void back() throws Exception {
        Main main = new Main();
        main.start(Login.getStage());
    }
}