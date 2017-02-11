package com.jameskbride.tetris.pieces;

import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.tetris.pieces.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertArrayEquals;

public class SquarePieceTest {

    private SquarePiece squarePiece;

    @Before
    public void setUp() {
        squarePiece = new SquarePiece();
    }

    @Test
    public void getShapeShouldReturnASquare() {
        String[][] expectedShape = {
                {FILLED_SPACE, FILLED_SPACE},
                {FILLED_SPACE, FILLED_SPACE}
        };

        assertArrayEquals(expectedShape, squarePiece.getShape());
    }
}