package snake.gui;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import snake.domain.*;
import snake.Direction;
import snake.game.SnakeGame;

public class KeyboardListener implements KeyListener {

    private Snake snake;
    private SnakeGame game;

    public KeyboardListener(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                this.snake.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                this.snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                this.snake.setDirection(Direction.RIGHT);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
