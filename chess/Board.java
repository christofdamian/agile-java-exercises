package chess;

import java.util.ArrayList;

import pieces.Piece;

import static util.StringUtil.NEWLINE;

public class Board {
    ArrayList<ArrayList<Piece>> pieces = new ArrayList<ArrayList<Piece>>();

    public Board() {
        initialize();
    }

    private void initialize() {
        for (int i=0; i<8; i++) {
            ArrayList<Piece> row = new ArrayList<Piece>();
            pieces.add(row);
            for (int j=0; j<8; j++) {
                row.add(Piece.createEmpty());
            }
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row=0; row<8; row++) {
            for (int column=0; column<8; column++) {
                builder.append(getPosition(column, row));
            }
            builder.append(NEWLINE);
        }
        return builder.toString();
    }

    public ArrayList<Piece> getRank(int rank)
    {
        return pieces.get(8-rank);
    }

    public ArrayList<Piece> getAll()
    {
        ArrayList<Piece> all = new ArrayList<Piece>();
        for (ArrayList<Piece> row: pieces) {
            for (Piece piece: row) {
                all.add(piece);
            }
        }
        return all;
    }

    private int getRowFromPosition(String position)
    {
        return 7-((int)position.charAt(1)-(int)'1');
    }

    private int getColumnFromPosition(String position)
    {
        return ((int)position.charAt(0)-(int)'a');
    }

    private Piece getPosition(int column, int row)
    {
        return pieces.get(row).get(column);
    }

    public Piece getPosition(String position)
    {
        return getPosition(
                getColumnFromPosition(position),
                getRowFromPosition(position)
        );
    }

    private void setPosition(int column, int row, Piece piece)
    {
        pieces.get(row).set(column, piece);
    }

    private String positionToString(int column, int row)
    {
        StringBuilder string = new StringBuilder();
        string.append((char)(column+(int)'a'));
        string.append(8-row);
        return string.toString();
    }

    public void setPosition(String position, Piece piece)
    {
        this.setPosition(
                getColumnFromPosition(position),
                getRowFromPosition(position),
                piece
        );
    }

    public boolean isValidDirection(String from, int x, int y)
    {
        int row = getRowFromPosition(from)-y;
        int column = getColumnFromPosition(from)+x;
        return (row>=0 && row<8 && column>=0 && column<8);
    }

    public String getMoveDirection(String from, int x, int y)
    {
        int row = getRowFromPosition(from)-y;
        int column = getColumnFromPosition(from)+x;
        return positionToString(column, row);
    }

    public String findPiece(Piece piece)
    {
        for (int row=0; row<8; row++) {
            for (int column=0; column<8; column++) {
                if (piece==getPosition(column, row)) {
                    return positionToString(column, row);
                }
            }
        }
        return null;
    }
}
