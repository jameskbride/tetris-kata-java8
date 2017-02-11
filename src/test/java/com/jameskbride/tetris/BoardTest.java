package com.jameskbride.tetris;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void itShouldHave24Rows() {
        assertEquals(24, board.getHeight());
    }

    @Test
    public void itShouldHave10Columns() {
        assertEquals(10, board.getWidth());
    }
}
