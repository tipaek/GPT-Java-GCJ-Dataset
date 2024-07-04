import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowsWithRepeats = 0;
            int colsWithRepeats = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowElements = new HashSet<>();
                boolean rowHasRepeat = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowHasRepeat && !rowElements.add(matrix[i][j])) {
                        rowHasRepeat = true;
                        rowsWithRepeats++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colElements = new HashSet<>();
                boolean colHasRepeat = false;
                for (int i = 0; i < n; i++) {
                    if (!colHasRepeat && !colElements.add(matrix[i][j])) {
                        colHasRepeat = true;
                        colsWithRepeats++;
                        break;
                    }
                }
            }

            System.out.format("Case #%d: %d %d %d%n", testCase, trace, rowsWithRepeats, colsWithRepeats);
        }
    }
}