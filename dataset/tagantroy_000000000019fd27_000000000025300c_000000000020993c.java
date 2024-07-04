import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int t = 1; t <= tests; ++t) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int k = trace(matrix);
            int r = checkRows(matrix);
            int c = checkCols(matrix);

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }

    private static int trace(int[][] matrix) {
        int n = matrix.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += matrix[i][i];
        }
        return res;
    }

    private static int checkRows(int[][] matrix) {
        int n = matrix.length;
        int result = 0;
        for (int r = 0; r < n; r++) {
            HashSet<Integer> set = new HashSet<>();
            boolean containsDuplicates = false;
            for (int c = 0; c < n; c++) {
                int val = matrix[r][c];
                if (set.contains(val)) containsDuplicates = true;
                set.add(val);
            }
            if (containsDuplicates) result++;
        }
        return result;
    }

    private static int checkCols(int[][] matrix) {
        int n = matrix.length;
        int result = 0;
        for (int c = 0; c < n; c++) {
            HashSet<Integer> set = new HashSet<>();
            boolean containsDuplicates = false;
            for (int r = 0; r < n; r++) {
                int val = matrix[r][c];
                if (set.contains(val)) containsDuplicates = true;
                set.add(val);
            }
            if (containsDuplicates) result++;
        }
        return result;
    }
}