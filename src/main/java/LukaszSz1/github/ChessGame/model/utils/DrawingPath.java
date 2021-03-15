package LukaszSz1.github.ChessGame.model.utils;

public enum DrawingPath {

    WHITE_BISHOP_PATH("/white_bishop.png"),
    BLACK_BISHOP_PATH("/black_bishop.png"),
    WHITE_KING_PATH("/white_king.png"),
    BLACK_KING_PATH("/black_king.png"),
    WHITE_KNIGHT_PATH("/white_knight.png"),
    BLACK_KNIGHT_PATH("/black_knight.png"),
    WHITE_PAWN_PATH("/white_pawn.png"),
    BLACK_PAWN_PATH("/black_pawn.png"),
    WHITE_QUEEN_PATH("/white_queen.png"),
    BLACK_QUEEN_PATH("/black_queen.png"),
    WHITE_ROOK_PATH("/white_rook.png"),
    BLACK_ROOK_PATH("/black_rook.png");

    private final String pathName;

    DrawingPath(String pathName) {
        this.pathName = pathName;
    }

    public String getPathName() {
        return pathName;
    }

    @Override
    public String toString() {
        return getPathName();
    }
}
