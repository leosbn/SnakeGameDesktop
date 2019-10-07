package snake.domain;

import snake.Direction;
import java.util.List;
import java.util.ArrayList;

public class Snake {

    private int x;
    private int y;
    private Direction direction;
    private List<Piece> piecesOfSnake;
    private boolean grows;

    public Snake(int originalX, int originalY, Direction direction) {
        this.x = originalX;
        this.y = originalY;
        this.direction = direction;
        this.piecesOfSnake = new ArrayList<Piece>();
        this.piecesOfSnake.add(new Piece(this.x, this.y));
        this.grows = false;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLength() {
        return this.piecesOfSnake.size();
    }

    public List<Piece> getPieces() {
        return this.piecesOfSnake;
    }

    public Piece getHead() {
        return this.piecesOfSnake.get(this.getLength() - 1);
    }

    /**
     * the snake moves in the given direction. if the snake length is less than
     * 3 pieces, the snake grows one piece at the time from the front if the
     * snake length is 3 or more pieces, the only way for it to grow is by
     * eating apples.
     */
    public void move() {
        int moveX = this.getHead().getX();
        int moveY = this.getHead().getY();
        if (null != this.direction) {
            switch (this.direction) {
                case UP:
                    moveY--;
                    break;
                case DOWN:
                    moveY++;
                    break;
                case RIGHT:
                    moveX++;
                    break;
                case LEFT:
                    moveX--;
                    break;
                default:
                    break;
            }
        }
        if (this.getLength() > 2 && !this.grows) {
            this.piecesOfSnake.remove(0);
        }
        if (this.grows) {
            this.grows = false;
        }
        this.piecesOfSnake.add(new Piece(moveX, moveY));
    }

    public void grows() {
        this.grows = true;
    }

    public boolean runsInto(Piece piece) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.piecesOfSnake.get(i).getX() == piece.getX() && this.piecesOfSnake.get(i).getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true when the head of the snake comes in touch with any part of
     * the body
     */
    public boolean runsIntoItself() {
        for (int i = 0; i < this.getLength() - 1; i++) {
            if (this.getHead().getX() == this.piecesOfSnake.get(i).getX() && this.getHead().getY() == this.piecesOfSnake.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
}
