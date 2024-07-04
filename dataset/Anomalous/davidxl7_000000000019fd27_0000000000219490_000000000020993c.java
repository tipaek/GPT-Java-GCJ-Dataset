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

            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col < N; col++) {
                    grid[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < N; j++) {
                trace += grid[j][j];
            }

            int duplicateRows = 0;
            for (int row = 0; row < N; row++) {
                Set<Integer> uniqueValues = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    uniqueValues.add(grid[row][col]);
                }
                if (uniqueValues.size() != N) {
                    duplicateRows++;
                }
            }

            int duplicateCols = 0;
            for (int col = 0; col < N; col++) {
                Set<Integer> uniqueValues = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    uniqueValues.add(grid[row][col]);
                }
                if (uniqueValues.size() != N) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}