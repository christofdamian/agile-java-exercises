package pieces;

public class Piece {
    public final static String COLOUR_WHITE = "white";
    public final static String COLOUR_BLACK = "black";

    public final static String TYPE_PAWN = "p";
    public final static String TYPE_KNIGHT = "n";
    public final static String TYPE_ROOK = "r";
    public final static String TYPE_KING = "k";
    public final static String TYPE_QUEEN = "q";
    public final static String TYPE_BISHOP = "b";

    private static int whitePiecesInUse = 0;
    private static int blackPiecesInUse = 0;

    String colour;
    String type;

    private Piece(String colour, String type) {
        this.colour = colour;
        this.type = type;
    }

    /**
     * Create piece of colour
     * @param colour
     * @param type
     */
    public static Piece create(String colour, String type) {
        if (colour == COLOUR_WHITE) {
            whitePiecesInUse++;
        } else {
            blackPiecesInUse++;
        }
        return new Piece(colour, type);
    }

    public static void resetCount() {
        whitePiecesInUse = 0;
        blackPiecesInUse = 0;
    }


    public boolean isWhite() {
        return colour == COLOUR_WHITE;
    }

    public boolean isBlack() {
        return !isWhite();
    }

    public static int getPiecesInUse() {
        return whitePiecesInUse+blackPiecesInUse;
    }

    public static int getNumberOfWhitePieces() {
        return whitePiecesInUse;
    }


    public static int getNumberOfBlackPieces() {
        return blackPiecesInUse;
    }

    /**
     * Get colour of piece.
     * @return
     */
    public String getColour() {
        return colour;
    }

    public String toString() {
        if (this.isWhite()) {
            return type.toUpperCase();
        }
        return type;
    }

}
