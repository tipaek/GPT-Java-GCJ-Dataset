import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static int caseNumber = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            processTestCase(scanner);
        }
    }

    private static void processTestCase(Scanner scanner) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        // Reading matrix and calculating trace
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int value = scanner.nextInt();
                if (i == j) {
                    trace += value;
                }
                matrix[i][j] = value;
            }
        }

        // Checking for duplicate rows
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < matrixSize; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                duplicateRows++;
            }
        }

        // Checking for duplicate columns
        for (int j = 0; j < matrixSize; j++) {
            Set<Integer> columnSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int i = 0; i < matrixSize; i++) {
                if (!columnSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                duplicateColumns++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        caseNumber++;
    }
}