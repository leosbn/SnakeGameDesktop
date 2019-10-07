package snake.domain;

/**
 * the most basic object of the game, meant to compose the apple and the pieces
 * of the body of the moving snake
 *
 * @author leosbn
 */
public class Piece {

    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * if the coordinates of this piece take the same values of another piece,
     * it means the two pieces have made contact and the method returns true
     *
     * @param piece
     * @return
     */
    public boolean runsInto(Piece piece) {
        if (this.x == piece.getX() && this.y == piece.getY()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
