import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            boolean[][] rowTracker = new boolean[n][n];
            boolean[][] colTracker = new boolean[n][n];

            boolean[] rowDuplicates = new boolean[n];
            boolean[] colDuplicates = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = sc.nextInt();
                    if (i == j) {
                        trace += num;
                    }

                    if (rowTracker[i][num - 1]) {
                        if (!rowDuplicates[i]) {
                            rowRepeats++;
                        }
                        rowDuplicates[i] = true;
                    }
                    if (colTracker[num - 1][j]) {
                        if (!colDuplicates[j]) {
                            colRepeats++;
                        }
                        colDuplicates[j] = true;
                    }
                    rowTracker[i][num - 1] = true;
                    colTracker[num - 1][j] = true;
                }
            }

            pw.printf("Case #%d: %d %d %d\n", testCase, trace, rowRepeats, colRepeats);
            pw.flush();
        }

        pw.close();
        sc.close();
    }
}