import processing.core.PApplet;
import processing.core.PVector;

public abstract class Sprite {
    PApplet p;
    PVector position;
    final static int SPEED = 1;
    float vel;
    float radius;
    int color;

    public Sprite(PApplet p){
        position = new PVector();
        this.p = p;
        this.position.x = (float) Math.random() * p.width;
        this.radius = (float) (Math.random() * 30) + 15; //Gives a range of 15-30 for the radius;
    }

    public void move(){
        this.position.y += vel;
    }

    public void draw(){
        p.fill(color);
        p.circle(position.x, position.y, radius);
    }

    public float getVel(){
        return this.vel;
    }

}
