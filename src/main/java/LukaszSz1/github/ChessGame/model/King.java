package LukaszSz1.github.ChessGame.model;


import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;

import java.util.ArrayList;
import java.util.List;

import static LukaszSz1.github.ChessGame.model.Chessboard.*;

class King extends Piece {

    King(final Chessboard chessboard, final Player player, final DrawingPath drawingPath, final Coordinate coordinates) {
        super(chessboard, player, drawingPath, coordinates);
    }

    @Override
    public List<Coordinate> getCoordinatesOfAllPossibleMoves() {
        List<Coordinate> coordinates = new ArrayList<>();
        goTopPossibleMovesCheck(coordinates);
        goRightPossibleMovesCheck(coordinates);
        goBottomPossibleMovesCheck(coordinates);
        goLeftPossibleMovesCheck(coordinates);
        goLeftUpPossibleMovesCheck(coordinates);
        goRightTopPossibleMovesCheck(coordinates);
        goLeftBottomPossibleMovesCheck(coordinates);
        goRightBottomPossibleMovesCheck(coordinates);
        return coordinates;
    }

    private void goRightBottomPossibleMovesCheck(final List<Coordinate> coords) {
        if (getXCoordinate() + 1 < NUMBER_OF_ROWS && getYCoordinate() + 1 < NUMBER_OF_ROWS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate() + 1, getYCoordinate() + 1);
        }
    }

    private void goLeftBottomPossibleMovesCheck(final List<Coordinate> coords) {
        if (getXCoordinate() - 1 >= 0 && getYCoordinate() + 1 < NUMBER_OF_ROWS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate() - 1, getYCoordinate() + 1);
        }
    }

    private void goRightTopPossibleMovesCheck(final List<Coordinate> coords) {
        if (getXCoordinate() + 1 < NUMBER_OF_ROWS && getYCoordinate() - 1 >= 0) {
            isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate() + 1, getYCoordinate() - 1);
        }
    }

    private void goLeftUpPossibleMovesCheck(final List<Coordinate> coords) {
        if (getXCoordinate() - 1 >= 0 && getYCoordinate() - 1 >= 0) {
            isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate() - 1, getYCoordinate() - 1);
        }
    }

    private void goLeftPossibleMovesCheck(final List<Coordinate> coords) {
        if (getXCoordinate() - 1 >= 0) {
            isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate() - 1, getYCoordinate());
        }
    }

    private void goBottomPossibleMovesCheck(final List<Coordinate> coords) {
        if (getYCoordinate() + 1 < NUMBER_OF_ROWS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate(), getYCoordinate() + 1);
        }
    }

    private void goRightPossibleMovesCheck(final List<Coordinate> coords) {
        if (getXCoordinate() + 1 < NUMBER_OF_ROWS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate() + 1, getYCoordinate());
        }
    }

    private void goTopPossibleMovesCheck(final List<Coordinate> coords) {
        if (getYCoordinate() - 1 >= 0) {
            isMoveValidCheckAndAddCoordinatesToList(coords, getXCoordinate(), getYCoordinate() - 1);
        }
    }

    // TODO check if King moved

    // TODO check if roszada is possible
}

