package com.jameskbride.tetris;

public class LeftLPiece implements TetrisPiece {

    public String[][] getShape() {
        String[][] leftLShape = {
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, EMPTY_SPACE},
                {FILLED_SPACE, FILLED_SPACE}
        };

        return leftLShape;
    }
}
