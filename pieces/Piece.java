package pieces;


public class Piece implements Comparable<Piece> {
    enum Colour {
        WHITE,
        BLACK
    }

    public enum Type {
        PAWN("p"),
        KNIGHT("n"),
        ROOK("r"),
        KING("k"),
        QUEEN("q"),
        BISHOP("b"),
        EMPTY(".");

        String name;

        private Type(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }
    }

    private static int whitePiecesInUse = 0;
    private static int blackPiecesInUse = 0;

    Colour colour;
    Type type;
    double strength = 0.0;

    private Piece(Colour colour, Type type) {
        this.colour = colour;
        this.type = type;
    }

    /**
     * Create piece of colour
     * @param colour
     * @param type
     */
    private static Piece create(Colour colour, Type type) {
        if (colour == Colour.WHITE) {
            whitePiecesInUse++;
        } else if (colour == Colour.BLACK) {
            blackPiecesInUse++;
        }
        return new Piece(colour, type);
    }

    public static Piece createEmpty()
    {
        return create(null, Type.EMPTY);
    }

    public static Piece createWhitePawn()
    {
        return create(Colour.WHITE, Type.PAWN);
    }
    public static Piece createWhiteRook()
    {
        return create(Colour.WHITE, Type.ROOK);
    }
    public static Piece createWhiteKing()
    {
        return create(Colour.WHITE, Type.KING);
    }
    public static Piece createWhiteQueen()
    {
        return create(Colour.WHITE, Type.QUEEN);
    }
    public static Piece createWhiteBishop()
    {
        return create(Colour.WHITE, Type.BISHOP);
    }
    public static Piece createWhiteKnight()
    {
        return create(Colour.WHITE, Type.KNIGHT);
    }

    public static Piece createBlackPawn()
    {
        return create(Colour.BLACK, Type.PAWN);
    }
    public static Piece createBlackRook()
    {
        return create(Colour.BLACK, Type.ROOK);
    }
    public static Piece createBlackKing()
    {
        return create(Colour.BLACK, Type.KING);
    }
    public static Piece createBlackQueen()
    {
        return create(Colour.BLACK, Type.QUEEN);
    }
    public static Piece createBlackBishop()
    {
        return create(Colour.BLACK, Type.BISHOP);
    }
    public static Piece createBlackKnight()
    {
        return create(Colour.BLACK, Type.KNIGHT);
    }

    public static void resetCount() {
        whitePiecesInUse = 0;
        blackPiecesInUse = 0;
    }

    public boolean isWhite() {
        return colour == Colour.WHITE;
    }

    public boolean isBlack() {
        return  colour == Colour.BLACK;
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
    public Colour getColour() {
        return colour;
    }

    public Type getType()
    {
        return type;
    }

    public String toString() {
        if (this.type == Type.EMPTY) {
            return ".";
        }
        if (this.isWhite()) {
            return type.getName().toUpperCase();
        }
        return type.getName();
    }

    public void setStrength(double strength)
    {
        this.strength = strength;
    }

    public double getStrength()
    {
        return strength;
    }

    public int compareTo(Piece other)
    {
        return (int)(other.getStrength()-getStrength());
    }
}
