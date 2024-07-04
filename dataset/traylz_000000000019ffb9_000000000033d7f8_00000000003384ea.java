

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import static java.lang.Math.min;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            final String[] setup = in.readLine().split(" ");
            final int left = Integer.parseInt(setup[0]);
            final int right = Integer.parseInt(setup[1]);
            String result = solveHard(left, right);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solveSimple(long left, long right) {
        long i = 1;
        while (i <= left || i <= right) {
            if (left >= right) {
                left -= i;
            } else {
                right -= i;
            }
            i++;
        }
        return (i - 1) + " " + left + " " + right;
    }

    public static String solveHard(long left, long right) {
        long i = 0;
        long diff = Math.abs(left - right);

        // make i < diff -> will switch to ping-pong mode
        if (diff > 0) {
            i = findFirstApproachBinary(diff);
            long toDeduct = sum(i);
            if (left > right) {
                left -= toDeduct;
            } else {
                right -= toDeduct;
            }
        }


        // now the diff is less than, we take same number of times from left and right until we can
        // we will take less times from min one
        long numWeCanTake = findNumCanTake2Binary(i + 2, min(left, right));
        if (left >= right) {
            right -= sum2(i + 2, numWeCanTake);
            left -= sum2(i + 1, numWeCanTake);
        } else {
            left -= sum2(i + 2, numWeCanTake);
            right -= sum2(i + 1, numWeCanTake);
        }
        i += (numWeCanTake * 2);

        // and take possibly one more time
        if ((i + 1) <= left || (i + 1) <= right) {
            if (left >= right) {
                left -= (i + 1);
            } else {
                right -= (i + 1);
            }
            i++;
        }


        return i + " " + left + " " + right;
    }

    static long findFirstApproach(long diff) {
        long i = 0;
        while (sum(i + 1) <= diff) {
            // do binary search here instead of this shet
            i++;
        }
        return i;
    }

    static long findFirstApproachBinary(long diff) {
        long i = 0;
        long step = 1;

        // go up until we find a sum that is greater than diff
        while (sum(i) <= diff) {
            if (sum(i) == diff) {
                return i;
            }
            // do binary search here instead of this shet
            i += step;
            step *= 2;
        }


        // now alterate between left and right bounds
        step /= 4;

        while (step > 0) {
            if (sum(i) > diff) {
                i -= step;
            } else {
                i += step;
            }
            step /= 2;
        }

        if (sum(i) > diff) {
            i--;
        }

        return i;
    }

    static long sum(long num) {
        if (num == 0) {
            return 0;
        }
        return BigInteger.valueOf(num).multiply(BigInteger.valueOf(num + 1)).divide(BigInteger.valueOf(2)).longValueExact();
    }


    static long findNumCanTake2(long start, long toEat) {
        int i = 0;
        while (sum2(start, i + 1) <= toEat) {
            // do binary search here instead of this shet
            i++;
        }
        return i;
    }

    static long findNumCanTake2Binary(long start, long toEat) {
        long i = 0;
        long step = 1;
        while (sum2(start, i) <= toEat) {
            if (sum2(start, i) == toEat) {
                return i;
            }
            i += step;
            step *= 2;
        }

        step /= 4;

        while (step > 0) {
            if (sum2(start, i) > toEat) {
                i -= step;
            } else {
                i += step;
            }
            step /= 2;
        }

        if (sum2(start, i) > toEat) {
            i--;
        }

        return i;
    }


    private static long sum2(long base, long num) {
        if (num == 0) {
            return 0;
        }
        return BigInteger.valueOf(num).multiply(BigInteger.valueOf(base + num - 1)).longValueExact();
    }


}