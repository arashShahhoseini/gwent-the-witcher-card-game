package model;

import Enums.Ability;
import Enums.Type;

public class Unit extends PlayableCard {
    private int power;
    private final boolean hero;
    private final Ability ability;

    public Unit(String territoryName, String name, int power, int number, boolean hero, Type type, Ability ability) {
        super(territoryName, name, number, type);
        this.power = power;
        this.hero = hero;
        this.ability = ability;
    }

    public int getPower() {
        return power;
    }

    public boolean isHero() {
        return hero;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Ability getAbility() { return ability; }
}
