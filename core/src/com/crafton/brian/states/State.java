package com.crafton.brian.states;

import com.crafton.brian.MainActivity;
import com.crafton.brian.handlers.BoundedCamera;
import com.crafton.brian.handlers.GameStateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class State
{
	protected GameStateManager gsm;
	protected MainActivity game;
	protected SpriteBatch sb;
	protected BoundedCamera cam;
	protected OrthographicCamera hudCam;
	
	public int V_WIDTH; 
	public int V_HEIGHT; 
	Vector2 center;
	Texture texture;

    /**
     * Constructor for the state object
     * @param gsm a reference to the game state manager object so can change the state of the game
     */
	public State(GameStateManager gsm)
	{
		this.gsm = gsm; 
		this.game = gsm.getGame();
		
		this.V_WIDTH = Gdx.graphics.getWidth(); 
		this.V_HEIGHT = Gdx.graphics.getHeight(); 
		this.center = new Vector2(this.V_WIDTH/2, this.V_HEIGHT/2);
		
		sb = new SpriteBatch(); 
	}

    /**
     * render the state object
     */
	public abstract void render();

    /**
     * update the state object
     */
	public abstract void update();
	
}
