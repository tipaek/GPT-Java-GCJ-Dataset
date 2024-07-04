import java.util.Scanner;

public class Solution {

    static long[] getMinEven(long max, long start) {
        long[] result = new long[2];
        start = start / 2 - 1;
        long low = 0;
        long high = Integer.MAX_VALUE;

        while (high - low > 1) {
            long mid = (high + low) / 2;
            long sum1 = start + mid;
            if (sum1 * (sum1 + 1) - (start + 1) * start <= max) {
                low = mid;
            } else {
                high = mid;
            }
        }
        result[0] = low;
        long sum1 = start + low;
        result[1] = max - (sum1 * (sum1 + 1) - (start + 1) * start);

        return result;
    }

    static long[] getMinOdd(long max, long start) {
        long[] result = new long[2];
        start = start / 2;
        long low = 0;
        long high = Integer.MAX_VALUE;

        while (high - low > 1) {
            long mid = (high + low) / 2;
            long sum1 = start + mid;
            if (sum1 * sum1 - start * start <= max) {
                low = mid;
            } else {
                high = mid;
            }
        }
        result[0] = low;
        long sum1 = start + low;
        result[1] = max - (sum1 * sum1 - start * start);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            long L = scanner.nextLong();
            long R = scanner.nextLong();
            boolean swapped = false;
            if (L < R) {
                swapped = true;
                long temp = L;
                L = R;
                R = temp;
            }

            long diff = L - R;

            long low = 0;
            long high = Integer.MAX_VALUE;

            while (high - low > 1) {
                long mid = (high + low) / 2;
                if (mid * (mid + 1) / 2 <= diff) {
                    low = mid;
                } else {
                    high = mid;
                }
            }

            long start = low;
            long remainingL = 0;
            long remainingR = 0;

            L -= start * (start + 1) / 2;
            if (L == R && swapped) {
                swapped = false;
            }

            if (start % 2 == 0) {
                long[] minOddL = getMinOdd(L, start + 1);
                long[] minEvenR = getMinEven(R, start + 2);
                if (minOddL[0] == minEvenR[0]) {
                    long min = minOddL[0];
                    start += 2 * min;
                    remainingL = minOddL[1];
                    remainingR = minEvenR[1];
                } else if (minOddL[0] > minEvenR[0]) {
                    long min = minEvenR[0];
                    long k = (start + 1) / 2;
                    long s = k + min + 1;
                    remainingL = L - s * s + k * k;
                    start += 2 * min + 1;
                    remainingR = minEvenR[1];
                } else {
                    long min = minOddL[0];
                    long k = (start + 2) / 2 - 1;
                    long s = k + min + 1;
                    remainingL = minOddL[1];
                    start += 2 * min;
                    remainingR = R - s * (s + 1) + (k + 1) * k;
                }
            } else {
                long[] minEvenL = getMinEven(L, start + 1);
                long[] minOddR = getMinOdd(R, start + 2);
                if (minEvenL[0] == minOddR[0]) {
                    long min = minEvenL[0];
                    start += 2 * min;
                    remainingL = minEvenL[1];
                    remainingR = minOddR[1];
                } else if (minEvenL[0] > minOddR[0]) {
                    long min = minOddR[0];
                    long k = (start + 2) / 2 - 1;
                    long s = k + min + 1;
                    start += 2 * min + 1;
                    remainingL = L - s * (s + 1) + (k + 1) * k;
                    remainingR = minOddR[1];
                } else {
                    long min = minEvenL[0];
                    long k = (start + 1) / 2;
                    long s = k + min + 1;
                    remainingL = minEvenL[1];
                    start += 2 * min;
                    remainingR = R - s * s + k * k;
                }
            }

            if (swapped) {
                System.out.println("Case #" + t + ": " + start + " " + remainingR + " " + remainingL);
            } else {
                System.out.println("Case #" + t + ": " + start + " " + remainingL + " " + remainingR);
            }
        }
        scanner.close();
    }
}