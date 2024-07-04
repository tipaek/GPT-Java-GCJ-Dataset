import java.util.*;
import java.io.*;

public class Vestigium {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            boolean[] rowCheck = new boolean[n];
            boolean[] colCheck = new boolean[n];
            boolean[][] rowTracker = new boolean[n][n];
            boolean[][] colTracker = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(rowCheck, false);
                Arrays.fill(colCheck, false);

                for (int j = 0; j < n; j++) {
                    int value = nextInt() - 1;

                    if (i == j) {
                        trace += value + 1;
                    }

                    if (rowTracker[i][value]) {
                        if (!rowCheck[i]) {
                            rowRepeats++;
                            rowCheck[i] = true;
                        }
                    } else {
                        rowTracker[i][value] = true;
                    }

                    if (colTracker[value][j]) {
                        if (!colCheck[j]) {
                            colRepeats++;
                            colCheck[j] = true;
                        }
                    } else {
                        colTracker[value][j] = true;
                    }
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}