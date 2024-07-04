import java.io.*;
import java.util.*;

class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            HashSet<Integer> repeatedCols = new HashSet<>();
            HashMap<Integer, HashSet<Integer>> columnSets = new HashMap<>();

            for (int i = 0; i < n; i++) {
                boolean rowHasRepeat = false;
                HashSet<Integer> rowSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();

                    // Calculate trace
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    // Check for row repeats
                    if (!rowSet.contains(matrix[i][j])) {
                        rowSet.add(matrix[i][j]);
                    } else if (!rowHasRepeat) {
                        rowRepeats++;
                        rowHasRepeat = true;
                    }

                    // Check for column repeats
                    columnSets.putIfAbsent(j, new HashSet<>());
                    HashSet<Integer> colSet = columnSets.get(j);

                    if (colSet.contains(matrix[i][j]) && !repeatedCols.contains(j)) {
                        repeatedCols.add(j);
                        colRepeats++;
                    } else {
                        colSet.add(matrix[i][j]);
                    }
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}