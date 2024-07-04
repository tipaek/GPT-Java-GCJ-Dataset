import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
            System.out.printf("Case #%d: %d %d %d%n", i, calculateTrace(mat, n), countDuplicateRows(mat, n), countDuplicateCols(mat, n));
        }
        in.close();
    }

    public static long calculateTrace(int[][] mat, int n) {
        long trace = 0;
        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }
        return trace;
    }

    public static int countDuplicateCols(int[][] mat, int n) {
        int count = 0;
        for (int c = 0; c < n; c++) {
            Set<Integer> seen = new HashSet<>();
            for (int r = 0; r < n; r++) {
                if (!seen.add(mat[r][c])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int countDuplicateRows(int[][] mat, int n) {
        int count = 0;
        for (int r = 0; r < n; r++) {
            Set<Integer> seen = new HashSet<>();
            for (int c = 0; c < n; c++) {
                if (!seen.add(mat[r][c])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}