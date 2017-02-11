package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.TetrisPiece;

import static com.jameskbride.tetris.pieces.TetrisPiece.EMPTY_SPACE;

public class Board {

    private static final int BOARD_HEIGHT = 24;
    private static final int BOARD_WIDTH = 10;

    private String[][] boardData;
    private TetrisPiece activePiece;
    private Coords pieceCoordinates;

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        boardData = new String[BOARD_HEIGHT][BOARD_WIDTH];
        for (int rowIndex=0; rowIndex<BOARD_HEIGHT; rowIndex++) {
            for (int columnIndex=0; columnIndex<BOARD_WIDTH; columnIndex++) {
                boardData[rowIndex][columnIndex] = EMPTY_SPACE;
            }
        }
    }

    public int getHeight() {
        return boardData.length;
    }

    public int getWidth() {
        return boardData[0].length;
    }

    public String getLocation(int rowIndex, int columnIndex) {
        return boardData[rowIndex][columnIndex];
    }

    public void setPiece(TetrisPiece piece, Coords initialCoords) {
        activePiece = piece;
        pieceCoordinates = initialCoords;
        updateBoardData(piece, initialCoords);
    }

    public void movePiece() {
        pieceCoordinates = new Coords(pieceCoordinates.getRowIndex() +1, pieceCoordinates.getColumnIndex());
        updateBoardData(activePiece, pieceCoordinates);
    }

    private void updateBoardData(TetrisPiece piece, Coords initialCoords) {
        int currentBoardRowIndex = initialCoords.getRowIndex();
        for (int pieceRowIndex=0; pieceRowIndex<piece.getShape().length; pieceRowIndex++) {
            int currentBoardColumnIndex = initialCoords.getColumnIndex();
            for (int pieceColumnIndex=0; pieceColumnIndex<piece.getShape()[0].length; pieceColumnIndex++) {
                boardData[currentBoardRowIndex][currentBoardColumnIndex] = piece.getShape()[pieceRowIndex][pieceColumnIndex];
                currentBoardColumnIndex += 1;
            }
            currentBoardRowIndex += 1;
        }
    }
}
