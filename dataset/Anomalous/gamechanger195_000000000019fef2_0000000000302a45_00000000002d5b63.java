import java.io.IOException;
import java.io.InputStream;

public class Solution {
    static FastReader in;

    static boolean print(long x, long y) throws Exception {
        System.out.println(x + " " + y);
        String response = in.next();
        return response.equals("HIT") || response.equals("CENTER");
    }

    public static void main(String[] args) throws Exception {
        in = new FastReader(System.in);
        int t = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        long x = 1_000_000_000 / 2;

        for (int t0 = 0; t0 < t; t0++) {
            int i, j = 0;
            outer:
            for (i = -1; i < 2; i++) {
                for (j = -1; j < 2; j++) {
                    System.out.println(x * i + " " + x * j);
                    String response = in.next();
                    if (response.equals("HIT") || response.equals("CENTER")) {
                        break outer;
                    }
                }
            }

            long val = x * j;
            long left = x * i;
            long right = x * 2;
            long rightmost = binarySearch(left, right, val, true);

            long leftmost = binarySearch(x * -2, x * i, val, false);

            long midX = (leftmost + rightmost) / 2;

            long down = binarySearch(x * -2, x * j, midX, false);
            long up = binarySearch(x * j, x * 2, midX, true);

            long midY = (up + down) / 2;
            print(midX, midY);
        }
    }

    static long binarySearch(long left, long right, long val, boolean isRightmost) throws Exception {
        long result = 0;
        while (left <= right) {
            if (left == right) {
                result = left;
                break;
            }
            if (left + 1 == right) {
                if (print(isRightmost ? left : right, val)) {
                    result = isRightmost ? left : right;
                } else {
                    result = isRightmost ? right : left;
                }
                break;
            }
            long mid = (left + right) / 2;
            if (print(mid, val)) {
                if (isRightmost) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (isRightmost) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return result;
    }
}

class FastReader {
    private final byte[] buf = new byte[2048];
    private int index, total;
    private final InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    private int scan() throws IOException {
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