import java.util.*;
import java.io.*;

public class Solution {
    public static int[] solve(int N, int[][] matrix) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;
        outer: for (int i = 0; i < N; i++) {
            int[] row = matrix[i];
            trace += row[i];
            boolean[] set = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                if (set[row[j]]) {
                    repeatedRows++;
                    continue outer;
                }

                set[row[j]] = true;
            }
        }
        outer: for (int y = 0; y < N; y++) {
            boolean[] set = new boolean[N + 1];
            for (int x = 0; x < N; x++) {
                if (set[matrix[x][y]]) {
                    repeatedCols++;
                    continue outer;
                }

                set[matrix[x][y]] = true;
            }
        }
        return new int[]{trace, repeatedRows, repeatedCols};
    }

    public static void main(String[] args) {
        Scanner in =
            new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for (int x = 0; x < N; x++) {
               int[] row = matrix[x];
               for (int y = 0; y < N; y++) {
                   row[y] = in.nextInt();
               }
            }
            out.format("Case #%d: ", i);
            int[] res = solve(N, matrix);
            out.println(res[0] + " " + res[1] + " " + res[2]);
        }
    }
}
