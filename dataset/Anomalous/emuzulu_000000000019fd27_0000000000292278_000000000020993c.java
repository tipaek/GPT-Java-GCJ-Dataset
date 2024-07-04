import java.util.*;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Reading the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Calculating the trace
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Checking for duplicate rows
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != size) {
                    duplicateRows++;
                }
            }

            // Checking for duplicate columns
            for (int j = 0; j < size; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != size) {
                    duplicateColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, duplicateRows, duplicateColumns);
        }
    }
}