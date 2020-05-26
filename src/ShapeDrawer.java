import processing.core.PApplet;

public class ShapeDrawer extends PApplet {
    OutBreakHandler obh;

    public void settings() {
        size(1000,800);
    }

    public void setup(){
        obh = new OutBreakHandler(50, 50, this);
        System.out.println(obh.getSprite(0).getVel());
    }

    public void draw(){
        background(255);
        obh.moveSprites();
        obh.drawSprites();
    }

}
