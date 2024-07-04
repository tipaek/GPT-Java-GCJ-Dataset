import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution{
        public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = getNums(in, n);
            System.out.println("Case #" + i + ": " + getData(matrix, n));
        }
    }

    private static int[][] getNums(Scanner sc, int n) {
        int[][] matrix = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = sc.nextInt();
            }
        }
        return matrix;
    }

    private static String getData(int[][] matrix, int n) {
        int trace = 0, row = 0, col = 0;
        Set<Integer>[] cols = new HashSet[n];
        boolean[] colRepeat = new boolean[n];
        for (int i = 0; i < n; i++) {
            cols[i] = new HashSet<>();
        }
        for (int r = 0; r < n; r++) {
            Set<Integer> rowVals = new HashSet<>();
            boolean rowRepeat = false;
            for (int c = 0; c < n; c++) {
                if (r == c) {
                    trace += matrix[r][c];
                }
                if (rowVals.contains(matrix[r][c])) {
                    rowRepeat = true;
                }
                rowVals.add(matrix[r][c]);
                if (cols[c].contains(matrix[r][c])) {
                    colRepeat[c] = true;
                }
                cols[c].add(matrix[r][c]);
            }
            if (rowRepeat) {
                row++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (colRepeat[i]) {
                col++;
            }
        }
        return trace+ " " + row + " " + col;
    }
}