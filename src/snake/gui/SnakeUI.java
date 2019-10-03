package snake.gui;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Container;
import javax.swing.WindowConstants;
import snake.game.SnakeGame;

public class SnakeUI implements Runnable {

    private JFrame frame;
    private SnakeGame game;
    private int sideLength;
    private PlayPanel board;

    public SnakeUI(SnakeGame game, int sideLength) {
        this.game = game;
        this.sideLength = sideLength;
    }

    public void run() {
        this.frame = new JFrame("Snake");
        int width = (this.game.getWidth() + 1) * sideLength + 10;
        int height = (this.game.getHeight() + 2) * sideLength + 10;
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(this.frame.getContentPane());
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void createComponents(Container container) {
        this.board = new PlayPanel(this.game, this.sideLength);
        container.add(this.board);
        this.frame.addKeyListener(new KeyboardListener(this.game.getSnake()));
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public Updatable getUpdatable() {
        return this.board;
    }
}
