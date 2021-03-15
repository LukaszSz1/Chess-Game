package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    Chessboard chessboard;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_PawnHasOtherPieceInFront() {

        //given
        Pawn pawn1 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(6,5));
        int xCoordPawn1 = 6;
        int yCoordPawn1 = 5;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1,yCoordPawn1);

        Pawn pawn2 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(6,6));
        int xCoordPawn2 = 6;
        int yCoordPawn2 = 6;
        pawn2.setPieceOnChessboardWithCoordinates(xCoordPawn2,yCoordPawn2);

        //when
        List<Coordinate> result = pawn1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(0, result.size());
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_PawnCanCaptureOpponentAndFreeSquareInFront() {

        //given
        Pawn pawn1 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(3,4));
        int xCoordPawn1 = 3;
        int yCoordPawn1 = 4;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1,yCoordPawn1);

        int newXCoordPawn1 = 3;
        int newYCoordPawn1 = 5;
        pawn1.setPieceOnChessboardWithCoordinates(newXCoordPawn1,newYCoordPawn1);

        Pawn pawn2 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(2,6));
        int xCoordPawn2 = 2;
        int yCoordPawn2 = 6;
        pawn2.setPieceOnChessboardWithCoordinates(xCoordPawn2,yCoordPawn2);

        //when
        List<Coordinate> result = pawn1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(2, result.size());
    }

    @Test
    void getCoordinatesOfAllPossibleMovesMethod_PawnHasFreeSquareInFront() {

        //given
        Pawn pawn1 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(3,4));
        int xCoordPawn1 = 3;
        int yCoordPawn1 = 4;
        pawn1.setPieceOnChessboardWithCoordinates(xCoordPawn1,yCoordPawn1);

        int newXCoordPawn1 = 3;
        int newYCoordPawn1 = 5;
        pawn1.setPieceOnChessboardWithCoordinates(newXCoordPawn1,newYCoordPawn1);

        //when
        List<Coordinate> result = pawn1.getCoordinatesOfAllPossibleMoves();

        //then
        assertEquals(1, result.size());
    }

}
