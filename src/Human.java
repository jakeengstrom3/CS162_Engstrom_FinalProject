import processing.core.PApplet;
import processing.core.PVector;

public class Human extends Sprite{
    final int HUMAN_COLOR = 111111999; //Blue

    public Human(float posX, float posY){
        this.position.x = posX;
        this.position.y = posY;
        this.radius = (float) (Math.random() * 15) + 5; //Gives a range of 5-20 for the radius;
        this.vel = SPEED * -1;
        this.color = HUMAN_COLOR;
    }
    public Human(PApplet p){
        position = new PVector();
        this.p = p;
        this.position.x = (float) Math.random() * 500;
        this.position.y = (float) (500 - ((Math.random() * 50) + 50)); //Between height and height + 50
        this.radius = (float) (Math.random() * 15) + 5; //Gives a range of 5-20 for the radius;
        this.vel = SPEED * -1;
        this.color = HUMAN_COLOR;
    }
}
