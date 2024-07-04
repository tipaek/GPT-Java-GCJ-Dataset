import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve(in);
        }
    }

    private static void solve(Scanner sc) {

        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[][] rowUsed = new boolean[N][N];
        boolean[][] colused = new boolean[N][N];
        int[][] matrix = new int[N][N];
        if (!backtrack(N, K, 0, 0, rowUsed, colused, matrix)) {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static boolean backtrack(int N, int K, int x, int y, boolean[][] rowUsed, boolean[][] colused, int[][] matrix) {
        if (x >= N) {
            x = 0;
            ++y;
        }

        if (y >= N) {
            if(K != 0) {
                return false;
            }
            System.out.println("POSSIBLE");
            for (int i = 0; i < N; ++i) {
                String[] row = new String[N];
                for (int j = 0; j < N; ++j) {
                    row[j] = Integer.toString(matrix[i][j]);
                }
                System.out.println(String.join(" ", row));

            }
            return true;
        }

        for (int i = 0; i < N; ++i) {
            if (rowUsed[i][x]) {
                continue;
            }
            if (colused[i][y]) {
                continue;
            }
            colused[i][y] = true;
            rowUsed[i][x] = true;

            matrix[x][y] = i + 1;
            int tempK = K;
            if (x == y) {
                tempK -= i + 1;
            }

            if (backtrack(N, tempK, x + 1, y, rowUsed, colused, matrix)) {
                return true;
            }


            colused[i][y] = false;
            rowUsed[i][x] = false;
        }
        return false;

    }
}
  