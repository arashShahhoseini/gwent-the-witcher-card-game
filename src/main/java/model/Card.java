package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.Login;
import java.util.Objects;

public class Card extends Rectangle {

    private final String territoryName;
    private final String name;

    public Card(String territoryName, String name) {
        super(187.5, 361);
        this.territoryName = territoryName;
        this.name = name;
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Login.class.getResource("/images/" + name + ".png")).toExternalForm())));
    }

    public String getTerritoryName() {
        return territoryName;
    }

    public String getName() {
        return name;
    }
}
