package model.territories;

import Enums.Ability;
import Enums.AllLeaders;
import Enums.AllUnits;
import Enums.Type;
import model.Territory;
import model.Unit;

import java.util.ArrayList;
import java.util.Arrays;

public class ScoiataelTerritory extends Territory {
    public ScoiataelTerritory() {
        super("Scoiatael", AllLeaders.DaisyOfTheValley.getCard(), new ArrayList<>(Arrays.asList(
                AllLeaders.QueenOfDolBlathanna.getCard(),
                AllLeaders.Beautiful.getCard(),
                AllLeaders.DaisyOfTheValley.getCard(),
                AllLeaders.PurebloodElf.getCard(),
                AllLeaders.HopeOfTheAenSeidhe.getCard()
        )), new ArrayList<>(Arrays.asList(
                AllUnits.ElvenSkirmisher.getCard(),
                AllUnits.Yaevinn.getCard(),
                AllUnits.CiaranAep.getCard(),
                AllUnits.DennisCranmer.getCard(),
                AllUnits.DolBlathannaScout.getCard(),
                AllUnits.DolBlathannaArcher.getCard(),
                AllUnits.DwarvenSkirmisher.getCard(),
                AllUnits.HavekarHealer.getCard(),
                AllUnits.HavekarSmuggler.getCard(),
                AllUnits.IdaEmeanAep.getCard(),
                AllUnits.Riordain.getCard(),
                AllUnits.Toruviel.getCard(),
                AllUnits.VriheddBrigadeRecruit.getCard(),
                AllUnits.VriheddBrigadeVeteran.getCard(),
                AllUnits.Milva.getCard(),
                AllUnits.Seasenthessis.getCard(),
                AllUnits.Schirru.getCard(),
                AllUnits.Eithne.getCard(),
                AllUnits.IsengrimFaoiltiarna.getCard(),
                AllUnits.Filavandrel.getCard(),
                AllUnits.BarclayEls.getCard(),
                AllUnits.MahakamanDefender.getCard(),
                AllUnits.Iorveth.getCard()
        )));
    }
}
