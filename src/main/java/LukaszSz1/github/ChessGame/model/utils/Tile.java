package LukaszSz1.github.ChessGame.model.utils;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static LukaszSz1.github.ChessGame.model.Chessboard.TILE_SIZE;

public class Tile extends Rectangle {

    private Tile(double x, double y, Color color) {
        setWidth(TILE_SIZE);
        setHeight(TILE_SIZE);
        relocate(x, y);
        setFill(color);
    }

    public static Tile greenTile(final double x, final double y) {
        return new Tile(x, y, Color.GREEN);
    }

    public static Tile blueTile(final double x, final double y) {
        return new Tile(x, y, Color.BLUE);
    }

    public static Tile yellowTile(final double x, final double y) {
        return new Tile(x, y, Color.YELLOW);
    }

    public static Tile redTile(final double x, final double y) {
        return new Tile(x, y, Color.RED);
    }

    public static Tile orangeTile(final double x, final double y) {
        return new Tile(x, y, Color.ORANGE);
    }
}
