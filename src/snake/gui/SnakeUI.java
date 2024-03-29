package snake.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.WindowConstants;
import snake.game.*;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SnakeUI implements Runnable {

    private JFrame frame;
    private SnakeGame game;
    private int sideLength;
    private PlayPanel board;
    private JLabel label;
    private int points;
    private Image logo;

    public SnakeUI(SnakeGame game, int sideLength) {
        this.game = game;
        this.sideLength = sideLength;
        this.points = this.game.getPoints();
        this.logo = new ImageIcon("src\\files\\snake_logo.jpg").getImage();
    }
/**
 * this method sets the main frame of the game
 */
    public void run() {
        this.frame = new JFrame("Snake");
        this.frame.setIconImage(this.logo);
        int width = (this.game.getWidth() + 1) * sideLength + 10;
        int height = (this.game.getHeight() + 2) * sideLength + 10;
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(this.frame.getContentPane());
        this.frame.pack();
        this.frame.setVisible(true);
    }
/**
 * this method sets the components on the main frame:
 * 1. the board game
 * 2. the panel with the points information
 * @param container 
 */
    public void createComponents(Container container) {
        this.board = new PlayPanel(this.game, this.sideLength);
        this.board.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        container.add(this.board);
        container.add(createPointsPanel(), BorderLayout.NORTH);
        this.frame.addKeyListener(new KeyboardListener(this.game.getSnake()));
    }
/**
 * this method contains the points board
 * @return 
 */
    public JPanel createPointsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JLabel pointsName = new JLabel("YOUR POINTS");
        JLabel empty = new JLabel("");
        this.label = new JLabel();
        this.label.setText(Integer.toString(this.points));
        panel.add(pointsName);
        panel.add(this.label);
        panel.add(empty);
        return panel;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JLabel updateLabel() {
        this.label.setText(Integer.toString(this.game.getPoints()));
        return this.label;
    }

    public Updatable getUpdatable() {
        return this.board;
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public void setPoints(){
        this.points++;
    }
}
