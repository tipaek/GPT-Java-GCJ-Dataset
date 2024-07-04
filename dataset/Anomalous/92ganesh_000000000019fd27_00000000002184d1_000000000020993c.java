import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        initializeBufferedReader();
        StringBuilder sb = new StringBuilder();

        int t = readInt();
        int testNum = 1;
        while (t-- > 0) {
            int n = readInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                String[] row = readStringArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = parseInt(row[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedCols = countRepeatedCols(matrix, n);

            System.out.println("Case #" + testNum + ": " + trace + " " + repeatedRows + " " + repeatedCols);
            testNum++;
        }
    }

    private static void initializeBufferedReader() {
        try {
            br = new BufferedReader(new FileReader("G:\\Workspace\\CompetitiveProgramming\\custom.txt"));
        } catch (Exception e) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    private static int readInt() throws Exception {
        return Integer.parseInt(br.readLine().trim());
    }

    private static String[] readStringArray() throws Exception {
        return br.readLine().trim().split("\\s+");
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            if (hasRepeatedElements(matrix[i], n)) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix, int n) {
        int repeatedCols = 0;
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }
            if (hasRepeatedElements(col, n)) {
                repeatedCols++;
            }
        }
        return repeatedCols;
    }

    private static boolean hasRepeatedElements(int[] array, int n) {
        boolean[] seen = new boolean[n + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}