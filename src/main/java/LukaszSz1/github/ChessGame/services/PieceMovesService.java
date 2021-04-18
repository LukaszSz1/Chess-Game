package LukaszSz1.github.ChessGame.services;

import LukaszSz1.github.ChessGame.model.Coordinate;
import LukaszSz1.github.ChessGame.model.Piece;
import LukaszSz1.github.ChessGame.model.utils.Player;
import LukaszSz1.github.ChessGame.states.GameState;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

import static LukaszSz1.github.ChessGame.model.Chessboard.*;

@Controller
public class PieceMovesService {

    private final GameState gameState;
    private final KingStateService kingStateService;
    private final TurnService turnService;

    public PieceMovesService(final GameState gameState, final KingStateService kingStateService, final TurnService turnService) {
        this.gameState = gameState;
        this.kingStateService = kingStateService;
        this.turnService = turnService;
    }

    List<Coordinate> getValidMovesForPiece(final Piece p) {
        List<Coordinate> allPossibleCoordinates = p.getCoordinatesOfAllPossibleMoves();

        return allPossibleCoordinates.stream()
                .filter(coordinate -> kingStateService.isSuicideMove(coordinate.getX(), coordinate.getY(), p))
                .filter(coordinate -> !isCoordinateOutsideChessboard(coordinate))
                .collect(Collectors.toList());
    }

    private boolean isCoordinateOutsideChessboard(final Coordinate coords) {
        return coords.getX() >= NUMBER_OF_COLUMNS || coords.getX() < 0 || coords.getY() >= NUMBER_OF_ROWS || coords.getY() < 0;
    }

    void movePieceToEmptySquare(final int xClickedCoord, final int yClickedCoord, Piece chosenPiece) {
        List<Coordinate> allPossibleCoordinates = chosenPiece.getCoordinatesOfAllPossibleMoves();
        Player currentPlayerTurn = getCurrentPlayerTurnFor(chosenPiece);

        List<Coordinate> coordinatesWithoutSuicideMoves = allPossibleCoordinates.stream()
                .filter(coordinate -> kingStateService.isSuicideMove(coordinate.getX(), coordinate.getY(), chosenPiece))
                .collect(Collectors.toList());

        for (Coordinate coord : coordinatesWithoutSuicideMoves) {
            if (isChosenTileEmpty(xClickedCoord, yClickedCoord, coord)) {
                chosenPiece.setPieceOnChessboardWithCoordinates(xClickedCoord, yClickedCoord);
                turnService.turnIncrement();
                gameState.stateCheck(currentPlayerTurn);
            }
        }  //nothing happen, no possible moves
    }

    void movePieceToOpponentSquare(final Piece opponentPiece, final Piece chosenPiece) {
        List<Coordinate> allPossibleCoordinates = chosenPiece.getCoordinatesOfAllPossibleMoves();
        Player currentPlayerTurn = getCurrentPlayerTurnFor(chosenPiece);

        List<Coordinate> coordinatesWithoutSuicideMoves = allPossibleCoordinates.stream()
                .filter(coordinate -> kingStateService.isSuicideMove(coordinate.getX(), coordinate.getY(), chosenPiece))
                .collect(Collectors.toList());

        for (Coordinate coord : coordinatesWithoutSuicideMoves) {
            if (isOpponentPieceUnderCapture(opponentPiece, coord)) {
                opponentPiece.removePieceFromPreviousCoordinate();
                chosenPiece.setPieceOnChessboardWithCoordinates(coord.getX(), coord.getY());
                opponentPiece.deletePiece();
                turnService.turnIncrement();
                gameState.stateCheck(currentPlayerTurn);
            }
        } //nothing happen, no possible moves
    }

    private Player getCurrentPlayerTurnFor(final Piece chosenPiece) {
        return chosenPiece.getPlayer() == Player.WHITE ? Player.BLACK : Player.WHITE;
    }

    private boolean isOpponentPieceUnderCapture(final Piece opponentPiece, final Coordinate coord) {
        return coord.getX() == opponentPiece.getXCoordinate() && coord.getY() == opponentPiece.getYCoordinate();
    }

    private boolean isChosenTileEmpty(final int xClickedCoord, final int yClickedCoord, final Coordinate coord) {
        return coord.getX() == xClickedCoord && coord.getY() == yClickedCoord;
    }
}
