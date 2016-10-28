package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Icicles {

    public static final String TAG = Icicles.class.getName();

    // TODO: Add an array of icicles and a viewport
    Array<Icicle> icicles;

    Viewport viewport;

    public Icicles(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        // TODO: Initialize the array of icicles
        icicles = new Array<Icicle>(false, 50);
    }

    public void update(float delta) {
        // TODO: Replace hard-coded spawn rate with a constant
        if (MathUtils.random() < delta * Constants.ICICLE_SPAWN_RATE) {
            // TODO: Add a new icicle at the top of the viewport at a random x position
            Vector2 randomIciclePos = new Vector2(
                    viewport.getWorldWidth() * MathUtils.random(), viewport.getWorldHeight());
            Icicle randomIcicle = new Icicle(randomIciclePos);
            icicles.add(randomIcicle);
        }
        // TODO: Update each icicle
        for (Icicle icicle : icicles) {
            icicle.update(delta);
        }

    }

    public void render(ShapeRenderer renderer) {
        // TODO: Set ShapeRenderer Color
        renderer.setColor(Constants.ICICLE_COLOR);

        // TODO: Render each icicle
        for (Icicle icicle : icicles) {
            icicle.render(renderer);
        }
    }
}
