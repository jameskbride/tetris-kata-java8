package com.jameskbride.tetris;

public class Board {

    public static final int BOARD_HEIGHT = 24;
    public static final int BOARD_WIDTH = 10;
    String[][] boardData;

    public Board() {
        boardData = new String[BOARD_HEIGHT][BOARD_WIDTH];
        for (int rowIndex=0; rowIndex<BOARD_HEIGHT; rowIndex++) {
            for (int columnIndex=0; columnIndex<BOARD_WIDTH; columnIndex++) {
                boardData[rowIndex][columnIndex] = " ";
            }
        }
    }

    public int getHeight() {
        return 24;
    }


    public int getWidth() {
        return 10;
    }

    public String getLocation(int rowIndex, int columnIndex) {
        return boardData[rowIndex][columnIndex];
    }
}
