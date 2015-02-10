package com.crafton.brian.handlers;

import com.crafton.brian.MainActivity;
import com.crafton.brian.states.Menu;
import com.crafton.brian.states.State;

public class GameStateManager 
{
	private MainActivity game;
	
	private State currentState;

    /**
     * Constructor for the gamestatemanager object
     * @param game
     */
	public GameStateManager(MainActivity game)
	{
		this.game = game;
		this.currentState = new Menu(this);
		
	}

    /**
     * updates the game
     */
	public void update()
	{
		this.currentState.update();
	}

    /**
     * renders the current state
     */
	public void render()
	{
		this.currentState.render();
	}

    /**
     * returns the game object.
     * @return the MainActivity game object
     */
	public MainActivity getGame()
	{
		return this.game;
	}

    /**
     * sets the current state to something else.
     * @param newState the new state to be rendered and updated.
     */
	public void setState(State newState)
	{
		this.currentState = newState;
	}
}
