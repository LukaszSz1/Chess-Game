package LukaszSz1.github.ChessGame.services;


import LukaszSz1.github.ChessGame.controllers.ChessboardViewController;
import LukaszSz1.github.ChessGame.model.utils.Player;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class TimeService extends Service<String> {

    private final ChessboardViewController chessboardViewController;
    private final TurnService turnService;
    private int blackTotalTime;
    private int whiteTotalTime;

    public TimeService(final ChessboardViewController chessboardViewController, final int totalGameTime, final TurnService turnService) {
        this.chessboardViewController = chessboardViewController;
        this.turnService = turnService;
        blackTotalTime = 60 * totalGameTime;
        whiteTotalTime = 60 * totalGameTime;
    }

    @Override
    public Task<String> createTask() {
        chessboardViewController.getPlayerBlackTimeCounter().setText(convertTotalTimeToString(blackTotalTime));
        chessboardViewController.getPlayerWhiteTimeCounter().setText(convertTotalTimeToString(blackTotalTime));
        return new Task<>() {
            @Override
            protected String call() {
                while (blackTotalTime > 0 || whiteTotalTime > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Wątek zliczania czasu został przerwany");
                        return null;
                    }
                    if (turnService.getCurrentPlayerTurn() == Player.BLACK){
                        blackTotalTime--;
                        chessboardViewController.getPlayerBlackTimeCounter().setText(convertTotalTimeToString(blackTotalTime));
                    } else{
                        whiteTotalTime--;
                        chessboardViewController.getPlayerWhiteTimeCounter().setText(convertTotalTimeToString(whiteTotalTime));
                    }
                }
                return null;
            }
        };
    }
    private String convertTotalTimeToString(final int totalTime) {
        String startTime = "00:00";
        int minutes = totalTime / 60 + Integer.parseInt(startTime.substring(0, 1));
        int seconds = totalTime % 60 + Integer.parseInt(startTime.substring(3, 4));
        return String.format("%02d:%02d", minutes, seconds);
    }
}
