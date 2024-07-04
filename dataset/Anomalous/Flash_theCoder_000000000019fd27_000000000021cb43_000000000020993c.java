import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int k = 0; k < n; k++) {
            int arrSize = sc.nextInt();
            int[][] matrix = new int[arrSize][arrSize];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading matrix and checking row repeats
            for (int i = 0; i < arrSize; i++) {
                int[] row = new int[arrSize];
                for (int j = 0; j < arrSize; j++) {
                    int value = sc.nextInt();
                    matrix[i][j] = value;
                    row[j] = value;
                }
                if (hasDuplicates(row)) {
                    rowRepeats++;
                }
            }

            // Calculating trace
            for (int i = 0; i < arrSize; i++) {
                trace += matrix[i][i];
            }

            // Checking column repeats
            for (int j = 0; j < arrSize; j++) {
                int[] column = new int[arrSize];
                for (int i = 0; i < arrSize; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            // Output result
            System.out.println("Case #" + (k + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}