package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.PieceFactory;
import com.jameskbride.tetris.pieces.TetrisPiece;

public class ActivePieceTetrisGame extends TetrisGame {
    public ActivePieceTetrisGame(Board board, TetrisPiece activePiece, Coords pieceCoordinates, PieceFactory pieceFactory) {
        super(board, activePiece, pieceCoordinates, pieceFactory);
    }

    @Override
    public ITetrisGame tick() {
        Coords newCoords = calculateNewCoordinates(pieceCoordinates);
        boolean pieceStopped = movePiece(newCoords);
        if (!pieceStopped) {
            board.clearSectionAbovePiece(activePiece, pieceCoordinates);
        }

        if (pieceStopped) {
            return new NewPieceTetrisGame(board, pieceFactory.newPiece(), INITIAL_COORDS, pieceFactory);
        } else {
            return new ActivePieceTetrisGame(board, activePiece, newCoords, pieceFactory);
        }
    }

    private Coords calculateNewCoordinates(Coords previousCoords) {
        return new Coords(previousCoords.getRowIndex() + 1, previousCoords.getColumnIndex());
    }
}
