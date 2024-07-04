import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %d %d %d";
        for (int cas = 1; cas <= n; cas++) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long x = Math.abs(r - l);
            long t = 1;
            long sum = 0;
//            t = helper(sum, x);
//            while (sum < x) {
//                sum += t;
//                t += 1;
//            }
//            if (l >= r) {
//                l -= sum;
//            } else {
//                r -= sum;
//            }
            while (l >= t || r >= t) {
                if (l >= r) {
                    l -= t;
                } else {
                    r -= t;
                }
                t++;
            }
            System.out.println(String.format(result, cas, t - 1, l, r));
        }
    }
}