package GoogleCodeJam2020;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    // Checks if a row has repeated numbers
    static boolean hasRowRepeated(int[][] matrix, int rowIndex, int size) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int col = 0; col < size; col++) {
            uniqueElements.add(matrix[rowIndex][col]);
        }
        return uniqueElements.size() != size;
    }

    // Checks if a column has repeated numbers
    static boolean hasColRepeated(int[][] matrix, int colIndex, int size) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int row = 0; row < size; row++) {
            if (!uniqueElements.add(matrix[row][colIndex])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for repeated numbers in rows
            for (int row = 0; row < size; row++) {
                if (hasRowRepeated(matrix, row, size)) {
                    rowRepeats++;
                }
            }

            // Check for repeated numbers in columns
            for (int col = 0; col < size; col++) {
                if (hasColRepeated(matrix, col, size)) {
                    colRepeats++;
                }
            }

            // Print the result for the current case
            System.out.format("Case #%d: %d %d %d\n", caseIndex + 1, trace, rowRepeats, colRepeats);
        }
        
        scanner.close();
    }
}