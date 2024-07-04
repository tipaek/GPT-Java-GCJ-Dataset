import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static final int EMPTY = 0;

    public static void main(String[] args) {
        int T = Integer.parseInt(in.nextLine());
        for (int t = 1; t <= T; t++) {
            String[] s1 = in.nextLine().split(" ");
            int N = Integer.parseInt(s1[0]);
            int K = Integer.parseInt(s1[1]);

            int min = N;
            int max = N * N;

            if (K < min || K > max || K == max - 1 || K == min + 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            int[][] board = new int[N][N];
            boolean isError = fillBoard(board, N, K);

            if (isError) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": POSSIBLE");
                solve(board);
            }
        }
    }

    private static boolean fillBoard(int[][] board, int N, int K) {
        int nPos = -1;
        int zeroC = 0;
        int r = K;
        int pos = 0;
        int n = N;
        boolean isError = false;

        while (r > 0) {
            if (n == 0) {
                isError = true;
                break;
            }
            int div = r / n;
            if (div == N - 1 && n != 1) {
                div--;
            }
            int rem = r - (n * div);
            while (rem < N - pos - div) {
                div--;
                rem = r - (n * div);
            }
            for (int i = 0; i < div; i++) {
                r -= n;
                if (pos == N) {
                    isError = true;
                    break;
                }
                board[pos][pos] = n;
                if (n > 1) {
                    nPos = pos;
                } else {
                    zeroC++;
                }
                pos++;
            }
            n--;
        }

        if (zeroC == N - 1) {
            board[nPos][nPos]--;
            board[N - 1][N - 1]++;
            if (board[nPos][nPos] == board[N - 1][N - 1] && N == 3) {
                isError = true;
            }
        }

        return isError;
    }

    private static boolean isOk(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return false;
            }
        }
        return true;
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