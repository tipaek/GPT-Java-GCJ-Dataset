import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    static class BackTracking {
        private int[][] board;
        private int SIZE;
        private static final int EMPTY = 0;

        public BackTracking(int n, int[] trace) {
            this.board = new int[n][n];
            for (int i = 0; i < n; i++) {
                this.board[i][i] = trace[i];
            }
            this.SIZE = n;
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

        private boolean isOk(int row, int col, int number) {
            return !isInRow(row, number) && !isInCol(col, number);
        }

        public void print() {
            for (int i = 0; i < SIZE; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < SIZE; j++) {
                    line.append(board[i][j]);
                    if (j < SIZE - 1) {
                        line.append(" ");
                    }
                }
                System.out.println(line);
            }
        }

        public boolean solve() {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    if (board[row][col] == EMPTY) {
                        for (int number = 1; number <= SIZE; number++) {
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
    }

    private static void solve(int t, int n, int k) {
        boolean possible = (k != Math.pow(n, 2) - 1 && k != n + 1);
        System.out.println("Case #" + t + ": " + (possible ? "POSSIBLE" : "IMPOSSIBLE"));
        if (possible) {
            if (k % n == 0) {
                solveEasy(k / n, n);
            } else {
                Random rnd = new Random();
                int[] arr = new int[n];
                boolean done = false;
                while (!done) {
                    int tempK = k;
                    int sum = 0;
                    for (int g = 0; g < n; g++) {
                        int min = Math.max((tempK - sum) - (n - g - 1) * n, 1);
                        int max = Math.min((tempK - sum) - (n - g - 1), n);
                        arr[g] = (max == min) ? max : rnd.nextInt(max - min) + min;
                        sum += arr[g];
                    }
                    if (sum == k) {
                        int[] check = new int[n];
                        for (int value : arr) {
                            check[value - 1]++;
                        }
                        boolean nonRepExists = false;
                        int count = 0;
                        for (int value : check) {
                            if (value == 1) nonRepExists = true;
                            if (value != 0) count++;
                        }
                        done = !(nonRepExists && count <= 2);
                    }
                }
                BackTracking bt = new BackTracking(n, arr);
                bt.solve();
                bt.print();
            }
        }
    }

    private static void solveEasy(int e, int n) {
        for (int i = 0; i < n; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < n; j++) {
                line.append((e + j) % n == 0 ? n : (e + j) % n);
                if (j < n - 1) {
                    line.append(" ");
                }
            }
            System.out.println(line);
            e = (e == 1) ? n : e - 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            solve(i, n, m);
        }
    }
}