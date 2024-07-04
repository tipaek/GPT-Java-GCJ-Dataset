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
//            System.out.println(String.format("Case #%d: %d %d %d", t, 0, L, R));
            long d = first(Math.abs(L-R));
            long sum = d*(d+1)/2;
            //Phase 1
            if (L>=R) {
                L-=sum;
            } else {
                R-=sum;
            }
//            System.out.println(String.format("Case #%d: %d %d %d", t, d, L, R));
            //Phase 2
            if (L<R) {
                if (R>=(d+1)) {
                    d++;
                    R-=d;
                }
            }
//            System.out.println(String.format("Case #%d: %d %d %d", t, d, L, R));
            //L>=R
            long n=d;
            d++;
            if (L>=d) {
                long x = (long) Math.floor((Math.sqrt(1.0f * d * d - 4 * d + 4 * L) - d) / 2.0f);
                L -= (x + d) * (x + 1);
                n += x+1;
            }
            if (R>=(d+1)) {
                long y = (long) Math.floor((Math.sqrt(1.0f * d * d + 4 * R) - d) / 2.0f);
                R -= (d+y) * y;
                n += y;
            }
            System.out.println(String.format("Case #%d: %d %d %d", t, n, L, R));
        }
    }

    private static long first(long diff) {
        long val = (long) Math.floor((Math.sqrt(1.0f+ 8.0f* diff)-1)/2.0f);
        if ((val+1)*(val+2) <= 2*diff) {
            return val+1;
        }
        return val;
    }
}
