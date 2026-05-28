package model;

import Enums.Type;

public class PlayableCard extends Card {
    private int number;
    private final Type type;
    private boolean isPlayed = false;

    public PlayableCard(String territoryName, String name, int number, Type type) {
        super(territoryName, name);
        this.number = number;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }
}
