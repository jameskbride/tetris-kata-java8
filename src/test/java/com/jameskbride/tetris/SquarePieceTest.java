package com.jameskbride.tetris;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquarePieceTest {

    private SquarePiece squarePiece;

    @Before
    public void setUp() {
        squarePiece = new SquarePiece();
    }

    @Test
    public void getShapeShouldReturnASquare() {
        String[][] expectedShape = {
                {"#", "#"},
                {"#", "#"}
        };

        assertArrayEquals(expectedShape, squarePiece.getShape());
    }
}