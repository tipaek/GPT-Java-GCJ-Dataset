import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int EMPTY = 0;

    public static void main(String[] args) {
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int t = 1; t <= testCases; t++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            int minSum = N;
            int maxSum = N * N;

            if (K < minSum || K > maxSum || K == maxSum - 1 || K == minSum + 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            int[][] board = new int[N][N];
            fillBoard(board, N, K);
            System.out.println("Case #" + t + ": POSSIBLE");
            solveSudoku(board);
        }
    }

    private static void fillBoard(int[][] board, int N, int K) {
        int remainingSum = K;
        int position = 0;
        int currentNum = N;

        while (remainingSum > 0) {
            int quotient = remainingSum / currentNum;
            if (quotient == N - 1) {
                quotient--;
            }
            int remainder = remainingSum - (currentNum * quotient);
            while (remainder < N - position - quotient) {
                quotient--;
                remainder = remainingSum - (currentNum * quotient);
            }
            for (int i = 0; i < quotient; i++) {
                remainingSum -= currentNum;
                board[position][position] = currentNum;
                position++;
            }
            currentNum--;
        }
    }

    private static boolean isNumberInRowOrCol(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSafeToPlace(int[][] board, int row, int col, int number) {
        return !isNumberInRowOrCol(board, row, col, number);
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == EMPTY) {
                    for (int number = 1; number <= board.length; number++) {
                        if (isSafeToPlace(board, row, col, number)) {
                            board[row][col] = number;
                            if (solveSudoku(board)) {
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
        printBoard(board);
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(" " + cell);
            }
            System.out.println();
        }
    }
}