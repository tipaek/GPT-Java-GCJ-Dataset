import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();

            int sum = n * (n + 1) / 2;
            if ((n == 2 || sum != k) && (k < n || k % n != 0)) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            int [][] res = new int[n][n];

            if (sum == k) {
                for (int m = 0; m < n; m++) {
                    res[m][m] = n - m;
                }

                for (int m = 0; m < n; m++) {
                    int[] row = res[m];
                    int start = (m + 1) % n;
                    int num = row[m];
                    while (start != m) {
                        num++;
                        num = num > n ? 1 : num;
                        row[start] = num;
                        start = (start + 1) % n;
                    }
                }

            } else {
                int nm = k / n;
                for (int m = 0; m < n; m++) {
                    res[m][m] = nm;
                }

                for (int m = 0; m < n; m++) {
                    int[] row = res[m];
                    int start = (m + 1) % n;
                    int num = 1;
                    while (start != m) {
                        if (num == nm) {
                            num++;
                        }
                        num = num > n ? 1 : num;
                        row[start] = num;
                        start = (start + 1) % n;
                        num++;
                    }
                }
            }

            System.out.println("Case #" + i + ": POSSIBLE");

            for (int m = 0; m < n; m++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[m][j] + " ");
                }
                System.out.println();
            }
        }
    }
}