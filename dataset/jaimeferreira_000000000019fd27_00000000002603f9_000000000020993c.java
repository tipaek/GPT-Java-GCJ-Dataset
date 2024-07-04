import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static void solve(int testCase, int[][] matrix) {
        int matrixSize = matrix.length;

        int trace = 0;
        int numUnnaturalRows = 0;
        int numUnnaturalCols = 0;

        Set<Integer> col;
        Set<Integer> row;

        for (int j = 0; j < matrixSize; j++) {
            col = new HashSet<>();
            row = new HashSet<>();
            for (int k = 0; k < matrixSize; k++) {
                if (j == k)
                    trace += matrix[j][k];

                row.add(matrix[j][k]);
                col.add(matrix[k][j]);
            }

            if (row.size() != matrixSize)
                numUnnaturalRows++;

            if (col.size() != matrixSize)
                numUnnaturalCols++;
        }

        System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + numUnnaturalRows + " " + numUnnaturalCols);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numTestCases = in.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            solve(i, matrix);
        }
    }
}
