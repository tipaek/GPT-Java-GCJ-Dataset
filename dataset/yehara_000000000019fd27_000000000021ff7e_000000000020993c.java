import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        out = new PrintWriter(System.out);
        for (int t = 1; t <= count; t++) {
            out.print("Case #" + t + ": ");
            solve(s, out);
        }
        out.close();
    }

    static void solve(Scanner sc, PrintWriter out) {
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int tr = 0;
        int rows = 0;
        int cols = 0;

        for (int i = 0; i < n; i++) {
            tr += a[i][i];
        }
        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            for (int j = 0; j < n; j++) {
                row[a[i][j]-1]++;
                if(row[a[i][j]-1] > 1) {
                    rows++;
                    break;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[a[i][j]-1]++;
                if(col[a[i][j]-1] > 1) {
                    cols++;
                    break;
                }
            }
        }

        out.format("%d %d %d", tr, rows, cols);
        out.println();
    }

}
