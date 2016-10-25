package com.udacity.gamedev.sierpinskitriangle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * TODO: Start here
 *
 * Your challenge, should you choose to accept it, is to draw a Serpinski Triangle. I offer no hints
 * beyond the fact that ShapeRenderer has a very convenient triangle() function, and that using a
 * FitViewport can simplify matters considerably. Good luck!
 */


public class SierpinskiTriangle extends ApplicationAdapter {

    static final float SIZE = 10;
    private static final int RECURSIONS = 7;
    private ShapeRenderer renderer;
    FitViewport viewport;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        viewport = new FitViewport(SIZE+2, SIZE+2);
        }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float width = Gdx.graphics.getWidth() * 1.0f;
        float heigth = Gdx.graphics.getHeight() * 1.0f;

        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeType.Filled);
//        renderer.setColor(Color.RED);
//        renderer.triangle(1,1, 5, 5, 9,1);
        renderer.setColor(Color.BLUE);
        //renderer.triangle(5.0f-1.5f, 5.0f-1.3f, 5.0f+1.5f, 5.0f-1.3f, 5.0f, 5.0f+1.3f);
        Vector2 a = new Vector2(0, 0);
        Vector2 b = new Vector2(SIZE, 0);
        Vector2 c = new Vector2(SIZE/2, SIZE  * MathUtils.sin(MathUtils.PI/3f));
        renderer.triangle(a.x, a.y, b.x, b.y, c.x, c.y);
        renderer.setColor(Color.BLACK);

        //renderer.circle(5,5,4, 40);
        renderer.end();

    }

    private void drawSierpinskiTriangle(Vector2 v1, Vector2 v2, Vector2 v3, int recursionStep) {

        if (recursionStep == 0) {

            return;

        } else {






        }

    }




}
