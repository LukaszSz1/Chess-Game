package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnightTest {

    Chessboard chessboard;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_FirstSetting() {

        //given
        Knight knight1 = new Knight(chessboard, Player.BLACK, DrawingPath.BLACK_KNIGHT_PATH, new Coordinate(4,3));
        int xCoordRook1 = 4;
        int yCoordRook1 = 3;
        knight1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(6,2));
        int xCoordPawn1 = 6;
        int yCoordPawn1 = 2;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Pawn pawn2 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(0,7));
        int xCoordPawn2 = 0;
        int yCoordPawn2 = 7;
        pawn2.setPieceOnChessboardWithCoordinates(xCoordPawn2, yCoordPawn2);

        Pawn pawn3 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(2,4));
        int xCoordPawn3 = 2;
        int yCoordPawn3 = 4;
        pawn3.setPieceOnChessboardWithCoordinates(xCoordPawn3, yCoordPawn3);

        //when
        List<Coordinate> result = knight1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(7, result.size());
    }


    @Test
    void getCoordinatesOfAllPossibleMovesMethod_SecondSetting() {

        //given
        Knight knight1 = new Knight(chessboard, Player.BLACK, DrawingPath.BLACK_KNIGHT_PATH, new Coordinate(5,1));
        int xCoordRook1 = 5;
        int yCoordRook1 = 1;
        knight1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(6,3));
        int xCoordPawn1 = 6;
        int yCoordPawn1 = 3;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Pawn pawn2 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(4,3));
        int xCoordPawn2 = 4;
        int yCoordPawn2 = 3;
        pawn2.setPieceOnChessboardWithCoordinates(xCoordPawn2, yCoordPawn2);

        Pawn pawn3 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(3,2));
        int xCoordPawn3 = 3;
        int yCoordPawn3 = 2;
        pawn3.setPieceOnChessboardWithCoordinates(xCoordPawn3, yCoordPawn3);

        //when
        List<Coordinate> result = knight1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(4, result.size());
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_ThirdSetting() {

        //given
        Knight knight1 = new Knight(chessboard, Player.WHITE, DrawingPath.WHITE_KNIGHT_PATH, new Coordinate(4,5));
        int xCoordRook1 = 4;
        int yCoordRook1 = 5;
        knight1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(2,6));
        int xCoordPawn1 = 2;
        int yCoordPawn1 = 6;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Pawn pawn3 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(3,7));
        int xCoordPawn3 = 3;
        int yCoordPawn3 = 7;
        pawn3.setPieceOnChessboardWithCoordinates(xCoordPawn3, yCoordPawn3);

        //when
        List<Coordinate> result = knight1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(7, result.size());
    }

}
