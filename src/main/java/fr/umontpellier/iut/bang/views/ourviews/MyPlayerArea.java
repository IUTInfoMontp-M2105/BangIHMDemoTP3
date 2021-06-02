package fr.umontpellier.iut.bang.views.ourviews;

import fr.umontpellier.iut.bang.IPlayer;
import fr.umontpellier.iut.bang.views.GameView;
import fr.umontpellier.iut.bang.views.PlayerArea;
import javafx.scene.control.Label;

public class MyPlayerArea extends PlayerArea {

    public MyPlayerArea(IPlayer player, GameView gameView) {
        super(player, gameView);
        Label nomJoueur = new Label(player.getName());
        getChildren().add(nomJoueur);
    }

    @Override
    public void highlightCurrentArea() {

    }

    @Override
    public void deHightlightCurrentArea() {

    }
}
