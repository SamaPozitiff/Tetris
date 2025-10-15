package manager;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class HighScore {
    @Id
    @GeneratedValue
    private Long id;
    private static long highScore = 0;


    public static long getHighScore(){
        return highScore;
    }

    public static void resetHighScore(){
        highScore = 0;
    }
    public static void incrementHighScore(int row) {
        if (row == 1) {
            highScore += 50;
        } else if (row == 2) {
            highScore += 125;
        } else if (row == 3) {
            highScore += 200;
        } else if (row == 4) {
            highScore += 300;
        }
    }
}
