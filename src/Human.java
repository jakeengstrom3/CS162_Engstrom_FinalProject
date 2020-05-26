import processing.core.PApplet;
import processing.core.PVector;

public class Human extends Sprite{
    final int HUMAN_COLOR = 999999999; //White


    public Human(PApplet p){
        super(p);
        this.position.y = (float) (p.height - ((Math.random() * 50) + 50)); //Between 50 and 100
        this.vel = SPEED * -1;
        this.color = HUMAN_COLOR;
    }
}
