package pieces;

import java.util.ArrayList;

import chess.Board;


public class Piece implements Comparable<Piece> {
    public enum Colour {
        WHITE,
        BLACK
    }

    public enum Type {
        PAWN("p", 0.5),
        KNIGHT("n", 2.5),
        ROOK("r", 5.0),
        KING("k", 0.0),
        QUEEN("q", 9.0),
        BISHOP("b", 3.0),
        EMPTY(".", 0.0);

        String name;
        double strength;

        private Type(String name, double strength)
        {
            this.name = name;
            this.strength = strength;
        }

        public String getName()
        {
            return name;
        }

        public double getStrength()
        {
            return strength;
        }
    }

    Colour colour;
    Type type;
    double strength = 0.0;

    protected Piece(Colour colour) {
        this.colour = colour;
    }

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
        return new King(Colour.WHITE);
    }
    public static Piece createWhiteQueen()
    {
        return new Queen(Colour.WHITE);
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
        return new King(Colour.BLACK);
    }
    public static Piece createBlackQueen()
    {
        return new Queen(Colour.BLACK);
    }
    public static Piece createBlackBishop()
    {
        return create(Colour.BLACK, Type.BISHOP);
    }
    public static Piece createBlackKnight()
    {
        return create(Colour.BLACK, Type.KNIGHT);
    }

    public boolean isWhite() {
        return colour == Colour.WHITE;
    }

    public boolean isBlack() {
        return  colour == Colour.BLACK;
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

    public String getName() {
        return type.getName();
    }

    protected String uppercaseForWhite() {
        if (this.isWhite()) {
            return getName().toUpperCase();
        }
        return getName();
    }

    public String toString() {
        if (this.getType() == Type.EMPTY) {
            return ".";
        }
        return uppercaseForWhite();
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

    public ArrayList<String> getPossibleMoves(Board board)
    {
        return new ArrayList<String>();
    }
}
