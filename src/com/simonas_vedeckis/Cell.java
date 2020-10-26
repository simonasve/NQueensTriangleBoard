package com.simonas_vedeckis;

public class Cell {

    int diagonal1;
    int diagonal2;
    int row;
    boolean isQueenPlaced = false;

    public Cell (int diagonal1, int diagonal2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    public void setRow (int row) {

        this.row = row;
    }

    public void putQueen () {
        isQueenPlaced = true;
    }

    public void removeQueen () {

        isQueenPlaced = false;
    }

}
