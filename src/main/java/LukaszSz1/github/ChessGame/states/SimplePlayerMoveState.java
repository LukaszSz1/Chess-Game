package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.controllers.ChessboardViewController;
import LukaszSz1.github.ChessGame.model.utils.Player;

class SimplePlayerMoveState implements State {

    private final ChessboardViewController chessBoardViewController;
    private final Player player;

    SimplePlayerMoveState(final ChessboardViewController chessBoardViewController, final Player player) {
        this.chessBoardViewController = chessBoardViewController;
        this.player = player;
    }

    @Override
    public void printMessage(GameState gameState) {
        if (player.equals(Player.BLACK)) {
            chessBoardViewController.getMessageDisplay().setText("Player Black turn");
        } else {
            chessBoardViewController.getMessageDisplay().setText("Player White turn");
        }
    }
}
