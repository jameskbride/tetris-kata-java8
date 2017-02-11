package com.jameskbride.tetris.pieces;

public class TPiece implements TetrisPiece {

    public String[][] getShape() {
        String[][] shape = {
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, FILLED_SPACE},
                {FILLED_SPACE, EMPTY_SPACE}
        };

        return shape;
    }
}
