package com.jameskbride.tetris;

import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.tetris.TetrisPiece.EMPTY_SPACE;
import static com.jameskbride.tetris.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertArrayEquals;

public class TPieceTest {

    private TPiece tPiece;

    @Before
    public void setUp() {
        tPiece = new TPiece();
    }

    @Test
    public void getShapeShouldReturnInitialShape() {
        String[][] expectedShape = {
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, FILLED_SPACE},
                {FILLED_SPACE, EMPTY_SPACE}
        };

        assertArrayEquals(expectedShape, tPiece.getShape());
    }
}
