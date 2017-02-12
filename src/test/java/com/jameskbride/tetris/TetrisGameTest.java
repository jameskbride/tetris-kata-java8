package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.LeftLPiece;
import com.jameskbride.tetris.pieces.SquarePiece;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.jameskbride.tetris.pieces.TetrisPiece.EMPTY_SPACE;
import static com.jameskbride.tetris.pieces.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void whenATickOccursThenTheActivePieceDescendsOneRow() {
        LeftLPiece leftLPiece = new LeftLPiece();

        TetrisGame startGame = tetrisGame.startGame(leftLPiece);
        TetrisGame gameAfterOneTick = startGame.tick();

        assertEquals(FILLED_SPACE, gameAfterOneTick.getBoard().getLocation(1, 5));
        assertEquals(FILLED_SPACE, gameAfterOneTick.getBoard().getLocation(2, 5));
        assertEquals(FILLED_SPACE, gameAfterOneTick.getBoard().getLocation(3, 5));
        assertEquals(FILLED_SPACE, gameAfterOneTick.getBoard().getLocation(3, 6));
    }

    @Test
    public void whenATickOccursThenTheSectionOfRowAboveTheActivePieceIsCleared() {
        LeftLPiece leftLPiece = new LeftLPiece();

        TetrisGame startGame = tetrisGame.startGame(leftLPiece);
        TetrisGame gameAfterOneTick = startGame.tick();
        Board board = gameAfterOneTick.getBoard();

        assertEquals(EMPTY_SPACE, board.getLocation(TetrisGame.INITIAL_ROW_INDEX, TetrisGame.INITIAL_COLUMN_INDEX));
        assertEquals(EMPTY_SPACE, board.getLocation(TetrisGame.INITIAL_ROW_INDEX, TetrisGame.INITIAL_COLUMN_INDEX + 1));
    }
}
