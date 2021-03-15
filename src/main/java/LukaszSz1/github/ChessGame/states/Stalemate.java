package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.controllers.ChessboardViewController;

class Stalemate implements State {

    private final ChessboardViewController chessBoardViewController;

    Stalemate(final ChessboardViewController chessBoardViewController) {
        this.chessBoardViewController = chessBoardViewController;
    }

    @Override
    public void printMessage(GameState gameState) {
        chessBoardViewController.getMessageDisplay().setText("STALEMATE");
    }
}
