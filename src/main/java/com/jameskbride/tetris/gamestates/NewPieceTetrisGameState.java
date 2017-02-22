package com.jameskbride.tetris.gamestates;

import com.jameskbride.tetris.Board;
import com.jameskbride.tetris.Coords;
import com.jameskbride.tetris.pieces.PieceFactory;
import com.jameskbride.tetris.pieces.TetrisPiece;


public class NewPieceTetrisGameState extends AbstractTetrisGameState {

    public NewPieceTetrisGameState(Board board, TetrisPiece tetrisPiece, Coords initialCoords, PieceFactory pieceFactory) {
        super(board, tetrisPiece, initialCoords, pieceFactory);
    }

    @Override
    public TetrisGameState tick() {
        return getNextGameState(pieceCoordinates, movePiece(pieceCoordinates));
    }
}
