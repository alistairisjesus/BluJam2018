import processing.core.PApplet;

/**
 * Created by sam on 20/04/18.
 */
public class SpaceLayer extends Layer {

    float dy;

    /**
     * Default constructor for the Layer
     *
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     */
    public SpaceLayer(float minY, float maxY) {
        super(minY, maxY);
        dy = 2;
    }

    @Override
    public void draw(PApplet pApplet) {
    }

    @Override
    public void modify(App app) {
        //a.update(0, dy);
    }
}
