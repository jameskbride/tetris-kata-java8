package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.TetrisPiece;

public class TetrisGame {

    private final Board board;

    public TetrisGame(Board board) {
        this.board = board;
    }

    public TetrisGame() {
        this.board = new Board();
    }

    public TetrisGame startGame(TetrisPiece initialPiece) {
        Board board = new Board();
        board.setPiece(initialPiece, 0, 5);

        TetrisGame tetrisGame = new TetrisGame(board);

        return tetrisGame;
    }

    public Board getBoard() {
        return board;
    }
}
