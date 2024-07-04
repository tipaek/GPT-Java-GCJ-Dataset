import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = nextInt();
            int repeatedRows = 0;
            int repeatedCols = 0;
            boolean[] rowHasDuplicate = new boolean[n];
            boolean[] colHasDuplicate = new boolean[n];
            boolean[][] rowElements = new boolean[n][n];
            boolean[][] colElements = new boolean[n][n];
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int element = nextInt() - 1;
                    if (i == j) {
                        diagonalSum += element + 1;
                    }
                    if (rowElements[i][element] && !rowHasDuplicate[i]) {
                        repeatedRows++;
                        rowHasDuplicate[i] = true;
                    } else {
                        rowElements[i][element] = true;
                    }
                    if (colElements[element][j] && !colHasDuplicate[j]) {
                        repeatedCols++;
                        colHasDuplicate[j] = true;
                    } else {
                        colElements[element][j] = true;
                    }
                }
            }
            System.out.println("case #" + caseNumber++ + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
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