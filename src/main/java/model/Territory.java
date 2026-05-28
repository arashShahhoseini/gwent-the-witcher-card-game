package model;

import Enums.AllSpecialCards;
import Enums.AllUnits;
import Enums.TerritoryEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.Login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Territory extends Rectangle {

    private final String name;
    private Card currentLeader;
    private final ArrayList<Card> leaders;
    private ArrayList<Card> units;
    private static final ArrayList<Territory> territories = new ArrayList<>(Arrays.asList(
            TerritoryEnum.Monsters.getTerritory(),
            TerritoryEnum.NilfgaardianEmpire.getTerritory(),
            TerritoryEnum.NorthernRealms.getTerritory(),
            TerritoryEnum.Scoiatael.getTerritory(),
            TerritoryEnum.Skellige.getTerritory()
            ));
    private static final ArrayList<Card> allTerritoryUnits = new ArrayList<>(Arrays.asList(
            AllUnits.Dandelion.getCard(),
            AllUnits.YenneferOfVengerberg.getCard(),
            AllUnits.OlgierdVonEverc.getCard(),
            AllUnits.GaunterODimm.getCard(),
            AllUnits.GaunterODImmDarkness.getCard(),
            AllUnits.MysteriousElf.getCard(),
            AllUnits.Cow.getCard(),
            AllUnits.EmielRegis.getCard(),
            AllUnits.GeraltOfRivia.getCard(),
            AllUnits.TrissMerigold.getCard(),
            AllUnits.Vesemir.getCard(),
            AllUnits.ZoltanChivay.getCard(),
            AllSpecialCards.BitingFrost.getCard(),
            AllSpecialCards.ClearWeather.getCard(),
            AllSpecialCards.CommandersHorn.getCard(),
            AllSpecialCards.Decoy.getCard(),
            AllSpecialCards.ImpenetrableFog.getCard(),
            AllSpecialCards.Scorch.getCard(),
            AllSpecialCards.TorrentialRain.getCard()
            ));

    public Territory(String name, Card currentLeader, ArrayList<Card> leaders, ArrayList<Card> units) {
        super(62.5, 100);
        this.name = name;
        this.currentLeader = currentLeader;
        this.leaders = leaders;
        this.units = units;
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Login.class.getResource("/images/" + name + ".png")).toExternalForm())));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Card> units) {
        this.units = units;
    }

    public Card getCurrentLeader() {
        return currentLeader;
    }

    public void setCurrentLeader(Card currentLeader) {
        this.currentLeader = currentLeader;
    }

    public ArrayList<Card> getLeaders() {
        return leaders;
    }

    public static ArrayList<Territory> getTerritories() {
        return territories;
    }

    public static ArrayList<Card> getAllTerritoryUnits() {
        return allTerritoryUnits;
    }

}
