package LukaszSz1.github.ChessGame.services;

import LukaszSz1.github.ChessGame.model.utils.Player;
import org.springframework.stereotype.Controller;

@Controller
public class TurnService {
    private int turn;

    public TurnService() {
        this.turn = 0;
    }

    public void turnIncrement() {
        turn++;
    }

    public Player getCurrentPlayerTurn() {
        return (turn % 2 == 0) ? Player.WHITE : Player.BLACK;
    }
}
