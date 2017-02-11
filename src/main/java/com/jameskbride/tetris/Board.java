package com.jameskbride.tetris;

public class Board {

    private static final int BOARD_HEIGHT = 24;
    private static final int BOARD_WIDTH = 10;
    private static final String EMPTY_SPACE = " ";

    String[][] boardData;

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

    public void setPiece(SquarePiece piece, int rowIndex, int columnIndex) {
        int currentBoardRowIndex = rowIndex;
        for (int pieceRowIndex=0; pieceRowIndex<piece.getShape().length; pieceRowIndex++) {
            int currentBoardColumnIndex = columnIndex;
            for (int pieceColumnIndex=0; pieceColumnIndex<piece.getShape()[0].length; pieceColumnIndex++) {
                boardData[currentBoardRowIndex][currentBoardColumnIndex] = piece.getShape()[pieceRowIndex][pieceColumnIndex];
                currentBoardColumnIndex += 1;
            }
            currentBoardRowIndex += 1;
        }
    }
}
