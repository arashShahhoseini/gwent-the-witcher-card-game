package model;

import Enums.Type;

public class SpecialCard extends PlayableCard {
    public SpecialCard(String territoryName, String name, Type type) {
        super(territoryName, name, 3, type);
    }
}
