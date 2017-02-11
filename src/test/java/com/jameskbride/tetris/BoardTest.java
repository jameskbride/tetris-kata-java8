package com.jameskbride.tetris;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void itShouldHave24Rows() {
        Board board = new Board();

        assertEquals(24, board.getHeight());
    }

    @Test
    public void itShouldHave10Columns() {
        Board board = new Board();

        assertEquals(10, board.getWidth());
    }
}
