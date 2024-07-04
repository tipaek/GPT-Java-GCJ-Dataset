import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] m = new int[n][n];
            int[][] rn = new int[n][n+1];
            int[][] cn = new int[n][n+1];
            int trace = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    m[r][c] = scanner.nextInt();
                    rn[r][m[r][c]]++;
                    cn[c][m[r][c]]++;
                    if (r == c) {
                        trace += m[r][c];
                    }
                }
            }
            int rr = 0;
            int cc = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 1; c <= n; c++) {
                    if (rn[r][c] == 0 || rn[r][c] > 1) {
                        rr++;
                        break;
                    }
                }
            }
            for (int c = 0; c < n; c++) {
                for (int r = 1; r <= n; r++) {
                    if (cn[c][r] == 0 || cn[c][r] > 1) {
                        cc++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + rr + " " + cc);
        }
    }
}

