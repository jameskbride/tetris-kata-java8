package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.SquarePiece;
import org.junit.Test;

import static com.jameskbride.tetris.pieces.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertEquals;

public class TetrisGameTest {

    @Test
    public void whenTheGameIsStartedThenAPieceIsPlacedAtTheTopCenterOfTheBoard() {
        TetrisGame tetrisGame = new TetrisGame();

        SquarePiece squarePiece = new SquarePiece();

        Board board = tetrisGame.startGame(squarePiece);

        assertEquals(FILLED_SPACE, board.getLocation(0, 5));
        assertEquals(FILLED_SPACE, board.getLocation(0, 6));
        assertEquals(FILLED_SPACE, board.getLocation(1, 5));
        assertEquals(FILLED_SPACE, board.getLocation(1, 6));
    }
}
