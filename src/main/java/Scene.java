import gameObjects.*;
import gameObjects.layers.Layer;
import gameObjects.layers.SpaceLayer;

import java.util.HashSet;

/**
 * Created by sam on 20/04/18.
 */

public class Scene {
    Layer[] layers;
    Asteroid asteroid;
    

    public Scene(){
        asteroid = new Asteroid();
        layers = new Layer[5];
        layers = new SpaceLayer();
        
        //layers.add(l);
    }

    public Asteroid getAsteroid() {
        return asteroid;
    }

    public HashSet<Layer> getLayers(){
        return layers;
    }

    public void update(){
        asteroid.update();
        for(Layer layer : layers) layer.update();
    }


}
