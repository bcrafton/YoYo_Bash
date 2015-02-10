
package com.crafton.brian;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.crafton.brian.handlers.BoundedCamera;
import com.crafton.brian.handlers.GameStateManager;

public class MainActivity extends Game {
    boolean firstTimeCreate = true;
    public int V_WIDTH;
    public int V_HEIGHT;
    Vector2 center;

    BoundedCamera cam;
    OrthographicCamera hudCam;
    SpriteBatch sb;
    GameStateManager gsm;

    public MainActivity() {
    }

    @Override
    public void create ()
    {
        this.V_WIDTH = Gdx.graphics.getWidth();
        this.V_HEIGHT = Gdx.graphics.getHeight();
        this.center = new Vector2(this.V_WIDTH/2, this.V_HEIGHT/2);

        cam = new BoundedCamera();
        cam.setToOrtho(true, V_WIDTH, V_HEIGHT);
        hudCam = new OrthographicCamera();
        hudCam.setToOrtho(true, V_WIDTH, V_HEIGHT);
        sb = new SpriteBatch();
        gsm = new GameStateManager(this);
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.gsm.update();
        this.gsm.render();
    }

    @Override
    public void dispose () {
        super.dispose();

    }


    public SpriteBatch getSpriteBatch() { return sb; }
    public BoundedCamera getCamera() { return cam; }
    public OrthographicCamera getHUDCamera() { return hudCam; }
}
