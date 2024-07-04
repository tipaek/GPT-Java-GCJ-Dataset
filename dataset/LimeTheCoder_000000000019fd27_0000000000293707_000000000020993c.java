import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            int trace = 0;
            for (int k = 0; k < n; k++) {
                for (int m = 0; m < n; m++) {
                    mat[k][m] = in.nextInt();

                    if (k == m) {
                        trace += mat[k][m];
                    }
                }
            }

            int rowCnt = 0;
            for (int k = 0; k < n; k++) {
                int[] row = mat[k];
                boolean[] r = new boolean[n];
                for (int m = 0; m < n; m++) {
                    int num = row[m];
                    if (r[num - 1]) {
                        rowCnt++;
                        break;
                    }
                    r[num - 1] = true;
                }
            }

            int colCnt = 0;
            for (int k = 0; k < n; k++) {
                boolean[] r = new boolean[n];
                for (int m = 0; m < n; m++) {
                    int num = mat[m][k];
                    if (r[num - 1]) {
                        colCnt++;
                        break;
                    }
                    r[num - 1] = true;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowCnt + " " + colCnt);
        }
    }
}