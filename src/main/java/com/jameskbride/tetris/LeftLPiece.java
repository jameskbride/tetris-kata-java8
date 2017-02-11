package com.jameskbride.tetris;

public class LeftLPiece extends SquarePiece {

    @Override
    public String[][] getShape() {
        String[][] leftLShape = {
                {"#", " "},
                {"#", " "},
                {"#", "#"}
        };

        return leftLShape;
    }
}
