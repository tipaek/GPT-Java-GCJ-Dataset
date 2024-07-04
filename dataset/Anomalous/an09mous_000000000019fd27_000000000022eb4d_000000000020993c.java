import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    rowCount++;
                }
            }

            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colCount++;
                }
            }

            out.println("Case #" + test + ": " + trace + " " + rowCount + " " + colCount);
        }

        out.flush();
        out.close();
    }
}