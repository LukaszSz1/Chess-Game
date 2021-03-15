package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;

import java.util.ArrayList;
import java.util.List;

import static LukaszSz1.github.ChessGame.model.Chessboard.*;

class Bishop extends Piece {

    Bishop(final Chessboard chessboard, final Player player, final DrawingPath drawingPath, final Coordinate coordinates) {
        super(chessboard, player, drawingPath, coordinates);
    }

    @Override
    public List<Coordinate> getCoordinatesOfAllPossibleMoves() {
        List<Coordinate> coordinates = new ArrayList<>();
        goLeftBottomPossibleMovesCheck(coordinates);
        goLeftTopPossibleMovesCheck(coordinates);
        goRightBottomPossibleMovesCheck(coordinates);
        goRightTopPossibleMovesCheck(coordinates);
        return coordinates;
    }

    private void goLeftBottomPossibleMovesCheck(final List<Coordinate> coords) {
        int yCoord;
        int xCoord;
        for (xCoord = getXCoordinate() - 1, yCoord = getYCoordinate() - 1; xCoord >= 0 && yCoord >= 0; xCoord--, yCoord--) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord)) {
                break;
            }
        }
    }

    private void goRightBottomPossibleMovesCheck(final List<Coordinate> coords) {
        int yCoord;
        int xCoord;
        for (xCoord = getXCoordinate() + 1, yCoord = getYCoordinate() - 1; xCoord < NUMBER_OF_COLUMNS && yCoord >= 0; xCoord++, yCoord--) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord)) {
                break;
            }
        }
    }

    private void goLeftTopPossibleMovesCheck(final List<Coordinate> coords) {
        int yCoord;
        int xCoord;
        for (xCoord = getXCoordinate() - 1, yCoord = getYCoordinate() + 1; xCoord >= 0 && yCoord < NUMBER_OF_ROWS; xCoord--, yCoord++) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord)) {
                break;
            }
        }
    }

    private void goRightTopPossibleMovesCheck(final List<Coordinate> coords) {
        int xCoord;
        int yCoord;
        for (xCoord = getXCoordinate() + 1, yCoord = getYCoordinate() + 1; xCoord < NUMBER_OF_COLUMNS && yCoord < NUMBER_OF_ROWS; xCoord++, yCoord++) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord)) {
                break;
            }
        }
    }

}

