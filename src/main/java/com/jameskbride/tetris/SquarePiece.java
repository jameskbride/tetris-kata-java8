package com.jameskbride.tetris;

public class SquarePiece implements TetrisPiece {

    public String[][] getShape() {
        String[][] shape = {
            {"#", "#"},
            {"#", "#"}
        };

        return shape;
    }
}
