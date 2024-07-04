import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int ver = 0;
            int n = in.nextInt();
            int cols[][] = new int[n][n];
            int r = 0;
            for(int i = 0; i < n; i++) {
                int rows[] = new int[n];
                for(int j = 0; j < n; j++) {
                    int num = in.nextInt();
                    if (j == i) {
                        ver += num;
                    }
                    rows[num - 1] += 1;
                    cols[j][num - 1] += 1;
                }

                for(int j = 0; j < n; j++) {
                    if (rows[j] > 1) {
                        r ++;
                        break;
                    }
                }
            }

            int c = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (cols[i][j] > 1) {
                        c ++;
                        break;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", t, ver, r, c));
        }
    }
}
