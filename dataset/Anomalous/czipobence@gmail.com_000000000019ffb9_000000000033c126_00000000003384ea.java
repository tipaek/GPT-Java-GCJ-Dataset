import java.util.*;
import java.io.*;

public class Solution {

    public static long estimateDiffCount(long l, long r) {
        long diff = Math.abs(l - r);
        if (diff == 0) return 0;
        long estim = (long) Math.sqrt(diff * 2);
        while (estim * (estim + 1) / 2 > diff) {
            estim--;
        }
        return estim;
    }

    public static long doubleSum(long start, long end) {
        if (start % 2 != end % 2) {
            throw new IllegalStateException();
        }
        long n = (end - start) / 2;
        return (n + 1) * start + n * (n + 1);
    }

    public static long getCalls(long initValue, long startStep) {
        if (initValue < startStep) return 0;
        long estim = (long) Math.sqrt(initValue);
        while (doubleSum(startStep, startStep + 2 * estim) > initValue) {
            estim--;
        }
        estim++;
        return estim;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long l = in.nextLong();
            long r = in.nextLong();

            long newL, newR, totalCalls, estim;
            if (l > r) {
                estim = estimateDiffCount(l, r);
                newL = l - estim * (estim + 1) / 2;
                newR = r;
            } else {
                estim = estimateDiffCount(l, r);
                newL = l;
                newR = r - estim * (estim + 1) / 2;
            }

            if (newR > newL) {
                long callL = getCalls(newL, estim + 2);
                long callR = getCalls(newR, estim + 1);

                if (callL > 0) {
                    newL -= doubleSum(estim + 2, estim + 2 + 2 * (callL - 1));
                }
                if (callR > 0) {
                    newR -= doubleSum(estim + 1, estim + 1 + 2 * (callR - 1));
                }

                totalCalls = estim + callL + callR;
            } else {
                long callL = getCalls(newL, estim + 1);
                long callR = getCalls(newR, estim + 2);

                if (callL > 0) {
                    newL -= doubleSum(estim + 1, estim + 1 + 2 * (callL - 1));
                }
                if (callR > 0) {
                    newR -= doubleSum(estim + 2, estim + 2 + 2 * (callR - 1));
                }

                totalCalls = estim + callL + callR;
            }

            System.out.println("Case #" + i + ": " + totalCalls + " " + newL + " " + newR);
        }
    }
}