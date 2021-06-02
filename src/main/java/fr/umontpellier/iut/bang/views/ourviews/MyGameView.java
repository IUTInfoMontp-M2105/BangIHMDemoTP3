package fr.umontpellier.iut.bang.views.ourviews;

import fr.umontpellier.iut.bang.IGame;
import fr.umontpellier.iut.bang.IPlayer;
import fr.umontpellier.iut.bang.logic.Player;
import fr.umontpellier.iut.bang.views.GameView;
import fr.umontpellier.iut.bang.views.PlayerArea;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MyGameView extends GameView {

    private VBox vuePrincipale;
    private Button pass;

    public MyGameView(IGame game) {
        super(game);
        vuePrincipale = new VBox();
        for (Player p : game.getPlayers())
            vuePrincipale.getChildren().add(new MyPlayerArea(new IPlayer(p), this));
        pass = new Button("pass");

        vuePrincipale.getChildren().add(pass);

        getChildren().add(vuePrincipale);
        setCurrentPlayerChangesListener(whenCurrentPlayerChanges);
        setPassSelectedListener();
        getIGame().run();
    }

    private ChangeListener<? super Player> whenCurrentPlayerChanges = new ChangeListener<Player>() {
        @Override
        public void changed(ObservableValue<? extends Player> observableValue, Player oldCurrentPlayer, Player newCurrentPlayer) {
            if (oldCurrentPlayer != null)
                findPlayerArea(oldCurrentPlayer).deHightlightCurrentArea();
            findPlayerArea(newCurrentPlayer).highlightCurrentArea();
        }
    };

    private PlayerArea findPlayerArea(Player player) {
        for (Node n : vuePrincipale.getChildren()) {
            PlayerArea nodePlayerArea = (PlayerArea) n;
            Player nodePlayer = nodePlayerArea.getPlayer();
            if (nodePlayer.equals(player))
                return nodePlayerArea;
        }
        return null;
    }

    @Override
    protected void bindNextActionMessage() {

    }

    @Override
    protected void setPassSelectedListener() {
        pass.setOnAction(event -> {
            getIGame().onPass();
        });
    }
}
