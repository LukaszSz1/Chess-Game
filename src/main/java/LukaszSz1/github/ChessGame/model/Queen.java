package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;

import java.util.ArrayList;
import java.util.List;

import static LukaszSz1.github.ChessGame.model.Chessboard.*;

class Queen extends Piece {

    Queen(final Chessboard chessboard, final Player player, final DrawingPath drawingPath, final Coordinate coordinates) {
        super(chessboard, player, drawingPath, coordinates);
    }

    @Override
    public List<Coordinate> getCoordinatesOfAllPossibleMoves() {
        List<Coordinate> coords = new ArrayList<>();

        goUpPossibleMovesCheck(coords);
        goDownPossibleMovesCheck(coords);
        goRightPossibleMovesCheck(coords);
        goLeftPossibleMovesCheck(coords);
        goLeftDownPossibleMovesCheck(coords);
        goRightDownPossibleMovesCheck(coords);
        goLeftUpPossibleMovesCheck(coords);
        goRightUpPossibleMovesCheck(coords);

        return coords;
    }

    private void goRightUpPossibleMovesCheck(final List<Coordinate> coords) {
        int xCoord;
        int yCoord;
        for (xCoord = getXCoordinate() + 1, yCoord = getYCoordinate() + 1; xCoord < NUMBER_OF_COLUMNS && yCoord < NUMBER_OF_ROWS; xCoord++, yCoord++) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord)) {
                break;
            }
        }
    }

    private void goLeftUpPossibleMovesCheck(final List<Coordinate> coords) {
        int yCoord;
        int xCoord;
        for (xCoord = getXCoordinate() - 1, yCoord = getYCoordinate() + 1; xCoord >= 0 && yCoord < NUMBER_OF_ROWS; xCoord--, yCoord++) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord)) {
                break;
            }
        }
    }

    private void goRightDownPossibleMovesCheck(final List<Coordinate> coords) {
        int yCoord;
        int xCoord;
        for (xCoord = getXCoordinate() + 1, yCoord = getYCoordinate() - 1; xCoord < NUMBER_OF_COLUMNS && yCoord >= 0; xCoord++, yCoord--) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord)) {
                break;
            }
        }
    }

    private void goLeftDownPossibleMovesCheck(final List<Coordinate> coords) {
        int yCoord;
        int xCoord;
        for (xCoord = getXCoordinate() - 1, yCoord = getYCoordinate() - 1; xCoord >= 0 && yCoord >= 0; xCoord--, yCoord--) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord)) {
                break;
            }
        }
    }

    private void goLeftPossibleMovesCheck(final List<Coordinate> coords) {
        int xCoord;
        for (xCoord = getXCoordinate() - 1; xCoord >= 0; xCoord--) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, getYCoordinate())) {
                break;
            }
        }
    }

    private void goRightPossibleMovesCheck(final List<Coordinate> coords) {
        int xCoord;
        for (xCoord = getXCoordinate() + 1; xCoord < NUMBER_OF_COLUMNS; xCoord++) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, getYCoordinate())) {
                break;
            }
        }
    }

    private void goDownPossibleMovesCheck(final List<Coordinate> coords) {
        int yCoord;
        for (yCoord = getYCoordinate() + 1; yCoord < NUMBER_OF_ROWS; yCoord++) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate(), yCoord)) {
                break;
            }
        }
    }

    private void goUpPossibleMovesCheck(final List<Coordinate> coords) {
        int yCoord;
        for (yCoord = getYCoordinate() - 1; yCoord >= 0; yCoord--) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate(), yCoord)) {
                break;
            }
        }
    }
}
