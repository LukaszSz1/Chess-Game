package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;

import java.util.ArrayList;
import java.util.List;

class Pawn extends Piece {

    private static final int MOVE_WHITE_PAWN = 1;
    private static final int MOVE_BLACK_PAWN = -1;

    Pawn(final Chessboard chessboard, final Player player, final DrawingPath drawingPath, final Coordinate coordinates) {
        super(chessboard, player, drawingPath, coordinates);
    }

    @Override
    public List<Coordinate> getCoordinatesOfAllPossibleMoves() {
        List<Coordinate> coordinates = new ArrayList<>();

        int getBlackOrWhitePawnMove = getPlayer() == Player.WHITE ? MOVE_WHITE_PAWN : MOVE_BLACK_PAWN;

        goOneSquareForwardCheck(coordinates, getBlackOrWhitePawnMove);
        goTwoSquaresForwardCheck(coordinates, getBlackOrWhitePawnMove);
        captureOpponentSquareOnTheLeftCheck(coordinates, getBlackOrWhitePawnMove);
        captureOpponentSquareOnTheRightCheck(coordinates, getBlackOrWhitePawnMove);

        return coordinates;
    }

    private void captureOpponentSquareOnTheRightCheck(final List<Coordinate> coords, final int pawnMove) {
        if (getChessboard().getPieceFromCoordinates(getXCoordinate() + 1, getYCoordinate() + pawnMove) != null && getChessboard().getPieceFromCoordinates(getXCoordinate() + 1, getYCoordinate() + pawnMove).getPlayer() != getPlayer()) {
            coords.add(new Coordinate(getXCoordinate() + 1, getYCoordinate() + pawnMove));
        }
    }

    private void captureOpponentSquareOnTheLeftCheck(final List<Coordinate> coords, final int pawnMove) {
        if (getChessboard().getPieceFromCoordinates(getXCoordinate() - 1, getYCoordinate() + pawnMove) != null && getChessboard().getPieceFromCoordinates(getXCoordinate() - 1, getYCoordinate() + pawnMove).getPlayer() != getPlayer()) {
            coords.add(new Coordinate(getXCoordinate() - 1, getYCoordinate() + pawnMove));
        }
    }

    private void goTwoSquaresForwardCheck(final List<Coordinate> coords, final int pawnMove) {
        if (!isPieceAlreadyMoved(this) && getChessboard().getPieceFromCoordinates(getXCoordinate(), getYCoordinate() + pawnMove) == null && getChessboard().getPieceFromCoordinates(getXCoordinate(), getYCoordinate() + pawnMove + pawnMove) == null) {
            coords.add(new Coordinate(getXCoordinate(), getYCoordinate() + pawnMove * 2));
        }
    }

    private void goOneSquareForwardCheck(final List<Coordinate> coords, final int pawnMove) {
        if (getChessboard().getPieceFromCoordinates(getXCoordinate(), getYCoordinate() + pawnMove) == null) {
            coords.add(new Coordinate(getXCoordinate(), getYCoordinate() + pawnMove));
        }
    }

    //TODO pawn promotion

    //TODO bicie w przelocie
}

