package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;

import java.util.ArrayList;
import java.util.List;

import static LukaszSz1.github.ChessGame.model.Chessboard.*;

public abstract class Piece {
    private final Chessboard chessboard;
    private final Coordinate coordinates;
    private final DrawingPath drawingPath;
    private final Player player;
    private final List<Piece> alreadyMovedPieces = new ArrayList<>();

    Piece(final Chessboard chessboard, final Player player, final DrawingPath drawingPath, final Coordinate coordinates) {
        this.coordinates = coordinates;
        this.drawingPath = drawingPath;
        this.player = player;
        this.chessboard = chessboard;
        chessboard.addPieceToWhiteOrBlackList(this);
    }

   public abstract List<Coordinate> getCoordinatesOfAllPossibleMoves();

    public int getXCoordinate() {
        return coordinates.getX();
    }

    public int getYCoordinate() {
        return coordinates.getY();
    }

    public Player getPlayer() {
        return player;
    }

    public DrawingPath getDrawPath() {
        return drawingPath;
    }

    Chessboard getChessboard() {
        return chessboard;
    }

   public void setPieceOnChessboardWithCoordinates(final int x, final int y) {
        addPieceToAlreadyMovedPiecesList(); // watch out for this second responsibility
        removePieceFromPreviousCoordinate();
        setNewCoordinate(x, y);
        savePieceOnChessboardWithNewCoordinates(x, y);
    }

   public void setPieceOnChessboardWithoutAddingToAlreadyMovedListWithCoordinates(final int x, final int y) {
        removePieceFromPreviousCoordinate();
        setNewCoordinate(x, y);
        savePieceOnChessboardWithNewCoordinates(x, y);
    }

    private void addPieceToAlreadyMovedPiecesList() {
        alreadyMovedPieces.add(this);
    }

    private void setNewCoordinate(final int x, final int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    public void removePieceFromPreviousCoordinate() {
        chessboard.removePieceFromChessboard(this);
    }

    void initialSetPieceOnChessboardWithCoordinates(final int x, final int y) {
        savePieceOnChessboardWithNewCoordinates(x, y);
    }

    boolean isPieceAlreadyMoved(Piece p) {
        return alreadyMovedPieces.contains(p);
    }

   public void deletePiece() {
        if (player == Player.BLACK) {
            chessboard.getBlackPieces().remove(this);
        } else {
            chessboard.getWhitePieces().remove(this);
        }
    }

    /**
     * Method with 2 responsibilities:
     * 1. Control flow of loops inside getCoordinatesOfAllPossibleMoves() method in concrete pieces implementations
     * 2. Adds sent coordinates to List and passes it further through coords argument
     */
    boolean isMoveValidCheckAndAddCoordinatesToList(List<Coordinate> coords, int x, int y) {

        if (isCoordinateOutsideChessboard(x, y)) {
            return false; // Knights behaving strange without this check, they went outside Chessboard
        } else if (isCoordinateEmpty(x, y)) {
            addGivenCoordinatesToList(coords, x, y);
            return false;
        } else if (isOpponentPieceOnCoordinates(x, y)) {
            addGivenCoordinatesToList(coords, x, y);
            return true;
        } else { // player meets own piece
            return true;
        }

    }

    private boolean isCoordinateOutsideChessboard(final int x, final int y) {
        return x < 0 || x >= NUMBER_OF_COLUMNS || y < 0 || y >= NUMBER_OF_ROWS;
    }

    private void savePieceOnChessboardWithNewCoordinates(final int x, final int y) {
        chessboard.setPieceAtCoordinates(this, x, y);
    }

    private void addGivenCoordinatesToList(final List<Coordinate> coords, final int x, final int y) {
        coords.add(new Coordinate(x, y));
    }

    private boolean isOpponentPieceOnCoordinates(final int x, final int y) {
        return chessboard.getPieceFromCoordinates(x, y).getPlayer() != player;
    }

    private boolean isCoordinateEmpty(final int x, final int y) {
        return chessboard.getPieceFromCoordinates(x, y) == null;
    }
}
