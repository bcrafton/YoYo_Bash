package com.crafton.brian.entities;


import com.badlogic.gdx.math.Vector2;

public class Enemy extends Entity
{
	Vector2 direction; 
	boolean offScreen = false;

    /**
     * Constructs an enemy object.
     * @param pos a vector containing the position of the enemy on the screen
     * @param direction the direction vector
     */
	public Enemy(Vector2 pos, Vector2 direction) 
	{
		super(pos);
		this.direction = direction; 
	}

	@Override
	public void update() 
	{
		pos.add(direction);
		
		if (pos.y <= -this.texture.getHeight()) 
		{
			this.offScreen = true; 
		}
	}

    /**
     * Returns whether the enenmy is on screen or not.
     * @return true or false if the enemy is on the screen or not.
     */
	public boolean offScreen()
	{
		return this.offScreen; 
	}
}


