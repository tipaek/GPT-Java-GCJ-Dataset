import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        return 1L;
    }

    public static int[] vestigium(int[][] matrix) {
        int matrixSize = matrix.length;
        int k = 0, r = 0, c = 0;

        for (int i = 0; i < matrixSize; i++) {
            HashMap<Integer, Boolean> rowMap = new HashMap<>();
            HashMap<Integer, Boolean> colMap = new HashMap<>();
            boolean rowRepeat = false;
            boolean colRepeat = false;

            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    k += matrix[i][j];
                }

                if (rowMap.containsKey(matrix[i][j])) {
                    rowRepeat = true;
                } else {
                    rowMap.put(matrix[i][j], true);
                }

                if (colMap.containsKey(matrix[j][i])) {
                    colRepeat = true;
                } else {
                    colMap.put(matrix[j][i], true);
                }
            }

            if (rowRepeat) {
                r++;
            }

            if (colRepeat) {
                c++;
            }
        }

        return new int[]{k, r, c};
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int x = 0; x < matrixSize; x++) {
                for (int y = 0; y < matrixSize; y++) {
                    matrix[x][y] = scanner.nextInt();
                }
            }

            int[] res = vestigium(matrix);
            System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
        }

        scanner.close();
    }
}