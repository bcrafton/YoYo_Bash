package com.crafton.brian.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.crafton.brian.states.Menu;
import com.crafton.brian.entities.EntityList;
import com.crafton.brian.entities.Player;

public class EntityManager 
{
	public int V_WIDTH; 
	public int V_HEIGHT; 
	Vector2 center;
	
	EntityList list;
	private Player player;
	int length;
	GameStateManager gsm;

    /**
     * The constructor for the entity manager
     * @param gsm reference to game state manager object so that entities can change the state of the game
     * @param amount the number of entities to be constructed
     */
	public EntityManager(GameStateManager gsm, int amount)
	{
		this.V_HEIGHT = Gdx.graphics.getWidth();
		this.V_WIDTH = Gdx.graphics.getHeight();
		this.center = new Vector2(this.V_WIDTH/2, this.V_HEIGHT/2);
		
		this.length = 200;
		this.gsm = gsm;
		player = new Player(new Vector2(center.x + this.length, center.y));
		list = new EntityList(amount);
	}

    /**
     * updates all the entities
     */
	public void update() 
	{
		list.update();
		player.update();
		checkCollisions();
	}

    /**
     * renders all the entities.
     * @param sb the sprite batch object for rendering the entities.
     */
	public void render(SpriteBatch sb) 
	{
		list.render(sb); 
		player.render(sb);
	}

    /**
     * checks for collisions between the player and enemies.
     */
	private void checkCollisions() 
	{
		int collision = 0;
		if((collision = list.checkCollisions(player)) != 0)
		{
			if(collision == 1)
			{
				player.setColor((player.color+1)%3);
			}	
			else if(collision == -1)
			{
				this.gsm.setState(new Menu(this.gsm));
			}
		}
	}

    /**
     * checks if the player has won or not yet
     * @return whether the player has won or not
     */
	public boolean gameOver() 
	{
		return list.getSize() <= 0; 
	}

    /**
     * returns the kill count
     * @return the kill count
     */
	public int getKillCount()
	{
		return this.list.getKillCount(); 
	}
}
