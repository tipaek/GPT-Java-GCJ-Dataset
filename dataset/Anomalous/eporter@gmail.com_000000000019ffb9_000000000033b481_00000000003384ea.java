import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private final Scanner in;

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }

    public static void run(Scanner in) {
        int cases = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            new Solution(in).runCase(cs);
        }
    }

    public Solution(Scanner in) {
        this.in = in;
    }

    private void runCase(int cs) {
        long left = in.nextLong();
        long right = in.nextLong();
        long i = 1;

        if (left >= right) {
            long diff = left - right;
            long init = binSearch(0, 1_000_000_000L, diff);
            left -= init * (init + 1) / 2;
            i = adjustValues(left, right, init + 1);
        } else {
            long diff = right - left;
            long init = binSearch(0, 1_000_000_000L, diff);
            right -= init * (init + 1) / 2;
            i = adjustValues(left, right, init + 1);
        }

        long n = binSearch2(i, 0, 1_000_000_000L, Math.min(left, right));
        if (n > 0) {
            n--;
        }

        if (n > 0) {
            long[] updatedValues = updateValues(left, right, i, n);
            left = updatedValues[0];
            right = updatedValues[1];
            i += n * 2;
        }

        while (i <= left || i <= right) {
            if (left >= right) {
                left -= i;
            } else {
                right -= i;
            }
            i++;
        }

        println(String.format("Case #%s: %s %s %s", cs, i - 1, left, right));
    }

    private long adjustValues(long left, long right, long start) {
        long i;
        for (i = start; i <= left || i <= right || Math.abs(left - right) > i; i++) {
            if (left >= right) {
                left -= i;
            } else {
                right -= i;
            }
        }
        return i;
    }

    private long[] updateValues(long left, long right, long i, long n) {
        if (left >= right) {
            left -= sumSequence(i, n);
            right -= sumSequence(i + 1, n);
        } else {
            left -= sumSequence(i + 1, n);
            right -= sumSequence(i, n);
        }
        return new long[]{left, right};
    }

    private long sumSequence(long start, long n) {
        long end = start + (n - 1) * 2;
        return (start + end) * n / 2;
    }

    private static long binSearch(long lo, long hi, long tgt) {
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            long msum = mid * (mid + 1) / 2;
            long msump = msum + msum + 1;
            if (msum <= tgt && msump >= tgt) {
                return mid;
            }
            if (msum > tgt) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static long binSearch2(long i, long lo, long hi, long tgt) {
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            long iEnd = i + (mid - 1) * 2;
            long msum = (i + iEnd) * mid / 2;
            long msump = msum + msum + 1;
            if (msum <= tgt && msump >= tgt) {
                return mid;
            }
            if (msum > tgt) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static void println(String s) {
        System.out.println(s);
    }
}