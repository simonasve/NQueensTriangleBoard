package com.simonas_vedeckis;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    int boardSize;
    int queenAmount;
    int queensPlaced = 0;

    ArrayList<Cell> board = new ArrayList<>();

    public void askForInput () {
        Scanner scan = new Scanner(System.in);
        System.out.println("What's the board size? ");
        boardSize = scan.nextInt();
        scan.nextLine();
        System.out.println("What's the queen amount? ");
        queenAmount = scan.nextInt();
        scan.nextLine();
    }


    public void giveCellNumber() {
        int tempSize = 0;
        for (int i = 0; i < this.boardSize; i++) {
            int tempSize1 = tempSize;
            for (int j = 0; j <=tempSize; j++) {
                Cell cell = new Cell(j, tempSize1);
                this.board.add(cell);
                tempSize1--;
            }
            tempSize++;
        }

        int tempSize2 = 0;
        int cellNumb = 0;
        for (int i = 0; i < this.boardSize; i++) {
            for (int j=0; j<=tempSize2; j++) {
                this.board.get(cellNumb).setRow(tempSize2);
                cellNumb++;
            }
            tempSize2++;
        }
    }

    public boolean isSafe (Cell cell) {
        for (Cell value : this.board) {
            if (cell.diagonal1 == value.diagonal1 && value.isQueenPlaced) {
                return false;
            }
        }
        for (Cell value : this.board) {
            if (cell.diagonal2 == value.diagonal2 && value.isQueenPlaced) {
                return false;
            }
        }
        for (Cell value : this.board) {
            if (cell.row == value.row && value.isQueenPlaced) {
                return false;
            }
        }
        return true;
    }

    public boolean placeQueens (int row) {
        if (this.queensPlaced == this.queenAmount)
        {
            printSolution();
            return true;
        }
        if (row>this.boardSize) {
            return false;
        }
        for (Cell cell : this.board) {
            if (cell.row == row) {
                if (isSafe(cell)) {
                    cell.putQueen();
                    this.queensPlaced++;
                    if (this.queensPlaced == this.queenAmount) {
                        printSolution();
                        return true;
                    }
                    if (!placeQueens(row + 1)) {
                        cell.removeQueen();
                        this.queensPlaced--;
                    }
                }
            }
        }
        return false;
    }

    public void printSolution () {
        for (Cell cell : this.board) {
            if (cell.isQueenPlaced) {
                System.out.println("[" + cell.diagonal1 + ";" + cell.diagonal2 + "]");
            }
        }
        System.out.println();
    }

    public void solve () {
        if (this.queenAmount > (((2*this.boardSize)+1)/3)) {
            System.out.println("Impossible to place " + this.queenAmount + " queens on a " + this.boardSize + " sized board");
        }
        else {
            giveCellNumber();
            for (int i = 0; i < this.boardSize; i++) {
                placeQueens(i);
            }
        }
    }

}
