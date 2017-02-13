package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.LeftLPiece;
import com.jameskbride.tetris.pieces.SquarePiece;
import com.jameskbride.tetris.pieces.TetrisPiece;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.jameskbride.tetris.pieces.TetrisPiece.EMPTY_SPACE;
import static com.jameskbride.tetris.pieces.TetrisPiece.FILLED_SPACE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
                assertEquals(EMPTY_SPACE, board.getLocation(rowIndex, columnIndex));
            }
        }
    }

    @Test
    public void whenASquarePieceIsSetThenItIsPlacedAtTheGivenLocation() {
        SquarePiece squarePiece = new SquarePiece();

        board.setPiece(squarePiece, new Coords(0, 0));

        assertEquals(FILLED_SPACE, board.getLocation(0, 0));
        assertEquals(FILLED_SPACE, board.getLocation(0, 1));
        assertEquals(FILLED_SPACE, board.getLocation(1, 0));
        assertEquals(FILLED_SPACE, board.getLocation(1, 1));
    }

    @Test
    public void whenALeftLPieceIsSetThenItIsPlacedAtTheGivenLocation() {
        LeftLPiece leftLPiece = new LeftLPiece();

        board.setPiece(leftLPiece, new Coords(0, 0));

        String[][] leftLShape = {
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, FILLED_SPACE}
        };

        assertEquals(leftLShape[0][0], board.getLocation(0, 0));
        assertEquals(leftLShape[0][1], board.getLocation(0, 1));
        assertEquals(leftLShape[1][0], board.getLocation(1, 0));
        assertEquals(leftLShape[1][1], board.getLocation(1, 1));
        assertEquals(leftLShape[2][0], board.getLocation(2, 0));
        assertEquals(leftLShape[2][1], board.getLocation(2, 1));
    }

    @Test
    public void givenPieceCoordinatesThenItShouldClearTheSectionOfRowMatchingTheWidthOfThePiece() {
        LeftLPiece leftLPiece = new LeftLPiece();
        Coords firstCoords = new Coords(0, 0);
        board.setPiece(leftLPiece, firstCoords);
        board.setPiece(leftLPiece, new Coords(1, 0));

        board.clearSectionAbovePiece(leftLPiece, firstCoords);

        assertEquals(EMPTY_SPACE, board.getLocation(0, 0));
        assertEquals(EMPTY_SPACE, board.getLocation(0, 1));
    }

    @Test
    public void whenThePieceHasAlreadyHitTheBottomOfTheBoardThenTheRemainsAtThePreviousLocation() {
        LeftLPiece leftLPiece = new LeftLPiece();
        Coords startingCoords = new Coords(0, 0);
        Coords coords = movePieceToTheBottomOfTheBoard(leftLPiece, startingCoords);

        assertEquals(FILLED_SPACE, board.getLocation(21, 0));
        assertEquals(FILLED_SPACE, board.getLocation(22, 0));
        assertEquals(FILLED_SPACE, board.getLocation(23, 0));
        assertEquals(FILLED_SPACE, board.getLocation(23, 1));

        assertTrue(board.setPiece(leftLPiece, new Coords(coords.getRowIndex() + 1, 0)));

        assertEquals(FILLED_SPACE, board.getLocation(21, 0));
        assertEquals(FILLED_SPACE, board.getLocation(22, 0));
        assertEquals(FILLED_SPACE, board.getLocation(23, 0));
        assertEquals(FILLED_SPACE, board.getLocation(23, 1));
    }

    private Coords movePieceToTheBottomOfTheBoard(TetrisPiece leftLPiece, Coords coords) {
        int numTicks = board.getHeight() - leftLPiece.getShape().length;
        for (int i=0; i<numTicks; i++) {
            coords = new Coords(coords.getRowIndex() + i, 0);
            board.setPiece(leftLPiece, coords);
        }
        return coords;
    }
}
