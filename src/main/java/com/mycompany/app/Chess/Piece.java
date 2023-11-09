
/**
 * Abstract class representing a chess piece.
 */
public abstract class Piece {

    /** The x coordinate of the piece. */
    private int coordinatesX;

    /** The y coordinate of the piece. */
    private int coordinatesY;

    /** The color of the piece. */
    private String color;

    /**
     * Constructor for a piece with coordinates.
     *
     * @param coordinatesX the x coordinate of the piece.
     * @param coordinatesY the y coordinate of the piece.
     */
    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
    }

    /**
     * Constructor for a piece with coordinates and color.
     *
     * @param coordinatesX the x coordinate of the piece.
     * @param coordinatesY the y coordinate of the piece.
     * @param color        the color of the piece.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    /**
     * Abstract method to get the symbol of the piece.
     *
     * @return the symbol of the piece.
     */
    public abstract String getSymbol();

    /**
     * Abstract method to check if the piece can move to the specified destination.
     *
     * @param board the chess board.
     * @param x     the x coordinate of the destination.
     * @param y     the y coordinate of the destination.
     * @return true if the piece can move, false otherwise.
     */
    public abstract boolean canMove(Board board, int x, int y);

    /**
     * Getter for the x coordinate of the piece.
     *
     * @return the x coordinate of the piece.
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * Setter for the x coordinate of the piece.
     *
     * @param coordinatesX the x coordinate of the piece.
     */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /**
     * Getter for the y coordinate of the piece.
     *
     * @return the y coordinate of the piece.
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * Setter for the y coordinate of the piece.
     *
     * @param coordinatesY the y coordinate of the piece.
     */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    /**
     * Getter for the color of the piece.
     *
     * @return the color of the piece.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for the color of the piece.
     *
     * @param color the color of the piece.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Check if the piece is in the same position as another piece.
     *
     * @param otherPiece the piece to check.
     * @return true if the pieces are in the same position, false otherwise.
     */
    public boolean checkPosition(Piece otherPiece) {
        return this.coordinatesX == otherPiece.getCoordinatesX()
                && this.coordinatesY == otherPiece.getCoordinatesY();
    }
}
