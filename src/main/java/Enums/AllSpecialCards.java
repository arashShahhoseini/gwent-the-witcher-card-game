package Enums;

import model.Card;
import model.SpecialCard;

public enum AllSpecialCards {
    // special units
    // all
    BitingFrost(new SpecialCard(null, "BitingFrost", Type.WHETHER)),
    ClearWeather(new SpecialCard(null, "ClearWeather", Type.WHETHER)),
    CommandersHorn(new SpecialCard(null, "CommandersHorn", Type.SPELL)),
    Decoy(new SpecialCard(null, "Decoy", Type.SPELL)),
    ImpenetrableFog(new SpecialCard(null, "ImpenetrableFog", Type.WHETHER)),
    Scorch(new SpecialCard(null, "Scorch", Type.SPELL)),
    TorrentialRain(new SpecialCard(null, "TorrentialRain", Type.WHETHER)),
    // Skellige
    SkelligeStorm(new SpecialCard("Skellige", "SkelligeStorm", Type.WHETHER)),
    Mardoeme(new SpecialCard("Skellige", "Mardoeme", Type.SPELL));

    private final Card specialUnit;

    AllSpecialCards(Card specialUnit) {
        this.specialUnit = specialUnit;
    }

    public Card getCard() {
        return specialUnit;
    }
}
