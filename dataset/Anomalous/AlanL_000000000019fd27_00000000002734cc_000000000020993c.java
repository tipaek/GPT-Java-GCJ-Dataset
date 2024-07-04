import java.util.*;
import java.io.*;

public class CodeJam2020 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int testCases = readInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = readInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = readInt();
                    if (i == j) trace += matrix[i][j];
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) rowRepeats++;
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) colRepeats++;
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return input.readLine().trim();
    }
}