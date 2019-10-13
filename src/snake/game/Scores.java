package snake.game;

import java.io.File;
import java.io.FileWriter;

public class Scores {

    private File file;
    private FileWriter writer;
    private static final String FILENAME = "SnakeGameScores.txt";
    private static final String PATH = System.getProperty("user.home");

    public Scores() {
        this.file = new File(PATH + File.separator + FILENAME);
    }

    public void addLastScore(int score) {
        try {
            this.writer = new FileWriter(this.file, true);
            this.writer.append("\n" + score);
            this.writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
