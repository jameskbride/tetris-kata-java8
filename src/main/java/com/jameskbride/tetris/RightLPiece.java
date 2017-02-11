package com.jameskbride.tetris;

public class RightLPiece implements TetrisPiece{
    public String[][] getShape() {
        String[][] rightLShape = {
                {EMPTY_SPACE, FILLED_SPACE},
                {EMPTY_SPACE, FILLED_SPACE},
                {FILLED_SPACE, FILLED_SPACE}
        };

        return rightLShape;
    }
}
