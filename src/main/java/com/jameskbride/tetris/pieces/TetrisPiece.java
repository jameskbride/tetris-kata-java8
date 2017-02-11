package com.jameskbride.tetris.pieces;

public interface TetrisPiece {

    String FILLED_SPACE = "#";
    String EMPTY_SPACE = " ";

    String[][] getShape();
}
