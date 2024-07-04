import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int EMPTY = 0;

    public static void main(String[] args) {
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int t = 1; t <= testCases; t++) {
            String[] inputs = scanner.nextLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int K = Integer.parseInt(inputs[1]);

            int minSum = N;
            int maxSum = N * N;

            if (K < minSum || K > maxSum || K == maxSum - 1 || K == minSum + 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            int[][] board = new int[N][N];
            if (fillBoard(board, N, K)) {
                System.out.println("Case #" + t + ": POSSIBLE");
                displayBoard(board);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean fillBoard(int[][] board, int N, int K) {
        int remainingSum = K;
        int position = 0;
        int currentValue = N;
        
        while (remainingSum > 0) {
            int quotient = remainingSum / currentValue;
            if (quotient == N - 1) {
                quotient--;
            }
            int remainder = remainingSum - (currentValue * quotient);
            while (remainder < N - position - quotient) {
                quotient--;
                remainder = remainingSum - (currentValue * quotient);
            }
            for (int i = 0; i < quotient; i++) {
                remainingSum -= currentValue;
                board[position][position] = currentValue;
                position++;
            }
            currentValue--;
        }

        return solveBoard(board);
    }

    private static boolean isValid(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == EMPTY) {
                    for (int number = 1; number <= board.length; number++) {
                        if (isValid(board, row, col, number)) {
                            board[row][col] = number;
                            if (solveBoard(board)) {
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

    private static void displayBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}