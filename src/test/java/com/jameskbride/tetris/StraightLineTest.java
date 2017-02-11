package com.jameskbride.tetris;

import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.tetris.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertArrayEquals;

public class StraightLineTest {

    private StraightLinePiece straightLinePiece;

    @Before
    public void setUp() {
        straightLinePiece = new StraightLinePiece();
    }

    @Test
    public void getShapeShouldReturnInitialShape() {
        String[][] expectedShape = {
                {FILLED_SPACE},
                {FILLED_SPACE},
                {FILLED_SPACE},
                {FILLED_SPACE}
        };

        assertArrayEquals(expectedShape, straightLinePiece.getShape());
    }
}
