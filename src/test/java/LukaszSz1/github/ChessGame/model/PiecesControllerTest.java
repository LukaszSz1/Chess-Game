package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.controllers.ChessboardViewController;
import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import LukaszSz1.github.ChessGame.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PiecesControllerTest {

    private Chessboard chessboard;
    private ChessboardViewController chessBoardViewController;
    private GameState gameState;
    private PiecesController piecesController;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
        chessBoardViewController = new ChessboardViewController();
        gameState = new GameState(chessBoardViewController);
        piecesController = new PiecesController(gameState, chessboard);
    }

    @Test
    void currentPlayerTurnMethod_returnsWhitePlayer_whenTurnIsOdd() {
        //given
        //when
        piecesController.turnIncrement();

        //then
        assertEquals(piecesController.getCurrentPlayerTurn(), Player.BLACK);
    }

    @Test
    void currentPlayerTurnMethod_returnsBlackPlayer_whenTurnIsEven() {
        //given
        //when
        piecesController.turnIncrement();
        piecesController.turnIncrement();

        //then
        assertEquals(piecesController.getCurrentPlayerTurn(), Player.WHITE);
    }

    @Test
    void getValidMovesForPieceMethod_returnsPossibleCoordinatesListForWhitePlayer_whenMoveIsSuicide() {

        //given
        King kingWhite = new King(chessboard, Player.WHITE, DrawingPath.WHITE_KING_PATH, new Coordinate(3,7));
        piecesController.setKingWhite(kingWhite);
        int xCoordKingWhite = 3;
        int yCoordKingWhite = 7;
        piecesController.getKingWhite().setPieceOnChessboardWithCoordinates(xCoordKingWhite, yCoordKingWhite);

        Knight whiteKnight = new Knight(chessboard, Player.WHITE, DrawingPath.WHITE_KNIGHT_PATH, new Coordinate(5,5));
        int xCoordWhitePawn = 5;
        int yCoordWhitePawn = 5;
        whiteKnight.setPieceOnChessboardWithCoordinates(xCoordWhitePawn, yCoordWhitePawn);

        Queen blackQueen = new Queen(chessboard, Player.BLACK, DrawingPath.BLACK_QUEEN_PATH, new Coordinate(7,3));
        int xCoordBlackQueen = 7;
        int yCoordBlackQueen = 3;
        blackQueen.setPieceOnChessboardWithCoordinates(xCoordBlackQueen, yCoordBlackQueen);

        //when
        List<Coordinate> coords = piecesController.getValidMovesForPiece(whiteKnight);

        //then
        assertEquals(coords.size(),0);
    }

    @Test
    void getValidMovesForPieceMethod_returnsPossibleCoordinatesListForWhitePlayer_whenThereIsNoSuicideMove() {

        //given
        King kingWhite = new King(chessboard, Player.WHITE, DrawingPath.WHITE_KING_PATH, new Coordinate(3,7));
        piecesController.setKingWhite(kingWhite);
        int xCoordKingWhite = 3;
        int yCoordKingWhite = 7;
        piecesController.getKingWhite().setPieceOnChessboardWithCoordinates(xCoordKingWhite, yCoordKingWhite);

        Knight whiteKnight = new Knight(chessboard, Player.WHITE, DrawingPath.WHITE_KNIGHT_PATH, new Coordinate(5,5));
        int xCoordWhitePawn = 5;
        int yCoordWhitePawn = 5;
        whiteKnight.setPieceOnChessboardWithCoordinates(xCoordWhitePawn, yCoordWhitePawn);

        Queen blackQueen = new Queen(chessboard, Player.BLACK, DrawingPath.BLACK_QUEEN_PATH, new Coordinate(0,0));
        int xCoordBlackQueen = 7;
        int yCoordBlackQueen = 4;
        blackQueen.setPieceOnChessboardWithCoordinates(xCoordBlackQueen, yCoordBlackQueen);

        //when
        List<Coordinate> coords = piecesController.getValidMovesForPiece(whiteKnight);

        //then
        assertEquals(coords.size(),8);
    }


    @Test
    void getValidMovesForPieceMethod_returnsPossibleCoordinatesListForWhitePlayer_whenCoordinatesAreOutsideChessboard() {
        //given
        King kingWhite = new King(chessboard, Player.WHITE, DrawingPath.WHITE_KING_PATH, new Coordinate(0,0));
        piecesController.setKingWhite(kingWhite);
        int xCoordKingWhite = 3;
        int yCoordKingWhite = 7;
        piecesController.getKingWhite().setPieceOnChessboardWithCoordinates(xCoordKingWhite, yCoordKingWhite);

        Knight whiteKnight = new Knight(chessboard, Player.WHITE, DrawingPath.WHITE_KNIGHT_PATH, new Coordinate(0,0));
        int xCoordWhitePawn = 7;
        int yCoordWhitePawn = 4;
        whiteKnight.setPieceOnChessboardWithCoordinates(xCoordWhitePawn, yCoordWhitePawn);

        //when
        List<Coordinate> coords = piecesController.getValidMovesForPiece(whiteKnight);

        //then
        assertEquals(coords.size(),4);
    }

}
