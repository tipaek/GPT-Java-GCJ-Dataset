import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int EMPTY = 0;

    public static void main(String[] args) {
        int T = Integer.parseInt(in.nextLine());
        for (int t = 1; t <= T; t++) {
            String[] inputs = in.nextLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int K = Integer.parseInt(inputs[1]);

            int minSum = N;
            int maxSum = N * N;

            if (K < minSum || K > maxSum || K == maxSum - 1 || K == minSum + 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            int[][] board = new int[N][N];
            int remainingSum = K;
            int position = 0;
            int size = N;
            int zeroCount = 0;
            int nonZeroPosition = -1;

            while (remainingSum > 0) {
                int quotient = remainingSum / size;
                if (quotient == N - 1) {
                    quotient--;
                }
                int remainder = remainingSum - (size * quotient);
                while (remainder < N - position - quotient) {
                    quotient--;
                    remainder = remainingSum - (size * quotient);
                }
                for (int i = 0; i < quotient; i++) {
                    remainingSum -= size;
                    board[position][position] = size;
                    if (size > 1) {
                        nonZeroPosition = position;
                    } else {
                        zeroCount++;
                    }
                }
                if (quotient == 0) {
                    remainingSum -= 1;
                    board[position][position] = 1;
                    zeroCount++;
                }
                position++;
                size--;
            }
            if (zeroCount == N - 1) {
                board[nonZeroPosition][nonZeroPosition]--;
                board[N - 1][N - 1]++;
            }
            System.out.println("Case #" + t + ": POSSIBLE");
            solve(board);
        }
    }

    private static boolean isInRowOrCol(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOk(int[][] board, int row, int col, int number) {
        return !isInRowOrCol(board, row, col, number);
    }

    public static boolean solve(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == EMPTY) {
                    for (int number = 1; number <= board.length; number++) {
                        if (isOk(board, row, col, number)) {
                            board[row][col] = number;
                            if (solve(board)) {
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
        display(board);
        return true;
    }

    public static void display(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}