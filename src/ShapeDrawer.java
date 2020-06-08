import processing.core.PApplet;

public class ShapeDrawer extends PApplet {
    OutBreakHandler obh;
    Scoreboard scoreboard;
    final int MAX_HUMANS = 100;
    final int MIN_HUMANS = 50;
    final int MIN_ZOMBIES = 50;
    final int MAX_ZOMBIES = 100;
    int numZombies;
    int numHumans;
    final int BACKGROUND_COLOR = 255;

    public void settings() {
        size(1000,800);
    }

    public void setup(){
        numHumans = (int) random(MIN_HUMANS, MAX_HUMANS);
        numZombies = (int) random(MIN_ZOMBIES, MAX_ZOMBIES);
        obh = new OutBreakHandler(numZombies, numHumans, this);
        scoreboard = new Scoreboard();
    }

    public void draw(){
        background(BACKGROUND_COLOR);
        obh.update();
        scoreboard.updateScore(obh);
        scoreboard.displayScore(this);
    }

}
