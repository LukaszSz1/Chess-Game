package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.model.utils.Player;

class SimplePlayerMoveState implements State {

    private final Player player;

    SimplePlayerMoveState(final Player player) {
        this.player = player;
    }

    @Override
    public String printMessage(GameState gameState) {
        if (player.equals(Player.BLACK)) {
            return "Player Black turn";
        } else {
            return "Player White turn";
        }
    }
}
