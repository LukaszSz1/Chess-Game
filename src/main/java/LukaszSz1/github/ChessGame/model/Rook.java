package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;

import java.util.ArrayList;
import java.util.List;

import static LukaszSz1.github.ChessGame.model.Chessboard.*;

class Rook extends Piece {

    Rook(final Chessboard chessboard, final Player player, final DrawingPath drawingPath, final Coordinate coordinates) {
        super(chessboard, player, drawingPath, coordinates);
    }

    @Override
    public List<Coordinate> getCoordinatesOfAllPossibleMoves() {
        List<Coordinate> coords = new ArrayList<>();
        goUpPossibleMovesCheck(coords);
        goDownPossibleMovesCheck(coords);
        goLeftPossibleMovesCheck(coords);
        goRightPossibleMovesCheck(coords);
        return coords;
    }

    private void goRightPossibleMovesCheck(final List<Coordinate> coords) {
        int xCoord;
        for (xCoord = getXCoordinate() + 1; xCoord < NUMBER_OF_COLUMNS; xCoord++) {
            if (isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, getYCoordinate())) {
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

    // TODO check if Rook moved

    // TODO check if roszada is possible
}

