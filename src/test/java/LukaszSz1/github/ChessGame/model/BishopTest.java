package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BishopTest {

    Chessboard chessboard;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_FirstSetting() {

        //given
        Bishop bishop1 = new Bishop(chessboard, Player.BLACK, DrawingPath.BLACK_BISHOP_PATH, new Coordinate(2,7));
        int xCoordRook1 = 2;
        int yCoordRook1 = 7;
        bishop1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(4,5));
        int xCoordPawn1 = 4;
        int yCoordPawn1 = 5;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Pawn pawn3 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(1,6));
        int xCoordPawn3 = 1;
        int yCoordPawn3 = 6;
        pawn3.setPieceOnChessboardWithCoordinates(xCoordPawn3, yCoordPawn3);

        //when
        List<Coordinate> result = bishop1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(2, result.size());
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_SecondSetting() {
        //given
        Bishop bishop1 = new Bishop(chessboard, Player.BLACK, DrawingPath.BLACK_BISHOP_PATH, new Coordinate(5,5));
        int xCoordRook1 = 5;
        int yCoordRook1 = 5;
        bishop1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(3,7));
        int xCoordPawn1 = 3;
        int yCoordPawn1 = 7;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Pawn pawn3 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(2,2));
        int xCoordPawn3 = 2;
        int yCoordPawn3 = 2;
        pawn3.setPieceOnChessboardWithCoordinates(xCoordPawn3, yCoordPawn3);

        //when
        List<Coordinate> result = bishop1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(8, result.size());
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_ThirdSetting() {
        //given
        Bishop bishop1 = new Bishop(chessboard, Player.WHITE, DrawingPath.WHITE_BISHOP_PATH, new Coordinate(6,4));
        int xCoordRook1 = 6;
        int yCoordRook1 = 4;
        bishop1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(5,5));
        int xCoordPawn1 = 5;
        int yCoordPawn1 = 5;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Pawn pawn3 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(4,2));
        int xCoordPawn3 = 4;
        int yCoordPawn3 = 2;
        pawn3.setPieceOnChessboardWithCoordinates(xCoordPawn3, yCoordPawn3);

        //when
        List<Coordinate> result = bishop1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(4, result.size());
    }


}
