package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueenTest {

    Chessboard chessboard;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
    }

    @Test
    void getPossibleMoveCoordinateMethod_FirstSetting() {

        //given
        Queen rook1 = new Queen(chessboard, Player.BLACK, DrawingPath.BLACK_QUEEN_PATH, new Coordinate(0,0));
        int xCoordRook1 = 4;
        int yCoordRook1 = 0;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(0,0));
        int xCoordPawn1 = 4;
        int yCoordPawn1 = 1;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Pawn pawn2 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(0,0));
        int xCoordPawn2 = 5;
        int yCoordPawn2 = 1;
        pawn2.setPieceOnChessboardWithCoordinates(xCoordPawn2, yCoordPawn2);

        Rook rook2 = new Rook(chessboard, Player.WHITE, DrawingPath.WHITE_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook2 = 0;
        int yCoordRook2 = 4;
        rook2.setPieceOnChessboardWithCoordinates(xCoordRook2, yCoordRook2);

        //when
        List<Coordinate> result = rook1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(11, result.size());
    }

    @Test
    void getPossibleMoveCoordinateMethod_SecondSetting() {

        //given
        Queen rook1 = new Queen(chessboard, Player.BLACK, DrawingPath.BLACK_QUEEN_PATH, new Coordinate(0,0));
        int xCoordRook1 = 5;
        int yCoordRook1 = 3;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(0,0));
        int xCoordPawn1 = 6;
        int yCoordPawn1 = 2;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Rook rook2 = new Rook(chessboard, Player.WHITE, DrawingPath.WHITE_ROOK_PATH, new Coordinate(0,0));
        int xCoordRook2 = 4;
        int yCoordRook2 = 4;
        rook2.setPieceOnChessboardWithCoordinates(xCoordRook2, yCoordRook2);

        //when
        List<Coordinate> result = rook1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(20, result.size());
    }

    @Test
    void getPossibleMoveCoordinateMethod_ThirdSetting() {

        //given
        Queen rook1 = new Queen(chessboard, Player.BLACK, DrawingPath.BLACK_QUEEN_PATH, new Coordinate(0,0));
        int xCoordRook1 = 2;
        int yCoordRook1 = 5;
        rook1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        //when
        List<Coordinate> result = rook1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(25, result.size());
    }

}
