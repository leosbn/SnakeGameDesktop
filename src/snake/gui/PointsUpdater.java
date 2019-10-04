package snake.gui;

import snake.game.SnakeGame;
import snake.gui.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PointsUpdater implements ActionListener {

    private SnakeGame game;
    private SnakeUI ui;

    public PointsUpdater(SnakeGame game, SnakeUI ui) {
        this.game = game;
        this.ui = ui;
    }

    public void updateP() {
        this.ui.updateLabel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.game.getPoints()!=Integer.parseInt(this.ui.getLabel().getText())){
            this.ui.updateLabel();
        }
    }
    
    
}
