package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import LukaszSz1.github.ChessGame.services.KingStateService;
import org.springframework.stereotype.Component;

@Component
public class ChessboardInitializer {

   private final Chessboard chessboard;
   private final KingStateService kingStateService;

   ChessboardInitializer(final Chessboard chessboard, final KingStateService kingStateService) {
        this.chessboard = chessboard;
        this.kingStateService = kingStateService;
    }

    public void initializeChessboard() {

        Piece whiteRook1 = new Rook(chessboard, Player.WHITE, DrawingPath.WHITE_ROOK_PATH, new Coordinate(0, 0));
        whiteRook1.initialSetPieceOnChessboardWithCoordinates(0, 0);

        Piece whiteKnight1 = new Knight(chessboard, Player.WHITE, DrawingPath.WHITE_KNIGHT_PATH, new Coordinate(1, 0));
        whiteKnight1.initialSetPieceOnChessboardWithCoordinates(1, 0);

        Piece whiteBishop1 = new Bishop(chessboard, Player.WHITE, DrawingPath.WHITE_BISHOP_PATH, new Coordinate(2, 0));
        whiteBishop1.initialSetPieceOnChessboardWithCoordinates(2, 0);

        Piece whiteQueen = new Queen(chessboard, Player.WHITE, DrawingPath.WHITE_QUEEN_PATH, new Coordinate(3, 0));
        whiteQueen.initialSetPieceOnChessboardWithCoordinates(3, 0);

        Piece whiteKing = new King(chessboard, Player.WHITE, DrawingPath.WHITE_KING_PATH, new Coordinate(4, 0));
        whiteKing.initialSetPieceOnChessboardWithCoordinates(4, 0);

        kingStateService.setKingWhite(whiteKing);

        Piece whiteBishop2 = new Bishop(chessboard, Player.WHITE, DrawingPath.WHITE_BISHOP_PATH, new Coordinate(5, 0));
        whiteBishop2.initialSetPieceOnChessboardWithCoordinates(5, 0);

        Piece whiteKnight2 = new Knight(chessboard, Player.WHITE, DrawingPath.WHITE_KNIGHT_PATH, new Coordinate(6, 0));
        whiteKnight2.initialSetPieceOnChessboardWithCoordinates(6, 0);

        Piece whiteRook2 = new Rook(chessboard, Player.WHITE, DrawingPath.WHITE_ROOK_PATH, new Coordinate(7, 0));
        whiteRook2.initialSetPieceOnChessboardWithCoordinates(7, 0);

        Piece whitePawn1 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(0, 1));
        whitePawn1.initialSetPieceOnChessboardWithCoordinates(0, 1);

        Piece whitePawn2 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(1, 1));
        whitePawn2.initialSetPieceOnChessboardWithCoordinates(1, 1);

        Piece whitePawn3 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(2, 1));
        whitePawn3.initialSetPieceOnChessboardWithCoordinates(2, 1);

        Piece whitePawn4 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(3, 1));
        whitePawn4.initialSetPieceOnChessboardWithCoordinates(3, 1);

        Piece whitePawn5 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(4, 1));
        whitePawn5.initialSetPieceOnChessboardWithCoordinates(4, 1);

        Piece whitePawn6 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(5, 1));
        whitePawn6.initialSetPieceOnChessboardWithCoordinates(5, 1);

        Piece whitePawn7 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(6, 1));
        whitePawn7.initialSetPieceOnChessboardWithCoordinates(6, 1);

        Piece whitePawn8 = new Pawn(chessboard, Player.WHITE, DrawingPath.WHITE_PAWN_PATH, new Coordinate(7, 1));
        whitePawn8.initialSetPieceOnChessboardWithCoordinates(7, 1);

        Piece blackRook1 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(0, 7));
        blackRook1.initialSetPieceOnChessboardWithCoordinates(0, 7);

        Piece blackKnight1 = new Knight(chessboard, Player.BLACK, DrawingPath.BLACK_KNIGHT_PATH, new Coordinate(1, 7));
        blackKnight1.initialSetPieceOnChessboardWithCoordinates(1, 7);

        Piece blackBishop1 = new Bishop(chessboard, Player.BLACK, DrawingPath.BLACK_BISHOP_PATH, new Coordinate(2, 7));
        blackBishop1.initialSetPieceOnChessboardWithCoordinates(2, 7);

        Piece blackQueen = new Queen(chessboard, Player.BLACK, DrawingPath.BLACK_QUEEN_PATH, new Coordinate(3, 7));
        blackQueen.initialSetPieceOnChessboardWithCoordinates(3, 7);

        Piece blackKing = new King(chessboard, Player.BLACK, DrawingPath.BLACK_KING_PATH, new Coordinate(4, 7));
        blackKing.initialSetPieceOnChessboardWithCoordinates(4, 7);
        kingStateService.setKingBlack(blackKing);

        Piece blackBishop2 = new Bishop(chessboard, Player.BLACK, DrawingPath.BLACK_BISHOP_PATH, new Coordinate(5, 7));
        blackBishop2.initialSetPieceOnChessboardWithCoordinates(5, 7);

        Piece blackKnight2 = new Knight(chessboard, Player.BLACK, DrawingPath.BLACK_KNIGHT_PATH, new Coordinate(6, 7));
        blackKnight2.initialSetPieceOnChessboardWithCoordinates(6, 7);

        Piece blackRook2 = new Rook(chessboard, Player.BLACK, DrawingPath.BLACK_ROOK_PATH, new Coordinate(7, 7));
        blackRook2.initialSetPieceOnChessboardWithCoordinates(7, 7);

        Piece blackPawn1 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(0, 6));
        blackPawn1.initialSetPieceOnChessboardWithCoordinates(0, 6);

        Piece blackPawn2 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(1, 6));
        blackPawn2.initialSetPieceOnChessboardWithCoordinates(1, 6);

        Piece blackPawn3 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(2, 6));
        blackPawn3.initialSetPieceOnChessboardWithCoordinates(2, 6);

        Piece blackPawn4 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(3, 6));
        blackPawn4.initialSetPieceOnChessboardWithCoordinates(3, 6);

        Piece blackPawn5 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(4, 6));
        blackPawn5.initialSetPieceOnChessboardWithCoordinates(4, 6);

        Piece blackPawn6 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(5, 6));
        blackPawn6.initialSetPieceOnChessboardWithCoordinates(5, 6);

        Piece blackPawn7 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(6, 6));
        blackPawn7.initialSetPieceOnChessboardWithCoordinates(6, 6);

        Piece blackPawn8 = new Pawn(chessboard, Player.BLACK, DrawingPath.BLACK_PAWN_PATH, new Coordinate(7, 6));
        blackPawn8.initialSetPieceOnChessboardWithCoordinates(7, 6);
    }
}
