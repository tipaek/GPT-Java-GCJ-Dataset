import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String... args) throws Exception {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int sum = 0;
        int current = 0;
        StringBuilder caseOutput;

        boolean rowDuplicates[] = null;
        boolean wasRowDup = false;
        int dupRows = 0;

        boolean[][] colDuplicates = null;
        boolean[] colDupFlags = null;
        int dupCols = 0;

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            caseOutput = new StringBuilder("Case #").append(i).append(": ");
            colDuplicates = new boolean[n][n];
            colDupFlags = new boolean[n];
            dupRows = 0;
            dupCols = 0;
            sum = 0;
            for (int j = 0; j < n; j++) {
                rowDuplicates = new boolean[n];
                wasRowDup = false;
                for (int k = 0; k < n; k++) {
                    current = in.nextInt();
                    if (j == k)
                        sum += current;

                    if (rowDuplicates[current - 1] && !wasRowDup) {
                        wasRowDup = true;
                        dupRows++;
                    }

                    if (colDuplicates[k][current - 1] && !colDupFlags[k]) {
                        colDupFlags[k] = true;
                        dupCols++;
                    }
                    colDuplicates[k][current - 1] = true;
                    rowDuplicates[current - 1] = true;
                }

            }

            System.out.println(caseOutput.append(sum).append(" ").append(dupRows).append(" ").append(dupCols));
        }
    }
}