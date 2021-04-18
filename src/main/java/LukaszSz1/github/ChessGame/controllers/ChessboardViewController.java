package LukaszSz1.github.ChessGame.controllers;

import LukaszSz1.github.ChessGame.model.Chessboard;
import LukaszSz1.github.ChessGame.model.ChessboardInitializer;
import LukaszSz1.github.ChessGame.services.ChessboardService;
import LukaszSz1.github.ChessGame.services.ChessboardPainterService;
import LukaszSz1.github.ChessGame.services.PieceMovesService;
import LukaszSz1.github.ChessGame.services.KingStateService;
import LukaszSz1.github.ChessGame.services.TimeService;
import LukaszSz1.github.ChessGame.services.TurnService;
import LukaszSz1.github.ChessGame.states.GameState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    Chessboard chessboard;
    TurnService turnService;
    KingStateService kingStateService;
    GameState gameState;
    ChessboardInitializer chessboardInitializer;
    ChessboardPainterService chessboardPainterService;
    PieceMovesService pieceMovesService;
    ChessboardService chessboardService;

    ChessboardViewController(final Chessboard chessboard, final TurnService turnService, final KingStateService kingStateService,
                             final GameState gameState, final ChessboardInitializer chessboardInitializer,
                             final ChessboardPainterService chessboardPainterService, final PieceMovesService pieceMovesService,
                             final ChessboardService chessboardService) {
        this.chessboard = chessboard;
        this.turnService = turnService;
        this.kingStateService = kingStateService;
        this.gameState = gameState;
        this.chessboardInitializer = chessboardInitializer;
        this.chessboardPainterService = chessboardPainterService;
        this.pieceMovesService = pieceMovesService;
        this.chessboardService = chessboardService;
    }

    @FXML
    public void initialize() {
        pane.getChildren().setAll(chessboardService);
        messageDisplay.setText(gameState.printMessage());
    }

    @FXML
    void giveUpButtonClick() {
    }

    @FXML
    void restartGameButtonClick() {
    }

    @FXML
    void startGameButtonClick() {
        if (callGameTimeDialogWindow()) {
            chessboardInitializer.initializeChessboard();
            messageDisplay.setText(gameState.printMessage());
            startGameButton.setDisable(true);
            restartGameButton.setDisable(false);
            giveUpButton.setDisable(false);
        }
        chessboardService.initializeStartGame();
    }

    public TextField getPlayerWhiteTimeCounter() {
        return playerWhiteTimeCounter;
    }

    public TextField getPlayerBlackTimeCounter() {
        return playerBlackTimeCounter;
    }

    private boolean callGameTimeDialogWindow() {
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
            TimeService timeService = new TimeService(this, chosenTimeValue, turnService);
            timeService.start();
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void mouseClickedEvent() {
        messageDisplay.setText(gameState.printMessage());
    }
}




