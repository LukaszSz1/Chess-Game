package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ChessboardTest {

    Chessboard chessboard;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
    }

    @Test
    void getPieceFromCoordinatesMethod_returnsNull_whenXCoordinateLowBorderIsInvalid() {

        //given
        int xCoordPawn = -2;
        int yCoordPawn = 2;

        //when
        Piece result = chessboard.getPieceFromCoordinates(xCoordPawn, yCoordPawn);

        //then
        assertNull(result);
    }

    @Test
    void getPieceFromCoordinatesMethod_returnsNull_whenXCoordinateUpBorderIsInvalid() {

        //given
        int xCoordPawn = 20;
        int yCoordPawn = 2;

        //when
        Piece result = chessboard.getPieceFromCoordinates(xCoordPawn, yCoordPawn);

        //then
        assertNull(result);
    }

    @Test
    void getPieceFromCoordinatesMethod_returnsNull_whenYCoordinateLowBorderIsInvalid() {

        //given
        int xCoordPawn = 2;
        int yCoordPawn = -2;

        //when
        Piece result = chessboard.getPieceFromCoordinates(xCoordPawn, yCoordPawn);

        //then
        assertNull(result);
    }

    @Test
    void getPieceFromCoordinatesMethod_returnsNull_whenYCoordinateUpBorderIsInvalid() {

        //given
        int xCoordPawn = 2;
        int yCoordPawn = 20;

        //when
        Piece result = chessboard.getPieceFromCoordinates(xCoordPawn, yCoordPawn);

        //then
        assertNull(result);
    }

    @Test
    void getPieceFromCoordinatesMethod_savesPieceCoordsInside2DTable_whenCoordsAreValid() {

        //given
        Pawn pawn = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(2,2));
        int xCoordPawn = 2;
        int yCoordPawn = 2;
        pawn.setPieceOnChessboardWithCoordinates(xCoordPawn, yCoordPawn);

        //when
        Piece result = chessboard.getPieceFromCoordinates(xCoordPawn, yCoordPawn);

        //then
        assertNotNull(result);
        assertEquals(result.getClass(), Pawn.class);
    }


    @Test
    void addPieceToWhiteOrBlackListMethod_addsWhitePieceToList_whenPlayerIsWhite() {

        //given
        //when - constructor of Piece calls this method
        Pawn pawn1 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(0,0));

        //then
        assertNotNull(chessboard.getWhitePieces());
        assertEquals(chessboard.getWhitePieces().get(0).getClass(), Pawn.class);
    }

    @Test
    void addPieceToWhiteOrBlackListMethod_addsBlackPieceToList_whenPlayerIsBlack() {

        //given
        //when - constructor of Piece calls this method
        Pawn pawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(0,0));

        //then
        assertNotNull(chessboard.getBlackPieces());
        assertEquals(chessboard.getBlackPieces().get(0).getClass(), Pawn.class);
    }

    @Test
    void removePieceMethod_removesPieceFromChessboard() {

        //given
        Piece pawn = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(2,2));
        int xCoordPawn = 2;
        int yCoordPawn = 2;
        pawn.setPieceOnChessboardWithCoordinates(xCoordPawn, yCoordPawn);

        //when
        Piece added = chessboard.getPieceFromCoordinates(xCoordPawn, yCoordPawn);
        chessboard.removePieceFromChessboard(pawn);

        //then
        assertNotNull(added);
        assertNull(chessboard.getPieceFromCoordinates(xCoordPawn, yCoordPawn));
    }

    @Test
    void setPieceAtCoordinatesMethod_setsPieceAtCoordinates() {

        //given
        Piece pawn = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(2,2));
        int xCoordPawn = 2;
        int yCoordPawn = 2;
        chessboard.setPieceAtCoordinates(pawn,xCoordPawn,yCoordPawn);

        //when
        Piece added = chessboard.getPieceFromCoordinates(xCoordPawn, yCoordPawn);

        //then
        assertNotNull(added);
    }

}
