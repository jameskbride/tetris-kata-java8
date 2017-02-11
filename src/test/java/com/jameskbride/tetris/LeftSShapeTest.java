package com.jameskbride.tetris;

import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.tetris.TetrisPiece.EMPTY_SPACE;
import static com.jameskbride.tetris.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertArrayEquals;

public class LeftSShapeTest {

    private LeftSShape leftSShape;

    @Before
    public void setUp() {
        leftSShape = new LeftSShape();
    }

    @Test
    public void getShapeShouldReturnInitialShape() {
        String[][] expectedShape = {
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, FILLED_SPACE},
                {EMPTY_SPACE, FILLED_SPACE}
        };

        assertArrayEquals(expectedShape, leftSShape.getShape());
    }
}
