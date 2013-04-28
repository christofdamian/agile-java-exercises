package pieces;

import java.util.ArrayList;

import chess.Board;

public class Piece implements Comparable<Piece> {
    public enum Colour {
        EMPTY,
        WHITE,
        BLACK
    }

    Colour colour;
    double strength = 0.0;

    protected Piece(Colour colour) {
        this.colour = colour;
    }

    public static Piece createEmpty()
    {
        return new Piece(Colour.EMPTY);
    }

    public static Piece createWhitePawn()
    {
        return new Pawn(Colour.WHITE);
    }
    public static Piece createWhiteRook()
    {
        return new Rook(Colour.WHITE);
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
        return new Bishop(Colour.WHITE);
    }
    public static Piece createWhiteKnight()
    {
        return new Knight(Colour.WHITE);
    }

    public static Piece createBlackPawn()
    {
        return new Pawn(Colour.BLACK);
    }
    public static Piece createBlackRook()
    {
        return new Rook(Colour.BLACK);
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
        return new Bishop(Colour.BLACK);
    }
    public static Piece createBlackKnight()
    {
        return new Knight(Colour.BLACK);
    }

    public boolean isWhite() {
        return colour == Colour.WHITE;
    }

    public boolean isBlack() {
        return colour == Colour.BLACK;
    }

    /**
     * Get colour of piece.
     * @return
     */
    public Colour getColour() {
        return colour;
    }

    public String getName() {
        return ".";
    }

    public String toString() {
        if (this.isWhite()) {
            return getName().toUpperCase();
        }
        return getName();
    }

    public void setStrength(double strength)
    {
        this.strength = strength;
    }

    public double getStrength()
    {
        return strength;
    }

    public double getBaseStrength()
    {
        return 0.0;
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
