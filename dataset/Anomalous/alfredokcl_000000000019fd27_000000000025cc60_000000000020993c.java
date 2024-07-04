import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = readMatrix(scanner, size);
            int trace = calculateTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] rowValues = scanner.nextLine().trim().split("\\s+");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(rowValues[j]);
            }
        }
        return matrix;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicates = false;
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    hasDuplicates = true;
                }
            }
            if (hasDuplicates) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicates = false;
            for (int i = 0; i < size; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    hasDuplicates = true;
                }
            }
            if (hasDuplicates) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
    }
}