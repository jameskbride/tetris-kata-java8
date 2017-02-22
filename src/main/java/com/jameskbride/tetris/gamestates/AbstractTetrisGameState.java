package com.jameskbride.tetris.gamestates;

import com.jameskbride.tetris.Board;
import com.jameskbride.tetris.Coords;
import com.jameskbride.tetris.pieces.PieceFactory;
import com.jameskbride.tetris.pieces.TetrisPiece;

public abstract class AbstractTetrisGameState implements TetrisGameState {

    public static final int INITIAL_ROW_INDEX = 0;
    public static final int INITIAL_COLUMN_INDEX = 5;

    public static final Coords INITIAL_COORDS;
    static {
        INITIAL_COORDS = new Coords(INITIAL_ROW_INDEX, INITIAL_COLUMN_INDEX);
    }

    protected final Board board;
    protected final TetrisPiece activePiece;
    protected final Coords pieceCoordinates;
    protected final PieceFactory pieceFactory;

    protected AbstractTetrisGameState(Board board, TetrisPiece activePiece, Coords pieceCoordinates, PieceFactory pieceFactory) {
        this.board = board;
        this.activePiece = activePiece;
        this.pieceCoordinates = pieceCoordinates;
        this.pieceFactory = pieceFactory;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public abstract TetrisGameState tick();

    protected boolean movePiece(Coords newCoords) {
        return board.setPiece(activePiece, newCoords);
    }

    protected TetrisGameState getNextGameState(Coords newCoords, boolean pieceStopped) {
        if (pieceStopped) {
            return new NewPieceTetrisGameState(board, pieceFactory.newPiece(), INITIAL_COORDS, pieceFactory);
        } else {
            return new ActivePieceTetrisGameState(board, activePiece, newCoords, pieceFactory);
        }
    }
}
