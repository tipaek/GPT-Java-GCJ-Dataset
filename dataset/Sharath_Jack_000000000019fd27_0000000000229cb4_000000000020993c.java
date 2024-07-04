import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static String solve(Scanner s) {
        int n = s.nextInt();
        int a[][] = new int[n][n];
        int ansR = 0;
        int ansC = 0;
        int trace = 0;
        for (int i = 0; i < n; i++) {
            int[] rowMap = new int[n + 1];
            boolean ansRow = true;
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
                if (i == j) trace += a[i][j];
                if (rowMap[a[i][j]] != 0) {
                    ansRow = false;
                } else {
                    rowMap[a[i][j]] = 1;
                }
            }
            if (!ansRow) {
                ansR++;
            }
        }
        for (int j = 0; j < n; j++) {
            int colMap[] = new int[n + 1];
            boolean ansCol = true;
            for (int i = 0; i < n; i++) {
                if (colMap[a[i][j]] != 0) {
                    ansCol = false;
                } else {
                    colMap[a[i][j]] = 1;
                }
            }
            if (!ansCol) {
                ansC++;
            }
        }
        return trace + " " + ansR + " " + ansC;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve(s));
        }
    }
}
