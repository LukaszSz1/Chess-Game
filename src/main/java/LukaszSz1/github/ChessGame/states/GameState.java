package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.controllers.ChessboardViewController;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.springframework.stereotype.Component;

@Component
public class GameState {

    private State state;
    private final ChessboardViewController chessBoardViewController;

    public GameState(final ChessboardViewController chessBoardViewController) {
        this.chessBoardViewController = chessBoardViewController;
        state = new StartGameState(chessBoardViewController);
    }

    public void printMessage() {
        state.printMessage(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void stateCheck(Player player) {
        if (chessBoardViewController.getPiecesController().isCheckmate(player)) {
            this.changeState(new Checkmate(chessBoardViewController, player));
        } else if (chessBoardViewController.getPiecesController().isStalemate(player)) {
            this.changeState(new Stalemate(chessBoardViewController));
        } else if (chessBoardViewController.getPiecesController().isInCheck()) {
            this.changeState(new Check(chessBoardViewController, player));
        } else {
            this.changeState(new SimplePlayerMoveState(chessBoardViewController, player));
        }
    }


}
