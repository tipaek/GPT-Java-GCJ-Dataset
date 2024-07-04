import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ToDoubleBiFunction;

import static java.lang.Math.*;

public class Solution extends PrintWriter {

    String check(long l, long r) {
        for (long n = 1;; n++) {
            if (l >= r) {
                if (l >= n) {
                    l -= n;
                } else {
                    return String.format("%d %d %d", n - 1, l, r);
                }
            } else {
                if (r >= n) {
                    r -= n;
                } else {
                    return String.format("%d %d %d", n - 1, l, r);
                }
            }
        }
    }

    long t(long n) {
        return n * (n + 1) / 2;
    }

    String solve(long l, long r) {

        long n = 0;

        if (l >= r) {
            long d = 0, u = 1;

            long diff = l - r;

            while (t(u) <= diff) {
                u *= 2;
            }

            while (u - d > 1) {
                long c = (u + d) / 2;

                if (t(c) <= diff) {
                    d = c;
                } else {
                    u = c;
                }
            }

            n += u;
            l -= t(n);

            if (l < 0) {
                return String.format("%d %d %d", n - 1, l + n, r);
            }

            if (n + 1 <= r) {
                n += 1;
                r -= n;
            } else {
                return String.format("%d %d %d", n, l, r);
            }
        } else {
            long d = 0, u = 1;
            long diff = r - l;

            while (t(u) < diff) {
                u *= 2;
            }
            while (u - d > 1) {
                long c = (u + d) / 2;

                if (t(c) < diff) {
                    d = c;
                } else {
                    u = c;
                }
            }

            n += u;
            r -= t(n);

            if (r < 0) {
                return String.format("%d %d %d", n - 1, l, r + n);
            }
        }

        if (n % 2 == 0) {

            long d = 0, u = 1;

            while (n * u + u * u <= l && n * u + t(u) * 2 <= r) {
                u *= 2;
            }
            while (u - d > 1) {
                long c = (u + d) / 2;

                if (n * c + c * c <= l && n * c + t(c) * 2 <= r) {
                    d = c;
                } else {
                    u = c;
                }
            }

            l -= n * d + d * d;
            r -= n * d + 2 * t(d);
            n += d * 2;

            if (n + 1 <= l) {
                n += 1;
                l -= n;
            }
        } else {
            long d = 0, u = 1;

            while (n * u + u * u <= l && n * u + t(u) * 2 <= r) {
                u *= 2;
            }
            while (u - d > 1) {
                long c = (u + d) / 2;

                if (n * c + c * c <= l && n * c + t(c) * 2 <= r) {
                    d = c;
                } else {
                    u = c;
                }
            }

            l -= n * d + d * d;
            r -= n * d + 2 * t(d);
            n += d * 2;

            if (n + 1 <= l) {
                n += 1;
                l -= n;
            }
        }
        return String.format("%d %d %d", n, l, r);
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

    public static boolean nextPermutation(int[] permutation) {
        int n = permutation.length, a = n - 2;
        while (0 <= a && permutation[a] >= permutation[a + 1]) {
            a--;
        }
        if (a == -1) {
            return false;
        }

        int b = n - 1;
        while (permutation[b] <= permutation[a]) {
            b--;
        }

        swap(permutation, a, b);
        for (int i = a + 1, j = n - 1; i < j; i++, j--) {
            swap(permutation, i, j);
        }
        return true;
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }
}