import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;
            boolean[] rowCheck = new boolean[n];
            boolean[] colCheck = new boolean[n];

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowCheck[i] = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colCheck[i] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (rowCheck[i]) duplicateRows++;
                if (colCheck[i]) duplicateCols++;
            }

            System.out.println(trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}