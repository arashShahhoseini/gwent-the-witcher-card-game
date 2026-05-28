package model;

import model.territories.MonstersTerritory;

import java.util.ArrayList;

public class Game {

    private User opponent;
    private boolean turn;
    private int userScore;
    private int opponentScore;
    private ArrayList<Card> deadCards = new ArrayList<>();
    private Territory territory = new MonstersTerritory();

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public void setOpponentScore(int opponentScore) {
        this.opponentScore = opponentScore;
    }

    public User getOpponent() {
        return opponent;
    }

    public void setOpponent(User opponent) {
        this.opponent = opponent;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    public ArrayList<Card> getDeadCards() {
        return deadCards;
    }

    public void setDeadCards(ArrayList<Card> deadCards) {
        this.deadCards = deadCards;
    }
}
