package com.jameskbride.tetris;

public class Coords {
    final int rowIndex;
    final int columnIndex;

    public Coords(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}
