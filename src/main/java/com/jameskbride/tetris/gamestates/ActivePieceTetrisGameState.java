package com.jameskbride.tetris.gamestates;

import com.jameskbride.tetris.Board;
import com.jameskbride.tetris.Coords;
import com.jameskbride.tetris.pieces.PieceFactory;
import com.jameskbride.tetris.pieces.TetrisPiece;

public class ActivePieceTetrisGameState extends AbstractTetrisGameState {

    public ActivePieceTetrisGameState(Board board, TetrisPiece activePiece, Coords pieceCoordinates, PieceFactory pieceFactory) {
        super(board, activePiece, pieceCoordinates, pieceFactory);
    }

    @Override
    public TetrisGameState tick() {
        Coords newCoords = calculateNewCoordinates(pieceCoordinates);
        boolean pieceStopped = movePiece(newCoords);
        if (!pieceStopped) {
            board.clearSectionAbovePiece(activePiece, pieceCoordinates);
        }

        return getNextGameState(newCoords, pieceStopped);
    }

    private Coords calculateNewCoordinates(Coords previousCoords) {
        return new Coords(previousCoords.getRowIndex() + 1, previousCoords.getColumnIndex());
    }
}
