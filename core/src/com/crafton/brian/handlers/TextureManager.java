package com.crafton.brian.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * The texture manager allows other methods to reference the skins for the objects
 */
public class TextureManager
{
	public static Texture RED = new Texture(Gdx.files.internal("red.png"));	
	public static Texture GREEN = new Texture(Gdx.files.internal("green.png"));
	public static Texture BLUE = new Texture(Gdx.files.internal("blue.png"));

	//menus
	public static Texture CONTROLS = new Texture(Gdx.files.internal("Controls.png"));
	//buttons
	public static Texture NEWGAME = new Texture(Gdx.files.internal("NewGame.png"));
	public static Texture BACK = new Texture(Gdx.files.internal("Back.png"));
	public static Texture CONTROLBUTTON = new Texture(Gdx.files.internal("ControlsButton.png"));

}