import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int caseNumber, Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        int trace = calculateTrace(matrix);
        int repeatedRows = countRepeatedRows(matrix);
        int repeatedCols = countRepeatedCols(matrix);

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedCols);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeatedCount = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int value : row) {
                if (!uniqueElements.add(value)) {
                    repeatedCount++;
                    break;
                }
            }
        }
        return repeatedCount;
    }

    private static int countRepeatedCols(int[][] matrix) {
        int repeatedCount = 0;
        int size = matrix.length;

        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedCount++;
                    break;
                }
            }
        }
        return repeatedCount;
    }
}