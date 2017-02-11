package com.jameskbride.tetris;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TetrisGameTest {

    @Test
    public void whenTheGameIsStartedThenAPieceIsPlacedAtTheTopCenterOfTheBoard() {
        TetrisGame tetrisGame = new TetrisGame();

        String[][] squarePiece = {
            {"#", "#"},
            {"#", "#"}
        };
        Board board = tetrisGame.startGame(squarePiece);

        assertEquals("#", board.getLocation(0, 5));
        assertEquals("#", board.getLocation(0, 6));
        assertEquals("#", board.getLocation(1, 5));
        assertEquals("#", board.getLocation(1, 6));
    }
}
