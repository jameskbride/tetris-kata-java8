package com.jameskbride.tetris.gamestates;

import com.jameskbride.tetris.Board;

public interface TetrisGameState {
    Board getBoard();

    TetrisGameState tick();
}
