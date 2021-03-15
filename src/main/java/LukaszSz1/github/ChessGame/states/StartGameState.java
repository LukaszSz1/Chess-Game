package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.controllers.ChessboardViewController;
import LukaszSz1.github.ChessGame.model.utils.Player;

class StartGameState implements State {

    private final ChessboardViewController chessBoardViewController;

    StartGameState(final ChessboardViewController chessBoardViewController) {
        this.chessBoardViewController = chessBoardViewController;
    }

    @Override
    public void printMessage(GameState gameState) {
        chessBoardViewController.getMessageDisplay().setText("Press Game Start button to start New Game");
        gameState.changeState(new SimplePlayerMoveState(chessBoardViewController, Player.WHITE));
    }


}
