import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static boolean test = false;
    static int lMax = 1000;
    static int rMax = 1000;
    static int lCur = 0;
    static int rCur = 0;
    public static int getTest(Scanner in) {
        if (test)
            return lMax * rMax;
        else
            return in.nextInt();
    }

    public static long getL(Scanner in) {
        if (test) {
            ++lCur;
            if (lCur > lMax) {
                lCur = 1;
                ++rCur;
            }
            return lCur;
        } else {
            return in.nextLong();
        }

    }

    public static long getR(Scanner in) {
        if (test) {
            return rCur;
        } else {
            return in.nextLong();
        }

    }

    public static long find(long dif, long i, long step, boolean higher) {
        long res = (long)Math.floor(Math.sqrt(2 * dif)) + 1;
        if (2 * i - step > 0)
            res = Math.min(res, (long)(2 * dif / (2 * i - step)) + 1);
        if (higher) {
            while (res * res * step + (2 * i - step) * res >= dif * 2) {
                --res;
            }
            ++res;
        } else {
            while (res * res * step + (2 * i - step) * res > dif * 2) {
                --res;
            }
        }
        return res;
    }

    public static long calc(long i, long step, long count) {
        return ((2 * i - step) * count + step * count * count) / 2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = getTest(in);
        for (int test = 1; test <= tests; ++test) {
            long l = getL(in);
            long r = getR(in);
            long i = 1;
            boolean cont = true;
            if (l < r) {
                long step = 1;
                long res = find(r - l, i, step, true);
                long dif = calc(i, step, res);
                if (r < dif) {
                    --res;
                    dif = calc(i, step, res);
                    cont = false;
                }
                i += res;
                r -= dif;
             } else if (r < l) {
                long step = 1;
                long res = find(l - r, i, step, false);
                long dif = calc(i, step, res);
                if (l < dif) {
                    --res;
                    dif = calc(i, step, res);
                    cont = false;
                }
                i += res;
                l -= dif;
            }
            if (cont) {
                long step = 2;
                long left = find(l, i, step, false);
                long right = find(r, i + 1, step,false);
                long add = Math.max(2 * (left - 1), (1 + 2 *(right - 1)));
                l -= calc(i, step, left);
                r -= calc(i + 1, step, right);
                i += add + 1;

            }
            System.out.println("Case #" + test + ": " + (i - 1) + " " + l + " " + r);

        }
    }
}