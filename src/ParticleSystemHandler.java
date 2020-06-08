import processing.core.PApplet;

import java.util.ArrayList;

public class ParticleSystemHandler {
    ArrayList<ParticleSystem> particleSystems;

    public ParticleSystemHandler(){
        this.particleSystems = new ArrayList<ParticleSystem>();
    }

    public void addParticleSystem(int x, int y, PApplet pApplet){
        particleSystems.add(new ParticleSystem(x, y, pApplet));
    }

    public void update(PApplet p){
        for(int i = particleSystems.size() - 1; i >= 0; i--){
            if(!particleSystems.get(i).onScreen(p)){
                particleSystems.remove(i);
            }
        }
        for(ParticleSystem ps : particleSystems){
            ps.update();
            ps.draw();
        }
    }


}
