
import java.util.ArrayList;

/**
 * Represents a chess board.
 */
public class Board {

    /** The width of the chess board. */
    public static final int WIDTH = 8;

    /** The height of the chess board. */
    public static final int HEIGHT = 8;

    /** The list of pieces on the board. */
    private ArrayList<Piece> pieces;

    /**
     * Constructor for the chess board.
     */
    public Board() {
        pieces = new ArrayList<>();
    }

    /**
     * Add a piece to the board if the coordinates are valid and the position is empty.
     *
     * @param piece the piece to add.
     */
    public void addPiece(Piece piece) {
        int x = piece.getCoordinatesX();
        int y = piece.getCoordinatesY();

        if (validate(x, y) && getAt(x, y) == null) {
            pieces.add(piece);
        }
    }

    /**
     * Validate if the coordinates are within the bounds of the chess board.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     * @return true if the coordinates are valid, false otherwise.
     */
    public boolean validate(int x, int y) {
        return x >= 1 && x <= WIDTH && y >= 1 && y <= HEIGHT;
    }

    /**
     * Remove a piece from the board at the specified coordinates.
     *
     * @param x the x coordinate of the piece.
     * @param y the y coordinate of the piece.
     */
    public void removeAt(int x, int y) {
        pieces.removeIf(piece -> piece.getCoordinatesX() == x && piece.getCoordinatesY() == y);
    }

    /**
     * Get the piece at the specified coordinates.
     *
     * @param x the x coordinate of the piece.
     * @param y the y coordinate of the piece.
     * @return the piece at the specified coordinates, or null if no piece is found.
     */
    public Piece getAt(int x, int y) {
        return pieces.stream()
                .filter(piece -> piece.getCoordinatesX() == x && piece.getCoordinatesY() == y)
                .findFirst()
                .orElse(null);
    }

    /**
     * Set the list of pieces on the board.
     *
     * @param pieces the list of pieces.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * Get the list of pieces on the board.
     *
     * @return the list of pieces.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }
}
