import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int j = 0; j < matrixSize; ++j) {
                for (int k = 0; k < matrixSize; ++k) {
                    matrix[j][k] = in.nextInt();
                }
            }
            String result = solve(matrixSize, matrix);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(int matrixSize, int[][] k) {
        int trace = 0;
        int dupRows = 0;
        int dupCols = 0;
        Set<Integer> rowCheck = new HashSet<Integer>();
        Set<Integer> colCheck = new HashSet<Integer>();

        for (int l = 0; l < matrixSize; ++l) {
            trace += k[l][l];

            for (int m = 0; m < matrixSize; ++m) {
                rowCheck.add(k[l][m]);
                colCheck.add(k[m][l]);
            }

            if (rowCheck.size() < matrixSize) {
                dupRows++;
            }

            if (colCheck.size() < matrixSize) {
                dupCols++;
            }

            rowCheck.clear();
            colCheck.clear();
        }

        return String.join(" ", String.valueOf(trace), String.valueOf(dupRows), String.valueOf(dupCols));
    }
}
