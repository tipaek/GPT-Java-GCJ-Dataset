import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            boolean[][] rowCheck = new boolean[n][n];
            boolean[][] colCheck = new boolean[n][n];

            boolean[] rowDuplicate = new boolean[n];
            boolean[] colDuplicate = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    if (i == j) {
                        trace += value;
                    }

                    if (rowCheck[i][value - 1]) {
                        if (!rowDuplicate[i]) {
                            rowRepeats++;
                        }
                        rowDuplicate[i] = true;
                    }

                    if (colCheck[value - 1][j]) {
                        if (!colDuplicate[j]) {
                            colRepeats++;
                        }
                        colDuplicate[j] = true;
                    }

                    rowCheck[i][value - 1] = true;
                    colCheck[value - 1][j] = true;
                }
            }

            pw.printf("Case #%d: %d %d %d\n", testCase, trace, rowRepeats, colRepeats);
            pw.flush();
        }

        pw.close();
        sc.close();
    }
}