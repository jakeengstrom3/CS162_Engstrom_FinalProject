import processing.core.PApplet;
import processing.core.PVector;

public class Zombie extends Sprite{
    final int ZOMBIE_COLOR = 178108040; //Brown

    public Zombie(float posX, float posY){
        this.position.x = posX;
        this.position.y = posY;
        this.radius = (float) (Math.random() * 15) + 5; //Gives a range of 5-20 for the radius;
        this.vel = SPEED;
        this.color = ZOMBIE_COLOR;
    }
    public Zombie(PApplet p){
        position = new PVector();
        this.p = p;
        this.position.x = (float) Math.random() * 500;
        this.position.y = (float) (Math.random() * 50) + 50; //Between 50 and 100
        this.radius = (float) (Math.random() * 15) + 5; //Gives a range of 5-20 for the radius;
        this.vel = SPEED;
        this.color = ZOMBIE_COLOR;
    }
}
