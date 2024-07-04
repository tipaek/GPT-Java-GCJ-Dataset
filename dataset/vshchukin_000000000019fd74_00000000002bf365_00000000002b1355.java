import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SquareDance solver = new SquareDance();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SquareDance {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[n][m];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                    sum += arr[i][j];
                }
            }
            long totalSum = sum;
            boolean noElims = false;
            List<int[]> toElims = new ArrayList<>();
            while (!noElims) {
                noElims = true;
                toElims.clear();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (shouldElim(arr, i, j, n, m)) {
                            toElims.add(new int[]{i, j, arr[i][j]});
                            noElims = false;
                        }
                    }
                }
                for (int[] elem : toElims) {
                    sum -= elem[2];
                    arr[elem[0]][elem[1]] = 0;
                }
                if (!noElims) {
                    totalSum += sum;
                }
            }
            out.printf("Case #%d: %d\n", testNumber, totalSum);
        }

        private boolean shouldElim(int[][] arr, int i, int j, int n, int m) {
            if (arr[i][j] == 0) {
                return false;
            }
            int up = 0;
            int down = 0;
            int left = 0;
            int right = 0;
            int cnt = 0;
            int sum = 0;
            for (int k = i - 1; k >= 0; k--) {
                if (arr[k][j] > 0) {
                    cnt++;
                    sum += arr[k][j];
                    break;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (arr[k][j] > 0) {
                    cnt++;
                    sum += arr[k][j];
                    break;
                }
            }
            for (int k = j - 1; k >= 0; k--) {
                if (arr[i][k] > 0) {
                    cnt++;
                    sum += arr[i][k];
                    break;
                }
            }
            for (int k = j + 1; k < m; k++) {
                if (arr[i][k] > 0) {
                    cnt++;
                    sum += arr[i][k];
                    break;
                }
            }
            return cnt > 0 && arr[i][j] < (double) sum / cnt;
        }

    }
}

