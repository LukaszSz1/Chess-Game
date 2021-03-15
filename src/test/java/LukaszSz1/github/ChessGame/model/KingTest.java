package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KingTest {

    Chessboard chessboard;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_FirstSetting() {

        //given
        King king1 = new King(chessboard, Player.BLACK, DrawingPath.BLACK_KING_PATH, new Coordinate(6,6));
        int xCoordRook1 = 6;
        int yCoordRook1 = 6;
        king1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(7,5));
        int xCoordPawn1 = 7;
        int yCoordPawn1 = 5;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Pawn pawn3 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(7,6));
        int xCoordPawn3 = 7;
        int yCoordPawn3 = 6;
        pawn3.setPieceOnChessboardWithCoordinates(xCoordPawn3, yCoordPawn3);

        Queen queen1 = new Queen(chessboard, Player.WHITE, DrawingPath.WHITE_KING_PATH, new Coordinate(5,5));
        int xCoordQueen1 = 5;
        int yCoordQueen1 = 5;
        queen1.setPieceOnChessboardWithCoordinates(xCoordQueen1, yCoordQueen1);

        //when
        List<Coordinate> result = king1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(6, result.size());
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_SecondSetting() {

        //given
        King king1 = new King(chessboard, Player.BLACK, DrawingPath.BLACK_KING_PATH, new Coordinate(3,4));
        int xCoordRook1 = 3;
        int yCoordRook1 = 4;
        king1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        Pawn pawn1 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(7,5));
        int xCoordPawn1 = 7;
        int yCoordPawn1 = 5;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1, yCoordPawn1);

        Pawn pawn3 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(7,6));
        int xCoordPawn3 = 7;
        int yCoordPawn3 = 6;
        pawn3.setPieceOnChessboardWithCoordinates(xCoordPawn3, yCoordPawn3);

        Queen queen1 = new Queen(chessboard, Player.BLACK, DrawingPath.BLACK_QUEEN_PATH, new Coordinate(2,4));
        int xCoordQueen1 = 2;
        int yCoordQueen1 = 4;
        queen1.setPieceOnChessboardWithCoordinates(xCoordQueen1, yCoordQueen1);

        //when
        List<Coordinate> result = king1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(7, result.size());
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_ThirdSetting() {

        //given
        King king1 = new King(chessboard, Player.BLACK, DrawingPath.BLACK_KING_PATH, new Coordinate(4,4));
        int xCoordRook1 = 4;
        int yCoordRook1 = 4;
        king1.setPieceOnChessboardWithCoordinates(xCoordRook1, yCoordRook1);

        //when
        List<Coordinate> result = king1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(8, result.size());
    }

}
