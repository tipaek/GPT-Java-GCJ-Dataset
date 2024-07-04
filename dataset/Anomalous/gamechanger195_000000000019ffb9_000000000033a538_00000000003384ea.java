import java.io.IOException;
import java.io.InputStream;

public class Solution {
    static long findBinary(long key) {
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
        throw new ArithmeticException("Unexpected case");
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
        throw new ArithmeticException("Unexpected case");
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
        throw new ArithmeticException("Unexpected case");
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCaseCount = in.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            long l = in.nextLong();
            long r = in.nextLong();
            long ans = 0, next = 1;

            if (l > r) {
                long diff = l - r;
                long x = findBinary(diff);
                if (l >= x * (x + 1) / 2) {
                    ans += x;
                    l -= x * (x + 1) / 2;
                    next = x + 1;
                } else {
                    ans += x - 1;
                    l -= x * (x - 1) / 2;
                    next = x;
                }
            } else if (r > l) {
                long diff = r - l;
                long x = findBinary(diff);
                if (r >= x * (x + 1) / 2) {
                    ans += x;
                    r -= x * (x + 1) / 2;
                    next = x + 1;
                } else {
                    ans += x - 1;
                    r -= x * (x - 1) / 2;
                    next = x;
                }
            }

            if (l >= r) {
                long z = findBinary1(l, next);
                long z1 = findBinary2(r, next);
                l -= z * next + z * (z - 1);
                r -= next * z1 + z1 * z1;
                ans += z + z1;
            } else {
                long z = findBinary1(r, next);
                long z1 = findBinary2(l, next);
                r -= z * next + z * (z - 1);
                l -= next * z1 + z1 * z1;
                ans += z + z1;
            }

            sb.append("Case #").append(t).append(": ").append(ans).append(" ").append(l).append(" ").append(r).append("\n");
        }

        System.out.print(sb);
    }
}

class FastReader {
    private final byte[] buffer = new byte[2048];
    private int index, total;
    private final InputStream in;

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
        boolean neg = c == '-';
        if (c == '-' || c == '+') c = scan();
        do {
            val = val * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        while ((c = scan()) <= 32);
        boolean neg = c == '-';
        if (c == '-' || c == '+') c = scan();
        do {
            val = val * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }
}