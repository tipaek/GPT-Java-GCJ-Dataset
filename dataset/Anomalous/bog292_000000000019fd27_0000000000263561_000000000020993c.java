import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            processTestCase(caseNumber, matrixSize, matrix);
        }
    }

    private static void processTestCase(int caseNumber, int matrixSize, int[][] matrix) {
        int diagonalSum = calculateDiagonalSum(matrixSize, matrix);
        int rowDuplicates = countRowDuplicates(matrixSize, matrix);
        int columnDuplicates = countColumnDuplicates(matrixSize, matrix);

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
    }

    private static int calculateDiagonalSum(int matrixSize, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrixSize; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRowDuplicates(int matrixSize, int[][] matrix) {
        int duplicates = 0;

        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < matrixSize; j++) {
                if (!seen.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }

            if (hasDuplicate) {
                duplicates++;
            }
        }

        return duplicates;
    }

    private static int countColumnDuplicates(int matrixSize, int[][] matrix) {
        int duplicates = 0;

        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < matrixSize; j++) {
                if (!seen.add(matrix[j][i])) {
                    hasDuplicate = true;
                }
            }

            if (hasDuplicate) {
                duplicates++;
            }
        }

        return duplicates;
    }
}