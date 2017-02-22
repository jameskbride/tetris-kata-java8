package com.jameskbride.tetris;

import com.jameskbride.tetris.pieces.TetrisPiece;

import static com.jameskbride.tetris.pieces.TetrisPiece.EMPTY_SPACE;

public class Board {

    private static final int BOARD_HEIGHT = 24;
    private static final int BOARD_WIDTH = 10;
    private static final boolean PIECE_STOPPED = true;

    private String[][] boardData;

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

    public boolean setPiece(TetrisPiece piece, Coords initialCoords) {
        return updateBoardData(piece, initialCoords);
    }

    private boolean updateBoardData(TetrisPiece piece, Coords coords) {
        int currentBoardRowIndex = coords.getRowIndex();

        return pieceHitBottom(piece, currentBoardRowIndex) ? PIECE_STOPPED : drawPieceAtCoordinates(piece, coords, currentBoardRowIndex);
    }

    private boolean pieceHitBottom(TetrisPiece piece, int currentBoardRowIndex) {
        return currentBoardRowIndex + piece.getHeight() - 1 >= getHeight();
    }

    private boolean drawPieceAtCoordinates(TetrisPiece piece, Coords coords, int currentBoardRowIndex) {
        for (int pieceRowIndex = 0; pieceRowIndex< piece.getHeight(); pieceRowIndex++) {
            int currentBoardColumnIndex = coords.getColumnIndex();
            for (int pieceColumnIndex = 0; pieceColumnIndex< piece.getWidth(); pieceColumnIndex++) {
                boardData[currentBoardRowIndex][currentBoardColumnIndex] = piece.getShape()[pieceRowIndex][pieceColumnIndex];
                currentBoardColumnIndex += 1;
            }
            currentBoardRowIndex += 1;
        }

        return !PIECE_STOPPED;
    }

    public void clearSectionAbovePiece(TetrisPiece activePiece, Coords previousCoords) {
        int pieceWidth = activePiece.getWidth();

        for (int i=0; i<pieceWidth; i++) {
            boardData[previousCoords.getRowIndex()][previousCoords.getColumnIndex() + i] = EMPTY_SPACE;
        }
    }
}
