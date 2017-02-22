package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.PieceFactory;
import com.jameskbride.tetris.pieces.TetrisPiece;

public abstract class TetrisGame implements ITetrisGame {

    public static final int INITIAL_ROW_INDEX = 0;
    public static final int INITIAL_COLUMN_INDEX = 5;

    protected static final Coords INITIAL_COORDS;
    static {
        INITIAL_COORDS = new Coords(INITIAL_ROW_INDEX, INITIAL_COLUMN_INDEX);
    }

    protected final Board board;
    protected final TetrisPiece activePiece;
    protected final Coords pieceCoordinates;
    protected final PieceFactory pieceFactory;

    protected TetrisGame(Board board, TetrisPiece activePiece, Coords pieceCoordinates, PieceFactory pieceFactory) {
        this.board = board;
        this.activePiece = activePiece;
        this.pieceCoordinates = pieceCoordinates;
        this.pieceFactory = pieceFactory;
    }

    public static ITetrisGame startGame(PieceFactory pieceFactory) {
        Board board = new Board();
        TetrisPiece activePiece = pieceFactory.newPiece();
        Coords pieceCoordinates = INITIAL_COORDS;
        board.setPiece(activePiece, pieceCoordinates);

        return new ActivePieceTetrisGame(board, activePiece, pieceCoordinates, pieceFactory);
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public abstract ITetrisGame tick();

    protected boolean movePiece(Coords newCoords) {
        return board.setPiece(activePiece, newCoords);
    }

    protected ITetrisGame getNextGameState(Coords newCoords, boolean pieceStopped) {
        if (pieceStopped) {
            return new NewPieceTetrisGame(board, pieceFactory.newPiece(), INITIAL_COORDS, pieceFactory);
        } else {
            return new ActivePieceTetrisGame(board, activePiece, newCoords, pieceFactory);
        }
    }
}
