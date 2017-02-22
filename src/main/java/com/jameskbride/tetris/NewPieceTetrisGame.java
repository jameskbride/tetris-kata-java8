package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.PieceFactory;
import com.jameskbride.tetris.pieces.TetrisPiece;


public class NewPieceTetrisGame extends TetrisGame {

    public NewPieceTetrisGame(Board board, TetrisPiece tetrisPiece, Coords initialCoords, PieceFactory pieceFactory) {
        super(board, tetrisPiece, initialCoords, pieceFactory);
    }

    @Override
    public ITetrisGame tick() {
        return getNextGameState(pieceCoordinates, movePiece(pieceCoordinates));
    }
}