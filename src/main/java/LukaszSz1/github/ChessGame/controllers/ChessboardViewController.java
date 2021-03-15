package LukaszSz1.github.ChessGame.controllers;

import LukaszSz1.github.ChessGame.game.ChessboardPaint;
import LukaszSz1.github.ChessGame.model.Chessboard;
import LukaszSz1.github.ChessGame.model.PiecesController;
import LukaszSz1.github.ChessGame.services.TimeCounter;
import LukaszSz1.github.ChessGame.states.GameState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class ChessboardViewController {

    @FXML
    private Pane pane;

    @FXML
    private TextField playerWhiteTimeCounter;

    @FXML
    private TextField playerBlackTimeCounter;

    @FXML
    private TextField messageDisplay;

    @FXML
    private Button startGameButton;

    @FXML
    private Button restartGameButton;

    @FXML
    private Button giveUpButton;

    Chessboard chessboard = new Chessboard();

    GameState gameState = new GameState(this);



    PiecesController piecesController = new PiecesController(gameState, chessboard);

    ChessboardPaint chessboardPaint = new ChessboardPaint(chessboard, gameState, piecesController);

    @FXML
    public void initialize() {
        pane.getChildren().setAll(chessboardPaint);
        gameState.printMessage();
    }


    @FXML
    void giveUpButtonClick() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("End Game");
        alert.setContentText("Press OK to confirm.");
//        Optional<ButtonType> result = alert.showAndWait();
    }

    @FXML
    void restartGameButtonClick() {

        Chessboard restartChessboard = new Chessboard();
        GameState restartGameState = new GameState(this);
        PiecesController restartPiecesController = new PiecesController(restartGameState, restartChessboard);
        ChessboardPaint restartChessboardPaint = new ChessboardPaint(restartChessboard, restartGameState, restartPiecesController);

        if (callGameTimeDialogWindow(restartChessboard, restartPiecesController)) {
            pane.getChildren().setAll(restartChessboardPaint);
            piecesController.initializeChessboard();
            gameState.printMessage();
            startGameButton.setDisable(true);
            restartGameButton.setDisable(false);
            giveUpButton.setDisable(false);
        }

        chessboardPaint.drawPiecesOnChessBoard();
    }

    @FXML
    void startGameButtonClick() {
        if (callGameTimeDialogWindow(chessboard, piecesController)) {
            // add ChessBoardPaint to Pane
            pane.getChildren().setAll(chessboardPaint);
            piecesController.initializeChessboard();
            // enable displaying messages
            gameState.printMessage();
            // disable/enable buttons
            startGameButton.setDisable(true);
            restartGameButton.setDisable(false);
            giveUpButton.setDisable(false);
        }
        chessboardPaint.drawPiecesOnChessBoard();
    }

    public TextField getPlayerWhiteTimeCounter() {
        return playerWhiteTimeCounter;
    }

    public TextField getPlayerBlackTimeCounter() {
        return playerBlackTimeCounter;
    }

    public TextField getMessageDisplay() {
        return messageDisplay;
    }

    private boolean callGameTimeDialogWindow(Chessboard chessboard, PiecesController piecesController) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Choose Game Time");

        // load fxml
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GameTimeDialogWindow.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // set buttons
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        GameTimeDialogWindowController gameTimeDialogWindowController = fxmlLoader.getController();
        Optional<ButtonType> result = dialog.showAndWait();

        // clicked OK/Cancel button
        if (result.isPresent() && result.get() == ButtonType.OK) {
            int chosenTimeValue = gameTimeDialogWindowController.getChosenTime();
            // start timeCounter thread
            TimeCounter timeCounter = new TimeCounter(this, chosenTimeValue, piecesController);
            timeCounter.start();
            return true;
        } else {
            return false;
        }

    }

    public PiecesController getPiecesController() {
        return piecesController;
    }
}




