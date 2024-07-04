package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int j = 0; j < T; j++) {
            boolean isPossible = false;
            int N = scanner.nextInt();
            int targetSum = scanner.nextInt();
            int[] arr = IntStream.rangeClosed(1, N).toArray();
            List<List<Integer>> subsets = new ArrayList<>();
            generateSubsets(arr, subsets, N, targetSum, "");

            for (List<Integer> subset : subsets) {
                int[][] grid = new int[N][N];
                for (int i = 0; i < N; i++) {
                    grid[i][i] = subset.get(i);
                }
                Sudoku sudoku = new Sudoku(grid, N);

                if (sudoku.solve()) {
                    System.out.println("Case #" + (j + 1) + ": POSSIBLE");
                    sudoku.display();
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + (j + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static void generateSubsets(int[] arr, List<List<Integer>> subsets, int N, int targetSum, String current) {
        List<Integer> subset = new ArrayList<>();
        if (targetSum == 0 && current.length() == 2 * N) {
            for (String num : current.split(" ")) {
                subset.add(Integer.parseInt(num));
            }
            subsets.add(new ArrayList<>(subset));
            return;
        }

        for (int value : arr) {
            if (targetSum >= value) {
                generateSubsets(arr, subsets, N, targetSum - value, current + value + " ");
            }
        }
    }
}

class Sudoku {

    private int[][] board;
    private static int EMPTY = 0;
    private static int SIZE = 9;

    public Sudoku(int[][] board, int size) {
        SIZE = size;
        this.board = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isPositionValid(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number);
    }

    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (isPositionValid(row, col, number)) {
                            board[row][col] = number;
                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}