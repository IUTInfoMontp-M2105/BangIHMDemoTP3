package fr.umontpellier.iut.bang.views.ourviews;

import fr.umontpellier.iut.bang.ICard;
import fr.umontpellier.iut.bang.IPlayer;
import fr.umontpellier.iut.bang.logic.cards.*;
import fr.umontpellier.iut.bang.views.CardView;
import fr.umontpellier.iut.bang.views.GameView;
import fr.umontpellier.iut.bang.views.PlayerArea;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

import static fr.umontpellier.iut.bang.logic.cards.CardSuit.*;

public class MyPlayerArea extends PlayerArea {

    private VBox vueJoueur;
    private HBox laMainDuJoueur;

    public MyPlayerArea(IPlayer player, GameView gameView) {
        super(player, gameView);
        vueJoueur = new VBox();
        Label nomJoueur = new Label(player.getName());
        laMainDuJoueur = new HBox();
/*        List<Card> cartes = new ArrayList<>();
        cartes.add(new Beer(6, CardSuit.HEART));
        cartes.add(new Bang(14, SPADE));
        cartes.add(new CatBalou(9, DIAMOND));
        for (Card c : cartes)
            laMainDuJoueur.getChildren().add(new MyCardView(new ICard(c), this));*/
        vueJoueur.getChildren().add(nomJoueur);
        vueJoueur.getChildren().add(laMainDuJoueur);

        setHandListener(updateHandListener);
        getChildren().add(vueJoueur);
    }

    private final ListChangeListener<Card> updateHandListener = change -> {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Card card : change.getAddedSubList()) {
                    MyCardView cardView = new MyCardView(new ICard(card), MyPlayerArea.this);
                    laMainDuJoueur.getChildren().add(cardView);
                }
            } else if (change.wasRemoved()) {
                for (Card card : change.getRemoved()) {
                    laMainDuJoueur.getChildren().remove(findCardView(laMainDuJoueur, card));
                }
            }
        }
    };

    private CardView findCardView(HBox container, Card card) {
        for (Node n : container.getChildren()) {
            CardView nodeCardView = (CardView) n;
            Card nodeCard = nodeCardView.getCard();
            if (nodeCard.equals(card))
                return nodeCardView;
        }
        return null;
    }

    @Override
    public void highlightCurrentArea() {
        setStyle("-fx-background-color: lightblue");
    }

    @Override
    public void deHightlightCurrentArea() {
        setStyle("-fx-background-color: transparent");
    }
}
