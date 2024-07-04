
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ravikumar Makwana
 */
class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        long T = scan.nextlong();
        for (long t = 1; t <= T; t++) {
            long n = scan.nextlong();
            long r = scan.nextlong();
            long a[][] = new long[n][n];
            long l;
            long z = 0;
            for (long k = 1; k <= n; k++) {
                for (long i = 0; i < n; i++) {
                    l = i + k;
                    if (l > n) {
                        l = l - n;
                    }
                    for (long j = 0; j < n; j++) {
                        if (l > n) {
                            l = 1;
                        }
                        a[i][j] = l++;
                    }
                }
                long sum1 = 0, sum2 = 0;
                for (long i = 0; i < n; i++) {
                    for (long j = 0; j < n; j++) {
                        if (i == j) {
                            sum1 += a[i][j];
                        }
                        if (i == n - j - 1) {
                            sum2 += a[i][j];
                        }
                    }
                }
                if (sum1 == r && sum2 == r) {
                    System.out.prlongln("Case #" + t + ": POSSIBLE");
                    for (long i = 0; i < n; i++) {
                        for (long j = 0; j < n; j++) {
                            System.out.prlong(a[i][j] + " ");
                        }
                        System.out.prlongln();
                    }
                    z = 1;
                    break;
                }
            }
            if (z == 0) {
                System.out.prlongln("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}
