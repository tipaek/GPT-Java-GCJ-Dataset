import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < n) {
                    colRepeats++;
                }
            }

            System.out.println("case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}