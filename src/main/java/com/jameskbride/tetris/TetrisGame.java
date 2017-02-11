package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.TetrisPiece;

public class TetrisGame {

    private static final Coords INITIAL_COORDS;
    private static final int INITIAL_ROW_INDEX = 0;
    private static final int INITIAL_COLUMN_INDEX = 5;

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
        board.setPiece(activePiece, new Coords(pieceCoordinates.getRowIndex() + 1, pieceCoordinates.getColumnIndex()));

        return new TetrisGame(board, activePiece, pieceCoordinates);
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
