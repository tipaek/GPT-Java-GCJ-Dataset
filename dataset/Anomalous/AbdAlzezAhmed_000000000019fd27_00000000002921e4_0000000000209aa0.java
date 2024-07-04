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
            int sum = scanner.nextInt();
            int[] arr = IntStream.rangeClosed(1, N).toArray();
            List<List<Integer>> allSubsets = new ArrayList<>();
            generateSubsets(arr, allSubsets, N, sum, "");
            for (List<Integer> subset : allSubsets) {
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

    private static void generateSubsets(int[] arr, List<List<Integer>> result, int N, int remainingSum, String currentSubset) {
        if (remainingSum == 0 && currentSubset.split(" ").length == N) {
            List<Integer> subset = new ArrayList<>();
            for (String num : currentSubset.trim().split(" ")) {
                subset.add(Integer.parseInt(num));
            }
            result.add(subset);
            return;
        }
        for (int i : arr) {
            if (remainingSum >= i) {
                generateSubsets(arr, result, N, remainingSum - i, currentSubset + i + " ");
            }
        }
    }
}

class Sudoku {

    private int[][] board;
    private static final int EMPTY = 0;
    private int size;

    public Sudoku(int[][] board, int size) {
        this.size = size;
        this.board = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(board[i], 0, this.board[i], 0, size);
        }
    }

    private boolean isInRow(int row, int number) {
        for (int col = 0; col < size; col++) {
            if (board[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(int col, int number) {
        for (int row = 0; row < size; row++) {
            if (board[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number);
    }

    public boolean solve() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == EMPTY) {
                    for (int number = 1; number <= size; number++) {
                        if (isOk(row, col, number)) {
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