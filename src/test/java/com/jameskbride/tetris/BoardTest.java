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

    @Test
    public void itShouldBeEmptyWhenCreated() {
        for (int rowIndex=0; rowIndex<board.getHeight(); rowIndex++) {
            for (int columnIndex=0; columnIndex<board.getWidth(); columnIndex++) {
                assertEquals(" ", board.getLocation(rowIndex, columnIndex));
            }
        }
    }

    @Test
    public void whenAPieceIsSetThenItIsPlacedAtTheGivenLocation() {
        String[][] squarePiece = {
                {"#", "#"},
                {"#", "#"}
        };

        board.setPiece(squarePiece, 0, 0);

        assertEquals("#", board.getLocation(0, 0));
        assertEquals("#", board.getLocation(0, 1));
        assertEquals("#", board.getLocation(1, 0));
        assertEquals("#", board.getLocation(1, 1));
    }
}
