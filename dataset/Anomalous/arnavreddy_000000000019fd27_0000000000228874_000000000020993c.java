import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    mat[r][c] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + calculateTrace(mat, n) + " " + countDuplicateRows(mat, n) + " " + countDuplicateCols(mat, n));
        }
    }

    public static long calculateTrace(int[][] mat, int n) {
        long trace = 0;
        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }
        return trace;
    }

    public static int countDuplicateRows(int[][] mat, int n) {
        int duplicateRowCount = 0;
        for (int r = 0; r < n; r++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int c = 0; c < n; c++) {
                if (!uniqueElements.add(mat[r][c])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    public static int countDuplicateCols(int[][] mat, int n) {
        int duplicateColCount = 0;
        for (int c = 0; c < n; c++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int r = 0; r < n; r++) {
                if (!uniqueElements.add(mat[r][c])) {
                    duplicateColCount++;
                    break;
                }
            }
        }
        return duplicateColCount;
    }
}