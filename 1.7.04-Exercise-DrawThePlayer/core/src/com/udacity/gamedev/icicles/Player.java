package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player {

    public static final String TAG = Player.class.getName();

    // TODO: Add a position (add constants to Constants.java first)
    Vector2 playerPosition;

    // TODO: Add a viewport
    Viewport viewport;

    // TODO: Add constructor that accepts and sets the viewport, then calls init()
    public Player(Viewport viewport) {
        this.viewport = viewport;
        init();

    }


        // TODO: Add init() function that moves the character to the bottom center of the screen
    public void init() {
        playerPosition = new Vector2(viewport.getWorldWidth() / 2, Constants.PLAYER_HEAD_HEIGHT);
    }

    // TODO: Create a render function that accepts a ShapeRenderer and does the actual drawing
    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.PLAYER_COLOR);
        renderer.set(ShapeType.Filled);

        // head
        renderer.circle(
                playerPosition.x, playerPosition.y,
                Constants.PLAYER_HEAD_RADIUS, Constants.PLAYER_HEAD_SEGMENTS);

        Vector2 playerBodyTop = new Vector2(playerPosition.x, playerPosition.y - Constants.PLAYER_HEAD_RADIUS);
        Vector2 playerBodyBottom = new Vector2(playerPosition.x, playerPosition.y - 3.5f * Constants.PLAYER_HEAD_RADIUS);

        // torso
        renderer.rectLine(playerBodyTop, playerBodyBottom, Constants.PLAYER_LIMB_WIDTH);
        // hands
        renderer.rectLine(
                playerBodyTop.x, playerBodyTop.y - 0.1f,
                playerBodyTop.x + 0.6f, playerBodyTop.y - 0.9f,
                Constants.PLAYER_LIMB_WIDTH);

        renderer.rectLine(
                playerBodyTop.x, playerBodyTop.y - 0.1f,
                playerBodyTop.x - 0.6f, playerBodyTop.y - 0.9f,
                Constants.PLAYER_LIMB_WIDTH);


        // legs
        renderer.rectLine(playerBodyBottom.x, playerBodyBottom.y,
                playerBodyBottom.x + 1.0f, playerBodyBottom.y - 3.0f,
                Constants.PLAYER_LIMB_WIDTH);

        renderer.rectLine(playerBodyTop.x, playerBodyBottom.y,
                playerBodyBottom.x - 1.0f, playerBodyBottom.y - 3.0f,
                Constants.PLAYER_LIMB_WIDTH);
    }
}
