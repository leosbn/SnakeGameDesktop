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

    public boolean runsIntoItself() {
        for (int i = 0; i < this.getLength() - 1; i++) {
            if (this.getHead().getX() == this.piecesOfSnake.get(i).getX() && this.getHead().getY() == this.piecesOfSnake.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
}
