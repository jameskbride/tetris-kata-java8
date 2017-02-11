package com.jameskbride.tetris.pieces;

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
