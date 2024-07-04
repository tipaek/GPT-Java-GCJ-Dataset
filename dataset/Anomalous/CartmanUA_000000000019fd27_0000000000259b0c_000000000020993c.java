import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            processAndPrintResult(testCase, matrix);
        }
    }

    private static void processAndPrintResult(int testCase, int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];

            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }

            if (hasColumnDuplicates(matrix, i)) {
                colDuplicates++;
            }
        }

        System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] matrix, int colIndex) {
        boolean[] seen = new boolean[matrix.length + 1];
        for (int[] row : matrix) {
            if (seen[row[colIndex]]) {
                return true;
            }
            seen[row[colIndex]] = true;
        }
        return false;
    }
}