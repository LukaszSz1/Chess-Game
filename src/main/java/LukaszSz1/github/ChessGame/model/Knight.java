package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;

import java.util.ArrayList;
import java.util.List;

import static LukaszSz1.github.ChessGame.model.Chessboard.*;

class Knight extends Piece {

    Knight(final Chessboard chessboard, final Player player, final DrawingPath drawingPath, final Coordinate coordinates) {
        super(chessboard, player, drawingPath, coordinates);
    }

    @Override
    public List<Coordinate> getCoordinatesOfAllPossibleMoves() {
        List<Coordinate> coordinates = new ArrayList<>();

        firstCasePossibleMovesCheck(coordinates);
        secondCasePossibleMovesCheck(coordinates);
        thirdCasePossibleMovesCheck(coordinates);
        fourthCasePossibleMovesCheck(coordinates);
        fifthCasePossibleMovesCheck(coordinates);
        sixthCasePossibleMovesCheck(coordinates);
        seventhCasePossibleMovesCheck(coordinates);
        eightCasePossibleMovesCheck(coordinates);

        return coordinates;
    }

    private void eightCasePossibleMovesCheck(final List<Coordinate> coords) {
        final int xCoord;
        final int yCoord;
        xCoord = getXCoordinate() - 2;
        yCoord = getYCoordinate() - 1;
        if (xCoord >= 0 && yCoord < NUMBER_OF_ROWS && xCoord < NUMBER_OF_COLUMNS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord);
        }
    }

    private void seventhCasePossibleMovesCheck(final List<Coordinate> coords) {
        final int xCoord;
        final int yCoord;
        xCoord = getXCoordinate() - 2;
        yCoord = getYCoordinate() + 1;
        if (xCoord >= 0 && yCoord < NUMBER_OF_ROWS && xCoord < NUMBER_OF_COLUMNS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord);
        }
    }

    private void sixthCasePossibleMovesCheck(final List<Coordinate> coords) {
        final int xCoord;
        final int yCoord;
        xCoord = getXCoordinate() - 1;
        yCoord = getYCoordinate() + 2;
        if (xCoord >= 0 && yCoord < NUMBER_OF_ROWS && xCoord < NUMBER_OF_COLUMNS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord);
        }
    }

    private void fifthCasePossibleMovesCheck(final List<Coordinate> coords) {
        final int xCoord;
        final int yCoord;
        xCoord = getXCoordinate() + 1;
        yCoord = getYCoordinate() + 2;
        if (xCoord >= 0 && yCoord < NUMBER_OF_ROWS && xCoord < NUMBER_OF_COLUMNS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord);
        }
    }

    private void fourthCasePossibleMovesCheck(final List<Coordinate> coords) {
        final int xCoord;
        final int yCoord;
        xCoord = getXCoordinate() + 2;
        yCoord = getYCoordinate() + 1;
        if (xCoord >= 0 && yCoord < NUMBER_OF_ROWS && xCoord < NUMBER_OF_COLUMNS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord);
        }
    }

    private void thirdCasePossibleMovesCheck(final List<Coordinate> coords) {
        final int xCoord;
        final int yCoord;
        xCoord = getXCoordinate() + 2;
        yCoord = getYCoordinate() - 1;
        if (xCoord >= 0 && yCoord < NUMBER_OF_ROWS && xCoord < NUMBER_OF_COLUMNS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord);
        }
    }

    private void secondCasePossibleMovesCheck(final List<Coordinate> coords) {
        final int xCoord;
        final int yCoord;
        xCoord = getXCoordinate() + 1;
        yCoord = getYCoordinate() - 2;
        if (xCoord >= 0 && yCoord < NUMBER_OF_ROWS && xCoord < NUMBER_OF_COLUMNS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord);
        }
    }

    private void firstCasePossibleMovesCheck(final List<Coordinate> coords) {
        final int xCoord;
        final int yCoord;
        xCoord = getXCoordinate() - 1;
        yCoord = getYCoordinate() - 2;
        if (xCoord >= 0 && yCoord < NUMBER_OF_ROWS && xCoord < NUMBER_OF_COLUMNS) {
            isMoveValidCheckAndAddCoordinatesToList(coords, xCoord, yCoord);
        }
    }

}

