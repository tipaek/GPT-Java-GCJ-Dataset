import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            long l = input.nextLong();
            long r = input.nextLong();

//            long ll = l;
//            long rr = r;
//            for (int i = 1; true; i++) {
//                if (ll >= rr && ll >= i)
//                    ll -= i;
//                else if (rr > ll && rr >= i)
//                    rr -= i;
//                else {
//                    System.out.println((i - 1) + " " + ll + " " + rr);
//                    break;
//                }
//            }

            long n;
            if (r >= l) {
                n = (long) Math.ceil((Math.sqrt(1 + 8 * (r - l)) - 1) / 2);
                r -= n * (n + 1) / 2;
                if (r < 0) {
                    r += n;
                    n--;
                }
            } else {
                n = (long) Math.ceil((Math.sqrt(1 + 8 * (l - r)) - 1) / 2);
                l -= n * (n + 1) / 2;
                if (l < 0) {
                    l += n;
                    n--;
                }
            }

            if (l >= r) {
                // start on left
                long k1 = (long) (Math.sqrt(1. * n * n + 4. * l) - n) / 2;
                long k2 = (long) (Math.sqrt(1. * (n + 1) * (n + 1) + 4. * r) - (n + 1)) / 2;
//                System.out.println(n + " " + l + " " + r + " " + k1 + " " + k2);
                if (k1 > k2) {
                    // left k2+1, right k2
                    l -= (k2 + 1) * (n + (k2 + 1));
                    r -= k2 * (n + k2 + 1);
                    System.out.printf("Case #%d: %s %s %s\n", caseNum, n + 2 * (k2 + 1) - 1, l, r);
                } else {
                    // left k1, right k1
                    l -= k1 * (n + k1);
                    r -= k1 * (n + k1 + 1);
                    System.out.printf("Case #%d: %s %s %s\n", caseNum, n + 2 * k1, l, r);
                }
            } else {
                // start on right
                long k1 = (long) (Math.sqrt(1. * n * n + 4. * r) - n) / 2;
                long k2 = (long) (Math.sqrt(1. * (n + 1) * (n + 1) + 4. * l) - (n + 1)) / 2;
//                System.out.println(n + " " + l + " " + r + " " + k1 + " " + k2);
                if (k1 > k2) {
                    // right k2+1, left k2
                    r -= (k2 + 1) * (n + (k2 + 1));
                    l -= k2 * (n + k2 + 1);
                    System.out.printf("Case #%d: %s %s %s\n", caseNum, n + 2 * (k2 + 1) - 1, l, r);
                } else {
                    // right k1, left k1
                    r -= k1 * (n + k1);
                    l -= k1 * (n + k1 + 1);
                    System.out.printf("Case #%d: %s %s %s\n", caseNum, n + 2 * k1, l, r);
                }
            }
        }
    }
}
