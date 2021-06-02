package fr.umontpellier.iut.bang.views.ourviews;

import fr.umontpellier.iut.bang.IGame;
import fr.umontpellier.iut.bang.IPlayer;
import fr.umontpellier.iut.bang.logic.Player;
import fr.umontpellier.iut.bang.views.GameView;
import javafx.scene.layout.VBox;

public class MyGameView extends GameView {

    private VBox vuePrincipale;
    public MyGameView(IGame game) {
        super(game);
        vuePrincipale = new VBox();
        for (Player p : game.getPlayers())
            vuePrincipale.getChildren().add(new MyPlayerArea(new IPlayer(p), this));
        getChildren().add(vuePrincipale);
        getIGame().run();
    }

    @Override
    protected void bindNextActionMessage() {

    }

    @Override
    protected void setPassSelectedListener() {

    }
}
