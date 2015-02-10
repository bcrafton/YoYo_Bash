package com.crafton.brian.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.crafton.brian.handlers.GameStateManager;
import com.crafton.brian.handlers.TextureManager;

public class ControlsDemo extends State
{
	Texture controlTexture; 
	Texture backButtonTexture;
	Button backButton; 
	
	Vector2 backButtonPos;

    /**
     * Constructor for the ControlsDemo object
     * @param gsm
     */
	public ControlsDemo(GameStateManager gsm)
	{
		super(gsm);
		
		this.controlTexture = TextureManager.CONTROLS; 
		this.backButtonTexture = TextureManager.BACK;
		
		backButtonPos = new Vector2(0, 0); 
	
		this.backButton = new Button(backButtonPos, backButtonTexture); 
	}

	@Override
	public void render() 
	{
		sb.begin();
		sb.draw(this.controlTexture, 0, 0);
		
		backButton.render(sb);
		
		sb.end();
	}

	@Override
	public void update() 
	{
		if(this.backButton.isTouched())
		{
			this.gsm.setState(new Menu(this.gsm));
		}
	}

}
