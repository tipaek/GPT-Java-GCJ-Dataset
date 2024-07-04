import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colDuplicates++;
                }
            }

            System.out.println("#" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        out.flush();
        out.close();
    }
}