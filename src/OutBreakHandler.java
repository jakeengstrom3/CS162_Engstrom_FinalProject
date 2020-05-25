import processing.core.PApplet;

import java.util.ArrayList;

public class OutBreakHandler {
    ArrayList<Sprite> sprites;

    public OutBreakHandler(int numZombies, int numHumans, PApplet p){
        sprites = new ArrayList<Sprite>();
        for(int i = 0; i < numZombies; i++){
            sprites.add(new Zombie(p));
        }

    }

    public void moveSprites(){
        for(Sprite s : sprites){
            s.move();
        }
    }

    public void drawSprites(){
        for(Sprite s : sprites){
            s.draw();
        }
    }
}
