package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.PieceFactory;
import com.jameskbride.tetris.pieces.TetrisPiece;

public class TetrisGame {

    public static final int INITIAL_ROW_INDEX = 0;
    public static final int INITIAL_COLUMN_INDEX = 5;

    private static final Coords INITIAL_COORDS;

    static {
        INITIAL_COORDS = new Coords(INITIAL_ROW_INDEX, INITIAL_COLUMN_INDEX);
    }

    private final Board board;
    private final TetrisPiece activePiece;
    private final Coords pieceCoordinates;
    private final PieceFactory pieceFactory;
    private final boolean newPiece;

    public TetrisGame(Board board, TetrisPiece activePiece, Coords pieceCoordinates, PieceFactory pieceFactory, boolean newPiece) {
        this.board = board;
        this.activePiece = activePiece;
        this.pieceCoordinates = pieceCoordinates;
        this.pieceFactory = pieceFactory;
        this.newPiece = newPiece;
    }

    public TetrisGame() {
        this.board = new Board();
        this.pieceCoordinates = INITIAL_COORDS;
        this.activePiece = new EmptyPiece();
        this.pieceFactory = new PieceFactory();
        this.newPiece = true;
    }

    public TetrisGame startGame(PieceFactory pieceFactory) {
        Board board = new Board();
        TetrisPiece activePiece = pieceFactory.newPiece();
        Coords pieceCoordinates = INITIAL_COORDS;
        board.setPiece(activePiece, pieceCoordinates);

        return new TetrisGame(board, activePiece, pieceCoordinates, pieceFactory, false);
    }

    public Board getBoard() {
        return board;
    }

    public TetrisGame tick() {
        Coords newCoords = newPiece ? pieceCoordinates : calculateNewCoordinates(pieceCoordinates);
        boolean pieceStopped = movePiece(newCoords);
        if (!pieceStopped && !newPiece) {
            board.clearSectionAbovePiece(activePiece, pieceCoordinates);
        }

        if (pieceStopped) {
           return new TetrisGame(board, pieceFactory.newPiece(), INITIAL_COORDS, pieceFactory, true);
        } else {
            return new TetrisGame(board, activePiece, newCoords, pieceFactory, false);
        }
    }

    private boolean movePiece(Coords newCoords) {
        return board.setPiece(activePiece, newCoords);
    }

    private Coords calculateNewCoordinates(Coords previousCoords) {
        return new Coords(previousCoords.getRowIndex() + 1, previousCoords.getColumnIndex());
    }

    //Placeholder for TetrisGame constructor only.  Never to be used in the game.
    public static class EmptyPiece implements TetrisPiece {

        public String[][] getShape() {
            String[][] shape = {
                    {EMPTY_SPACE}
            };

            return shape;
        }
    }
}
