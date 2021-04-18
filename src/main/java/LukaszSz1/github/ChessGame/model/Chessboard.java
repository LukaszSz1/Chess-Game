package LukaszSz1.github.ChessGame.model;

import LukaszSz1.github.ChessGame.model.utils.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Chessboard {
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int NUMBER_OF_ROWS = 8;
    public static final double TILE_SIZE = 64;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;
    private Piece[][] tileForPiece;

    public Chessboard() {
        this.whitePieces = new ArrayList<>();
        this.blackPieces = new ArrayList<>();
        prepare2DTableToStorePieces();
    }

    private void prepare2DTableToStorePieces() {
        tileForPiece = new Piece[NUMBER_OF_ROWS][];
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            tileForPiece[i] = new Piece[NUMBER_OF_COLUMNS];
        }
    }

    // TODO nie powinoo się zwracać NULL ale jak zwracam pustą tablicę to ruch skrajnymi pionkami wyrzuca błąd
    public Piece getPieceFromCoordinates(int x, int y) {
        if (isCoordOutsideChessboard(x, y)) {
            return null;
        } else {
            return tileForPiece[x][y];
        }
    }

    private boolean isCoordOutsideChessboard(final int x, final int y) {
        return x >= NUMBER_OF_COLUMNS || x < 0 || y >= NUMBER_OF_ROWS || y < 0;
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public void addPieceToWhiteOrBlackList(Piece p) {
        if (p.getPlayer() == Player.WHITE) {
            whitePieces.add(p);
        } else {
            blackPieces.add(p);
        }
    }

    public void removePieceFromChessboard(Piece p) {
        int x = p.getXCoordinate();
        int y = p.getYCoordinate();
        tileForPiece[x][y] = null;
    }

    public void setPieceAtCoordinates(Piece p, int x, int y) {
        this.tileForPiece[x][y] = p;
    }

    public List<Piece> getAllCurrentPiecesFor(Player player) {
        if (player == Player.BLACK) {
            return getBlackPieces();
        } else {
            return getWhitePieces();
        }
    }

}
