import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int j = 1; j <= t; j++) {
            int N = in.nextInt(); // Size of the NxN matrix
            int[][] matrix = new int[N][N];
            int trace = 0, rowCount = 0, colCount = 0;

            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    matrix[i][k] = in.nextInt();
                    if (i == k) {
                        trace += matrix[i][k];
                    }
                }
            }

            // Check for duplicate entries in rows
            for (int i = 0; i < N; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowCount++;
                }
            }

            // Check for duplicate entries in columns
            for (int i = 0; i < N; i++) {
                int[] colArray = new int[N];
                for (int k = 0; k < N; k++) {
                    colArray[k] = matrix[k][i];
                }
                if (hasDuplicates(colArray)) {
                    colCount++;
                }
            }

            System.out.println("Case #" + j + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return true;
            }
        }
        return false;
    }
}