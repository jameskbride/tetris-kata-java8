package com.jameskbride.tetris.pieces;

import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.tetris.pieces.TetrisPiece.EMPTY_SPACE;
import static com.jameskbride.tetris.pieces.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertArrayEquals;

public class RightSPieceTest {

    private RightSPiece rightSPiece;

    @Before
    public void setUp() {
        rightSPiece = new RightSPiece();
    }

    @Test
    public void getShapeShouldReturnInitialShape() {
        String[][] expectedShape = {
                {EMPTY_SPACE, FILLED_SPACE},
                {FILLED_SPACE, FILLED_SPACE},
                {FILLED_SPACE, EMPTY_SPACE}
        };

        assertArrayEquals(expectedShape, rightSPiece.getShape());
    }
}
