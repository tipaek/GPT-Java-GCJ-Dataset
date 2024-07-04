import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        try {
            br = new BufferedReader(new FileReader("G:\\Workspace\\CompetitiveProgramming\\custom.txt"));
        } catch (Exception e) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int t = readInt();
        while (t-- > 0) {
            int n = readInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                String[] row = readStringArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedCols = countRepeatedCols(matrix, n);

            System.out.println(trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    private static String[] readStringArray() throws IOException {
        return br.readLine().trim().split("\\s+");
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;

        for (int i = 0; i < n; i++) {
            int[] count = new int[n + 1];
            for (int j = 0; j < n; j++) {
                count[matrix[i][j]]++;
            }
            if (hasRepetition(count, n)) {
                repeatedRows++;
            }
        }

        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix, int n) {
        int repeatedCols = 0;

        for (int i = 0; i < n; i++) {
            int[] count = new int[n + 1];
            for (int j = 0; j < n; j++) {
                count[matrix[j][i]]++;
            }
            if (hasRepetition(count, n)) {
                repeatedCols++;
            }
        }

        return repeatedCols;
    }

    private static boolean hasRepetition(int[] count, int n) {
        for (int i = 1; i <= n; i++) {
            if (count[i] > 1) {
                return true;
            }
        }
        return false;
    }
}