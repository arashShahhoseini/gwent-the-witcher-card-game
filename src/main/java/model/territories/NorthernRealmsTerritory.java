package model.territories;

import Enums.Ability;
import Enums.AllLeaders;
import Enums.AllUnits;
import Enums.Type;
import model.Territory;
import model.Unit;

import java.util.ArrayList;
import java.util.Arrays;

public class NorthernRealmsTerritory extends Territory {

    public NorthernRealmsTerritory() {
        super("NorthernRealms", AllLeaders.Siegemaster.getCard(), new ArrayList<>(Arrays.asList(
                AllLeaders.KingOfTemeria.getCard(),
                AllLeaders.LordCommanderOfTheNorth.getCard(),
                AllLeaders.Siegemaster.getCard(),
                AllLeaders.SonOfMedell.getCard(),
                AllLeaders.SteelForged.getCard()
        )), new ArrayList<>(Arrays.asList(
                AllUnits.Ballista.getCard(),
                AllUnits.Catapult.getCard(),
                AllUnits.DragonHunter.getCard(),
                AllUnits.Trebuchet.getCard(),
                AllUnits.BlueStripesCommando.getCard(),
                AllUnits.Dethmold.getCard(),
                AllUnits.KeiraMetz.getCard(),
                AllUnits.SheldonSkaggs.getCard(),
                AllUnits.DunBannerMedic.getCard(),
                AllUnits.EsteradThyssen.getCard(),
                AllUnits.JohnNatalis.getCard(),
                AllUnits.KaedweniSiegeExpert.getCard(),
                AllUnits.PhilippaEilhart.getCard(),
                AllUnits.PoorFuckingInfantry.getCard(),
                AllUnits.PrinceStennis.getCard(),
                AllUnits.RedanianFootSoldier.getCard(),
                AllUnits.SabrinaGlevissing.getCard(),
                AllUnits.SiegeTower.getCard(),
                AllUnits.SiegfriedOfDenesle.getCard(),
                AllUnits.SigismundDijkstra.getCard(),
                AllUnits.SileDeTansarville.getCard(),
                AllUnits.Thaler.getCard(),
                AllUnits.VernonRoche.getCard(),
                AllUnits.Ves.getCard(),
                AllUnits.YarpenZirgrin.getCard()
        )));
    }
}