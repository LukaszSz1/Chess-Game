package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.controllers.ChessboardViewController;
import LukaszSz1.github.ChessGame.model.utils.Player;

class Check implements State {

    private final ChessboardViewController chessBoardViewController;
    private final Player player;

    Check(final ChessboardViewController chessBoardViewController, final Player player) {
        this.chessBoardViewController = chessBoardViewController;
        this.player = player;
    }

    @Override
    public void printMessage(GameState gameState) {
        chessBoardViewController.getMessageDisplay().setText("Player " + player + " is in CHECK");
    }


}
