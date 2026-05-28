package model.territories;

import Enums.AllLeaders;
import Enums.AllUnits;
import model.Territory;

import java.util.ArrayList;
import java.util.Arrays;

public class NilfgaardianEmpireTerritory extends Territory {
    public NilfgaardianEmpireTerritory() {
        super("NilfgaardianEmpire", AllLeaders.Relentless.getCard(), new ArrayList<>(Arrays.asList(
                AllLeaders.WhiteFlame.getCard(),
                AllLeaders.HisImperialMajesty.getCard(),
                AllLeaders.Relentless.getCard(),
                AllLeaders.EmperorOfNilfgaard.getCard(),
                AllLeaders.InvaderOfTheNorth.getCard()
        )), new ArrayList<>(Arrays.asList(
                AllUnits.EtolianAuxiliaryArchers.getCard(),
                AllUnits.MennoCoehoorn.getCard(),
                AllUnits.SiegeTechnician.getCard(),
                AllUnits.ShilardFitzOesterlen.getCard(),
                AllUnits.StefanSkellen.getCard(),
                AllUnits.VattierDeRideaux.getCard(),
                AllUnits.ImperaBrigadeGuard.getCard(),
                AllUnits.NausicaaCavalryRider.getCard(),
                AllUnits.YoungEmissary.getCard(),
                AllUnits.Albrich.getCard(),
                AllUnits.AssireVarAnahid.getCard(),
                AllUnits.BlackInfantryArcher.getCard(),
                AllUnits.CahirMawrDyffrynAepCeallach.getCard(),
                AllUnits.Cynthia.getCard(),
                AllUnits.FringillaVigo.getCard(),
                AllUnits.HeavyZerrikanianFireScorpion.getCard(),
                AllUnits.LethoOfGulet.getCard(),
                AllUnits.Morteisen.getCard(),
                AllUnits.MorvranVoorhis.getCard(),
                AllUnits.Puttkammer.getCard(),
                AllUnits.Rainfarn.getCard(),
                AllUnits.RenualdAepMatsen.getCard(),
                AllUnits.RottenMangonel.getCard(),
                AllUnits.SiegeEngineer.getCard(),
                AllUnits.Sweers.getCard(),
                AllUnits.TiborEggebracht.getCard(),
                AllUnits.Vanhemar.getCard(),
                AllUnits.Vreemde.getCard(),
                AllUnits.ZerrikanianFireScorpion.getCard()
        )));
    }
}