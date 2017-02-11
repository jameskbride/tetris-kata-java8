package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.SquarePiece;
import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.tetris.pieces.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertEquals;

public class TetrisGameTest {

    private TetrisGame tetrisGame;

    @Before
    public void setUp() {
        tetrisGame = new TetrisGame();
    }

    @Test
    public void whenTheGameIsStartedThenAPieceIsPlacedAtTheTopCenterOfTheBoard() {
        SquarePiece squarePiece = new SquarePiece();

        TetrisGame startGame = tetrisGame.startGame(squarePiece);

        assertEquals(FILLED_SPACE, startGame.getBoard().getLocation(0, 5));
        assertEquals(FILLED_SPACE, startGame.getBoard().getLocation(0, 6));
        assertEquals(FILLED_SPACE, startGame.getBoard().getLocation(1, 5));
        assertEquals(FILLED_SPACE, startGame.getBoard().getLocation(1, 6));
    }
}
