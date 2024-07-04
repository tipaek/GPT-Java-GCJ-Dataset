import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] grid = new int[N][N];
            int trace = 0;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    grid[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < N; j++) {
                trace += grid[j][j];
            }

            int duplicateRows = 0;
            for (int j = 0; j < N; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    rowSet.add(grid[j][k]);
                }
                if (rowSet.size() != N) {
                    duplicateRows++;
                }
            }

            int duplicateCols = 0;
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    colSet.add(grid[k][j]);
                }
                if (colSet.size() != N) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}