package LukaszSz1.github.ChessGame.services;

import LukaszSz1.github.ChessGame.model.Chessboard;
import LukaszSz1.github.ChessGame.model.Piece;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Controller;

import static LukaszSz1.github.ChessGame.model.Chessboard.TILE_SIZE;

@Controller
public class ChessboardService extends AnchorPane {

    private final Chessboard chessboard;
    private final ChessboardPainterService chessboardPainterService;
    private final PieceMovesService pieceMovesService;
    private final TurnService turnService;
    private Piece chosenPiece;
    private double xCoordClicked;
    private double yCoordClicked;

    public ChessboardService(Chessboard chessboard, ChessboardPainterService chessboardPainterService, PieceMovesService pieceMovesService, TurnService turnService) {
        this.chessboard = chessboard;
        this.chessboardPainterService = chessboardPainterService;
        this.pieceMovesService = pieceMovesService;
        this.turnService = turnService;
        chosenPiece = null;
        xCoordClicked = -1;
        yCoordClicked = -1;
        initializePaneStartLook();
    }

    public void initializeStartGame() {
        chessboardPainterService.drawPiecesOnChessBoard();
        mouseClickEvent();
    }

    private void initializePaneStartLook() {
        getChildren().addAll(chessboardPainterService.getTileGroup(), chessboardPainterService.getPieceGroup());
        chessboardPainterService.repaintChessboard(xCoordClicked, yCoordClicked);
    }

    private void mouseClickEvent() {
        setOnMouseClicked(e -> {
            xCoordClicked = e.getX();
            yCoordClicked = e.getY();
            UserClick(xCoordClicked, yCoordClicked);
        });
    }

    private void UserClick(final double xClickedCoord, final double yClickedCoord) {

        int x = (int) (xClickedCoord / TILE_SIZE);
        int y = (int) (yClickedCoord / TILE_SIZE);
        Piece clickedPiece = chessboard.getPieceFromCoordinates(x, y);

        chessboardPainterService.repaintChessboard(xCoordClicked, yCoordClicked);

        if (clickedPiece != null) {

            if (playerClickedOwnPiece(clickedPiece) && chosenPiece == null) {
                chosenPiece = clickedPiece;
                chessboardPainterService.drawPossibleMoves(pieceMovesService.getValidMovesForPiece(clickedPiece));

            } else if (!playerClickedOwnPiece(clickedPiece) && chosenPiece != null) {
                pieceMovesService.movePieceToOpponentSquare(clickedPiece, chosenPiece);
                chessboardPainterService.repaintChessboard(xClickedCoord, yClickedCoord);
                chosenPiece = null;

            } // ELSE - player clicked opponent piece and chosenPiece was null while click - do nothing

        } else if (chosenPiece != null) {
            pieceMovesService.movePieceToEmptySquare(x, y, chosenPiece);
            chessboardPainterService.repaintChessboard(xClickedCoord, yClickedCoord);
            chosenPiece = null;

        }  // ELSE - player clicked empty field and chosenPiece was null while click - do nothing
    }

    private boolean playerClickedOwnPiece(final Piece clickedPiece) {
        return clickedPiece.getPlayer() == turnService.getCurrentPlayerTurn();
    }

}
