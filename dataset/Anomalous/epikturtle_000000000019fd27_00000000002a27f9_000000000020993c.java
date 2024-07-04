import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int sideLength = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[sideLength][sideLength];

            for (int row = 0; row < sideLength; row++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                for (int col = 0; col < sideLength; col++) {
                    matrix[row][col] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = calculateTrace(matrix, sideLength);
            int duplicateRows = countDuplicateRows(matrix, sideLength);
            int duplicateColumns = countDuplicateColumns(matrix, sideLength);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static int calculateTrace(int[][] matrix, int sideLength) {
        int trace = 0;
        for (int i = 0; i < sideLength; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int sideLength) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int sideLength) {
        int duplicateColumns = 0;
        for (int col = 0; col < sideLength; col++) {
            int[] column = new int[sideLength];
            for (int row = 0; row < sideLength; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : array) {
            if (!uniqueElements.add(element)) {
                return true;
            }
        }
        return false;
    }
}