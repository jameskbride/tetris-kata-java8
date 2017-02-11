package com.jameskbride.tetris;

class Coords {
    final int rowIndex;
    final int columnIndex;

    Coords(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    Coords(Coords coords) {
        this.rowIndex = coords.getRowIndex();
        this.columnIndex = coords.getColumnIndex();
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}
