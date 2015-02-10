package com.crafton.brian.handlers;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class BoundedCamera extends OrthographicCamera {
	
	private float xmin;
	private float xmax;
	private float ymin;
	private float ymax;
	
	public BoundedCamera() {
		this(0, 0, 0, 0);
	}

    /**
     * the constructor for the bounded camera object
     * @param xmin min x coordinate
     * @param xmax max x coordinate
     * @param ymin min y coordinate
     * @param ymax max y coordinate
     */
	public BoundedCamera(float xmin, float xmax, float ymin, float ymax) {
		super();
		setBounds(xmin, xmax, ymin, ymax);
	}

    /**
     * sets the bounds of the camera.
     * @param xmin min x coordinate
     * @param xmax max x coordinate
     * @param ymin min y coordinate
     * @param ymax max y coordinate
     */
	public void setBounds(float xmin, float xmax, float ymin, float ymax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}

    /**
     * sets the position of the camera
     * @param x x coordinate
     * @param y y coordinate
     */
	public void setPosition(float x, float y) {
		setPosition(x, y, 0);
	}

    /**
     * sets the 3d position ... not used
     * @param x x coordinate
     * @param y y coordinate
     * @param z z coordinate
     */
	public void setPosition(float x, float y, float z) {
		position.set(x, y, z);
		fixBounds();
	}

    /**
     * sets the bounds based on the screen of the phone
     */
	private void fixBounds() {
		if(position.x < xmin + viewportWidth / 2) {
			position.x = xmin + viewportWidth / 2;
		}
		if(position.x > xmax - viewportWidth / 2) {
			position.x = xmax - viewportWidth / 2;
		}
		if(position.y < ymin + viewportHeight / 2) {
			position.y = ymin + viewportHeight / 2;
		}
		if(position.y > ymax - viewportHeight / 2) {
			position.y = ymax - viewportHeight / 2;
		}
	}
	
}
