package LukaszSz1.github.ChessGame.services;

import LukaszSz1.github.ChessGame.model.Chessboard;
import LukaszSz1.github.ChessGame.model.utils.Player;
import LukaszSz1.github.ChessGame.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KingStateServiceTest {

    private Chessboard chessboard;
    private KingStateService kingStateService;
    private TurnService turnService;
    private PieceMovesService pieceMovesService;
    private GameState gameState;

    @BeforeEach
    void initializeChessboard() {
        chessboard = new Chessboard();
        turnService = new TurnService();
        kingStateService = new KingStateService(chessboard, turnService);
        gameState = new GameState(kingStateService);
        pieceMovesService = new PieceMovesService(gameState, kingStateService, turnService);
    }

    @Test
    void currentPlayerTurnMethod_returnsWhitePlayer_whenTurnIsOdd() {
        //given
        //when
        turnService.turnIncrement();

        //then
        assertEquals(turnService.getCurrentPlayerTurn(), Player.BLACK);
    }

    @Test
    void currentPlayerTurnMethod_returnsBlackPlayer_whenTurnIsEven() {
        //given
        //when
        turnService.turnIncrement();
        turnService.turnIncrement();

        //then
        assertEquals(turnService.getCurrentPlayerTurn(), Player.WHITE);
    }

    @Test
    void getValidMovesForPieceMethod_returnsPossibleCoordinatesListForWhitePlayer_whenMoveIsSuicide() {
//
//        //given
//        Piece kingWhite = new King(chessboard, Player.WHITE, DrawingPath.WHITE_KING_PATH, new Coordinate(3, 7));
//        kingController.setKingWhite(kingWhite);
//        int xCoordKingWhite = 3;
//        int yCoordKingWhite = 7;
//        kingController.getKingWhite().setPieceOnChessboardWithCoordinates(xCoordKingWhite, yCoordKingWhite);
//
//        Piece whiteKnight = new Knight(chessboard, Player.WHITE, DrawingPath.WHITE_KNIGHT_PATH, new Coordinate(5, 5));
//        int xCoordWhitePawn = 5;
//        int yCoordWhitePawn = 5;
//        whiteKnight.setPieceOnChessboardWithCoordinates(xCoordWhitePawn, yCoordWhitePawn);
//
//        Piece blackQueen = new Queen(chessboard, Player.BLACK, DrawingPath.BLACK_QUEEN_PATH, new Coordinate(7, 3));
//        int xCoordBlackQueen = 7;
//        int yCoordBlackQueen = 3;
//        blackQueen.setPieceOnChessboardWithCoordinates(xCoordBlackQueen, yCoordBlackQueen);
//
//        //when
//        List<Coordinate> coords = gameController.getValidMovesForPiece(whiteKnight);
//
//        //then
//        assertEquals(coords.size(), 0);
    }

    @Test
    void getValidMovesForPieceMethod_returnsPossibleCoordinatesListForWhitePlayer_whenThereIsNoSuicideMove() {

//        //given
//        Piece kingWhite = new King(chessboard, Player.WHITE, DrawingPath.WHITE_KING_PATH, new Coordinate(3, 7));
//        kingController.setKingWhite(kingWhite);
//        int xCoordKingWhite = 3;
//        int yCoordKingWhite = 7;
//        kingController.getKingWhite().setPieceOnChessboardWithCoordinates(xCoordKingWhite, yCoordKingWhite);
//
//        Piece whiteKnight = new Knight(chessboard, Player.WHITE, DrawingPath.WHITE_KNIGHT_PATH, new Coordinate(5, 5));
//        int xCoordWhitePawn = 5;
//        int yCoordWhitePawn = 5;
//        whiteKnight.setPieceOnChessboardWithCoordinates(xCoordWhitePawn, yCoordWhitePawn);
//
//        Piece blackQueen = new Queen(chessboard, Player.BLACK, DrawingPath.BLACK_QUEEN_PATH, new Coordinate(0, 0));
//        int xCoordBlackQueen = 7;
//        int yCoordBlackQueen = 4;
//        blackQueen.setPieceOnChessboardWithCoordinates(xCoordBlackQueen, yCoordBlackQueen);
//
//        //when
//        List<Coordinate> coords = gameController.getValidMovesForPiece(whiteKnight);
//
//        //then
//        assertEquals(coords.size(), 8);
    }


    @Test
    void getValidMovesForPieceMethod_returnsPossibleCoordinatesListForWhitePlayer_whenCoordinatesAreOutsideChessboard() {
//        //given
//        Piece kingWhite = new King(chessboard, Player.WHITE, DrawingPath.WHITE_KING_PATH, new Coordinate(0, 0));
//        kingController.setKingWhite(kingWhite);
//        int xCoordKingWhite = 3;
//        int yCoordKingWhite = 7;
//        kingController.getKingWhite().setPieceOnChessboardWithCoordinates(xCoordKingWhite, yCoordKingWhite);
//
//        Piece whiteKnight = new Knight(chessboard, Player.WHITE, DrawingPath.WHITE_KNIGHT_PATH, new Coordinate(0, 0));
//        int xCoordWhitePawn = 7;
//        int yCoordWhitePawn = 4;
//        whiteKnight.setPieceOnChessboardWithCoordinates(xCoordWhitePawn, yCoordWhitePawn);
//
//        //when
//        List<Coordinate> coords = gameController.getValidMovesForPiece(whiteKnight);
//
//        //then
//        assertEquals(coords.size(), 4);
    }

}
