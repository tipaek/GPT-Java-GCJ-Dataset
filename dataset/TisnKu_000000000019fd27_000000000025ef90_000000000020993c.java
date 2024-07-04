import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            solve(i, n, matrix);
        }
    }

    private static void solve(int caseNumber, int n, int[][] matrix) {
        int rowCount = 0, columnCount = 0, diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
            Set<Integer> numberSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (numberSet.contains(matrix[i][j])){
                    rowCount++;
                    break;
                }
                numberSet.add(matrix[i][j]);
            }
            numberSet.clear();
            for (int j = 0; j < n; j++) {
                if (numberSet.contains(matrix[j][i])){
                    columnCount++;
                    break;
                }
                numberSet.add(matrix[j][i]);
            }
        }
        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowCount + " " + columnCount);
    }
}
