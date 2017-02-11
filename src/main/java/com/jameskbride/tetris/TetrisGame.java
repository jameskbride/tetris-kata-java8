package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.TetrisPiece;

public class TetrisGame {
    public Board startGame(TetrisPiece initialPiece) {
        Board board = new Board();
        board.setPiece(initialPiece, 0, 5);
        return board;
    }
}
