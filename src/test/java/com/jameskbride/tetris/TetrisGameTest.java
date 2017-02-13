package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.jameskbride.tetris.pieces.TetrisPiece.EMPTY_SPACE;
import static com.jameskbride.tetris.pieces.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TetrisGameTest {

    private TetrisGame tetrisGame;

    @Mock
    PieceFactory pieceFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tetrisGame = new TetrisGame();
    }

    @Test
    public void whenTheGameIsStartedThenAPieceIsPlacedAtTheTopCenterOfTheBoard() {
        SquarePiece squarePiece = new SquarePiece();
        when(pieceFactory.newPiece()).thenReturn(squarePiece);

        TetrisGame startGame = tetrisGame.startGame(pieceFactory);

        assertEquals(FILLED_SPACE, startGame.getBoard().getLocation(0, 5));
        assertEquals(FILLED_SPACE, startGame.getBoard().getLocation(0, 6));
        assertEquals(FILLED_SPACE, startGame.getBoard().getLocation(1, 5));
        assertEquals(FILLED_SPACE, startGame.getBoard().getLocation(1, 6));
    }

    @Test
    public void whenATickOccursThenTheActivePieceDescendsOneRow() {
        LeftLPiece leftLPiece = new LeftLPiece();
        when(pieceFactory.newPiece()).thenReturn(leftLPiece);

        TetrisGame startGame = tetrisGame.startGame(pieceFactory);
        TetrisGame gameAfterOneTick = startGame.tick();

        assertEquals(FILLED_SPACE, gameAfterOneTick.getBoard().getLocation(1, 5));
        assertEquals(FILLED_SPACE, gameAfterOneTick.getBoard().getLocation(2, 5));
        assertEquals(FILLED_SPACE, gameAfterOneTick.getBoard().getLocation(3, 5));
        assertEquals(FILLED_SPACE, gameAfterOneTick.getBoard().getLocation(3, 6));
    }

    @Test
    public void whenATickOccursThenTheSectionOfRowAboveTheActivePieceIsCleared() {
        LeftLPiece leftLPiece = new LeftLPiece();
        when(pieceFactory.newPiece()).thenReturn(leftLPiece);

        TetrisGame startGame = tetrisGame.startGame(pieceFactory);
        TetrisGame gameAfterOneTick = startGame.tick();
        Board board = gameAfterOneTick.getBoard();

        assertEquals(EMPTY_SPACE, board.getLocation(TetrisGame.INITIAL_ROW_INDEX, TetrisGame.INITIAL_COLUMN_INDEX));
        assertEquals(EMPTY_SPACE, board.getLocation(TetrisGame.INITIAL_ROW_INDEX, TetrisGame.INITIAL_COLUMN_INDEX + 1));
    }

    @Test
    public void givenATickHasOccurredWhenAPieceHitsTheBottomOfTheBoardThenANewPieceIsPlaced() {
        StraightLinePiece straightLinePiece = new StraightLinePiece();
        when(pieceFactory.newPiece()).thenReturn(straightLinePiece);
        tetrisGame = tetrisGame.startGame(pieceFactory);

        movePieceToBottomOfTheBoard(straightLinePiece);

        SquarePiece squarePiece = new SquarePiece();
        when(pieceFactory.newPiece()).thenReturn(squarePiece);

        tetrisGame = tetrisGame.tick().tick();

        assertEquals(FILLED_SPACE, tetrisGame.getBoard().getLocation(0, 5));
        assertEquals(FILLED_SPACE, tetrisGame.getBoard().getLocation(0, 6));
        assertEquals(FILLED_SPACE, tetrisGame.getBoard().getLocation(1, 5));
        assertEquals(FILLED_SPACE, tetrisGame.getBoard().getLocation(1, 6));
    }

    private void movePieceToBottomOfTheBoard(TetrisPiece tetrisPiece) {
        int numTicks = tetrisGame.getBoard().getHeight() - tetrisPiece.getShape().length;
        for (int i=0; i<numTicks; i++) {
            tetrisGame = tetrisGame.tick();
        }
    }
}
