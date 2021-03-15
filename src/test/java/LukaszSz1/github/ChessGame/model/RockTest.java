package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockTest {

    Chessboard chessboard;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
    }

    @Test
    void getPossibleMoveCoordinateMethod_FirstSetting() {

        //given
        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook1 = 0;
        int yCoordRook1 = 0;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(0,1));
        int xCoordPawn1 = 0;
        int yCoordPawn1 = 1;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Rook rook2 = new Rook(chessboard, Player.WHITE, DrawingPath.WHITE_ROOK_PATH, new Coordinate(0,7));
        int xCoordRook2 = 0;
        int yCoordRook2 = 7;
        rook2.setPieceOnChessboardWithCoordinates(xCoordRook2, yCoordRook2);

        Pawn pawn2 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(0,6));
        int xCoordPawn2 = 0;
        int yCoordPawn2 = 6;
        pawn2.setPieceOnChessboardWithCoordinates(xCoordPawn2, yCoordPawn2);

        //when
        List<Coordinate> result = rook1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(7, result.size());
    }

    @Test
    void getPossibleMoveCoordinateMethod_SecondSetting() {

        //given
        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook1 = 3;
        int yCoordRook1 = 3;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(0,0));
        int xCoordPawn1 = 3;
        int yCoordPawn1 = 2;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Rook rook2 = new Rook(chessboard, Player.WHITE, DrawingPath.WHITE_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook2 = 4;
        int yCoordRook2 = 3;
        rook2.setPieceOnChessboardWithCoordinates(xCoordRook2, yCoordRook2);

        Pawn pawn2 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(0,0));
        int xCoordPawn2 = 3;
        int yCoordPawn2 = 4;
        pawn2.setPieceOnChessboardWithCoordinates(xCoordPawn2, yCoordPawn2);

        //when
        List<Coordinate> result = rook1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(5, result.size());
    }

    @Test
    void getPossibleMoveCoordinateMethod_ThirdSetting() {

        //given
        Rook rook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook1 = 4;
        int yCoordRook1 = 5;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        //when
        List<Coordinate> result = rook1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(14, result.size());
    }
}
