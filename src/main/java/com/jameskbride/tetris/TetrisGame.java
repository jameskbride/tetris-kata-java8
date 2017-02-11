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

    public TetrisGame(Board board) {
        this.board = board;
    }

    public TetrisGame() {
        this.board = new Board();
    }

    public TetrisGame startGame(TetrisPiece initialPiece) {
        Board board = new Board();
        board.setPiece(initialPiece, INITIAL_COORDS);

        return new TetrisGame(board);
    }

    public Board getBoard() {
        return board;
    }

    public TetrisGame tick() {
        board.movePiece();

        return new TetrisGame(board);
    }

}
