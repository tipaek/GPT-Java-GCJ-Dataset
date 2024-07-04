import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, size);
            int diagonalSum = calculateDiagonalSum(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);
            printResult(caseNum, diagonalSum, duplicateRows, duplicateColumns);
        }
        scanner.close();
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        Set<Integer> uniqueElements = new TreeSet<>();
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            uniqueElements.clear();
            for (int col = 0; col < size; col++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        Set<Integer> uniqueElements = new TreeSet<>();
        int duplicateColumns = 0;
        for (int col = 0; col < size; col++) {
            uniqueElements.clear();
            for (int row = 0; row < size; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < size) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static void printResult(int caseNum, int diagonalSum, int duplicateRows, int duplicateColumns) {
        System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
    }
}