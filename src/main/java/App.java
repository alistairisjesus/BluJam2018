import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App extends PApplet {
    private Asteroid asteroid;
    private ArrayList<Layer> layers;
    private Earth earth;
    PImage space;
    public static PImage green;
    private boolean left;
    private boolean right;
    public final float groundHeight = 4*height/5;

    public PFont font;

    private List<ColorCycle> layerColors = new ArrayList<>();

    public void setup() {
        frameRate(120);
        ImageLoader.loadImageAsset("green.jpg", "green", this, 1, 1);
        ImageLoader.loadImageAsset("cloud1.png", "cloud", this, 100, 50);
//        ImageLoader.loadImageAsset("wind1.png", "wind", this, 150, 75);
        layers = new ArrayList<>();
        layers.add(new SpaceLayer(0, height / 5));
        layers.add(new WindLayer(5 * height / 10, 6 * height / 10));
        layers.add(new WindLayer(6 * height / 10, 7 * height / 10));
        layers.add(new WindLayer(7 * height / 10, 8 * height / 10));
        asteroid = new Asteroid((float)((Math.random() * width*2/3) + width/6), 0, width / 48);
        earth = new Earth(4 * height / 5, height, this);

        left = false;
        right = false;

        layerColors.add(new ColorCycle(color(26, 27, 28), color(26, 27, 28), 1));
        layerColors.add(new ColorCycle(color(26, 27, 28), color(26, 27, 28), 1));
        layerColors.add(new ColorCycle(color(22, 23, 35), color(34, 35, 55), 30));
        layerColors.add(new ColorCycle(color(34, 51, 65), color(57, 84, 108), 30));
        layerColors.add(new ColorCycle(color(40, 59, 75), color(97, 121, 142), 30));
        layerColors.add(new ColorCycle(color(116, 140, 171), color(191, 202, 216), 15));
        layerColors.add(new ColorCycle(color(116, 140, 171), color(191, 202, 216), 15));
        layerColors.add(new ColorCycle(color(116, 140, 171), color(191, 202, 216), 15));
        layerColors.add(new ColorCycle(color(116, 140, 171), color(191, 202, 216), 15));

        printArray(PFont.list());

        font = createFont("SansSerif.bold",64,true);
//        space = loadImage("space.jpg");
//        space.resize(width, height/5);
//        green = loadImage("green.jpg");

    }

    public void draw() {
        /*clear();

        //asteroid.setPosition(new PVector(width/2, 4*height/5));
        for(Layer layer: layers) layer.draw(this);

        earth.draw(this);
        asteroid.draw(this);

        earth.explode(asteroid);
        asteroid.reset();*/

        clear();
        earth.update(this);
        // User movement
        if (left || right) {
            asteroid.userMove(left, this);
        }

        asteroid.update(this);


        for(Layer layer: layers){
//            if(layer.getClass() != CloudLayer.class && layer.getClass() != WindLayer.class) layer.modify(asteroid);
//            else ((CloudLayer)layer).modify(this);
            layer.modify(this);

        }


        noStroke();
        int dy = (int) (height * 0.85) / layerColors.size();
        int y = 0;
        for (ColorCycle c : layerColors) {
            fill(c.getColor(millis()));
            rect(0, y, width, dy);
            y += dy;
        }

        fill(color(50, 35, 29));
        rect(0, earth.yOffset, width, height - groundHeight);

        textAlign(CENTER, CENTER);
        fill(color(0, 0, 0));
        textFont(font);
        String text = Integer.toBinaryString(0x10000000 | ((millis() / 100) * 4)).substring(1);
        text(text, width/2, (earth.yOffset + height)/2);

        //earth.draw(this);
        for(Layer layer: layers) layer.draw(this);
        earth.draw(this);
        asteroid.draw(this);

    }

    public PImage getImage(String i) {
        switch (i) {
            case "space":
                return space;
            default:
                return null;
        }

    }


    public void settings() {
        fullScreen();
    }

    public static void main(String[] args) {
        PApplet.main(App.class);
    }

    public Asteroid getAsteroid() {
        return asteroid;
    }

    public ArrayList<Layer> getLayers() {
        return layers;
    }

    public void setAsteroid (Asteroid a) {
        this.asteroid = a;
    }

    //Sets booleans for keys
    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == LEFT) {
                left = true;
            } else if (keyCode == RIGHT) {
                right = true;
            }
        }
    }

    //Removes true booleans when key released
    public void keyReleased() {
        if (key == CODED) {
            if (keyCode == LEFT) {
                left = false;
                //asteroid.getVelocity().add(new PVector(-1,0));
                //cat.velLeft = new PVector(-3/2, 0);
            } else if (keyCode == RIGHT) {
                right = false;
                //asteroid.getVelocity().add(new PVector(1,0));
                //cat.velRight = new PVector(3/2, 0);
            }
        }
    }
}
