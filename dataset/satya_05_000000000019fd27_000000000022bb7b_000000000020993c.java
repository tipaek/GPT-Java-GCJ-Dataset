import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        String[] strings;
        int[][] mat;
        // For each test case.
        for (int p=0; p<t; p++) {
            int n = Integer.parseInt(br.readLine());

            mat = new int[n][n];
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            boolean[] map;
            for (int i=0; i<n; i++) {
                strings = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Integer.parseInt(strings[j]);
                    if (i == j) trace += mat[i][j];
                }
            }

            // row Count
            for (int i=0; i<n; i++) {
                map = new boolean[n+1];
                for (int j = 0; j < n; j++) {
                    // Already visited.
                    if (map[mat[i][j]]) { rowCount++; break; }
                    else map[mat[i][j]] = true; // Mark as visited.
                }
            }

            for (int j=0; j<n; j++) {
                map = new boolean[n+1];
                for (int i = 0; i < n; i++) {
                    // Already visited.
                    if (map[mat[i][j]]) { colCount++; break; }
                    else map[mat[i][j]] = true; // Mark as visited.
                }
            }

            output(sb, p, trace, rowCount, colCount);
        }
        System.out.println(sb);
    }

    private static void output(StringBuffer sb, int testCase, int answer, int row, int col) {
        sb.append("Case #" + (testCase + 1) + ": " + answer + " " + row + " " + col +  "\n");
    }
}
