package pieces;

public class Pawn {
    public final static String WHITE = "white";
    public final static String BLACK = "black";

    String colour;

    String toString;

    /**
     * Create pawn of colour
     * @param colour
     */
    public Pawn(String colour, String toString) {
        this.colour = colour;
        this.toString = toString;
    }

    /**
     * Create default pawn (white)
     */
    public Pawn()
    {
        this.colour = WHITE;
        this.toString = "P";
    }

    /**
     * Get colour of pawn.
     * @return
     */
    public String getColour() {
        return colour;
    }

    public String toString() {
        return toString;
    }

}
