import processing.core.PApplet;
import processing.core.PVector;

public abstract class Sprite {
    PApplet p;
    PVector position;
    final static int SIZE_UPPER = 50;
    final static int SIZE_LOWER = 5;
    final float speed = 8;
    public float circumference;
    public float radius;
    protected int color;

    public Sprite(PApplet p){
        position = new PVector();
        this.p = p;
        this.position.x = (float) Math.random() * p.width;
        this.circumference = (float) p.random(SIZE_LOWER, SIZE_UPPER);
        this.radius = circumference / 2;
    }

    public abstract void move();

    public void draw(){
        p.fill(color);
        p.strokeWeight(4);
        p.stroke(0);
        p.circle(position.x, position.y, circumference);
    }

    public boolean isTouching(Sprite c1){
        return this.position.dist(c1.position) < this.radius + c1.radius;
    }

}
