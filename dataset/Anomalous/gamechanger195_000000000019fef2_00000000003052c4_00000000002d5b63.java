import java.io.IOException;
import java.io.InputStream;

public class Solution {
    static FastReader in;

    static boolean print(long x, long y) throws Exception {
        System.out.println(x + " " + y);
        String s = in.next();
        return s.equals("HIT") || s.equals("CENTER");
    }

    public static void main(String[] args) throws Exception {
        in = new FastReader(System.in);
        int t = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        long x = 10 / 2;

        for (int t0 = 0; t0 < t; t0++) {
            boolean found = false;
            long hitX = 0, hitY = 0;

            // Initial search for a hit point
            outer:
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (print(x * i, x * j)) {
                        hitX = x * i;
                        hitY = x * j;
                        found = true;
                        break outer;
                    }
                }
            }

            if (!found) {
                throw new RuntimeException("No initial hit found");
            }

            // Binary search for the rightmost hit point
            long rightmost = binarySearch(hitX, hitY, x, x * 2, true);

            // Binary search for the leftmost hit point
            long leftmost = binarySearch(hitX, hitY, x * -2, hitX, false);

            // Calculate midpoint of leftmost and rightmost
            long midX = (leftmost + rightmost) / 2;

            // Binary search for the lowest hit point
            long down = binarySearchVertical(midX, x * -2, hitY, false);

            // Binary search for the highest hit point
            long up = binarySearchVertical(midX, hitY, x * 2, true);

            // Calculate midpoint of lowest and highest
            long midY = (down + up) / 2;

            print(midX, midY);
        }
    }

    static long binarySearch(long hitX, long hitY, long low, long high, boolean searchRight) throws Exception {
        long result = 0;
        while (low <= high) {
            if (low == high) {
                result = low;
                break;
            }
            if (low + 1 == high) {
                result = print(high, hitY) ? high : low;
                break;
            }
            long mid = (low + high) / 2;
            if (print(mid, hitY)) {
                if (searchRight) {
                    low = mid;
                } else {
                    high = mid;
                }
            } else {
                if (searchRight) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
        }
        return result;
    }

    static long binarySearchVertical(long midX, long low, long high, boolean searchUp) throws Exception {
        long result = 0;
        while (low <= high) {
            if (low == high) {
                result = low;
                break;
            }
            if (low + 1 == high) {
                result = print(midX, high) ? high : low;
                break;
            }
            long mid = (low + high) / 2;
            if (print(midX, mid)) {
                if (searchUp) {
                    low = mid;
                } else {
                    high = mid;
                }
            } else {
                if (searchUp) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
        }
        return result;
    }
}

class FastReader {
    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}