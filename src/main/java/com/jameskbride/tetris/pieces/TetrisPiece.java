package com.jameskbride.tetris.pieces;

public interface TetrisPiece {

    String FILLED_SPACE = "#";
    String EMPTY_SPACE = " ";

    String[][] getShape();

    default int getHeight() {
        return getShape().length;
    }

    default int getWidth() {
        return getShape()[0].length;
    }
}
