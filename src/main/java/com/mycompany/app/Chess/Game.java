import java.util.ArrayList;

/**
 * The Game class represents a chess game.
 */
public class Game {

    private Board board;
    private ArrayList<Move> moveHistory;

    /**
     * Constructs a Game object with the specified board.
     *
     * @param board The board to play on.
     */
    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<>();
    }

    /**
     * Gets the current game board.
     *
     * @return The game board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Sets the game board to the specified board.
     *
     * @param board The board to set.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Gets the move history of the game.
     *
     * @return The move history.
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * Moves a chess piece to the specified coordinates.
     *
     * @param piece The piece to move.
     * @param x The x-coordinate of the move.
     * @param y The y-coordinate of the move.
     */
    public void movePiece(Piece piece, int destinationX, int destinationY) {
        if (piece.canMove(this.board, destinationX, destinationY)) {
            int currentX = piece.getCoordinatesX();
            int currentY = piece.getCoordinatesY();

            Move newMove = createMove(piece, currentX, currentY, destinationX, destinationY);

            if (isDestinationOccupied(destinationX, destinationY)) {
                handleOccupiedDestination(destinationX, destinationY, piece);
            } else {
                updateBoardAndPiecePosition(piece, currentX, currentY, destinationX, destinationY);
            }

            this.moveHistory.add(newMove);
        }
    }

    private Move createMove(Piece piece, int startX, int startY, int endX, int endY) {
        return new Move(startX, endX, startY, endY, piece);
    }

    private boolean isDestinationOccupied(int x, int y) {
        return this.board.getAt(x, y) != null;
    }

    private void handleOccupiedDestination(int x, int y, Piece movingPiece) {
        Piece pieceAtDestination = this.board.getAt(x, y);
        Move newMove = createMove(movingPiece, movingPiece.getCoordinatesX(), movingPiece.getCoordinatesY(), x, y);
        newMove.setKilledPiece(pieceAtDestination);

        this.board.removeAt(x, y);
        updateBoardAndPiecePosition(movingPiece, movingPiece.getCoordinatesX(), movingPiece.getCoordinatesY(), x, y);
    }

    private void updateBoardAndPiecePosition(Piece piece, int startX, int startY, int endX, int endY) {
        this.board.removeAt(startX, startY);
        piece.setCoordinatesX(endX);
        piece.setCoordinatesY(endY);
        this.board.addPiece(piece);
    }

}
