import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static final int EMPTY = 0;

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 1; t <= T; t++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            int min = N;
            int max = N * N;

            if (K < min || K > max || K == max - 1 || K == min + 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            int[][] board = new int[N][N];
            boolean isError = fillBoard(N, K, board);

            if (isError) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": POSSIBLE");
                solve(board);
            }
        }
    }

    private static boolean fillBoard(int N, int K, int[][] board) {
        int nPos = -1;
        int zeroCount = 0;
        int remaining = K;
        int pos = 0;
        int n = N;
        boolean isError = false;

        while (remaining > 0) {
            if (n == 0) {
                isError = true;
                break;
            }

            int div = remaining / n;
            if (div == N - 1 && n != 1) {
                div--;
            }
            int rem = remaining - (n * div);
            while (rem < N - pos - div) {
                div--;
                rem = remaining - (n * div);
            }

            for (int i = 0; i < div; i++) {
                remaining -= n;
                if (pos == N) {
                    isError = true;
                    break;
                }
                board[pos][pos] = n;
                if (n > 1) {
                    nPos = pos;
                } else {
                    zeroCount++;
                }
                pos++;
            }
            n--;
        }

        if (zeroCount == N - 1) {
            board[nPos][nPos]--;
            board[N - 1][N - 1]++;
            if (board[nPos][nPos] == board[N - 1][N - 1] && N == 3) {
                isError = true;
            }
        }

        return isError;
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