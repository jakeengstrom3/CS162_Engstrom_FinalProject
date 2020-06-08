import processing.core.PApplet;
import processing.core.PVector;

public class Human extends Sprite{
    final int HUMAN_COLOR = 999999999; //White
    public Human(PApplet p){
        super(p);
        this.position.y = (float) (p.height - ((Math.random() * 50) + 50)); //Between 50 and 100
        this.color = HUMAN_COLOR;
    }

    @Override
    public void move() {
        double choice = Math.random();
        if(choice < (1 / speed)){
            this.position.x++;
        } else if(choice < (2 / speed)){
            this.position.x--;
        } else if(choice < (3 / speed)){
            this.position.y++;
        } else {
            this.position.y--;
        }
    }
}
