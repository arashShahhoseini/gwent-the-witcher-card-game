package model.territories;

import Enums.*;
import model.Territory;

import java.util.ArrayList;
import java.util.Arrays;

public class SkelligeTerritory extends Territory {
    public SkelligeTerritory() {
        super("Skellige", AllLeaders.KingBran.getCard(), new ArrayList<>(Arrays.asList(
                AllLeaders.KingBran.getCard(),
                AllLeaders.CrachAnCraite.getCard()
        )), new ArrayList<>(Arrays.asList(
                AllSpecialCards.SkelligeStorm.getCard(),
                AllSpecialCards.Mardoeme.getCard(),
                AllUnits.Berserker.getCard(),
                AllUnits.Vidkaarl.getCard(),
                AllUnits.Svanrige.getCard(),
                AllUnits.Udalryk.getCard(),
                AllUnits.DonarAnHindar.getCard(),
                AllUnits.ClanAnCraite.getCard(),
                AllUnits.MadmanLugos.getCard(),
                AllUnits.Cerys.getCard(),
                AllUnits.Kambi.getCard(),
                AllUnits.BirnaBran.getCard(),
                AllUnits.ClanDrummondShieldmaiden.getCard(),
                AllUnits.ClanDimunPirate.getCard(),
                AllUnits.ClanBrokvarArcher.getCard(),
                AllUnits.Ermion.getCard(),
                AllUnits.Hjalmar.getCard(),
                AllUnits.YoungBerserker.getCard(),
                AllUnits.YoungVidkaarl.getCard(),
                AllUnits.LightLongship.getCard(),
                AllUnits.WarLongship.getCard(),
                AllUnits.DraigBonDhu.getCard(),
                AllUnits.BlueboyLugos.getCard(),
                AllUnits.ClanTordarrochArmorsmith.getCard(),
                AllUnits.HolgerBlackhand.getCard(),
                AllUnits.Olaf.getCard()
                )));
    }
}
