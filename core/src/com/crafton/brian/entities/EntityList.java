package com.crafton.brian.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.crafton.brian.handlers.TextureManager;

public class EntityList
{
	public int V_WIDTH; 
	public int V_HEIGHT; 
	public Vector2 center;
	private int killCount; 
	
	public EntityNode head, tail;

    /**
     * Constructor for the entity list object
     * @param amount the number of entities for be created.
     */
	public EntityList(int amount)
	{
		this.V_WIDTH = Gdx.graphics.getWidth(); 
		this.V_HEIGHT = Gdx.graphics.getHeight(); 
		this.center = new Vector2(this.V_WIDTH/2, this.V_HEIGHT/2);
		
		this.head = null; 
		this.tail = null; 
		
		for (int i = 0; i < amount; i++) 
		{
			append(makeEnemy());
		}
		
		this.killCount = 0; 
	}

    /**
     * creates an enemy object
     * @return the enemy reference
     */
	private Enemy makeEnemy()
	{
		float x = MathUtils.random(0, V_WIDTH - TextureManager.RED.getWidth());
		float y = MathUtils.random(V_HEIGHT, V_HEIGHT * 3);
		// than others.
		float speed = MathUtils.random(2, 5);
		return new Enemy(new Vector2(x, y), new Vector2(0, -speed));
	}

    /**
     * appends an new entity to the list
     * @param entity the entity to be added
     */
	public void append(Entity entity)
	{
		EntityNode newNode = new EntityNode(entity);
		if(head == null && tail == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.next = newNode;
			newNode.prev = tail; 
			tail = newNode;
		}
	}

    /**
     * removes an entity from the list
     * @param ptr the entity reference to be removed.
     */
	public void remove(EntityNode ptr)
	{
		if(head == null)
		{
			return;
		}
		else if(ptr == head && ptr == tail)
		{
			head = null;
			tail = null; 
		}
		else if(ptr == head)
		{
			head = head.next;
			head.prev = null;
		}
		else if (ptr == tail)
		{
			tail = tail.prev;
			tail.next = null; 
		}
		else
		{
			ptr.prev.next = ptr.next;
			ptr.next.prev = ptr.prev; 
		}
	}

    /**
     * renders each entity in the list
     * @param sb the sprite batch object used to render them
     */
	public void render(SpriteBatch sb) 
	{
		for(EntityNode ptr = head; ptr != null; ptr = ptr.next)
		{
			ptr.getEntity().render(sb); 
		}
	}

    /**
     * updates each entity in the list
     */
	public void update()
	{
		for(EntityNode ptr = head; ptr != null; ptr = ptr.next)
		{
			ptr.getEntity().update(); 
			if(ptr.getEntity().offScreen())
			{
				ptr.setEntity(makeEnemy());
			}
		}
	}

    /**
     * returns the size of the entity list
     * @return returns the size of the entity list
     */
	public int getSize()
	{
		int size = 0;
		for(EntityNode ptr = head; ptr != null; ptr = ptr.next)
		{
			size++; 
		}
		return size;
	}

    /**
     * checks to see if there were any collisons between the enemies and the player.
     * @param player the entity to check elements in the list against
     * @return if the game is over or if the player made a kill
     */
	public int checkCollisions(Player player)
	{
		for(EntityNode ptr = head; ptr != null; ptr = ptr.next)
		{
			if(ptr.getEntity().getBounds().overlaps(player.getBounds()))
			{
				
				if(player.counter(ptr.getEntity()))
				{
					ptr.setEntity(makeEnemy());
					this.killCount++; 
					return 1;
				}
				else

				{
					return -1;
				}
			}
		}
		return 0;
	}

    /**
     * returns the kill count of the list
     * @return the kill count of the list
     */
	public int getKillCount()
	{
		return killCount; 
	}
};