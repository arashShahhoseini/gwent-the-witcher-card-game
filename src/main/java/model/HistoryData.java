package model;

public class HistoryData {
    private String enemyName;
    private String date;
    private int yourScore;
    private int enemyScore;
    private String winner;

    public HistoryData(String enemyName, String date, int yourScore, int enemyScore, String winner) {
        this.enemyName = enemyName;
        this.date = date;
        this.yourScore = yourScore;
        this.enemyScore = enemyScore;
        this.winner = winner;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getYourScore() {
        return yourScore;
    }

    public void setYourScore(int yourScore) {
        this.yourScore = yourScore;
    }

    public int getEnemyScore() {
        return enemyScore;
    }

    public void setEnemyScore(int enemyScore) {
        this.enemyScore = enemyScore;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}