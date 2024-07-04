import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int n = Integer.parseInt(in.next());
            int[][] matrix = new int[n][n];
            for (int k = 0; k < n; k++) {
                for (int g = 0; g < n; g++) {
                    matrix[k][g] = Integer.parseInt(in.next());
                }
            }

            int total = 0;
            int totalRows = 0;
            int totalCols = 0;
            for (int q = 0; q < n; q++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                for (int w = 0; w < n; w++) {
                    if (q == w) {
                        total += matrix[q][w];
                    }
                    rowSet.add(matrix[q][w]);
                    colSet.add(matrix[w][q]);
                }
                if (rowSet.size() != n) {
                    totalRows++;
                }
                if (colSet.size() != n) {
                    totalCols++;
                }
            }

            System.out.println("Case #" + i + ": " + total +" "+totalRows+" "+totalCols);
        }
    }
}