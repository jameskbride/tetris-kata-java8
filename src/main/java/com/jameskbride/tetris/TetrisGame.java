package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.TetrisPiece;

public class TetrisGame {

    private static final Coords INITIAL_COORDS;

    static {
        INITIAL_COORDS = new Coords(0, 5);
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
