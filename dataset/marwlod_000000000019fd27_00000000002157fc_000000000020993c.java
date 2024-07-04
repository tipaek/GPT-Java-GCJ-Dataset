import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; ++t) {
            int n = scanner.nextInt();
            int[][] grid = new int[n][n];
            int diagonal = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonal += grid[i][j];
                    }
                }
            }
            int rowRepeats = 0, columnRepeats = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowDistinct = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (rowDistinct.contains(grid[i][j])) {
                        rowRepeats++;
                        break;
                    }
                    rowDistinct.add(grid[i][j]);
                }
            }
            for (int i = 0; i < n; i++) {
                Set<Integer> columnDistinct = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (columnDistinct.contains(grid[j][i])) {
                        columnRepeats++;
                        break;
                    }
                    columnDistinct.add(grid[j][i]);
                }
            }
            System.out.println("Case #" + t + ": " + diagonal + " " + rowRepeats + " " + columnRepeats);
        }
    }
}