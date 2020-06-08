import processing.core.PApplet;

import java.util.ArrayList;

public class OutBreakHandler {
    ArrayList<Sprite> sprites;
    PApplet p;
    final double PROB_LARGER_ZOMBIE_WINS = .66;
    final double PROB_LARGER_HUMAN_WINS = .75;
    ParticleSystemHandler psh;

    public void updateParticleSystems(){
        psh.update(this.p);
    }

    public OutBreakHandler(int numZombies, int numHumans, PApplet p){
        this.psh = new ParticleSystemHandler();
        this.p = p;
        sprites = new ArrayList<Sprite>();
        for(int i = 0; i < numHumans; i++){
            sprites.add(new Human(p));
        }
        for(int i = 0; i < numZombies; i++){
            sprites.add(new Zombie(p));
        }
    }

    public void update(){
        moveSprites();
        checkCollisions();
        drawSprites();
        updateParticleSystems();
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

    public int numZombies(){
        int count = 0;
        for(Sprite s : sprites){
            if(s instanceof Zombie){
                count++;
            }
        }
        return count;
    }

    public int numHumans(){
        int count = 0;
        for(Sprite s : sprites){
            if(s instanceof Human){
                count++;
            }
        }
        return count;
    }

    public Sprite getSprite(int index){
        return sprites.get(index);
    }

    public void checkCollisions(){
        //Loop backwards through the array. Compare last with all but last, then second to last with all with lower index and so on
        for(int i = sprites.size() - 1; i >= 1; i--){ //Loops backward from last item to second item
            for(int j = i - 1; j >= 0; j--){ //Loops backward from parent loop current index - 1 to the last item
                Sprite s1 = sprites.get(i);
                Sprite s2 = sprites.get(j);
                if(s1.isTouching(s2)){
                    collide(s1, s2); //Always removes one of the sprites
                    break;
                }
            }
        }
    }

    public void collide(Sprite s1, Sprite s2){
        if(s1 instanceof Zombie && s2 instanceof Human){ //if one is a zombie and two is human
            double choice = Math.random();
            double prob;
            if(s1.radius > s2.radius) prob = PROB_LARGER_ZOMBIE_WINS;
            else prob = PROB_LARGER_HUMAN_WINS;

            if (choice < prob) {
                if(s1.radius > s2.radius){
                    sprites.add(sprites.indexOf(s2), new Zombie(s2.position.x, s2.position.y, p));
                    sprites.remove(s2);
                }else{
                    this.psh.addParticleSystem((int) s1.position.x, (int) s1.position.y, this.p);
                    ((Zombie) s1).playDeathSound();
                    sprites.remove(s1);
                }

            } else { //Smaller one wins
                if(s1.radius < s2.radius){
                    this.psh.addParticleSystem((int) s1.position.x, (int) s1.position.y, this.p);
                    ((Zombie) s1).playDeathSound();
                    sprites.remove(s1);
                }else{
                    sprites.add(sprites.indexOf(s2), new Zombie(s2.position.x, s2.position.y, p));
                    sprites.remove(s2);
                }
            }
        }
        if(s1 instanceof Human && s2 instanceof Zombie){ //if two is a zombie and one is human
            double choice = Math.random();
            double prob;
            if(s1.radius > s2.radius) prob = PROB_LARGER_HUMAN_WINS;
            else prob = PROB_LARGER_ZOMBIE_WINS;

            if (choice < prob) {
                if(s1.radius > s2.radius){
                    sprites.add(sprites.indexOf(s1), new Zombie(s1.position.x, s1.position.y, p));
                    sprites.remove(s1);
                }else{
                    this.psh.addParticleSystem((int) s2.position.x, (int) s2.position.y, this.p);
                    ((Zombie) s2).playDeathSound();
                    sprites.remove(s2);
                }

            } else { //Smaller one wins
                if(s1.radius < s2.radius){
                    sprites.add(sprites.indexOf(s1), new Zombie(s1.position.x, s1.position.y, p));
                    sprites.remove(s1);
                }else{
                    this.psh.addParticleSystem((int) s2.position.x, (int) s2.position.y, this.p);
                    ((Zombie) s2).playDeathSound();
                    sprites.remove(s2);
                }
            }
        }
    }
}
