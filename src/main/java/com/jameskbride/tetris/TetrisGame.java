package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.TetrisPiece;

public class TetrisGame {

    public static final int INITIAL_ROW_INDEX = 0;
    public static final int INITIAL_COLUMN_INDEX = 5;

    private static final Coords INITIAL_COORDS;

    static {
        INITIAL_COORDS = new Coords(INITIAL_ROW_INDEX, INITIAL_COLUMN_INDEX);
    }

    private final Board board;
    private final TetrisPiece activePiece;
    private final Coords pieceCoordinates;

    public TetrisGame(Board board, TetrisPiece activePiece, Coords pieceCoordinates) {
        this.board = board;
        this.activePiece = activePiece;
        this.pieceCoordinates = pieceCoordinates;
    }

    public TetrisGame() {
        this.board = new Board();
        this.pieceCoordinates = INITIAL_COORDS;
        this.activePiece = new EmptyPiece();
    }

    public TetrisGame startGame(TetrisPiece initialPiece) {
        Board board = new Board();
        TetrisPiece activePiece = initialPiece;
        Coords pieceCoordinates = INITIAL_COORDS;
        board.setPiece(initialPiece, INITIAL_COORDS);

        return new TetrisGame(board, activePiece, pieceCoordinates);
    }

    public Board getBoard() {
        return board;
    }

    public TetrisGame tick() {
        Coords previousCoords = pieceCoordinates;
        Coords newCoords = new Coords(previousCoords.getRowIndex() + 1, previousCoords.getColumnIndex());
        board.setPiece(activePiece, newCoords);
        board.clearSectionAbovePiece(activePiece, previousCoords);

        return new TetrisGame(board, activePiece, newCoords);
    }

    //Placeholder for TetrisGame constructor only.  Never to be used in the game.
    public static class EmptyPiece implements TetrisPiece {

        public String[][] getShape() {
            String[][] shape = {
                    {EMPTY_SPACE}
            };

            return shape;
        }
    }
}
