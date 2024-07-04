import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < n; j++) {
                // Calculate trace
                if (i == j) {
                    trace += matrix[i][j];
                }

                // Check for row duplicates
                if (!rowSet.add(matrix[i][j])) {
                    rowHasDuplicate = true;
                }

                // Check for column duplicates
                if (!colSet.add(matrix[j][i])) {
                    colHasDuplicate = true;
                }
            }

            if (rowHasDuplicate) {
                rowRepeats++;
            }

            if (colHasDuplicate) {
                colRepeats++;
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        InputStream inputStream = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/qualification/vestigium-1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                System.out.println("Case #" + testCase + ": " + solve(matrix));
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
    }
}