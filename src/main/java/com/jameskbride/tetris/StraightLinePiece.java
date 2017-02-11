package com.jameskbride.tetris;

public class StraightLinePiece implements TetrisPiece {

    public String[][] getShape() {
        String[][] shape = {
                {FILLED_SPACE},
                {FILLED_SPACE},
                {FILLED_SPACE},
                {FILLED_SPACE}
        };

        return shape;
    }
}
