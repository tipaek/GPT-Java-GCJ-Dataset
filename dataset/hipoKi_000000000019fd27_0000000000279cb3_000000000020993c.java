import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


        boolean[][] columnContains = new boolean[101][102];
        boolean[][] rowContains = new boolean[101][102];
        boolean[] badRow = new boolean[101];
        boolean[] badColumn = new boolean[101];

        for (int c = 1; c <= t; ++c) {
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 102; j++) {
                    columnContains[i][j] =  false;
                    rowContains[i][j] =  false;
                }
                badRow[i] = false;
                badColumn[i] = false;
            }

            int N = in.nextInt();

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
            out.println(String.format("Case #%d: %d %d %d", c, trace, rows, columns));
        }
    }

}
