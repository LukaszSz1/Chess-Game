package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.model.utils.Player;

class Checkmate implements State {

    private final Player player;

    Checkmate(final Player player) {
        this.player = player;
    }

    @Override
    public String printMessage(GameState gameState) {
        return "Player " + player + " is in CHECKMATE";
    }
}
