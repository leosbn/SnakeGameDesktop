package snake.game;

import java.io.File;
import java.io.FileWriter;

public class Scores {
    private File file;
    private FileWriter writer;
    private static String path = "src/snake/game/files/scores.txt";
    
    public Scores(){
        this.file = new File(path);
    }
    
    public void addLastScore(int score){
        try {
        this.writer = new FileWriter(path, true);
        this.writer.append("\n" + score);
        this.writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
