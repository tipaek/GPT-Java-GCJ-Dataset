import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int expectedSum = n * (n + 1) / 2;
            int[] referenceArray = new int[n];

            for (int i = 0; i < n; i++) {
                referenceArray[i] = i + 1;
            }

            for (int i = 0; i < n; i++) {
                int rowSum = 0;
                int[] rowArray = new int[n];

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowSum += matrix[i][j];
                    rowArray[j] = matrix[i][j];
                }

                trace += matrix[i][i];

                if (rowSum != expectedSum || !isArrayPermutation(rowArray, referenceArray)) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < n; j++) {
                int colSum = 0;
                int[] colArray = new int[n];

                for (int i = 0; i < n; i++) {
                    colSum += matrix[i][j];
                    colArray[i] = matrix[i][j];
                }

                if (colSum != expectedSum || !isArrayPermutation(colArray, referenceArray)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static boolean isArrayPermutation(int[] array, int[] referenceArray) {
        Arrays.sort(array);
        return Arrays.equals(array, referenceArray);
    }
}