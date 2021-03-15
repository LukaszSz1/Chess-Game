package LukaszSz1.github.ChessGame.game;

import LukaszSz1.github.ChessGame.model.Piece;
import LukaszSz1.github.ChessGame.model.Chessboard;
import LukaszSz1.github.ChessGame.model.Coordinate;
import LukaszSz1.github.ChessGame.model.PiecesController;
import LukaszSz1.github.ChessGame.model.utils.Player;
import LukaszSz1.github.ChessGame.states.GameState;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.util.List;

import static LukaszSz1.github.ChessGame.model.Chessboard.NUMBER_OF_COLUMNS;
import static LukaszSz1.github.ChessGame.model.Chessboard.NUMBER_OF_ROWS;
import static LukaszSz1.github.ChessGame.model.Chessboard.TILE_SIZE;

public class ChessboardPaint extends AnchorPane {

    private final Chessboard chessboard;
    private final GameState gameState;
    private final PiecesController piecesController;

    private final Group tileGroup;
    private final Group pieceGroup;
    private Piece p;
    private Piece chosenPiece;
    private Color color;
    private double xCoordClicked;
    private double yCoordClicked;

    public ChessboardPaint(Chessboard chessboard, GameState gameState, PiecesController piecesController) {
        this.chessboard = chessboard;
        this.gameState = gameState;
        this.piecesController = piecesController;
        tileGroup = new Group();
        pieceGroup = new Group();
        xCoordClicked = -1;
        yCoordClicked = -1;
        initializePaneStartLook();
        mouseClickEvent();
    }

    private void initializePaneStartLook() {
        getChildren().addAll(tileGroup, pieceGroup);
        drawTiles();
    }

    private void mouseClickEvent() {
        setOnMouseClicked(e -> {
            xCoordClicked = e.getX();
            yCoordClicked = e.getY();
            UserClick(xCoordClicked, yCoordClicked);
            gameState.printMessage();
        });
    }

    private void drawTiles() {

        double x;
        double y;

        int colourCounter = 0;

        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                x = i * TILE_SIZE;
                y = j * TILE_SIZE;

                if (colourCounter % 2 == 0) {
                    color = Color.BLUE;
                } else {
                    color = Color.GREEN;
                }
                if (xCoordClicked >= x && xCoordClicked < x + TILE_SIZE && yCoordClicked >= y && yCoordClicked < y + TILE_SIZE) {
                    color = Color.YELLOW;
                }
                drawTile(x, y, color);
                colourCounter++;
            }
            colourCounter++;
        }
        paintKingCheck();
    }

    private void paintKingCheck() {
        boolean isBlackKingInCheck = piecesController.getCurrentPlayerTurn() == Player.BLACK && piecesController.isInCheck();
        boolean isWhiteKingInCheck = piecesController.getCurrentPlayerTurn() == Player.WHITE && piecesController.isInCheck();

        if (isBlackKingInCheck) {
            double xKingCoord = piecesController.getKingBlack().getXCoordinate() * TILE_SIZE;
            double yKingCoord = piecesController.getKingBlack().getYCoordinate() * TILE_SIZE;
            color = Color.RED;
            drawTile(xKingCoord, yKingCoord, color);
        }

        if (isWhiteKingInCheck) {
            double xKingCoord = piecesController.getKingWhite().getXCoordinate() * TILE_SIZE;
            double yKingCoord = piecesController.getKingWhite().getYCoordinate() * TILE_SIZE;
            color = Color.RED;
            drawTile(xKingCoord, yKingCoord, color);
        }
    }

    public void drawPiecesOnChessBoard() {
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                p = chessboard.getPieceFromCoordinates(i, j);
                if (p != null) {
                    drawPieceImage(p);
                }
            }
        }
    }

    private void drawTile(double x, double y, Color color) {
        Tile tile = new Tile(x, y, color);
        tileGroup.getChildren().add(tile);
    }

    private void drawPieceImage(Piece p) {
        ImageView iv = new ImageView(getClass().getResource(p.getDrawPath().toString()).toExternalForm());
        iv.setX(p.getXCoordinate() * TILE_SIZE);
        iv.setY(p.getYCoordinate() * TILE_SIZE);
        tileGroup.getChildren().add(iv);
    }

    private void UserClick(double xClickedCoord, double yClickedCoord) {

        int x = (int) (xClickedCoord / TILE_SIZE);
        int y = (int) (yClickedCoord / TILE_SIZE);

        //to repaint pane when clicked
        drawTiles();
        drawPiecesOnChessBoard();

        // save clicked piece
        p = chessboard.getPieceFromCoordinates(x, y);

        //player clicked piece
        if (p != null) {

            // player clicked own piece
            if (p.getPlayer() == piecesController.getCurrentPlayerTurn()) {
                chosenPiece = p;
                drawPossibleMoves(piecesController.getValidMovesForPiece(p));

                // player clicked opponent piece
            } else {
                // player clicked opponent piece and chosenPiece was not null while click
                if (chosenPiece != null) {
                    piecesController.movePieceToOpponentSquare(p, chosenPiece);
                    drawTiles();
                    drawPiecesOnChessBoard();
                    chosenPiece = null;
                }  // ELSE - player clicked opponent piece and chosenPiece was null while click - do nothing
            }

            // player clicked empty field
        } else {
            // player clicked empty field and chosenPiece was not null while click
            if (chosenPiece != null) {
                piecesController.movePieceToEmptySquare(x, y, chosenPiece);
                drawTiles();
                drawPiecesOnChessBoard();
                chosenPiece = null;
            }  // ELSE - player clicked empty field and chosenPiece was null while click - do nothing
        }
    }

    private void drawPossibleMoves(List<Coordinate> coords) {
        for (Coordinate coord : coords) {
            // piece meets empty spot
            if (chessboard.getPieceFromCoordinates(coord.getX(), coord.getY()) == null) {
                color = Color.YELLOW;
                // piece meets opponent piece
            } else {
                color = Color.ORANGE;
            }
            // adjust variables to square size and draw Tile
            double x = coord.getX() * TILE_SIZE;
            double y = coord.getY() * TILE_SIZE;
            drawTile(x, y, color);
            // draw image
            p = chessboard.getPieceFromCoordinates(coord.getX(), coord.getY());
            if (p != null) {
                drawPieceImage(p);
            }
        }
    }
}
