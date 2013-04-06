package pieces;

public class Pawn {
    public final static String WHITE = "white";
    public final static String BLACK = "black";

    String colour;

    /**
     * Create pawn of colour
     * @param colour
     */
    public Pawn(String colour) {
        this.colour = colour;
    }

    /**
     * Create default pawn (white)
     */
    public Pawn()
    {
        this.colour = WHITE;
    }

    /**
     * Get colour of pawn.
     * @return
     */
    public String getColour() {
        return colour;
    }


}
