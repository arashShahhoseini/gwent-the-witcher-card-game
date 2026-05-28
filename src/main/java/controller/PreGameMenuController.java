package controller;

import Enums.Type;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import view.GameLauncher;
import view.Login;

public class PreGameMenuController {
    private Label dot = new Label();
    private Label back = new Label();
    private Game game = null;
    private Stage stage;
    private Pane pane;
    @FXML
    private TextField userName;

    @FXML
    private void initialize() {
        this.game = new Game();
        makeLabel();
    }

    public void makeLabel() {
        Label dot = new Label();
        dot.setText(".");
        dot.setLayoutX(999);
        dot.setLayoutY(529);
        this.dot = dot;

        Label back = new Label();
        back.setText("back");
        back.setLayoutX(880);
        back.setLayoutY(20);
        back.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        back.setTextFill(Color.BROWN);
        this.back = back;
    }

    public void applyOpponent() {
        User opponent = User.getUserByName(userName.getText());
        if (opponent == null) {
            showNoPlayerError();
            return;
        } else if (User.getLoggedInUser().getUsername().equals(userName.getText())) {
            showYourNameError();
            return;
        }
        game.setOpponent(opponent);
    }

    private void showYourNameError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("this is yourself!");
        alert.showAndWait();
    }

    private void showNoPlayerError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("this player doesnt exist!");
        alert.showAndWait();
    }

    public void handleTextField (KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) applyOpponent();
    }

    public void selectTerritory() {
        openTerritorySelectionPane();
    }

    private void openTerritorySelectionPane() {
        makeStage(500, 300);

        Label header = new Label();
        header.setText("Choose your territory");
        header.setLayoutX(150);
        header.setLayoutY(20);
        header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        header.setAlignment(Pos.CENTER);

        int X = 60;
        for (Territory territory:
             Territory.getTerritories()) {
            territory.setX(X);
            territory.setY(80);
            X += 80;
            pane.getChildren().add(territory);
        }

        Label img1Name = new Label();
        Label img2Name = new Label();
        Label img2Name2 = new Label();
        Label img3Name = new Label();
        Label img3Name2 = new Label();
        Label img4Name = new Label();
        Label img5Name = new Label();

        img1Name.setText("Monsters");
        img2Name.setText("Nilfgaardian");
        img2Name2.setText("Empire");
        img3Name.setText("Northern");
        img3Name2.setText("Realms");
        img4Name.setText("Scoia’tael");
        img5Name.setText("Skellige");

        img1Name.setLayoutX(60);
        img1Name.setLayoutY(185);
        img2Name.setLayoutX(140);
        img2Name.setLayoutY(185);
        img2Name2.setLayoutX(140);
        img2Name2.setLayoutY(197);
        img3Name.setLayoutX(220);
        img3Name.setLayoutY(185);
        img3Name2.setLayoutX(220);
        img3Name2.setLayoutY(197);
        img4Name.setLayoutX(300);
        img4Name.setLayoutY(185);
        img5Name.setLayoutX(380);
        img5Name.setLayoutY(185);

        switch (game.getTerritory().getName()) {
            case "Monsters" -> {
                img1Name.setTextFill(Color.DARKGREEN);
                img1Name.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            }
            case "NilfgaardianEmpire" -> {
                img2Name.setTextFill(Color.DARKGREEN);
                img2Name2.setTextFill(Color.DARKGREEN);
                img2Name.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                img2Name2.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            }
            case "NorthernRealms" -> {
                img3Name.setTextFill(Color.DARKGREEN);
                img3Name2.setTextFill(Color.DARKGREEN);
                img3Name.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                img3Name2.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            }
            case "Scoia’tael" -> {
                img4Name.setTextFill(Color.DARKGREEN);
                img4Name.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            }
            default -> {
                img5Name.setTextFill(Color.DARKGREEN);
                img5Name.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            }
        }

        pane.getChildren().addAll(header, img1Name, img2Name, img2Name2, img3Name, img3Name2, img4Name, img5Name);

        for (Node node:
             pane.getChildren()) {
            node.setOnMouseClicked(event -> setTerritory(((Territory) node)));
        }

        stage.show();
    }

    private void setTerritory(Territory territory) {
        User.getLoggedInUser().removeAllCardFromDeck();
        game.setTerritory(territory);
        stage.close();
    }

    public void selectLeader() {
        openLeaderSelectionPane();
    }

    private void openLeaderSelectionPane() {
        makeStage(1000, 530);

        Label header = new Label();
        header.setText("Choose your leader");
        header.setLayoutX(350);
        header.setLayoutY(20);
        header.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        header.setAlignment(Pos.CENTER);

        setLeadersStage(header, game.getTerritory());

        for (Node node:
             pane.getChildren()) {
            node.setOnMouseClicked(mouseEvent -> setLeader(((Card) node)));
        }

        stage.show();
    }

    private void setLeader(Card leader) {
        game.getTerritory().setCurrentLeader(leader);
        stage.close();
        System.out.println(leader.getName());
    }

    private void setLeadersStage(Label header, Territory territory) {
        int X = 10;
        if (territory.getName().equals("Skellige")) X = 300;
        for (Card card: territory.getLeaders()) {
            if (card.equals(game.getTerritory().getCurrentLeader())) {
                card.setY(100);
            } else {
                card.setY(80);
            }
            card.setX(X);
            pane.getChildren().add(card);
            X += 197.5;
        }
        pane.getChildren().add(header);
    }

    private void makeStage(double v, double v1) {
        Pane pane = new Pane();
        this.pane = pane;
        pane.setPrefSize(v, v1);
        pane.setBackground(new Background(new BackgroundFill(Color.web("#D2B48C"), CornerRadii.EMPTY, Insets.EMPTY)));

        Stage stage = new Stage();
        this.stage = stage;
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(Login.getStage());
        stage.setTitle("Gwent");
        stage.setScene(new Scene(pane));
    }

    public void selectCard() {
        openUnitSelectionPane();
    }

    private void openUnitSelectionPane() {
        makeStage(1000, 530);

        Label header = new Label();
        header.setText("Choose your Unit");
        header.setLayoutX(370);
        header.setLayoutY(20);
        header.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        header.setAlignment(Pos.CENTER);

        this.pane = new Pane();
        pane.setBackground(new Background(new BackgroundFill(Color.web("#D2B48C"), CornerRadii.EMPTY, Insets.EMPTY)));
        setUnitsStage(header, game.getTerritory());

        ScrollPane scrollPane = new ScrollPane(pane);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        stage.setScene(new Scene(scrollPane, 1000, 530));

        for (Node node:
                pane.getChildren()) {
            node.setOnMouseClicked(mouseEvent -> addCardToDeck(((PlayableCard) node)));
        }

        pane.getChildren().addAll(dot, back);
        back.setOnMouseClicked(mouseEvent -> getBack(stage));
        stage.show();
    }

    private void setUnitsStage(Label header, Territory territory) {
        User user = User.getLoggedInUser();
        int X = 10;
        int Y = 80;
        for (Card card: Territory.getAllTerritoryUnits()) {
            if (!user.isCardInDeck(card)) {
                card.setX(X);
                card.setY(Y);
                pane.getChildren().add(card);
                X += 197.5;
                if (X > 950) {
                    Y += 371;
                    X = 10;
                }
            }
        }
        for (Card card: territory.getUnits()) {
            if (!user.isCardInDeck(card)) {
                card.setX(X);
                card.setY(Y);
                pane.getChildren().add(card);
                X += 197.5;
                if (X > 950) {
                    Y += 371;
                    X = 10;
                }
            }
        }
        pane.getChildren().add(header);
    }

    private void addCardToDeck(PlayableCard card) {
        User user = User.getLoggedInUser();
        user.addCardToDeck(card);
        pane.getChildren().remove(card);
    }

    private void removeCardFromDeck(PlayableCard card, Label allUnitNumber, Label unitsNumber, Label specialUnitsNumber) {
        User user = User.getLoggedInUser();
        user.removeCardFromDeck(card);
        pane.getChildren().remove(card);
        allUnitNumber.setText("total cards: " + user.getNumberOfCardInDeck());
        if (user.getNumberOfCardInDeck() - user.getNumberOfSpecialCardInDeck() < 22) unitsNumber.setTextFill(Color.DARKRED);
        if (user.getNumberOfSpecialCardInDeck() < 11) specialUnitsNumber.setTextFill(Color.BLACK);
        if (card.getType() == Type.SPELL || card.getType() == Type.WHETHER)
            specialUnitsNumber.setText("special cards: " + user.getNumberOfSpecialCardInDeck());
        else unitsNumber.setText("units: " + (user.getNumberOfCardInDeck() - user.getNumberOfSpecialCardInDeck()));
    }

    public void showDeck() {
        User user = User.getLoggedInUser();
        makeStage(1000, 530);

        Label header = new Label();
        header.setText("Your Deck");
        header.setLayoutX(420);
        header.setLayoutY(20);
        header.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        header.setAlignment(Pos.CENTER);

        Label allCardNumber = new Label();
        allCardNumber.setText("total cards: " + user.getNumberOfCardInDeck());
        allCardNumber.setLayoutX(300);
        allCardNumber.setLayoutY(90);
        allCardNumber.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        Label specialUnitsNumber = new Label();
        specialUnitsNumber.setText("special cards: " + user.getNumberOfSpecialCardInDeck());
        specialUnitsNumber.setLayoutX(560);
        specialUnitsNumber.setLayoutY(90);
        specialUnitsNumber.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        if (user.getNumberOfSpecialCardInDeck() > 10) specialUnitsNumber.setTextFill(Color.DARKRED);

        Label unitsNumber = new Label();
        unitsNumber.setText("units: " + (user.getNumberOfCardInDeck() - user.getNumberOfSpecialCardInDeck()));
        unitsNumber.setLayoutX(460);
        unitsNumber.setLayoutY(90);
        unitsNumber.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        if (user.getNumberOfCardInDeck() - user.getNumberOfSpecialCardInDeck() < 22) unitsNumber.setTextFill(Color.DARKRED);

        this.pane = new Pane();
        pane.setBackground(new Background(new BackgroundFill(Color.web("#D2B48C"), CornerRadii.EMPTY, Insets.EMPTY)));
        setDeckStage(header);

        ScrollPane scrollPane = new ScrollPane(pane);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        stage.setScene(new Scene(scrollPane, 1000, 530));

        for (Node node:
                pane.getChildren()) {
            node.setOnMouseClicked(event -> removeCardFromDeck(((PlayableCard) node), allCardNumber, unitsNumber, specialUnitsNumber));
        }

        pane.getChildren().addAll(allCardNumber, unitsNumber, specialUnitsNumber, dot, back);
        back.setOnMouseClicked(mouseEvent -> getBack(stage));
        stage.show();
    }

    private void setDeckStage(Label header) {
        User user = User.getLoggedInUser();
        int X = 10;
        int Y = 120;
        for (Card card: user.getDeck()) {
            card.setX(X);
            card.setY(Y);
            pane.getChildren().add(card);
            X += 197.5;
            if (X > 950) {
                Y += 371;
                X = 10;
            }
        }
        pane.getChildren().add(header);
    }

    public void startGame () throws Exception {
        User user = User.getLoggedInUser();
//        if (user.getNumberOfCardInDeck() - user.getNumberOfSpecialCardInDeck() < 22) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Pick more");
//            alert.setContentText("cards must be more than 21");
//            alert.show();
//
//            return;
//        }
//        else if (user.getNumberOfSpecialCardInDeck() > 10) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Pick less");
//            alert.setContentText("special cards must be less than 11");
//            alert.show();
//
//            return;
//        }
        GameLauncher gameLauncher = new GameLauncher(game);
        gameLauncher.start(Login.getStage());
    }

    private void getBack(Stage stage) {
        stage.close();
    }

    public void exit() {
        Platform.exit();
    }
}