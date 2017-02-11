package com.jameskbride.tetris;

public class LeftSPiece implements TetrisPiece{

    public String[][] getShape() {
        String[][] shape = {
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, FILLED_SPACE},
                {EMPTY_SPACE, FILLED_SPACE}
        };

        return shape;
    }
}
