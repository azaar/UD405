package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class IciclesScreen implements Screen {

    public static final String TAG = IciclesScreen.class.getName();

    ExtendViewport iciclesViewport;
    ShapeRenderer renderer;

    // TODO: Add ScreenViewport for HUD
    ScreenViewport hudViewport;


    // TODO: Add SpriteBatch
    SpriteBatch hudSpriteBatch;


    // TODO: Add BitmapFont
    BitmapFont hudFont;


    Player player;
    Icicles icicles;

    // TODO: Add int to hold the top score
    int score;


    @Override
    public void show() {
        iciclesViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        // TODO: Initialize the HUD viewport
        hudViewport = new ScreenViewport();

        // TODO: Initialize the SpriteBatch
        hudSpriteBatch = new SpriteBatch();

        // TODO: Initialize the BitmapFont
        hudFont = new BitmapFont();

        // TODO: Give the font a linear TextureFilter
        hudFont.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);


        player = new Player(iciclesViewport);
        icicles = new Icicles(iciclesViewport);

        // TODO: Set top score to zero
        score = 0;

    }

    @Override
    public void resize(int width, int height) {
        iciclesViewport.update(width, height, true);

        // TODO: Update HUD viewport
        hudViewport.update(width, height, true);

        // TODO: Set font scale to min(width, height) / reference screen size
        hudFont.getData().setScale(Math.min(width, height) / Constants.HUD_SCREEN_SIZE);


        player.init();
        icicles.init();
    }

    @Override
    public void dispose() {
        renderer.dispose();
        // TODO: Dispose of the SpriteBatch and font
        hudSpriteBatch.dispose();
        hudFont.dispose();
    }


    @Override
    public void render(float delta) {
        icicles.update(delta);
        player.update(delta);
        if (player.hitByIcicle(icicles)) {
            icicles.init();
        }


        iciclesViewport.apply(true);
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(iciclesViewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);
        icicles.render(renderer);
        player.render(renderer);
        renderer.end();

        // TODO: Set the top score to max(topScore, iciclesDodges)
        score = Math.max(score, icicles.iciclesDodged);

        // TODO: Apply the HUD viewport
        hudViewport.apply();

        // TODO: Set the SpriteBatch's projection matrix
        hudSpriteBatch.setProjectionMatrix(hudViewport.getCamera().combined);

        // TODO: Begin the SpriteBatch
        hudSpriteBatch.begin();

        // TODO: Draw the number of player deaths in the top left
        hudFont.draw(hudSpriteBatch, "Deaths: " + player.deaths,
                Constants.HUD_EDGE_MARGIN, hudViewport.getWorldHeight() - Constants.HUD_EDGE_MARGIN);


        // TODO: Draw the score and top score in the top right
        hudFont.draw(hudSpriteBatch, "Score: " + icicles.iciclesDodged + "\nTop Score: " + score,
                hudViewport.getWorldWidth() - Constants.HUD_EDGE_MARGIN,
                hudViewport.getWorldHeight() - Constants.HUD_EDGE_MARGIN,
                0, Align.right, false);


        // TODO: End the SpriteBatch
        hudSpriteBatch.end();


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
