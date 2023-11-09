/**
 * Represents a Bishop chess piece.
 */
public class Bishop extends Piece {

    /**
     * Constructor for Bishop.
     *
     * @param coordinatesX x-coordinate of the piece.
     * @param coordinatesY y-coordinate of the piece.
     */
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     * Constructor for Bishop with specified color.
     *
     * @param coordinatesX x-coordinate of the piece.
     * @param coordinatesY y-coordinate of the piece.
     * @param color         the color of the piece.
     */
    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    /**
     * Get the symbol of the Bishop piece.
     *
     * @return the symbol of the piece.
     */
    public String getSymbol() {
        return "B";
    }

    /**
     * Check if the Bishop can move to the destination.
     *
     * @param board the board of the game.
     * @param x     the x coordinate of the destination.
     * @param y     the y coordinate of the destination.
     * @return true if the piece can move to the destination, false otherwise.
     */
    public boolean canMove(Board board, int x, int y) {
        if (!isValidDestination(x, y)) {
            return false;
        }

        if (isSameColorPiece(board, x, y)) {
            return false;
        }

        if (isDiagonalMove(x, y)) {
            return isPathClear(board, x, y);
        }

        return false;
    }

    /**
     * Check if the destination coordinates are within the valid chess board range.
     *
     * @param x the x coordinate of the destination.
     * @param y the y coordinate of the destination.
     * @return true if the destination is within the valid range, false otherwise.
     */
    private boolean isValidDestination(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    /**
     * Check if the destination has a piece of the same color.
     *
     * @param board the board of the game.
     * @param x     the x coordinate of the destination.
     * @param y     the y coordinate of the destination.
     * @return true if the destination has a piece of the same color, false otherwise.
     */
    private boolean isSameColorPiece(Board board, int x, int y) {
        Piece destinationPiece = board.getAt(x, y);
        return destinationPiece != null && destinationPiece.getColor().equals(this.getColor());
    }

    /**
     * Check if the move is a diagonal move.
     *
     * @param x the x coordinate of the destination.
     * @param y the y coordinate of the destination.
     * @return true if the move is diagonal, false otherwise.
     */
    private boolean isDiagonalMove(int x, int y) {
        return Math.abs(x - this.getCoordinatesX()) == Math.abs(y - this.getCoordinatesY());
    }

    /**
     * Check if the path to the destination is clear.
     *
     * @param board the board of the game.
     * @param x     the x coordinate of the destination.
     * @param y     the y coordinate of the destination.
     * @return true if the path is clear, false otherwise.
     */
    private boolean isPathClear(Board board, int x, int y) {
        int xDirection = Integer.compare(x, this.getCoordinatesX());
        int yDirection = Integer.compare(y, this.getCoordinatesY());

        for (int i = this.getCoordinatesX() + xDirection, j = this.getCoordinatesY() + yDirection;
             i != x; i += xDirection, j += yDirection) {
            if (board.getAt(i, j) != null) {
                return false;
            }
        }

        return true;
    }
}
