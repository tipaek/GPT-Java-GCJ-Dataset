package com.company;

import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int j = 0; j < T ; j++) {
            boolean pos = false;
            int N = scanner.nextInt();
            int sum = scanner.nextInt();
            int arr []= IntStream.rangeClosed(1,N).toArray();
            List<List<Integer>> PP = new ArrayList<>();
            allSubsets(arr,PP,N,sum,"");
            for (List diag:
                    PP) {
                int[][] G = new int[N][N];
                for (int i = 0; i <N ; i++) {
                    G[i][i] = (int) diag.get(i);
                }
                Sudoku sudoku = new Sudoku(G,N);


                // we try resolution
                if (sudoku.solve()) {
                    System.out.println("Case #"+T+": "+"POSSIBLE");
                    sudoku.display();
                    pos = true;
                    break;
                }
            }
        if (!pos){
            System.out.println("Case #"+T+": "+"IMPOSSIBLE");
        }
        }



    }
    private static void allSubsets(int[] arr,List PP,int N ,int n, String res) {
        List<Integer> OO = new ArrayList<>();
        if(n == 0 && res.length()==2*N) {
            for (String i:
                 res.split(" ")) {
                OO.add(Integer.parseInt(i));

            }
            PP.add(new ArrayList<Integer>(OO));
            return;
        }
        for(int i = 0; i<arr.length;i++) {
            if(n >= arr[i]) {
                allSubsets(arr,PP, N,n-arr[i], res + arr[i]+" ");
            }
        }
    }
}
class Sudoku {



    private int[][] board;
    public static  int EMPTY = 0; // empty cell
    public static  int SIZE = 9; // size of our Sudoku grids

    public Sudoku(int[][] board,int size) {
        SIZE=size;
        this.board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    // we check if a possible number is already in a row
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[row][i] == number)
                return true;

        return false;
    }

    // we check if a possible number is already in a column
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[i][col] == number)
                return true;

        return false;
    }

    // we check if a possible number is in its 3x3 box
//    private boolean isInBox(int row, int col, int number) {
//        int r = row - row % 3;
//        int c = col - col % 3;
//
//        for (int i = r; i < r + 3; i++)
//            for (int j = c; j < c + 3; j++)
//                if (board[i][j] == number)
//                    return true;
//
//        return false;
//    }

    // combined method to check if a number possible to a row,col position is ok
    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number)  &&  !isInCol(col, number) ;
        // &&  !isInBox(row, col, number)
    }

    // Solve method. We will use a recursive BackTracking algorithm.
    // we will see better approaches in next video :)
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // we search an empty cell
                if (board[row][col] == EMPTY) {
                    // we try possible numbers
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOk(row, col, number)) {
                            // number ok. it respects sudoku constraints
                            board[row][col] = number;

                            if (solve()) { // we start backtracking recursively
                                return true;
                            } else { // if not a solution, we empty the cell and we continue
                                board[row][col] = EMPTY;
                            }
                        }
                    }

                    return false; // we return false
                }
            }
        }

        return true; // sudoku solved
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("" + board[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }



}
