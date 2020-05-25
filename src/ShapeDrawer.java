import processing.core.PApplet;

public class ShapeDrawer extends PApplet {
    OutBreakHandler obh;

    public void settings() {
        size(500,500);
    }
    public void setup(){
        obh = new OutBreakHandler(50, 50, this);
    }
    public void draw(){
        background(50);
        obh.moveSprites();
        obh.drawSprites();
    }

}
