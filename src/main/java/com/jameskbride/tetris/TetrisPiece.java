package com.jameskbride.tetris;

public interface TetrisPiece {

    String FILLED_SPACE = "#";
    String EMPTY_SPACE = " ";

    String[][] getShape();
}
