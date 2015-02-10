package com.crafton.brian.entities;

public class EntityNode
{
	public EntityNode next, prev; 
	private Entity ptr;

    /**
     * Constructor for the entity node object.
     * This is just a wrapper for the entity object
     * @param entity a reference to the entity itself
     */
	public EntityNode(Entity entity)
	{
		this.ptr = entity;
	}

    /**
     * getter for the entity.
     * @return the entity object
     */
	Entity getEntity()
	{
		return this.ptr; 
	}

    /**
     * sets the enttiy object the wrapper holds
     * @param entity the entity object
     */
	public void setEntity(Entity entity)
	{
		this.ptr = entity; 
	}
	
};