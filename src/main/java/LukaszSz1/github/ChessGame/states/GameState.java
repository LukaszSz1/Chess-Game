package LukaszSz1.github.ChessGame.states;

import LukaszSz1.github.ChessGame.model.utils.Player;
import LukaszSz1.github.ChessGame.services.KingStateService;
import org.springframework.stereotype.Controller;

@Controller
public class GameState {

    private State state;
    private final KingStateService kingStateService;

    public GameState(final KingStateService kingStateService) {
        this.kingStateService = kingStateService;
        state = new StartGameState();
    }

    public String printMessage() {
        return state.printMessage(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void stateCheck(Player player) {
        if (kingStateService.isCheckmate(player)) {
            this.changeState(new Checkmate(player));
        } else if (kingStateService.isStalemate(player)) {
            this.changeState(new Stalemate());
        } else if (kingStateService.isInCheck()) {
            this.changeState(new Check(player));
        } else {
            this.changeState(new SimplePlayerMoveState(player));
        }
    }
}
