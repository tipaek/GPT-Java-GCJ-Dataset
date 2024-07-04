import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            int k = 0;
            int r = 0;
            int c = 0;
            for (int i2 = 0; i2 < n; i2++) {
                for (int i3 = 0; i3 < n; i3++) {
                    m[i2][i3] = in.nextInt();
                }
                k += m[i2][i2];
                for (int i3 = 1; i3 < n; i3++) {
                    boolean b = false;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if(m[i2][i3] == m[i2][i4]) {
                            r++;
                            b = true;
                            break;
                        }
                    }
                    if (b) break;
                }
            }
            for (int i2 = 0; i2 < n; i2++) {
                for (int i3 = 1; i3 < n; i3++) {
                    boolean b = false;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if(m[i3][i2] == m[i4][i2]) {
                            c++;
                            b = true;
                            break;
                        }
                    }
                    if (b) break;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i, k, r, c);
        }
        in.close();
    }
}