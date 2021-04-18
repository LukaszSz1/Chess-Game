package LukaszSz1.github.ChessGame.services;

import LukaszSz1.github.ChessGame.model.Chessboard;
import LukaszSz1.github.ChessGame.model.Coordinate;
import LukaszSz1.github.ChessGame.model.Piece;
import LukaszSz1.github.ChessGame.model.utils.Player;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class KingStateService {
    private final Chessboard chessboard;
    private final TurnService turnService;
    private Piece kingWhite;
    private Piece kingBlack;

    public KingStateService(final Chessboard chessboard, final TurnService turnService) {
        this.kingWhite = null;
        this.kingBlack = null;
        this.chessboard = chessboard;
        this.turnService = turnService;
    }

    public boolean isInCheck() {
        List<Piece> opponentPieces = getOpponentPieces();

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

    private boolean isInCheck(final Piece king) {
        List<Piece> opponentPieces = getOpponentPieces();

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

    private List<Piece> getOpponentPieces() {
        return turnService.getCurrentPlayerTurn() == Player.WHITE ? chessboard.getBlackPieces() : chessboard.getWhitePieces();
    }

    private boolean isOpponentPieceUnderCapture(final Piece opponentPiece, final Coordinate coord) {
        return coord.getX() == opponentPiece.getXCoordinate() && coord.getY() == opponentPiece.getYCoordinate();
    }

    public boolean isCheckmate(final Player player) {
        Piece king = (player == Player.WHITE ? getKingWhite() : getKingBlack());
        return isAnyPlayerMovePossible(player) && isInCheck(king);
    }

    public boolean isStalemate(final Player player) {
        Piece king = turnService.getCurrentPlayerTurn() == Player.WHITE ? getKingWhite() : getKingBlack();
        return isAnyPlayerMovePossible(player) && isInCheck(king);
    }

    private boolean isAnyPlayerMovePossible(final Player player) {
        List<Piece> playerPieces = ((player == Player.WHITE) ? chessboard.getWhitePieces() : chessboard.getBlackPieces());
        for (Piece p : playerPieces) {
            List<Coordinate> allPossibleCoordinates = p.getCoordinatesOfAllPossibleMoves();
            for (Coordinate coord : allPossibleCoordinates) {
                if (isSuicideMove(coord.getX(), coord.getY(), p)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSuicideMove(final int moveToXCoordinate, final int moveToYCoordinate, final Piece p) {
        boolean isSuicide = false;
        int currentXCoordinate = p.getXCoordinate();
        int currentYCoordinate = p.getYCoordinate();
        Piece currentPlayerKing = getCurrentPlayerKing();
        List<Piece> opponentPieces = getOpponentPieces();
        Piece pieceOnTileWhereWeWantToMove = getPieceFromCoordinates(moveToXCoordinate, moveToYCoordinate);

        // capture move - remove temporary opponent piece from tile where we want to move
        if (pieceOnTileWhereWeWantToMove != null) {
            chessboard.removePieceFromChessboard(pieceOnTileWhereWeWantToMove);
            opponentPieces = chessboard.getAllCurrentPiecesFor(p.getPlayer());
        }

        // move current player piece to coords where we want to move
        p.setPieceOnChessboardWithoutAddingToAlreadyMovedListWithCoordinates(moveToXCoordinate, moveToYCoordinate);

        isSuicide = checkIfMoveIsSuicide(isSuicide, currentPlayerKing, opponentPieces);

        // restore current player piece
        p.setPieceOnChessboardWithoutAddingToAlreadyMovedListWithCoordinates(currentXCoordinate, currentYCoordinate);

        // restore piece which was removed (capture move)
        if (pieceOnTileWhereWeWantToMove != null) {
            pieceOnTileWhereWeWantToMove.setPieceOnChessboardWithoutAddingToAlreadyMovedListWithCoordinates(moveToXCoordinate, moveToYCoordinate);
        }

        return !isSuicide;
    }

    private boolean checkIfMoveIsSuicide(boolean isSuicide, final Piece currentPlayerKing, final List<Piece> opponentPieces) {
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
        return isSuicide;
    }

    private Piece getPieceFromCoordinates(final int moveToXCoordinate, final int moveToYCoordinate) {
        return chessboard.getPieceFromCoordinates(moveToXCoordinate, moveToYCoordinate);
    }

    private Piece getCurrentPlayerKing() {
        return turnService.getCurrentPlayerTurn() == Player.WHITE ? kingWhite : kingBlack;
    }

    public Piece getKingWhite() {
        return kingWhite;
    }

    public Piece getKingBlack() {
        return kingBlack;
    }

    public void setKingWhite(final Piece kingWhite) {
        this.kingWhite = kingWhite;
    }

    public void setKingBlack(final Piece kingBlack) {
        this.kingBlack = kingBlack;
    }
}
