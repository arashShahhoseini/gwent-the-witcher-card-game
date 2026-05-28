package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.Login;

import java.util.Objects;

public class Shape extends Rectangle {
    private final String name;
    public Shape(double v, double v1, String name) {
        super(v, v1);
        this.name = name;
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Login.class.getResource("/images/" + name + ".png")).toExternalForm())));
    }
    public String getName() {
        return name;
    }
}
