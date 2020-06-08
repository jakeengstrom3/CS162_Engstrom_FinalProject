import processing.core.PApplet;

import java.util.Objects;

public class Scoreboard {
    int numZombies;
    int numHumans;


    public void displayScore(PApplet p){
        p.fill(0);
        p.text("Number of Zombies: " + numZombies, p.width / 2, 50);
        p.text("Number of Humans: " + numHumans, p.width / 2, p.height - 50);
    }

    public void updateScore(OutBreakHandler outBreakHandler){
        this.numZombies = outBreakHandler.numZombies();
        this.numHumans = outBreakHandler.numHumans();
    }
}
