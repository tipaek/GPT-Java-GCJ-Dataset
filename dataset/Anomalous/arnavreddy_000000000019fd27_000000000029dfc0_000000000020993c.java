import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            System.out.print("Case #" + testCase + ": ");
            System.out.print(calculateTrace(matrix, size) + " ");
            System.out.print(countDuplicateRows(matrix, size) + " ");
            System.out.println(countDuplicateCols(matrix, size));
        }
    }

    public static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;

        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }

        return duplicateRowCount;
    }

    public static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateColCount = 0;

        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColCount++;
                    break;
                }
            }
        }

        return duplicateColCount;
    }
}