package com.jameskbride.tetris;

import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.tetris.TetrisPiece.EMPTY_SPACE;
import static com.jameskbride.tetris.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertArrayEquals;

public class RightLPieceTest {

    RightLPiece rightLPiece;

    @Before
    public void setUp() {
        rightLPiece = new RightLPiece();
    }

    @Test
    public void getShapeShouldReturnInitialShape() {
        String[][] expectedShape = {
                {EMPTY_SPACE, FILLED_SPACE},
                {EMPTY_SPACE, FILLED_SPACE},
                {FILLED_SPACE, FILLED_SPACE}
        };

        assertArrayEquals(expectedShape, rightLPiece.getShape());
    }
}
