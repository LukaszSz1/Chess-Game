package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.DrawingPath;
import LukaszSz1.github.ChessGame.model.utils.Player;
import LukaszSz1.github.ChessGame.states.GameState;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import static LukaszSz1.github.ChessGame.model.Chessboard.*;

@Controller
public class PiecesController {
    private final GameState gameState;
    private final Chessboard chessboard;
    private int turn;
    private Piece kingWhite;
    private Piece kingBlack;

    public PiecesController(final GameState gameState, final Chessboard chessboard) {
        this.kingWhite = null;
        this.kingBlack = null;
        this.gameState = gameState;
        this.chessboard = chessboard;
        this.turn = 0;
    }

    public void turnIncrement() {
        turn++;
    }

    public Player getCurrentPlayerTurn() {
        return (turn % 2 == 0) ? Player.WHITE : Player.BLACK;
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
        kingWhite = whiteKing;

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
        kingBlack = blackKing;

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

    public List<Coordinate> getValidMovesForPiece(Piece p) {
        List<Coordinate> validCoordinates = new ArrayList<>();
        List<Coordinate> allPossibleCoordinates = p.getCoordinatesOfAllPossibleMoves();

        for (Coordinate coords : allPossibleCoordinates) {
            if (isSuicideMove(coords.getX(), coords.getY(), p)) {
                continue;
            }
            if (isCoordinateOutsideChessboard(coords)) {
                continue;
            }
            validCoordinates.add(coords);
        }
        return validCoordinates;
    }

    private boolean isCoordinateOutsideChessboard(final Coordinate coords) {
        return coords.getX() >= NUMBER_OF_COLUMNS || coords.getX() < 0 || coords.getY() >= NUMBER_OF_ROWS || coords.getY() < 0;
    }

    public void movePieceToEmptySquare(int xClickedCoord, int yClickedCoord, Piece chosenPiece) {
        List<Coordinate> allPossibleCoordinates = chosenPiece.getCoordinatesOfAllPossibleMoves();

        for (Coordinate coord : allPossibleCoordinates) {
            if (isSuicideMove(coord.getX(), coord.getY(), chosenPiece)) {
                continue;
            }
            if (coord.getX() == xClickedCoord && coord.getY() == yClickedCoord) {
                chosenPiece.setPieceOnChessboardWithCoordinates(xClickedCoord, yClickedCoord);
                turnIncrement();
                Player currentPlayerTurn = ((chosenPiece.getPlayer() == Player.WHITE) ? Player.BLACK : Player.WHITE);
                gameState.stateCheck(currentPlayerTurn);
            }
        }  //nothing happen, no possible moves
    }

    public void movePieceToOpponentSquare(Piece opponentPiece, Piece chosenPiece) {
        List<Coordinate> allPossibleCoordinates = chosenPiece.getCoordinatesOfAllPossibleMoves();
        Player currentPlayerTurn = ((chosenPiece.getPlayer() == Player.WHITE) ? Player.BLACK : Player.WHITE);

            for (Coordinate coord : allPossibleCoordinates) {
                if (isSuicideMove(coord.getX(), coord.getY(), chosenPiece)) {
                    continue;
                }
                if (isOpponentPieceUnderCapture(opponentPiece, coord)) {
                    opponentPiece.removePieceFromPreviousCoordinate();
                    chosenPiece.setPieceOnChessboardWithCoordinates(coord.getX(), coord.getY());
                    opponentPiece.deletePiece();
                    turnIncrement();
                    gameState.stateCheck(currentPlayerTurn);
                }
            }
        }  //nothing happen, no possible moves

    private boolean isOpponentPieceUnderCapture(final Piece opponentPiece, final Coordinate coord) {
        return coord.getX() == opponentPiece.getXCoordinate() && coord.getY() == opponentPiece.getYCoordinate();
    }

    public boolean isInCheck() {
        List<Piece> opponentPieces = (getCurrentPlayerTurn() == Player.WHITE ? chessboard.getBlackPieces() : chessboard.getWhitePieces());

        for (Piece p : opponentPieces) {
            List<Coordinate> allPossibleCoordinates = p.getCoordinatesOfAllPossibleMoves();
            for (Coordinate coord : allPossibleCoordinates) {
                if (isOpponentPieceUnderCapture(kingWhite, coord) || isOpponentPieceUnderCapture(kingBlack, coord)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCheckmate(Player player) {
        Piece king = (player == Player.WHITE ? getKingWhite() : getKingBlack());
        return isAnyPlayerMovePossible(player) && isInCheck(king);
    }

    public boolean isStalemate(Player player) {
        Piece king = (getCurrentPlayerTurn() == Player.WHITE ? getKingWhite() : getKingBlack());
        return isAnyPlayerMovePossible(player) && isInCheck(king);
    }

    private boolean isInCheck(Piece king) {
        List<Piece> opponentPieces = (getCurrentPlayerTurn() == Player.WHITE ? chessboard.getBlackPieces() : chessboard.getWhitePieces());

        for (Piece p : opponentPieces) {
            List<Coordinate> allPossibleCoordinates = p.getCoordinatesOfAllPossibleMoves();
            for (Coordinate coord : allPossibleCoordinates) {
                if (isOpponentPieceUnderCapture(king, coord)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAnyPlayerMovePossible(Player player) {
        List<Piece> playerPieces = ((player == Player.WHITE) ? chessboard.getWhitePieces() : chessboard.getBlackPieces());
        for (Piece p : playerPieces) {
            List<Coordinate> allPossibleCoordinates = p.getCoordinatesOfAllPossibleMoves();
            for (Coordinate coord : allPossibleCoordinates) {
                if (!isSuicideMove(coord.getX(), coord.getY(), p)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSuicideMove(int moveToXCoordinate, int moveToYCoordinate, Piece p) {
        boolean isSuicide = false;
        int currentXCoordinate = p.getXCoordinate();
        int currentYCoordinate = p.getYCoordinate();
        Piece currentPlayerKing = (getCurrentPlayerTurn() == Player.WHITE ? getKingWhite() : getKingBlack());
        List<Piece> opponentPieces = (getCurrentPlayerTurn() == Player.WHITE ? chessboard.getBlackPieces() : chessboard.getWhitePieces());
        Piece tileWhereWeWantToMove = chessboard.getPieceFromCoordinates(moveToXCoordinate, moveToYCoordinate);


        // capture move - remove temporary opponent piece from tile where we want to move
        if (tileWhereWeWantToMove != null) {
            chessboard.removePieceFromChessboard(tileWhereWeWantToMove);
            opponentPieces = chessboard.getAllCurrentPiecesFor(p.getPlayer());
        }

        // move current player piece to coords where we want to move
        p.setPieceOnChessboardWithoutAddingToAlreadyMovedListWithCoordinates(moveToXCoordinate, moveToYCoordinate);

        // ArrayList with possible opponent moves
        for (Piece opponentPiece : opponentPieces) {
            List<Coordinate> coords = opponentPiece.getCoordinatesOfAllPossibleMoves();
            // opponent piece can reach king - suicide move
            for (Coordinate coord : coords) {
                if (isOpponentPieceUnderCapture(currentPlayerKing, coord)) {
                    isSuicide = true;
                    break;
                }
            }
        }

        // restore current player piece
        p.setPieceOnChessboardWithoutAddingToAlreadyMovedListWithCoordinates(currentXCoordinate, currentYCoordinate);

        // restore piece which was removed (capture move)
        if (tileWhereWeWantToMove != null) {
            tileWhereWeWantToMove.setPieceOnChessboardWithoutAddingToAlreadyMovedListWithCoordinates(moveToXCoordinate, moveToYCoordinate);
        }

        return isSuicide;
    }

    public Piece getKingWhite() {
        return kingWhite;
    }

    public Piece getKingBlack() {
        return kingBlack;
    }

    void setKingWhite(final Piece kingWhite) {
        this.kingWhite = kingWhite;
    }
}
