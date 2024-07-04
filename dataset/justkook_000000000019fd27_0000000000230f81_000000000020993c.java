import java.util.*;
import java.io.*;

public class Solution {
    static int ROW = 0;
    static int COLUMN = 1;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ti = 1; ti <= t; ++ti) {
            int n = in.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            boolean[][] duplicated = new boolean[2][n];
            Set<Integer> row = null;
            Set<Integer>[] columnsAtRow = new Set[n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    int el = in.nextInt();
                    if (i == j) k += el;
                    if ( i == 0 )  {
                        columnsAtRow[j] = new HashSet<Integer>(n);
                    }
                    if (j == 0) {
                        row = new HashSet<>(n);
                    }
                    if ( !duplicated[ROW][i] && row.contains(el) ) {
                        r++;
                        duplicated[ROW][i] = true;
                    } else {
                        row.add(el);
                    }
                    if ( !duplicated[COLUMN][j] && columnsAtRow[j].contains(el) ) {
                        c++;
                        duplicated[COLUMN][j] = true;
                    } else {
                        columnsAtRow[j].add(el);
                    }
                }
            }
            System.out.println("Case #" + ti + ": " + k + " " + r + " " + c);
        }
    }
}