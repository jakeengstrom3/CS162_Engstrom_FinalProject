import processing.core.PApplet;
import processing.core.PVector;

public abstract class Sprite {
    PApplet p;
    PVector position;
    final static int SPEED = 5;
    float vel;
    float radius;
    int color;

    public void move(){
        this.position.y += vel;
    }

    public void draw(){
        p.fill(color);
        p.circle(position.x, position.y, radius);
    }

}
