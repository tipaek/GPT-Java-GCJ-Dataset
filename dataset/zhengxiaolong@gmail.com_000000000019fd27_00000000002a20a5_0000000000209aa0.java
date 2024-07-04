import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int K = in.nextInt();
            indicium(in, i, N, K);
        }
        in.close();
    }

    private static void indicium(Scanner in, int i, int N, int K) {


        if (N % 2 == 0 && K % 2 == 1) {
            String output = String.format("Case #%d: %s", i, IMPOSSIBLE);
            System.out.println(output);
            return;
        }

        Worker worker = new Worker(N, K, i);
        worker.construct(1, 1, 0);

        if (!worker.isPossible) {
            String output = String.format("Case #%d: %s", i, IMPOSSIBLE);
            System.out.println(output);
        }
    }

    private static void printMatrix(Worker worker) {
        for (int i = 1; i < worker.square.length; i++) {
            for (int j = 1; j < worker.square.length; j++) {
                System.out.print(worker.square[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Worker {
        int[][] square;
        boolean[][] dp_row;
        boolean[][] dp_col;
        boolean isPossible = false;
        int n, k, i;

        Worker(int N, int K, int i) {
            int dim = N + 1;
            square = new int[dim][dim];
            dp_row = new boolean[dim][dim];
            dp_col = new boolean[dim][dim];
            this.n = N;
            this.k = K;
            this.i = i;
        }


        void construct(int row, int col, int m) {
            if (!isPossible && row == n && col == n + 1 && m == k) {
                isPossible = true;
                String output = String.format("Case #%d: %s", i, POSSIBLE);
                System.out.println(output);
                printMatrix(this);
                return;
            } else if (row > n) {
                return;
            } else if (col > n) {
                construct(row + 1, 1, m);
            }
            for (int i = 1; i <= n && !isPossible; ++i) {
                if (!dp_row[row][i] && !dp_col[col][i]) {
                    dp_row[row][i] = dp_col[col][i] = true;
                    if (row == col) m += i;
                    this.square[row][col] = i;
                    construct(row, col + 1, m);
                    dp_row[row][i] = false;
                    dp_col[col][i] = false;
                    if (row == col) m -= i;
                    this.square[row][col] = 0;
                }
            }
        }
    }
}