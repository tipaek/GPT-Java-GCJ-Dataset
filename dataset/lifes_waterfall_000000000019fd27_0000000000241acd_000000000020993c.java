import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();

            int trace = 0;
            int column = 0;
            int row = 0;

            int[][] mArray = new int[n][n];
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int m = in.nextInt();
                    if (i == j) {
                        trace += m;
                    }
                    rowSet.add(m);
                    mArray[i][j] = m;
                }
                if (rowSet.size() < n) {
                    row++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    columnSet.add(mArray[i][j]);
                }
                if (columnSet.size() < n) {
                    column++;
                }
            }
            System.out.println("Case #" + x + ": " + trace + " " + row + " " + column);
        }
    }
}