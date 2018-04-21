import processing.core.PApplet;

/**
 * Created by sam on 20/04/18.
 * <p>
 * Empty layer just above earth layer - for now.
 */
public class EmptyLayer extends Layer {


    /**
     * Construct an emptylayer object
     *
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     */
    public EmptyLayer(float minY, float maxY) {
        super(minY, maxY);
    }

    @Override
    public void draw(PApplet pApplet) {
        pApplet.fill(pApplet.color(20, 20, 180));
        pApplet.rect(0, getMinY(), pApplet.width, getMaxY()-getMinY());
    }

    @Override
    public void modify(Asteroid asteroid) {

    }
}

