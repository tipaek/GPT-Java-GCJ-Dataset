import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= testCases; i++) {
            output.append(runTestCase(i));
        }

        System.out.println(output);
    }

    public static String runTestCase(int caseNumber) {
        int size = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        return String.format("Case #%d: %d %d %d%n", caseNumber, calcTrace(matrix), countDuplicateRows(matrix), countDuplicateColumns(matrix));
    }

    public static int calcTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicate(row)) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    public static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicate(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    public static boolean hasDuplicate(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}