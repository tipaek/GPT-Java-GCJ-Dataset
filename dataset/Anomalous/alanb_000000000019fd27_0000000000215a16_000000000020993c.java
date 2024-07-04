import java.io.*;
import java.util.*;

public class Vest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            HashSet<Integer> uniqueElements = new HashSet<>(matrixSize);

            // Reading the matrix and calculating trace and row duplicates
            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    matrix[rowIndex][colIndex] = scanner.nextInt();
                    uniqueElements.add(matrix[rowIndex][colIndex]);
                    if (rowIndex == colIndex) {
                        trace += matrix[rowIndex][colIndex];
                    }
                }
                if (uniqueElements.size() < matrixSize) {
                    rowDuplicates++;
                }
                uniqueElements.clear();
            }

            // Calculating column duplicates
            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                    uniqueElements.add(matrix[rowIndex][colIndex]);
                }
                if (uniqueElements.size() < matrixSize) {
                    columnDuplicates++;
                }
                uniqueElements.clear();
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }
}