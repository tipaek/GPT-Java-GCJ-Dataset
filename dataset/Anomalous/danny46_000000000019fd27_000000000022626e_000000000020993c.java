import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] result = analyzeMatrix(size, matrix);
            System.out.println("Case #" + caseNumber + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static int[] analyzeMatrix(int size, int[][] matrix) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            if (containsDuplicates(matrix[i])) {
                rowDuplicates++;
            }
        }

        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (containsDuplicates(column)) {
                colDuplicates++;
            }
        }

        return new int[]{trace, rowDuplicates, colDuplicates};
    }

    private static boolean containsDuplicates(int[] array) {
        Set<Integer> seenElements = new HashSet<>();
        for (int element : array) {
            if (!seenElements.add(element)) {
                return true;
            }
        }
        return false;
    }
}