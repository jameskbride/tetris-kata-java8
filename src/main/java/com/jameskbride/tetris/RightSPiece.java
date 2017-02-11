package com.jameskbride.tetris;

public class RightSPiece implements TetrisPiece {

    public String[][] getShape() {
        String[][] shape = {
                {EMPTY_SPACE, FILLED_SPACE},
                {FILLED_SPACE, FILLED_SPACE},
                {FILLED_SPACE, EMPTY_SPACE}
        };

        return shape;
    }
}
