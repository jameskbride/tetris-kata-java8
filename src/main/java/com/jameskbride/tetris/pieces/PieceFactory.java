package com.jameskbride.tetris.pieces;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PieceFactory {

    public TetrisPiece newPiece() {
        List<TetrisPiece> pieces = Arrays.asList(
                new LeftLPiece(),
                new LeftSPiece(),
                new RightLPiece(),
                new RightSPiece(),
                new SquarePiece(),
                new StraightLinePiece(),
                new TPiece()
        );
        Random random = new Random();

        return pieces.get(random.nextInt(pieces.size() + 1));
    }
}
