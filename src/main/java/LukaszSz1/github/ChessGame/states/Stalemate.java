package LukaszSz1.github.ChessGame.states;

class Stalemate implements State {

    @Override
    public String printMessage(GameState gameState) {
        return "STALEMATE";
    }
}
