import java.util.*;
import java.io.*;

public class Solution {
    private static final int MOD = 1000000007;
    private static final int INT_MAX = 1000000000;
    private static final int INT_MIN = -1000000000;
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};

    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            int N = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[N][N];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += grid[i][i];
            }

            // Check for repeated elements in rows
            for (int i = 0; i < N; i++) {
                Set<Integer> seen = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!seen.add(grid[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for repeated elements in columns
            for (int i = 0; i < N; i++) {
                Set<Integer> seen = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!seen.add(grid[j][i])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.print(trace + " " + rowRepeats + " " + colRepeats);
            if (t != T) {
                System.out.println();
            }
        }
        br.close();
    }
}