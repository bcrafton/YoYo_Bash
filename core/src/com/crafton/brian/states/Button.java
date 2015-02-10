package com.crafton.brian.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.crafton.brian.handlers.InputHandler;

public class Button 
{
	Vector2 pos; 
	int height, width; 
	Rectangle buttonPosition; 
	Texture texture;
    InputHandler input;
	
	boolean touchState;

    /**
     * Constructor for the Button object.
     * @param pos the position of the button
     * @param texture the texture that represents the button
     */
	public Button(Vector2 pos, Texture texture)
	{
		this.pos = pos; 
		this.height = texture.getHeight();
		this.width = texture.getWidth();
		this.texture = texture; 
		
		this.buttonPosition = new Rectangle(); 
		this.buttonPosition.x = pos.x; 
		this.buttonPosition.y = pos.y; 
		this.buttonPosition.height = height;
		this.buttonPosition.width = width; 
		
		input = new InputHandler();
		touchState = true; 
	}

    /**
     * renders the button
     * @param sb the sprite batch object needed to render the button
     */
	void render(SpriteBatch sb)
	{
		sb.draw(this.texture, this.pos.x, this.pos.y); 
	}

    /**
     * checks to see if the button was touched
     * @return whether the button was touched or not
     */
	boolean isTouched() 
	{
		if(Gdx.input.isTouched())
		{	
			if(touchState == false)
			{
				Vector2 temp = input.getInput(); 
				if(buttonPosition.contains(temp.x, temp.y))
				{
					touchState = true; 
					return true;
				}
			}
		}
		else
		{
			touchState = false; 
		}
		return false;
	}
}; 
