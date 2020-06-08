import processing.core.PApplet;
import processing.sound.*;

public class Zombie extends Sprite{
    final int ZOMBIE_COLOR = 0; //Black
    public SoundFile deathSoundFile;
    public Zombie(float x, float y, PApplet p){
        super(p);
        this.position.x = x;
        this.position.y = y;
        this.color = ZOMBIE_COLOR;
        this.deathSoundFile = new SoundFile(p, "ZombieDeath.mp3");
    }

    public Zombie(PApplet p){
        super(p);
        this.position.y = (float) (Math.random() * 50) + 50; //Between 50 and 100
        this.color = ZOMBIE_COLOR;
        this.deathSoundFile = new SoundFile(p, "ZombieDeath.mp3");
    }

    public void playDeathSound(){
        deathSoundFile.play();
    }

    @Override
    public void move() {
        double choice = Math.random();
        if(choice < (1 / speed)){
            this.position.x++;
        } else if(choice < (2 / speed)){
            this.position.x--;
        } else if(choice < (3 / speed)){
            this.position.y--;
        } else {
            this.position.y++;
        }
    }
}
