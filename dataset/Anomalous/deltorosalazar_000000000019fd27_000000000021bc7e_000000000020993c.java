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

            // Initialize columns tracking
            List<Set<Integer>> columns = new ArrayList<>();
            for (int i = 0; i < matrixSize; i++) {
                columns.add(new HashSet<>());
            }

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    // Diagonal
                    if (row == col) {
                        diagonalSum += value;
                    }

                    // Rows
                    if (!rowSet.add(value)) {
                        rowHasDuplicate = true;
                    }

                    // Columns
                    if (!columns.get(col).add(value)) {
                        columnsWithRepeatedNumbers++;
                        columns.set(col, new HashSet<>()); // Reset the column to avoid counting multiple duplicates
                    }
                }

                if (rowHasDuplicate) {
                    rowsWithRepeatedNumbers++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowsWithRepeatedNumbers + " " + columnsWithRepeatedNumbers);
        }
    }
}