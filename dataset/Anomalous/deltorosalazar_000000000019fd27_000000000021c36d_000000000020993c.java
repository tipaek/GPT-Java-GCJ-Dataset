import java.util.*;
import java.io.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; ++caseNumber) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int diagonalSum = 0;
            int rowsWithRepeatedNumbers = 0;
            int columnsWithRepeatedNumbers = 0;

            // Initialize column sets
            List<Set<Integer>> columnSets = new ArrayList<>();
            for (int i = 0; i < matrixSize; i++) {
                columnSets.add(new HashSet<>());
            }

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;

                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    // Diagonal sum
                    if (row == col) {
                        diagonalSum += value;
                    }

                    // Row check
                    if (!rowSet.add(value)) {
                        rowHasDuplicates = true;
                    }

                    // Column check
                    if (!columnSets.get(col).add(value)) {
                        if (columnSets.get(col) != null) {
                            columnSets.set(col, null);
                            columnsWithRepeatedNumbers++;
                        }
                    }
                }

                if (rowHasDuplicates) {
                    rowsWithRepeatedNumbers++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowsWithRepeatedNumbers + " " + columnsWithRepeatedNumbers);
        }
    }
}