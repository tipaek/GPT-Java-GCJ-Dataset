import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            long L = scanner.nextLong();
            long R = scanner.nextLong();
            boolean swapped = false;
            if (R > L) {
                long temp = L;
                L = R;
                R = temp;
                swapped = true;
            }
            long D = L - R;
            long n = calculateN(D);
            long LL = L - (n * (n + 1)) / 2;
            long x1 = calculateX(LL, n);
            long x2 = calculateX(R, n + 1);
            long ans = n + x1 + x2;
            long pl = LL - (n * x1 + x1 * x1);
            long pr = R - (n * x2 + x2 * (x2 + 1));

            if (swapped) {
                long temp = pr;
                pr = pl;
                pl = temp;
            }

            writer.printf("Case #%d: %d %d %d%n", cs, ans, pl, pr);
        }
        writer.flush();
    }

    public static long calculateN(long D) {
        return (long) Math.floor((Math.sqrt(8 * D + 1) - 1) / 2.0);
    }

    public static long calculateX(long D, long n) {
        return (long) Math.floor((Math.sqrt(4 * D + n * n) - n) / 2.0);
    }
}