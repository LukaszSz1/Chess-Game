package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.model.utils.Player;

class StartGameState implements State {

    @Override
    public String printMessage(GameState gameState) {
        gameState.changeState(new SimplePlayerMoveState(Player.WHITE));
        return "Press Game Start button to start New Game";
    }


}
