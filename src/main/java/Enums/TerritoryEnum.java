package Enums;

import model.territories.NilfgaardianEmpireTerritory;
import model.Territory;
import model.territories.*;

public enum TerritoryEnum {
    Monsters(new MonstersTerritory()),
    NilfgaardianEmpire(new NilfgaardianEmpireTerritory()),
    NorthernRealms(new NorthernRealmsTerritory()),
    Scoiatael(new ScoiataelTerritory()),
    Skellige(new SkelligeTerritory());

    private final Territory territory;

    TerritoryEnum(Territory territory) {
        this.territory = territory;
    }

    public Territory getTerritory() {
        return territory;
    }
}
