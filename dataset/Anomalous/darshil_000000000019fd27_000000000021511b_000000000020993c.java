import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for row repeats
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }

    private static boolean hasDuplicates(int[] array) {
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] == sortedArray[i + 1]) {
                return true;
            }
        }
        return false;
    }
}