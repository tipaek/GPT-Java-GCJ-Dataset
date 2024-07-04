import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();

        for (int t = 0; t < numberOfTestCases; t++) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];

        int trace = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        int duplicateRows = countDuplicateRows(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);

        System.out.println("Case #" + (testCaseNumber++) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();

            for (int j = 0; j < matrix[i].length; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }

        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();

            for (int j = 0; j < matrix.length; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }

        return duplicateColumnCount;
    }
}