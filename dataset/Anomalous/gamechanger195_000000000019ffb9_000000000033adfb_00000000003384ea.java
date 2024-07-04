import java.io.IOException;
import java.io.InputStream;

public class Solution {

    static long binarySearch(long key) {
        long left = 1, right = 2_000_000_004L;
        while (left <= right) {
            if (left == right) return left;
            if (left + 1 == right) {
                if (left * (left + 1) / 2 >= key) return left;
                return right;
            }
            long mid = (left + right) / 2;
            if (mid * (mid + 1) / 2 >= key) right = mid;
            else left = mid + 1;
        }
        throw new ArithmeticException("Unexpected condition");
    }

    static long binarySearch1(long key, long initial) {
        long left = 0, right = 2_000_000_004L;
        while (left <= right) {
            if (left == right) return left;
            if (left + 1 == right) {
                if (key >= initial * right + right * (right - 1)) return right;
                return left;
            }
            long mid = (left + right) / 2;
            if (key >= initial * mid + mid * (mid - 1)) left = mid;
            else right = mid;
        }
        throw new ArithmeticException("Unexpected condition");
    }

    static long binarySearch2(long key, long initial) {
        long left = 0, right = 2_000_000_004L;
        while (left <= right) {
            if (left == right) return left;
            if (left + 1 == right) {
                if (key >= initial * right + right * right) return right;
                return left;
            }
            long mid = (left + right) / 2;
            if (key >= initial * mid + mid * mid) left = mid;
            else right = mid;
        }
        throw new ArithmeticException("Unexpected condition");
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int t = in.nextInt();
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            long l = in.nextLong();
            long r = in.nextLong();
            long steps = 0, nextStep = 1;

            if (l > r) {
                long diff = l - r;
                long x = binarySearch(diff);
                if (l >= x * (x + 1) / 2) {
                    steps += x;
                    l -= x * (x + 1) / 2;
                    nextStep = x + 1;
                } else {
                    steps += x - 1;
                    l -= x * (x - 1) / 2;
                    nextStep = x;
                }
            } else if (r > l) {
                long diff = r - l;
                long x = binarySearch(diff);
                if (r >= x * (x + 1) / 2) {
                    steps += x;
                    r -= x * (x + 1) / 2;
                    nextStep = x + 1;
                } else {
                    steps += x - 1;
                    r -= x * (x - 1) / 2;
                    nextStep = x;
                }
            }

            if (l >= r) {
                long z = binarySearch1(l, nextStep);
                long z1 = binarySearch2(r, nextStep);
                l -= z * nextStep + z * (z - 1);
                r -= nextStep * z1 + z1 * z1;
                steps += z + z1;
            } else {
                long z = binarySearch1(r, nextStep);
                long z1 = binarySearch2(l, nextStep);
                r -= z * nextStep + z * (z - 1);
                l -= nextStep * z1 + z1 * z1;
                steps += z + z1;
            }

            sb.append("Case #").append(caseNumber).append(": ").append(steps).append(" ").append(l).append(" ").append(r).append("\n");
        }

        System.out.print(sb);
    }
}

class FastReader {

    private final byte[] buffer = new byte[2048];
    private int index, total;
    private final InputStream inputStream;

    FastReader(InputStream is) {
        this.inputStream = is;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = inputStream.read(buffer);
            if (total <= 0) return -1;
        }
        return buffer[index++];
    }

    String next() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) > 32);
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, value = 0;
        while ((c = scan()) <= 32);
        boolean negative = c == '-';
        if (c == '-' || c == '+') c = scan();
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return negative ? -value : value;
    }

    long nextLong() throws IOException {
        int c;
        long value = 0;
        while ((c = scan()) <= 32);
        boolean negative = c == '-';
        if (c == '-' || c == '+') c = scan();
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return negative ? -value : value;
    }
}