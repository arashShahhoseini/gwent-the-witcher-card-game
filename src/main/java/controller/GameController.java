package controller;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import model.Card;
import model.Unit;
import view.GameLauncher;

public class GameController {
    private static int closeCardsX = 600;
    private static int rangedCardsX = 600;
    private static int siegeCardsX = 600;
    private static int whetherCardX = 100;
    private static final int spellCardX = 440;

    public static void setCloseCardPlace(Card card) {
        card.setX(closeCardsX);
        closeCardsX += 71;
        card.setY(315);
    }

    public static void setRangedCardPlace(Card card) {
        card.setX(rangedCardsX);
        rangedCardsX += 71;
        card.setY(415);
    }

    public static void setSiegeCardPlace(Card card) {
        card.setX(siegeCardsX);
        siegeCardsX += 71;
        card.setY(517);
    }

    public static void setWhetherCardPlace(Card card, Pane pane) {
        card.setX(whetherCardX);
        whetherCardX += 71;
        card.setY(340);
        int score = activeAbility(card, pane);
        GameLauncher.setCloseCardsScore(score);
    }

    public static void setSpellInCloseCardPlace(Card card, Pane pane) {
        card.setX(spellCardX);
        card.setY(315);
        int score = activeAbility(card, pane);
        GameLauncher.setCloseCardsScore(score);
    }

    public static void setSpellInRangedCardPlace(Card card, Pane pane) {
        card.setX(spellCardX);
        card.setY(415);
        GameLauncher.setCloseCardsScore(activeAbility(card, pane));
    }

    public static void setSpellInSiegeCardPlace(Card card, Pane pane) {
        card.setX(spellCardX);
        card.setY(517);
        activeAbility(card, pane);
    }

    private static int activeAbility(Card card, Pane pane) {
        int score = 0;
        switch (card.getName()) {
            case "CommandersHorn" -> {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Unit currentCard) {
                        if (currentCard.getY() == card.getY()) {
                            if (!currentCard.isHero()) currentCard.setPower(currentCard.getPower() * 2);
                            System.out.println(currentCard.getName() + ": " + currentCard.getPower());
                            score += currentCard.getPower();
                        }
                    }
                }
                return score;
            }
            case "Mardoeme" -> System.out.println("");
            case "Scorch" -> System.out.println("");
            case "Decoy" -> System.out.println("");
            case "BitingFrost" -> {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Unit currentCard) {
                        if (currentCard.getY() == 315) {
                            if (!currentCard.isHero()) currentCard.setPower(1);
                            System.out.println(currentCard.getName() + ": " + currentCard.getPower());
                            score += currentCard.getPower();
                        }
                    }
                }
                return score;
            }
        }
        return 0;
    }
}