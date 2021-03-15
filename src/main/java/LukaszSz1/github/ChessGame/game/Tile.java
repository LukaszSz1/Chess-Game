package LukaszSz1.github.ChessGame.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static LukaszSz1.github.ChessGame.model.Chessboard.*;

class Tile extends Rectangle {

    Tile(double x, double y, Color color) {
        setWidth(TILE_SIZE);
        setHeight(TILE_SIZE);
        relocate(x, y);
        setFill(color);
    }
}
