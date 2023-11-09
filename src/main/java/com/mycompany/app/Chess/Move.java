
import java.util.HashMap;

/**
 * Represents a move in the chess game.
 */
public class Move {

    /** The x coordinate of the start position. */
    private int startX;

    /** The y coordinate of the start position. */
    private int startY;

    /** The x coordinate of the end position. */
    private int endX;

    /** The y coordinate of the end position. */
    private int endY;

    /** The piece that is moved. */
    private Piece movedPiece;

    /** The piece that is killed. */
    private Piece killedPiece;

    /** Maps integer values to chess board columns (a-h). */
    private final HashMap<Integer, String> columnMap = new HashMap<Integer, String>() {{
        put(1, "a");
        put(2, "b");
        put(3, "c");
        put(4, "d");
        put(5, "e");
        put(6, "f");
        put(7, "g");
        put(8, "h");
    }};


    /**
     * Constructor for a move without killing.
     *
     * @param startX     the x coordinate of the start position.
     * @param startY     the y coordinate of the start position.
     * @param endX       the x coordinate of the end position.
     * @param endY       the y coordinate of the end position.
     * @param movedPiece the piece that is moved.
     */
    public Move(int startX, int startY, int endX, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * Constructor for a move with killing.
     *
     * @param startX      the x coordinate of the start position.
     * @param startY      the y coordinate of the start position.
     * @param endX        the x coordinate of the end position.
     * @param endY        the y coordinate of the end position.
     * @param movedPiece  the piece that is moved.
     * @param killedPiece the piece that is killed.
     */
    public Move(int startX, int startY, int endX, int endY, Piece movedPiece, Piece killedPiece) {
        this(startX, startY, endX, endY, movedPiece);
        this.killedPiece = killedPiece;
    }

    /**
     * Get the start x coordinate of the move.
     *
     * @return the start x coordinate of the move.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Set the start x coordinate of the move.
     *
     * @param startX the start x coordinate of the move.
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Get the start y coordinate of the move.
     *
     * @return the start y coordinate of the move.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Set the start y coordinate of the move.
     *
     * @param startY the start y coordinate of the move.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Get the end x coordinate of the move.
     *
     * @return the end x coordinate of the move.
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Set the end x coordinate of the move.
     *
     * @param endX the end x coordinate of the move.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * Get the end y coordinate of the move.
     *
     * @return the end y coordinate of the move.
     */
    public int getEndY() {
        return endY;
    }

    /**
     * Set the end y coordinate of the move.
     *
     * @param endY the end y coordinate of the move.
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * Get the piece that is moved.
     *
     * @return the piece that is moved.
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * Set the piece that is moved.
     *
     * @param movedPiece the piece that is moved.
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * Get the piece that is killed.
     *
     * @return the piece that is killed.
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * Set the piece that is killed.
     *
     * @param killedPiece the piece that is killed.
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**
     * Get the string representation of the move.
     *
     * @return the string representation of the move.
     */
    @Override
    public String toString() {
        String column = columnMap.get(this.endX);
        String row = Integer.toString(this.endY);
        String color = this.movedPiece.getColor();
        String symbol = this.movedPiece.getSymbol();
        return color + "-" + symbol + column + row;
    }
}
