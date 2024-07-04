import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int test = 1; test <= t; test++) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    m[j][k] = in.nextInt();
                }
            }

            int trace = 0;
            int wrongRows = 0;
            int wrongColumns = 0;

            for (int j = 0; j < n; j++) {
                trace += m[j][j];
            }

            for (int row = 0; row < n; row++) {
                Set<Integer> rowItems = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    rowItems.add(m[row][k]);
                }
                if (rowItems.size() != n) {
                    ++wrongRows;
                }
            }

            for (int column = 0; column < n; column++) {
                Set<Integer> columnItems = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    columnItems.add(m[k][column]);
                }
                if (columnItems.size() != n) {
                    ++wrongColumns;
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", test, trace, wrongRows, wrongColumns));
            
        }

    }
}
