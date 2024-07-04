import java.util.Scanner;

public class Solution {

    public static String solve(int[][] m, int n) {
        int k = 0;
        for (int i=0; i<n; i++) {
            k += m[i][i];
        }
        // repeated row
        int r = 0;
        for (int i=0; i<n; i++) {
            boolean[] row = new boolean [n];
            for (int j=0; j<n; j++) {
                if (row[m[i][j] - 1]) {
                    r++;
                    break;
                } else {
                    row[m[i][j] - 1] = true;
                }
            }
        }
        // repeated column
        int c = 0;
        for (int j=0; j<n; j++) {
            boolean[] col = new boolean [n];
            for (int i=0; i<n; i++) {
                if (col[m[i][j] - 1]) {
                    c++;
                    break;
                } else {
                    col[m[i][j] - 1] = true;
                }
            }
        }
        return String.format("%d %d %d", k, r, c);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int i=0; i<t; i++) {
                int n = sc.nextInt();
                int[][] m = new int [n][n];
                for (int j=0; j<n; j++) {
                    for (int k=0; k<n; k++) {
                        m[j][k] = sc.nextInt();
                    }
                }
                String sol = solve(m, n);
                System.out.printf("Case #%s: %s%n", i+1, sol);
            }
        }
    }

}
