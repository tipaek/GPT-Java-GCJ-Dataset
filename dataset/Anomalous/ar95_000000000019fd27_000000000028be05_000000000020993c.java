import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace (sum of diagonal elements)
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Calculate the number of rows with duplicate elements
            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (rowSet.contains(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                    rowSet.add(matrix[i][j]);
                }
            }

            // Calculate the number of columns with duplicate elements
            int duplicateColumns = 0;
            for (int i = 0; i < size; i++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (columnSet.contains(matrix[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                    columnSet.add(matrix[j][i]);
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}