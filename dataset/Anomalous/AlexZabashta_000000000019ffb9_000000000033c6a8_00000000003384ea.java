import java.io.*;
import java.util.*;

public class Solution extends PrintWriter {

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }

    void run() {
        int t = nextInt();
        for (int test = 1; test <= t; test++) {
            long l = nextLong();
            long r = nextLong();
            String ans = solve(l, r);
            printf("Case #%d: %s%n", test, ans);
        }
    }

    String solve(long l, long r) {
        long n = 0;

        if (l >= r) {
            n = adjustForLargerL(l, r, n);
        } else {
            n = adjustForLargerR(l, r, n);
        }

        if (n % 2 == 0) {
            n = adjustForEvenN(l, r, n);
        } else {
            n = adjustForOddN(l, r, n);
        }

        return String.format("%d %d %d", n, l, r);
    }

    private long adjustForLargerL(long l, long r, long n) {
        long d = 0, u = 1;
        long diff = l - r;

        while (triangularNumber(u) <= diff) {
            u *= 2;
        }
        while (u - d > 1) {
            long c = (u + d) / 2;
            if (triangularNumber(c) <= diff) {
                d = c;
            } else {
                u = c;
            }
        }

        n += u;
        l -= triangularNumber(n);

        if (l < 0) {
            return n - 1;
        }

        if (n + 1 <= r) {
            n += 1;
            r -= n;
        } else {
            return n;
        }

        return n;
    }

    private long adjustForLargerR(long l, long r, long n) {
        long d = 0, u = 1;
        long diff = r - l;

        while (triangularNumber(u) < diff) {
            u *= 2;
        }
        while (u - d > 1) {
            long c = (u + d) / 2;
            if (triangularNumber(c) < diff) {
                d = c;
            } else {
                u = c;
            }
        }

        n += u;
        r -= triangularNumber(n);

        if (r < 0) {
            return n - 1;
        }

        return n;
    }

    private long adjustForEvenN(long l, long r, long n) {
        long d = 0, u = 1;

        while (n * u + u * u <= l && n * u + triangularNumber(u) * 2 <= r) {
            u *= 2;
        }
        while (u - d > 1) {
            long c = (u + d) / 2;
            if (n * c + c * c <= l && n * c + triangularNumber(c) * 2 <= r) {
                d = c;
            } else {
                u = c;
            }
        }

        l -= n * d + d * d;
        r -= n * d + 2 * triangularNumber(d);
        n += d * 2;

        if (n + 1 <= l) {
            n += 1;
            l -= n;
        }

        return n;
    }

    private long adjustForOddN(long l, long r, long n) {
        long d = 0, u = 1;

        while (n * u + u * u <= l && n * u + triangularNumber(u) * 2 <= r) {
            u *= 2;
        }
        while (u - d > 1) {
            long c = (u + d) / 2;
            if (n * c + c * c <= l && n * c + triangularNumber(c) * 2 <= r) {
                d = c;
            } else {
                u = c;
            }
        }

        l -= n * d + d * d;
        r -= n * d + 2 * triangularNumber(d);
        n += d * 2;

        if (n + 1 <= l) {
            n += 1;
            l -= n;
        }

        return n;
    }

    long triangularNumber(long n) {
        return n * (n + 1) / 2;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    String next() {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }
}