package com.crafton.brian.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.crafton.brian.handlers.InputHandler;

public class Player extends Entity
{
	double theta; 
	double length; 
	double lastLength;
	
	long touchTime;
	long offTime; 
	double speed; 
	boolean wasTouched;

    InputHandler input;

    /**
     * Constructor for the Player object
     * @param pos the position of the player on the screen.
     */
	public Player(Vector2 pos)
	{
		super(pos);
		
		this.theta = 0; 
		this.length = 200; 
		this.lastLength = 200;
		
		this.touchTime = 0; 
		this.offTime = 0; 
		this.speed = 2; 
		this.wasTouched = false; 
		
		input = new InputHandler();
	}

    /**
     * updates the player
     */
	public void update()
	{
		getSpeed(); 
		getLength(); 
		theta = theta + Math.toRadians(this.speed);
		pos.x = (float) (center.x + this.length*Math.cos(theta));
		pos.y = (float) (center.y + this.length*Math.sin(theta)); 
		
	}

    /**
     * calculates and sets the speed of the player
     */
	public void getSpeed()
	{
		if (input.isTouched())
		{
			if(System.currentTimeMillis() - this.touchTime > 1000 && wasTouched == true)
			{
				this.touchTime = System.currentTimeMillis(); 
				this.offTime = System.currentTimeMillis();
				this.speed++; 
			}
			else 
			{
				this.wasTouched = true; 
				this.offTime = System.currentTimeMillis(); 
			}
		}
		else
		{
			wasTouched = false; 
			this.touchTime = System.currentTimeMillis(); 
			
			if(System.currentTimeMillis() - this.offTime > 1000)
			{
				this.offTime = System.currentTimeMillis();
				if (this.speed > 2)
					this.speed--; 
			}
		}
		
	}

    /**
     * gets the distance from the player to the center of the screen.
     */
	public void getLength()
	{
		if(Gdx.input.isTouched())
		{
			Vector2 touch = input.getInput();
			double x = touch.x - center.x; 
			double y = touch.y - center.y; 
			this.length = Math.sqrt(x*x + y*y); 
			
			////////////////// controlling length//////////////////////////////////////////////
			if(this.length > this.lastLength + 4)
				this.length = this.lastLength + 4; 
			
			else if(this.length < this.lastLength -4)
				this.length = this.lastLength -4;
			
			else if(this.length > Gdx.graphics.getHeight()*(.4))
				this.length =  Gdx.graphics.getHeight()*(.4);
			//////////////////controlling length//////////////////////////////////////////////
			this.lastLength = this.length; 
		}
	}


}

