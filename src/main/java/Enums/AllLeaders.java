package Enums;

import model.Card;
import model.Leader;

public enum AllLeaders {
    // leaders
    // northern realms
    KingOfTemeria(new Leader("NorthernRealms", "KingOfTemeria")),
    LordCommanderOfTheNorth(new Leader("NorthernRealms", "LordCommanderOfTheNorth")),
    Siegemaster(new Leader("NorthernRealms", "Siegemaster")),
    SonOfMedell(new Leader("NorthernRealms", "SonOfMedell")),
    SteelForged(new Leader("NorthernRealms", "SteelForged")),
    // nilfgaardian empire
    WhiteFlame(new Leader("NilfgaardianEmpire", "WhiteFlame")),
    HisImperialMajesty(new Leader("NilfgaardianEmpire", "HisImperialMajesty")),
    EmperorOfNilfgaard(new Leader("NilfgaardianEmpire", "EmperorOfNilfgaard")),
    Relentless(new Leader("NilfgaardianEmpire", "Relentless")),
    InvaderOfTheNorth(new Leader("NilfgaardianEmpire", "InvaderOfTheNorth")),
    // monsters
    BringerOfDeath(new Leader("Monsters", "BringerOfDeath")),
    KingOfTheWildHunt(new Leader("Monsters", "KingOfTheWildHunt")),
    DestroyerOfWorlds(new Leader("Monsters", "DestroyerOfWorlds")),
    CommanderOfTheRedRiders(new Leader("Monsters", "CommanderOfTheRedRiders")),
    Treacherous(new Leader("Monsters", "Treacherous")),
    // scoia’tael
    QueenOfDolBlathanna(new Leader("Scoiatael", "QueenOfDolBlathanna")),
    Beautiful(new Leader("Scoiatael", "Beautiful")),
    DaisyOfTheValley(new Leader("Scoiatael", "DaisyOfTheValley")),
    PurebloodElf(new Leader("Scoiatael", "PurebloodElf")),
    HopeOfTheAenSeidhe(new Leader("Scoiatael", "HopeOfTheAenSeidhe")),
    // skellige
    KingBran(new Leader("Skellige", "KingBran")),
    CrachAnCraite(new Leader("Skellige", "CrachAnCraite"));

    private final Card leader;

    AllLeaders(Card leader) {
        this.leader = leader;
    }

    public Card getCard() {
        return leader;
    }
}
