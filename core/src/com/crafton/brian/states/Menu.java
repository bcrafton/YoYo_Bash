package com.crafton.brian.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.crafton.brian.handlers.EntityManager;
import com.crafton.brian.handlers.GameStateManager;
import com.crafton.brian.handlers.TextureManager;
public class Menu extends State
{
	Texture menuTexture; 
	Texture newGameTexture, controlScreenTexture;
	Button newGameButton, controlScreenButton; 
	
	Vector2 newGameButtonPos;
	Vector2 controlScreenButtonPos;

	EntityManager em;

    /**
     * Constructor for the menu object
     * @param gsm a reference to the game state object so that can change the state of the game
     */
	public Menu(GameStateManager gsm)
	{
		super(gsm);
		
		em = new EntityManager(this.gsm, 0);
		
		this.newGameTexture = TextureManager.NEWGAME;
		this.controlScreenTexture = TextureManager.CONTROLBUTTON; 
		
		newGameButtonPos = new Vector2(this.center.x - this.newGameTexture.getWidth()/2, this.center.y - this.newGameTexture.getHeight()/2); 
		controlScreenButtonPos = new Vector2(this.center.x - this.controlScreenTexture.getWidth()/2, this.center.y - this.controlScreenTexture.getHeight()/2 - 50 - newGameTexture.getHeight()); 
		
		this.newGameButton = new Button(newGameButtonPos, newGameTexture); 
		this.controlScreenButton = new Button(controlScreenButtonPos, controlScreenTexture); 

	}

	@Override
	public void render() 
	{
		sb.begin();
		
		newGameButton.render(sb);
		controlScreenButton.render(sb);
		
		em.render(sb);
		
		sb.end();
	}

	@Override
	public void update() 
	{
		if(this.newGameButton.isTouched())
		{
			this.gsm.setState(new Play(this.gsm));
		}
	}

}
