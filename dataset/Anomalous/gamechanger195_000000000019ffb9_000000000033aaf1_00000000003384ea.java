import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {

    static long findBinary(long key) {
        long left = 1, right = 2_000_000_004;
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
        throw new IllegalStateException("Should never reach here");
    }

    static long findBinary1(long key, long initial) {
        long left = 0, right = 4_000_000_004L;
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
        throw new IllegalStateException("Should never reach here");
    }

    static long findBinary2(long key, long initial) {
        long left = 0, right = 4_000_000_004L;
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
        throw new IllegalStateException("Should never reach here");
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCaseCount = in.nextInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            long l = in.nextLong();
            long r = in.nextLong();
            long result = 0, next = 1;

            if (l > r) {
                long diff = l - r;
                long x = findBinary(diff);
                if (l >= x * (x + 1) / 2) {
                    result += x;
                    l -= x * (x + 1) / 2;
                    next = x + 1;
                } else {
                    result += x - 1;
                    l -= x * (x - 1) / 2;
                    next = x;
                }
            } else if (r > l) {
                long diff = r - l;
                long x = findBinary(diff);
                if (r >= x * (x + 1) / 2) {
                    result += x;
                    r -= x * (x + 1) / 2;
                    next = x + 1;
                } else {
                    result += x - 1;
                    r -= x * (x - 1) / 2;
                    next = x;
                }
            }

            if (l >= r) {
                long z = findBinary1(l, next);
                long z1 = findBinary2(r, next);
                l -= z * next + z * (z - 1);
                r -= next * z1 + z1 * z1;
                result += z + z1;
            } else {
                long z = findBinary1(r, next);
                long z1 = findBinary2(l, next);
                r -= z * next + z * (z - 1);
                l -= next * z1 + z1 * z1;
                result += z + z1;
            }

            sb.append("Case #").append(testCase).append(": ").append(result).append(" ").append(l).append(" ").append(r).append("\n");
        }

        System.out.print(sb);
    }
}

class FastReader {
    private byte[] buffer = new byte[2048];
    private int index, total;
    private InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buffer);
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
        int c, val = 0;
        while ((c = scan()) <= 32);
        boolean negative = c == '-';
        if (c == '-' || c == '+') c = scan();
        while (c >= '0' && c <= '9') {
            val = (val << 3) + (val << 1) + (c & 15);
            c = scan();
        }
        return negative ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        while ((c = scan()) <= 32);
        boolean negative = c == '-';
        if (c == '-' || c == '+') c = scan();
        while (c >= '0' && c <= '9') {
            val = (val << 3) + (val << 1) + (c & 15);
            c = scan();
        }
        return negative ? -val : val;
    }
}