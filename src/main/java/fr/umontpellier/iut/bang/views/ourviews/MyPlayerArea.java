package fr.umontpellier.iut.bang.views.ourviews;

import fr.umontpellier.iut.bang.ICard;
import fr.umontpellier.iut.bang.IPlayer;
import fr.umontpellier.iut.bang.logic.cards.*;
import fr.umontpellier.iut.bang.views.GameView;
import fr.umontpellier.iut.bang.views.PlayerArea;
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
        List<Card> cartes = new ArrayList<>();
        cartes.add(new Beer(6, CardSuit.HEART));
        cartes.add(new Bang(14, SPADE));
        cartes.add(new CatBalou(9, DIAMOND));
        for (Card c : cartes)
            laMainDuJoueur.getChildren().add(new MyCardView(new ICard(c), this));
        vueJoueur.getChildren().add(nomJoueur);
        vueJoueur.getChildren().add(laMainDuJoueur);
        getChildren().add(vueJoueur);
    }

    @Override
    public void highlightCurrentArea() {

    }

    @Override
    public void deHightlightCurrentArea() {

    }
}
