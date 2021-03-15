package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PieceTest {

    Chessboard chessboard;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
    }

    @Test
    void addToCoordinatesIfValidMethod_dontAddCoordsToListAndReturnsFalse_when_playerPieceMeetsOwnPiece() {

        //given
        ArrayList<Coordinate> coords = new ArrayList<>();
        ArrayList<Coordinate> testCoordsList = new ArrayList<>();

        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook1 = 0;
        int yCoordRook1 = 0;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(0,1));
        int xCoordPawn1 = 0;
        int yCoordPawn1 = 1;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        //when
        boolean result = rook1.isMoveValidCheckAndAddCoordinatesToList(coords, xCoordPawn1, yCoordPawn1);
        testCoordsList.add(new Coordinate(xCoordPawn1, yCoordPawn1));

        //then
        assertTrue(result);
        assertEquals(Collections.EMPTY_LIST, coords);
        assertNotEquals(testCoordsList, coords);

    }

    @Test
    void addToCoordinatesIfValidMethod_AddCoordsToListAndReturnsTrue_when_playerPieceMeetsOpponentPiece() {

        //given
        ArrayList<Coordinate> coords = new ArrayList<>();

        // black rook init
        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook1 = 0;
        int yCoordRook1 = 0;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        // white pawn init
        Pawn pawn2 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(0,6));
        int xCoordPawn2 = 0;
        int yCoordPawn2 = 6;
        pawn2.setPieceOnChessboardWithCoordinates(xCoordPawn2, yCoordPawn2);

        //when
        boolean result = rook1.isMoveValidCheckAndAddCoordinatesToList(coords, xCoordPawn2, yCoordPawn2);

        //then
        assertTrue(result);
        assertNotEquals(Collections.emptyList(), coords);
    }

    @Test
    void addToCoordinatesIfValidMethod_AddCoordsToListAndReturnsFalse_when_playerMeetsEmptySquare() {

        //given
        ArrayList<Coordinate> coords = new ArrayList<>();

        // black rook init
        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook1 = 0;
        int yCoordRook1 = 0;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        // empty coords init
        int xCoordPawn2 = 0;
        int yCoordPawn2 = 6;

        //when
        boolean result = rook1.isMoveValidCheckAndAddCoordinatesToList(coords, xCoordPawn2, yCoordPawn2);

        //then
        assertFalse(result);
        assertNotEquals(Collections.emptyList(), coords);
    }

//    @Test
//    void setCoordinateMethod_ReturnsFalse_when_xCoordIsLowerThanBorder() {
//
//        //given
//        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(-2,1));
//        int xCoordRook1 = -2;
//        int yCoordRook1 = 1;
//
//        //when
//        rook1.setPieceOnChessboardWithCoords(xCoordRook1, yCoordRook1);
//
//        //then
//        assertFalse(result);
//    }
//
//    @Test
//    void setCoordinateMethod_ReturnsFalse_when_xCoordIsHigherThanBorder() {
//
//        //given
//        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(10,1));
//        int xCoordRook1 = 10;
//        int yCoordRook1 = 1;
//
//        //when
//        boolean result = rook1.setPieceOnChessboardWithCoords(xCoordRook1, yCoordRook1);
//
//        //then
//        assertFalse(result);
//    }
//
//    @Test
//    void setCoordinateMethod_ReturnsFalse_when_yCoordIsLowerThanBorder() {
//
//        //given
//        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(1,-2));
//        int xCoordRook1 = 1;
//        int yCoordRook1 = -2;
//
//        //when
//        boolean result = rook1.setPieceOnChessboardWithCoords(xCoordRook1, yCoordRook1);
//
//        //then
//        assertFalse(result);
//    }
//
//    @Test
//    void setCoordinateMethod_ReturnsFalse_when_yCoordIsHigherThanBorder() {
//
//        //given
//        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(1,10));
//        int xCoordRook1 = 1;
//        int yCoordRook1 = 10;
//
//        //when
//        boolean result = rook1.setPieceOnChessboardWithCoords(xCoordRook1, yCoordRook1);
//
//        //then
//        assertFalse(result);
//    }

    @Test
    void setCoordinateMethod_removesPieceFromPreviousCoordinates_when_pieceMoved() {

        //given
        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook1 = 0;
        int yCoordRook1 = 0;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);
        chessboard.setPieceAtCoordinates(rook1, xCoordRook1, yCoordRook1);

        int newXCoordRook1 = 0;
        int newYCoordRook1 = 1;

        //when
        rook1.setPieceOnChessboardWithCoordinates(newXCoordRook1, newYCoordRook1);

        //then
        assertNull(chessboard.getPieceFromCoordinates(xCoordRook1, yCoordRook1));
    }

    @Test
    void setCoordinateMethod_setsNewCoordinates_when_pieceMoved() {

        //given
        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook1 = 0;
        int yCoordRook1 = 0;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);
        chessboard.setPieceAtCoordinates(rook1, xCoordRook1, yCoordRook1);

        int newXCoordRook1 = 0;
        int newYCoordRook1 = 1;

        //when
        rook1.setPieceOnChessboardWithCoordinates(newXCoordRook1, newYCoordRook1);

        //then
        assertNotNull(chessboard.getPieceFromCoordinates(newXCoordRook1, newYCoordRook1));
    }

}
