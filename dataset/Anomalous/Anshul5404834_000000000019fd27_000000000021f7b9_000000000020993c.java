import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            Map<Integer, Integer> columnCounts = new HashMap<>();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < size; i++) {
                Map<Integer, Integer> rowCounts = new HashMap<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < size; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;

                    // Calculate trace
                    if (i == j) {
                        trace += value;
                    }

                    // Check for row duplicates
                    if (!rowHasDuplicate && rowCounts.containsKey(value)) {
                        rowRepeats++;
                        rowHasDuplicate = true;
                    } else {
                        rowCounts.put(value, 1);
                    }

                    // Check for column duplicates
                    if (!columnCounts.containsKey(j)) {
                        columnCounts.put(j, 0);
                    }
                    boolean colHasDuplicate = false;
                    for (int k = 0; k <= i; k++) {
                        if (matrix[k][j] == value) {
                            colHasDuplicate = true;
                            break;
                        }
                    }
                    if (colHasDuplicate) {
                        columnCounts.put(j, columnCounts.get(j) + 1);
                    }
                }
            }

            // Count columns with duplicates
            for (int count : columnCounts.values()) {
                if (count > 0) {
                    colRepeats++;
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}