package snake;

import snake.game.*;
import snake.gui.*;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(20, 20);

        SnakeUI ui = new SnakeUI(game, 20);
        SwingUtilities.invokeLater(ui);

        while (ui.getUpdatable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("The drawing board hasn't been created yet.");
            }
        }
        game.setUpdatable(ui.getUpdatable());
        game.start();
    }
}
