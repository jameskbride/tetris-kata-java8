package com.jameskbride.tetris;

public interface ITetrisGame {
    Board getBoard();

    ITetrisGame tick();
}
