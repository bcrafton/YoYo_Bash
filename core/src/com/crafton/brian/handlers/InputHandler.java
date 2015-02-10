package com.crafton.brian.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class InputHandler
{
    public int width;
    public int height;
    Vector2 center;

    /**
     * Constructor for the input handler object
     */
    public InputHandler()
    {
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.center = new Vector2(this.width/2, this.height/2);
    }

    /**
     * returns the input it has taken
     * @return
     */
    public Vector2 getInput()
    {
        Vector2 touch;
        touch = new Vector2(Gdx.input.getX(), this.height - Gdx.input.getY()); // inverts vertical input
        return touch;
    }

    /**
     * if the screen has been touched or not
     * @return whether the screen has been touched or not.
     */
    public boolean isTouched()
    {
        return Gdx.input.isTouched();
    }
}
