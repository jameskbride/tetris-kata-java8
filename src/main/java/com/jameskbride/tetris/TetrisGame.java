package com.jameskbride.tetris;

import com.jameskbride.tetris.gamestates.AbstractTetrisGameState;
import com.jameskbride.tetris.gamestates.ActivePieceTetrisGameState;
import com.jameskbride.tetris.gamestates.TetrisGameState;
import com.jameskbride.tetris.pieces.PieceFactory;
import com.jameskbride.tetris.pieces.TetrisPiece;

public class TetrisGame {

    public static TetrisGameState startGame(PieceFactory pieceFactory) {
        Board board = new Board();
        TetrisPiece activePiece = pieceFactory.newPiece();
        Coords pieceCoordinates = AbstractTetrisGameState.INITIAL_COORDS;
        board.setPiece(activePiece, pieceCoordinates);

        return new ActivePieceTetrisGameState(board, activePiece, pieceCoordinates, pieceFactory);
    }
}
