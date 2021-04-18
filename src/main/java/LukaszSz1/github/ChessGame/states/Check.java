package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.model.utils.Player;

class Check implements State {

    private final Player player;

    Check(final Player player) {
        this.player = player;
    }

    @Override
    public String printMessage(GameState gameState) {
        return "Player " + player + " is in CHECK";
    }
}
