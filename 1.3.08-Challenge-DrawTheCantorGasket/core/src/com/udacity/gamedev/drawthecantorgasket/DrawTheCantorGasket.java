package com.udacity.gamedev.drawthecantorgasket;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/*

TODO: Start here

The Cantor gasket is a fractal where we start with a white square. We divide that square up into a 3x3 grid of smaller squares, then remove the middle square. Finally, we repeat the process on each of the remaining 8 squares.

 */

public class DrawTheCantorGasket extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;
    // TODO: Set a constant for how many recursions to draw. 5 is a good place to start
    private static final int RECURSION_DEPTH = 5;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Finds a good place to draw our fractal
        // Rectangle has members x,y for the lower left corner, and width and height
        Rectangle bounds = findLargestSquare();

        // TODO: Begin a filled shapeRenderer batch
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // TODO: Draw a white square matching the bounds
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());

        // TODO: Set the working color to black, and call punchCantorGasket with the bounds
        shapeRenderer.setColor(Color.BLACK);
        punchCantorGasket(bounds.getX(), bounds.getY(), bounds.getHeight(), RECURSION_DEPTH);

        // TODO: End the batch
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        shapeRenderer = new ShapeRenderer();
    }


    private void punchCantorGasket(float x, float y, float size, int recursions){
        // Note that size means the height and width of the square
        // TODO: Base case, if recursions = 0, return
        if (recursions == 0) {
            return;
        }
        float newSize = size / 3;
        float newSize2 = newSize * 2;
        // TODO: Draw a black square in the middle square
        shapeRenderer.rect(x + newSize, y + newSize, newSize, newSize);

        // TODO: Call punchCantorGasket on all 8 other squares
                                                                                      // x y
        punchCantorGasket(x, y, newSize , recursions - 1);                            // 1,1
        punchCantorGasket(x + newSize, y, newSize , recursions - 1);                  // 2,1
        punchCantorGasket(x + newSize2, y, newSize , recursions - 1);                 // 3,1
        punchCantorGasket(x, y + newSize, newSize , recursions - 1);                  // 1,2
        punchCantorGasket(x + newSize2, y + newSize, newSize , recursions - 1);       // 3,2
        punchCantorGasket(x, y + newSize2, newSize , recursions - 1);                 // 1,3
        punchCantorGasket(x + newSize, y + newSize2, newSize , recursions - 1);       // 2,3
        punchCantorGasket(x + newSize2, y + newSize2, newSize , recursions - 1);      // 3,3






    }

    private Rectangle findLargestSquare(){
        Rectangle largestSquare = new Rectangle();
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        if (screenWidth > screenHeight){
            largestSquare.x = (screenWidth - screenHeight)/2;
            largestSquare.y = 0;
            largestSquare.width = screenHeight;
            largestSquare.height = screenHeight;
        } else {
            largestSquare.x = 0;
            largestSquare.y = (screenHeight - screenWidth)/2;
            largestSquare.width = screenWidth;
            largestSquare.height = screenWidth;
        }
        return largestSquare;
    }
}
