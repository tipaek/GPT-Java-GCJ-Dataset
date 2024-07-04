import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int trace = 0, rowCount = 0, colCount = 0;
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];

                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowFlag = false, colFlag = false;

                for (int k = 0; k < n; k++) {
                    if (rowSet.contains(matrix[j][k]) && !rowFlag) {
                        rowCount++;
                        rowFlag = true;
                    }
                    rowSet.add(matrix[j][k]);

                    if (colSet.contains(matrix[k][j]) && !colFlag) {
                        colCount++;
                        colFlag = true;
                    }
                    colSet.add(matrix[k][j]);
                }
            }

            results[i] = "Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}