import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;

        while (scanner.hasNext()) {
            int numCases = scanner.nextInt();

            for (int i = 0; i < numCases; i++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                int duplicateRows = 0;
                int duplicateCols = 0;

                // Read the matrix and check for duplicate values in rows
                for (int row = 0; row < size; row++) {
                    Set<Integer> rowSet = new HashSet<>();
                    boolean hasDuplicate = false;

                    for (int col = 0; col < size; col++) {
                        matrix[row][col] = scanner.nextInt();
                        if (!rowSet.add(matrix[row][col])) {
                            hasDuplicate = true;
                        }
                    }

                    if (hasDuplicate) {
                        duplicateRows++;
                    }
                }

                // Check for duplicate values in columns
                for (int col = 0; col < size; col++) {
                    Set<Integer> colSet = new HashSet<>();
                    boolean hasDuplicate = false;

                    for (int row = 0; row < size; row++) {
                        if (!colSet.add(matrix[row][col])) {
                            hasDuplicate = true;
                        }
                    }

                    if (hasDuplicate) {
                        duplicateCols++;
                    }
                }

                // Calculate the trace of the matrix
                int trace = 0;
                for (int j = 0; j < size; j++) {
                    trace += matrix[j][j];
                }

                // Print the result for the current case
                System.out.printf("Case #%d: %d %d %d%n", caseNumber++, trace, duplicateRows, duplicateCols);
            }
        }

        scanner.close();
    }
}