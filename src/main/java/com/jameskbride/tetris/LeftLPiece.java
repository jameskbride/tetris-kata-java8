package com.jameskbride.tetris;

public class LeftLPiece implements TetrisPiece {

    public String[][] getShape() {
        String[][] leftLShape = {
                {"#", " "},
                {"#", " "},
                {"#", "#"}
        };

        return leftLShape;
    }
}
