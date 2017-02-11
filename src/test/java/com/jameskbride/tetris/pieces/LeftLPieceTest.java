package com.jameskbride.tetris.pieces;

import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.tetris.pieces.TetrisPiece.EMPTY_SPACE;
import static com.jameskbride.tetris.pieces.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertArrayEquals;

public class LeftLPieceTest {
    
    private LeftLPiece leftLPiece;
    
    @Before
    public void setUp() {
        leftLPiece = new LeftLPiece();
    }
    
    @Test
    public void getShapeShouldReturnInitialShape() {
        String[][] expectedShape = {
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, FILLED_SPACE}
        };

        assertArrayEquals(expectedShape, leftLPiece.getShape());
    }
}
