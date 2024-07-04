import java.util.*;
import java.io.*;

public class Solution {
    static int total = 0;
    static int duplicateRows = 0;
    static int duplicateCols = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int[][] transpose = new int[n][n];
            duplicateRows = 0;
            duplicateCols = 0;
            total = 0;

            for (int j = 0; j < n; ++j) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; ++k) {
                    matrix[j][k] = in.nextInt();
                    rowSet.add(matrix[j][k]);
                    transpose[k][j] = matrix[j][k];
                }
                if (rowSet.size() < n) {
                    duplicateRows++;
                }
            }

            calculateTraceAndDuplicates(matrix, n);
            calculateColumnDuplicates(transpose, n);

            System.out.println("Case #" + i + ": " + total + " " + duplicateRows + " " + duplicateCols);
        }
    }

    public static void calculateTraceAndDuplicates(int[][] matrix, int n) {
        for (int i = 0; i < n; ++i) {
            total += matrix[i][i];
        }
    }

    public static void calculateColumnDuplicates(int[][] transpose, int n) {
        for (int j = 0; j < n; ++j) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int k = 0; k < n; ++k) {
                colSet.add(transpose[j][k]);
            }
            if (colSet.size() < n) {
                duplicateCols++;
            }
        }
    }
}