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
        int testCases = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        long radius = 1_000_000_000 / 2;

        for (int t = 0; t < testCases; t++) {
            boolean found = false;
            long x = 0, y = 0;

            // Initial search to find a hit point
            outer:
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    System.out.println(radius * i + " " + radius * j);
                    String response = in.next();
                    if (response.equals("HIT") || response.equals("CENTER")) {
                        x = radius * i;
                        y = radius * j;
                        found = true;
                        break outer;
                    }
                }
            }

            if (!found) {
                throw new ArithmeticException("No hit found");
            }

            // Binary search to find the rightmost hit on x-axis
            long left = x, right = radius * 2, rightmost = 0;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (print(mid, y)) {
                    rightmost = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // Binary search to find the leftmost hit on x-axis
            left = -radius * 2;
            right = x;
            long leftmost = 0;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (print(mid, y)) {
                    leftmost = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            long midX = (leftmost + rightmost) / 2;

            // Binary search to find the bottommost hit on y-axis
            left = -radius * 2;
            right = y;
            long bottommost = 0;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (print(midX, mid)) {
                    bottommost = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Binary search to find the topmost hit on y-axis
            left = y;
            right = radius * 2;
            long topmost = 0;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (print(midX, mid)) {
                    topmost = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            long midY = (bottommost + topmost) / 2;
            print(midX, midY);
        }
    }
}

class FastReader {
    byte[] buffer = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
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
        if (neg || c == '+') c = scan();
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
        if (neg || c == '+') c = scan();
        do {
            val = val * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }
}