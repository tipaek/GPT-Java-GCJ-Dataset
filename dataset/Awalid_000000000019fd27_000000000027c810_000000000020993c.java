import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        int currentCase = 1;
        while (cases-- > 0) {
            int n = in.nextInt();
            int k = 0, r = 0, c = 0;
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j)
                        k += matrix[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                Set<Integer> row = new HashSet<>();
                Set<Integer> col = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    row.add(matrix[i][j]);
                    col.add(matrix[j][i]);
                }
                if (row.size() != n)
                    r++;
                if (col.size() != n)
                    c++;
            }
            System.out.println("Case #" + currentCase++ + ": " + k + " " + r + " " + c);
        }
    }
}