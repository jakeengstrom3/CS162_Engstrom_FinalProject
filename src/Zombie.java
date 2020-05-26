import processing.core.PApplet;
import processing.core.PVector;

public class Zombie extends Sprite{
    final int ZOMBIE_COLOR = 0; //Black


    public Zombie(PApplet p){
        super(p);
        this.position.y = (float) (Math.random() * 50) + 50; //Between 50 and 100

        this.vel = SPEED;
        this.color = ZOMBIE_COLOR;
    }
}
