package LukaszSz1.github.ChessGame.services;

import LukaszSz1.github.ChessGame.model.Chessboard;
import LukaszSz1.github.ChessGame.model.Coordinate;
import LukaszSz1.github.ChessGame.model.Piece;
import LukaszSz1.github.ChessGame.model.utils.Player;
import LukaszSz1.github.ChessGame.model.utils.Tile;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Component;

import java.util.List;

import static LukaszSz1.github.ChessGame.model.Chessboard.NUMBER_OF_COLUMNS;
import static LukaszSz1.github.ChessGame.model.Chessboard.NUMBER_OF_ROWS;
import static LukaszSz1.github.ChessGame.model.Chessboard.TILE_SIZE;

@Component
public class ChessboardPainterService {

    private final KingStateService kingStateService;
    private final Chessboard chessboard;
    private final TurnService turnService;
    private final Group tileGroup;
    private final Group pieceGroup;

    public ChessboardPainterService(final KingStateService kingStateService, final Chessboard chessboard, final TurnService turnService) {
        this.kingStateService = kingStateService;
        this.chessboard = chessboard;
        this.turnService = turnService;
        tileGroup = new Group();
        pieceGroup = new Group();
    }

    void repaintChessboard(final double xCoordClicked, final double yCoordClicked) {
        double x;
        double y;
        int colourCounter = 0;

        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                x = i * TILE_SIZE;
                y = j * TILE_SIZE;
                setStartColorOfTiles(x, y, colourCounter);
                setColorOfTilesWhenMouseClicked(xCoordClicked, yCoordClicked, x, y);
                colourCounter++;
            }
            colourCounter++;
        }
        setColorWhenKingInCheck();
        drawPiecesOnChessBoard();
    }

    private void setStartColorOfTiles(final double x, final double y, final int colourCounter) {
        if (colourCounter % 2 == 0) {
            tileGroup.getChildren().add(Tile.blueTile(x, y));
        } else {
            tileGroup.getChildren().add(Tile.greenTile(x, y));
        }
    }

    private void setColorOfTilesWhenMouseClicked(final double xCoordClicked, final double yCoordClicked, final double x, final double y) {
        if (xCoordClicked >= x && xCoordClicked < x + TILE_SIZE && yCoordClicked >= y && yCoordClicked < y + TILE_SIZE) {
            tileGroup.getChildren().add(Tile.yellowTile(x, y));
        }
    }

    void setColorWhenKingInCheck() {
        boolean isBlackKingInCheck = turnService.getCurrentPlayerTurn() == Player.BLACK && kingStateService.isInCheck();
        boolean isWhiteKingInCheck = turnService.getCurrentPlayerTurn() == Player.WHITE && kingStateService.isInCheck();

        if (isBlackKingInCheck) {
            double xKingCoord = kingStateService.getKingBlack().getXCoordinate() * TILE_SIZE;
            double yKingCoord = kingStateService.getKingBlack().getYCoordinate() * TILE_SIZE;
            tileGroup.getChildren().add(Tile.redTile(xKingCoord, yKingCoord));
        }

        if (isWhiteKingInCheck) {
            double xKingCoord = kingStateService.getKingWhite().getXCoordinate() * TILE_SIZE;
            double yKingCoord = kingStateService.getKingWhite().getYCoordinate() * TILE_SIZE;
            tileGroup.getChildren().add(Tile.redTile(xKingCoord, yKingCoord));
        }
    }

    void drawPieceImage(final Piece p) {
        ImageView iv = new ImageView(getClass().getResource(p.getDrawPath().toString()).toExternalForm());
        iv.setX(p.getXCoordinate() * TILE_SIZE);
        iv.setY(p.getYCoordinate() * TILE_SIZE);
        tileGroup.getChildren().add(iv);
    }

    void drawPiecesOnChessBoard() {
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                Piece p = chessboard.getPieceFromCoordinates(i, j);
                if (p != null) {
                    drawPieceImage(p);
                }
            }
        }
    }

    void drawPossibleMoves(final List<Coordinate> coords) {
        for (Coordinate coord : coords) {
            double x = coord.getX() * TILE_SIZE;
            double y = coord.getY() * TILE_SIZE;
            setColorForPossibleMoves(coord, x, y);
            drawPiecesOnChessBoard();
        }
    }

    private void setColorForPossibleMoves(final Coordinate coord, final double x, final double y) {
        if (isPossibleMoveTileEmpty(coord)) {
            tileGroup.getChildren().add(Tile.yellowTile(x, y));
        } else {
            tileGroup.getChildren().add(Tile.orangeTile(x, y));
        }
    }

    private boolean isPossibleMoveTileEmpty(final Coordinate coord) {
        return chessboard.getPieceFromCoordinates(coord.getX(), coord.getY()) == null;
    }

    Group getTileGroup() {
        return tileGroup;
    }

    Group getPieceGroup() {
        return pieceGroup;
    }

}
