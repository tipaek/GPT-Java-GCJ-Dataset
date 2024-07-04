package codejam;

import java.util.HashSet;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases > 0) {
            int size = scanner.nextInt();
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;
            int[][] matrix = new int[size][size];

            // Read the matrix and calculate the trace
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != size) {
                    duplicateRows++;
                }
            }

            // Check for duplicate elements in columns
            for (int j = 0; j < size; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != size) {
                    duplicateColumns++;
                }
            }

            System.out.println(trace + " " + duplicateRows + " " + duplicateColumns);
            testCases--;
        }
    }
}