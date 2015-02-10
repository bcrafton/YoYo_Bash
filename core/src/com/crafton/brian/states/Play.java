package com.crafton.brian.states;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.crafton.brian.handlers.EntityManager;
import com.crafton.brian.handlers.GameStateManager;

public class Play extends State
{
	private EntityManager entityManager; 
	GameStateManager gsm;
	BitmapFont font;

    /**
     * The game state of playing
     * @param gsm the game state manager so can change the state of the game
     */
	public Play(GameStateManager gsm)
	{
		super(gsm);
		this.gsm = gsm;
		this.entityManager = new EntityManager(this.gsm, 10);
		font = new BitmapFont();
		
	}

	@Override
	public void render() 
	{
		sb.begin();
		this.entityManager.render(this.sb);
		this.printKillCount();
		
		
		sb.end();
	}

	@Override
	public void update() 
	{
		this.entityManager.update(); 
	}

    /**
     * prints the kill count in the top right
     */
	private void printKillCount()
	{
		String message = new String("Kill Count: " + String.valueOf(this.entityManager.getKillCount())); 
		float height = font.getBounds(message).height;
		float width = font.getBounds(message).width;
		font.setScale(4);
		font.draw(sb, message, this.V_WIDTH-width, this.V_HEIGHT-height); 
	}
}
