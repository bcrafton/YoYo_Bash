package com.crafton.brian.entities;

import com.crafton.brian.handlers.TextureManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity
{
	public int V_WIDTH; 
	public int V_HEIGHT; 
	public Vector2 center;
	
	protected Texture texture;
	protected Vector2 pos;

	
	public int color;

    /**
     * Constructs the entity object.
     * @param pos the position of the entity on the screen
     */
	public Entity(Vector2 pos)
	{
		this.V_WIDTH = Gdx.graphics.getWidth(); 
		this.V_HEIGHT = Gdx.graphics.getHeight(); 
		this.center = new Vector2(this.V_WIDTH/2, this.V_HEIGHT/2);
		
		this.pos = pos; 
		
		this.color = MathUtils.random(0, 2);
		switch(this.color)
		{
			case 0:
				this.texture = TextureManager.RED;
				break;
			case 1:
				this.texture = TextureManager.GREEN;  
				break;
			case 2:
				this.texture = TextureManager.BLUE;  
				break;
		}
		this.setTexture(texture); 
	}

    /**
     * Sets the texture of the entity.
     * @param texture the texture object, references the skin of the entity.
     */
	public void setTexture(Texture texture)
	{
		this.texture = texture; 
	}

    /**
     * Updates the entity on the screen.
     */
	public abstract void update();

    /**
     * Draws the entity on the screen
     * @param sb the sprite batch object to be drawn.
     */
	public void render(SpriteBatch sb)
	{
		sb.draw(this.texture, this.pos.x, this.pos.y);
	}

    /**
     * Returns the position of the object
     * @return position vector of the object
     */
	public Vector2 getPosition()
	{
		return pos;
	}

    /**
     * Gets the bounds of the objects skin to check for collisions
     * @return the bounds of the object
     */
	public Rectangle getBounds() 
	{
		return new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
	}

    /**
     * checks if the entity is off the screen or not.
     * @return whether the entity is on the screen or not.
     */
	public boolean offScreen()
	{
		return false; 
	}

    /**
     * checks if player loses or if player wins and then sets the color of the player to correct color.
     * @param entity the entity to be changed.
     * @return true or false if the game is over or not.
     */
	public boolean counter(Entity entity)
	{
		if(this.color == 0 && entity.color == 1)
		{
			return true;
		}
		if(this.color == 1 && entity.color == 2)
		{
			return true;
		}
		if(this.color == 2 && entity.color == 0)
		{
			return true;
		}
		else 
			return false;
	}

    /**
     * sets the color of the entity.
     * @param color the color to be set
     */
	public void setColor(int color)
	{
		this.color = color;
		if(this.color == 0)
			this.setTexture(TextureManager.RED);
		else if(this.color == 1)
			this.setTexture(TextureManager.GREEN);
		else if(this.color == 2)
			this.setTexture(TextureManager.BLUE);
		
	}
}
	
