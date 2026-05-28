package view;

import Enums.Type;
import controller.GameController;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;

import java.util.Objects;

public class GameLauncher extends Application {
    private boolean turn;
    private final User user = User.getLoggedInUser();
    private final Game game;
    private Pane pane;
    private final Label closeCardsScoreLabel = new Label();
    private final Label rangedCardsScoreLabel = new Label();
    private final Label siegeCardsScoreLabel = new Label();
    private static int closeCardsScore = 0;
    private static int rangedCardsScore = 0;
    private static int siegeCardsScore = 0;
    private final Circle cheat1 = new Circle("cheat1");
    private final Circle cheat2 = new Circle("cheat2");
    private final Circle cheat3 = new Circle("cheat3");
    private final Circle cheat4 = new Circle("cheat4");
    private int X = 435;

    public GameLauncher(Game game) {
        this.game = game;
    }

    @Override
    public void start(Stage stage) throws Exception {
        makeLabels();
        makePane();
        makeStage(stage);
        startRound1();
    }

    private void startRound1() {
        for (Node node: pane.getChildren()) {
            node.setOnMouseClicked(mouseEvent -> move((node)));
        }
    }

    private void cheat(Circle node) {
        int number = (int) (Math.random() * 20) + 10;
        System.out.println(number);
        int i = 1;
        if (node.getName().equals("cheat1")) {
            for (Card card: user.getDeck()) {
                if (i == number && !((PlayableCard) card).isPlayed()) {
                    pane.getChildren().add(((PlayableCard) card));
                    setPlace(card, X, 633, 104, 68);
                    X += 71;
                    break;
                }
                i++;
            }
        } else if (node.getName().equals("cheat2")) {
            int score = 0;
            for (Node n : pane.getChildren()) {
                if (n instanceof Unit currentCard) {
                    if (currentCard.getY() == 315) {
                        if (!currentCard.isHero()) currentCard.setPower(1);
                        System.out.println(currentCard.getName() + ": " + currentCard.getPower());
                        score += currentCard.getPower();
                    }
                }
            }
            closeCardsScore = score;
            closeCardsScoreLabel.setText("" + score);
        } else if (node.getName().equals("cheat3")) {
            int score = 0;
            for (Node n : pane.getChildren()) {
                if (n instanceof Unit currentCard) {
                    if (currentCard.getY() == 415) {
                        if (!currentCard.isHero()) currentCard.setPower(1);
                        System.out.println(currentCard.getName() + ": " + currentCard.getPower());
                        score += currentCard.getPower();
                    }
                }
            }
            rangedCardsScore = score;
            rangedCardsScoreLabel.setText("" + score);
        } else if (node.getName().equals("cheat4")) {
            int score = 0;
            for (Node n : pane.getChildren()) {
                if (n instanceof Unit currentCard) {
                    if (currentCard.getY() == 517) {
                        if (!currentCard.isHero()) currentCard.setPower(1);
                        System.out.println(currentCard.getName() + ": " + currentCard.getPower());
                        score += currentCard.getPower();
                    }
                }
            }
            siegeCardsScore = score;
            siegeCardsScoreLabel.setText("" + score);
        }
    }

    private void move(Node card) {

        if (card instanceof Circle) {
            cheat(((Circle) card));
            return;
        }


        PlayableCard c = ((PlayableCard) card);
        if (c.isPlayed()) return;
        Type type = c.getType();
        c.setPlayed(true);
        if (type == Type.WHETHER) {
            GameController.setWhetherCardPlace(c, pane);
            closeCardsScoreLabel.setText("" + closeCardsScore);
            rangedCardsScoreLabel.setText("" + rangedCardsScore);
            siegeCardsScoreLabel.setText("" + siegeCardsScore);
        }
        else if (type == Type.SPELL) setSpellCardPlace(c);
        else if (type == Type.CLOSE) {
            X -= 71;
            GameController.setCloseCardPlace(c);
            closeCardsScore += ((Unit) c).getPower();
            closeCardsScoreLabel.setText("" + closeCardsScore);
        } else if (type == Type.RANGED) {
            X -= 71;
            GameController.setRangedCardPlace(c);
            rangedCardsScore += ((Unit) c).getPower();
            rangedCardsScoreLabel.setText("" + rangedCardsScore);
        } else if (type == Type.SIEGE) {
            X -= 71;
            GameController.setSiegeCardPlace(c);
            siegeCardsScore += ((Unit) c).getPower();
            siegeCardsScoreLabel.setText("" + siegeCardsScore);
        } else if (type == Type.AGILE) setAgileCardPlace(c);
    }

