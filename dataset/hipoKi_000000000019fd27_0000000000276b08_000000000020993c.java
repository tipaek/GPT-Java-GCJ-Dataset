import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int c = 1; c <= t; ++c) {

            int N = in.nextInt();
            boolean[][] columnContains = new boolean[N][10];
            boolean[][] rowContains = new boolean[N][10];
            boolean[] badRow = new boolean[N];
            boolean[] badColumn = new boolean[N];

            int trace = 0;
            for (int i = 0;  i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int number = in.nextInt();
                    if (i == j) {
                        trace += number;
                    }
                    if (columnContains[j][number]) {
                        badColumn[j] = true;
                    }
                    if (rowContains[i][number]) {
                        badRow[i] = true;
                    }
                    columnContains[j][number] = true;
                    rowContains[i][number] = true;
                }
            }
            int rows = 0;
            int columns = 0;
            for (int i = 0; i < N; i++) {
                rows += badRow[i]? 1 : 0;
                columns += badColumn[i]? 1 : 0;
            }
            out.println(String.format("Case #%d: %d %d  %d", c, trace, rows, columns));
        }
    }

}
