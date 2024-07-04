

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            long trace = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j)
                        trace += arr[i][j];
                }
            int rows = 0, cols = 0;
            boolean[] row_stat = new boolean[n], col_stat = new boolean[n];
            Arrays.fill(row_stat, true);
            Arrays.fill(col_stat, true);
            for (int i = 0; i < n; i++) {
                Set<Integer> row = new HashSet<>(), col = new HashSet<>();
                for (int m = 0; m < n; m++) {
                    if (row.contains(arr[i][m]))
                        row_stat[i] = false;
                    else
                        row.add(arr[i][m]);
                }
                for (int p = 0; p < n; p++) {
                    if (col.contains(arr[p][i]))
                        col_stat[i] = false;
                    else
                        col.add(arr[p][i]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (!row_stat[i])
                    rows++;
                if (!col_stat[i])
                    cols++;
            }
            System.out.println("Case #" + (k + 1) + ": " + trace + " " + rows + " " + cols);
        }
    }
}
