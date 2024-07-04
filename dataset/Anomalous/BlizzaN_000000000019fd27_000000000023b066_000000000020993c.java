import java.io.*;
import java.util.*;

public class Solution {

    private static String solve(int[][] matrix) {
        int sum = 0;
        int rrTotal = 0;
        int rcTotal = 0;

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowRepeated = false;
            boolean colRepeated = false;

            for (int j = 0; j < n; j++) {
                // Check row for duplicates
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeated = true;
                }

                // Check column for duplicates
                if (!colSet.add(matrix[j][i])) {
                    colRepeated = true;
                }

                // Sum of diagonal elements
                if (i == j) {
                    sum += matrix[i][j];
                }
            }

            if (rowRepeated) {
                rrTotal++;
            }
            if (colRepeated) {
                rcTotal++;
            }
        }

        return sum + " " + rrTotal + " " + rcTotal;
    }

    public static void main(String[] args) {
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }

                System.out.println("Case #" + testNumber + ": " + solve(matrix));
            }
        }
    }
}