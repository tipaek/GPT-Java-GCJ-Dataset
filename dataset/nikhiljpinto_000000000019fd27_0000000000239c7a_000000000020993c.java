import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int t = 1; t <= tests; t++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int k = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rows = new HashSet<Integer>();
                boolean duplicateRows = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    if (rows.contains(matrix[i][j])) duplicateRows = true;
                    rows.add(matrix[i][j]);
                }
                k += matrix[i][i];
                if (duplicateRows) r++;
            }
            for (int i = 0; i < n; i++) {
                HashSet<Integer> cols = new HashSet<Integer>();
                boolean duplicateCols = false;
                for (int j = 0; j < n; j++) {
                    if (cols.contains(matrix[j][i])) duplicateCols = true;
                    cols.add(matrix[j][i]);
                }
                if (duplicateCols) c++;
            }
            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }
}