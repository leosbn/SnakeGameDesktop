package snake.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;
import snake.game.*;
import snake.domain.*;

public class PlayPanel extends JPanel implements Updatable {

    private SnakeGame game;
    private int pieceLength;

    public PlayPanel(SnakeGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (Piece piece : this.game.getSnake().getPieces()) {
            graphics.setColor(Color.DARK_GRAY);
            graphics.fill3DRect(piece.getX() * this.pieceLength, piece.getY() * this.pieceLength, this.pieceLength, this.pieceLength, true);
        }
        graphics.setColor(Color.RED);
        graphics.fillOval(this.game.getApple().getX() * this.pieceLength, this.game.getApple().getY() * this.pieceLength, this.pieceLength, this.pieceLength);
    }

    public void update() {
        this.repaint();
    }

}