    private void setSpellCardPlace(PlayableCard card) {
        Circle bow = new Circle("circle1");
        bow.setX(card.getX() - 15);
        bow.setY(card.getY() + 100);

        Circle sword = new Circle("circle2");
        sword.setX(card.getX() + 27);
        sword.setY(card.getY() + 100);

        Circle siege = new Circle("circle3");
        siege.setX(card.getX() + 6);
        siege.setY(card.getY() + 150);
        pane.getChildren().addAll(sword, bow, siege);

        bow.setOnMouseClicked(mouseEvent -> {
            pane.getChildren().removeAll(bow, sword, siege);
            GameController.setSpellInRangedCardPlace(card, pane);
        });
        sword.setOnMouseClicked(mouseEvent -> {
            GameController.setSpellInCloseCardPlace(card, pane);
            pane.getChildren().removeAll(bow, sword, siege);
            closeCardsScoreLabel.setText("" + closeCardsScore);
        });
        siege.setOnMouseClicked(mouseEvent -> {
            GameController.setSpellInSiegeCardPlace(card, pane);
            pane.getChildren().removeAll(bow, sword, siege);
        });
    }

    private void setAgileCardPlace(PlayableCard card) {
        X -= 71;
        Circle bow = new Circle("circle1");
        bow.setX(card.getX() - 15);
        bow.setY(card.getY() + 100);

        Circle sword = new Circle("circle2");
        sword.setX(card.getX() + 27);
        sword.setY(card.getY() + 100);
        pane.getChildren().addAll(sword, bow);

        bow.setOnMouseClicked(mouseEvent -> {
            GameController.setRangedCardPlace(card);
            rangedCardsScore += ((Unit) card).getPower();
            rangedCardsScoreLabel.setText("" + rangedCardsScore);
            pane.getChildren().removeAll(bow, sword);
        });
        sword.setOnMouseClicked(mouseEvent -> {
            GameController.setCloseCardPlace(card);
            closeCardsScore += ((Unit) card).getPower();
            closeCardsScoreLabel.setText("" + closeCardsScore);
            pane.getChildren().removeAll(bow, sword);
        });
    }

    private void makeLabels() {
        closeCardsScoreLabel.setText("0");
        closeCardsScoreLabel.setLayoutX(389);
        closeCardsScoreLabel.setLayoutY(358);
        closeCardsScoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        closeCardsScoreLabel.setTextFill(Color.BLACK);

        rangedCardsScoreLabel.setText("0");
        rangedCardsScoreLabel.setLayoutX(389);
        rangedCardsScoreLabel.setLayoutY(457);
        rangedCardsScoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        rangedCardsScoreLabel.setTextFill(Color.BLACK);

        siegeCardsScoreLabel.setText("0");
        siegeCardsScoreLabel.setLayoutX(389);
        siegeCardsScoreLabel.setLayoutY(561);
        siegeCardsScoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        siegeCardsScoreLabel.setTextFill(Color.BLACK);

        cheat1.setLayoutX(1400);
        cheat1.setLayoutY(500);
        cheat2.setLayoutX(1400);
        cheat2.setLayoutY(440);
        cheat3.setLayoutX(1400);
        cheat3.setLayoutY(380);
        cheat4.setLayoutX(1400);
        cheat4.setLayoutY(320);
    }

    private void makeStage(Stage stage) {
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    private void makePane() {
        Pane pane = new Pane();
        pane.setMinWidth(1450);
        pane.setMaxWidth(1450);
        pane.setMaxHeight(840);
        pane.setMinHeight(840);
        pane.setBackground(new Background(createBackgroundImage()));
        this.pane = pane;
        addObjectsToPane();
    }

    private void addObjectsToPane() {
        // add leader
        Card leader = game.getTerritory().getCurrentLeader();
        leader.setFill(new ImagePattern(new Image(Objects.requireNonNull(Login.class.getResource("/images/" + leader.getName() + "2.png")).toExternalForm())));
        setPlace(leader, 97, 625, 110, 85);
        // addCards
        int i = 0;
        for (Card card:user.getDeck()) {
            setPlace(card, X, 633, 104, 68);
            X += 71;
            card.setFill(new ImagePattern(new Image(Objects.requireNonNull(Login.class.getResource("/images/" + card.getName() + "2.png")).toExternalForm())));
            pane.getChildren().add(card);
            i ++;
            if (i == 10) break;
        }
        pane.getChildren().addAll(leader, closeCardsScoreLabel, rangedCardsScoreLabel, siegeCardsScoreLabel, cheat1,
        cheat2, cheat3, cheat4);
    }

    private void setPlace(Card card, double X, double Y, double HEIGHT, double WIDTH) {
        card.setX(X);
        card.setY(Y);
        card.setHeight(HEIGHT);
        card.setWidth(WIDTH);
    }

    private BackgroundImage createBackgroundImage() {
        Image image = new Image(Objects.requireNonNull(Login.class.getResource("/images/GwentBoard2.png")).toExternalForm());
        return new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(50, 50, true, true, true, true)
        );
    }

    private void passTurn() {
        turn = !turn;
    }

    public static void setCloseCardsScore(int closeCardsScore) {
        GameLauncher.closeCardsScore = closeCardsScore;
    }

    public static void setRangedCardsScore(int rangedCardsScore) {
        GameLauncher.rangedCardsScore = rangedCardsScore;
    }

    public static void setSiegeCardsScore(int siegeCardsScore) {
        GameLauncher.siegeCardsScore = siegeCardsScore;
    }
}