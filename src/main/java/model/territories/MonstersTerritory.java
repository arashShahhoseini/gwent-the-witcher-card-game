package model.territories;

import Enums.AllLeaders;
import Enums.AllUnits;
import model.Territory;
import java.util.ArrayList;
import java.util.Arrays;

public class MonstersTerritory extends Territory {
    public MonstersTerritory() {
        super("Monsters", AllLeaders.DestroyerOfWorlds.getCard(), new ArrayList<>(Arrays.asList(
                AllLeaders.BringerOfDeath.getCard(),
                AllLeaders.KingOfTheWildHunt.getCard(),
                AllLeaders.DestroyerOfWorlds.getCard(),
                AllLeaders.CommanderOfTheRedRiders.getCard(),
                AllLeaders.Treacherous.getCard()
        )), new ArrayList<>(Arrays.asList(
                AllUnits.Kayran.getCard(),
                AllUnits.Arachas.getCard(),
                AllUnits.ArachasBehemoth.getCard(),
                AllUnits.Brewess.getCard(),
                AllUnits.Weavess.getCard(),
                AllUnits.Whispess.getCard(),
                AllUnits.Ghoul.getCard(),
                AllUnits.Nekker.getCard(),
                AllUnits.VampireBruxa.getCard(),
                AllUnits.VampireEkimmara.getCard(),
                AllUnits.VampireFleder.getCard(),
                AllUnits.VampireGarkain.getCard(),
                AllUnits.VampireKatakan.getCard(),
                AllUnits.Toad.getCard(),
                AllUnits.Botchling.getCard(),
                AllUnits.CelaenoHarpy.getCard(),
                AllUnits.Cockatrice.getCard(),
                AllUnits.Draug.getCard(),
                AllUnits.EarthElemental.getCard(),
                AllUnits.Endrega.getCard(),
                AllUnits.Fiend.getCard(),
                AllUnits.FireElemental.getCard(),
                AllUnits.Foglet.getCard(),
                AllUnits.Forktail.getCard(),
                AllUnits.Frightener.getCard(),
                AllUnits.Gargoyle.getCard(),
                AllUnits.GraveHag.getCard(),
                AllUnits.Griffin.getCard(),
                AllUnits.Harpy.getCard(),
                AllUnits.IceGiant.getCard(),
                AllUnits.Imlerith.getCard(),
                AllUnits.Leshen.getCard(),
                AllUnits.PlagueMaiden.getCard(),
                AllUnits.Werewolf.getCard(),
                AllUnits.Wyvern.getCard()
        )));
    }
}