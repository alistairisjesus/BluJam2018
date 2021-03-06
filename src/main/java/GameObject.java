import processing.core.PVector;
import processing.core.PImage;

/**
 * A generic class for an object that exists within a layer
 */
public abstract class GameObject implements Drawable{
    protected PVector position;
    protected PVector velocity;

    /**
     * Default constructor for an object that exists within a layer
     * @param xPos The initial x position of the object
     * @param yPos The initial y position of the object
     */
    public GameObject(float xPos, float yPos) {
        this.position = new PVector(xPos, yPos);
        this.velocity = new PVector(0, 0); // Initial velocity vector
    }

    /**
     * Default constructor for an object that exists within a layer
     * @param xPos The initial x position of the object
     * @param yPos The initial y position of the object
     * @param xVel The initial x velocity of the object
     * @param yVel The initial y velocity of the object
     */
    public GameObject(float xPos, float yPos, float xVel, float yVel) {
        this.position = new PVector(xPos, yPos);
        this.velocity = new PVector(xVel, yVel); // Initial velocity vector
    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }

    public PVector getVelocity() {
        return velocity;
    }

    public void setVelocity(PVector velocity) {
        this.velocity = velocity;
    }


}
