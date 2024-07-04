import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String input;
        String[] inputArray;
        input = br.readLine();
        final int T = Integer.parseInt(input);
        for (int t = 1; t <= T; t++) {
            input = br.readLine();
            inputArray = input.split(" ");

            long L = Long.parseLong(inputArray[0]);
            long R = Long.parseLong(inputArray[1]);
            long d = find(Math.abs(L - R), 1, 1000 * 1000 * 1000);
            long sum = d * (d + 1) / 2;
            //Phase 1
            if (L >= R) {
                L -= sum;
            } else {
                R -= sum;
            }
            //Phase 2
            if (L < R) {
                if (R >= (d + 1)) {
                    d++;
                    R -= d;
                }
            }
//            System.out.println(String.format("Case #%d: %d %d %d", t, d, L, R));
            //L>=R
            long n = d;
            d++;
            long x = findX(L, R, d, 0, 1000*1000*1000);
            L -= (d+x-1)*x;
            R -= (d+x)*x;
            n += 2*x;
            if (L>=n+1) {
                n++;
                L-=n;
            }

//            if (L >= d) {
//                long x = (long) Math.floor((Math.sqrt(1.0f * d * d - 4 * d + 4 * L) - d) / 2.0f);
//                L -= (x + d) * (x + 1);
//                n += x + 1;
//            }
//            if (R >= (d + 1)) {
//                long y = (long) Math.floor((Math.sqrt(1.0f * d * d + 4 * R) - d) / 2.0f);
//                R -= (d + y) * y;
//                n += y;
//            }
            System.out.println(String.format("Case #%d: %d %d %d", t, n, L, R));
        }
    }
    
    private static long find(long diff, long min, long max) {
        if (min + 1 == max) {
            if (max * (max + 1) <= 2 * diff) return max;
            return min;
        }
        long ave = (max + min) / 2;
        if (ave * (ave + 1) <= 2 * diff) {
            return find(diff, ave, max);
        } else {
            return find(diff, min, ave);
        }
    }

    private static long findX(long L, long R, long d, long min, long max) {
        if (min + 1 == max) {
            if ((d+max-1)*max <=L && (d+max)*max <= R) return max;
            return min;
        }
        long x = (max + min) / 2;
        if ((d+x-1)*x <=L && (d+x)*x <= R) {
            return findX(L, R, d, x, max);
        } else {
            return findX(L, R, d, min, x);
        }
    }
}
