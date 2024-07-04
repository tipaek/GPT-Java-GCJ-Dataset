import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            InputStream inputStream = System.in;
            PrintWriter out = new PrintWriter(System.out);
            InputReader in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (int test = 1; test <= tests; test++) {
                out.print("Case #" + test + ": ");
                solve(in, out);
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void solve(InputReader in, PrintWriter out) throws Exception {
        long l = in.nextInt();
        long r = in.nextInt();
        long diff = Math.abs(l - r);
        long i = (long) (Math.sqrt(2.0 * diff) + 1e-11);

        if (r >= l) {
            r -= i * (i + 1) / 2;
        } else {
            l -= i * (i + 1) / 2;
        }

        long target = Math.max(l, r);
        long n = (long) ((-i + Math.sqrt(i * i + 4 * target) + 1e-11) / 2);
        long total = i + 2 * n;

        if (l >= r) {
            l -= (n + i) * n;
            r -= (n + i + 1) * n;
            if (r < 0) {
                r += i + 2 * n;
                total--;
            }
        } else {
            r -= (n + i) * n;
            l -= (n + i + 1) * n;
            if (l < 0) {
                l += i + 2 * n;
                total--;
            }
        }

        out.println(total + " " + l + " " + r);
    }

    private static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null) return "";
                    tokenizer = new StringTokenizer(str);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private static class Node {
        int[] arr;
        int size;
        BigInteger hash;
        int moves = 0;
        StringBuilder solution = new StringBuilder();

        Node(int[] arr, int size, int moves) {
            this.arr = Arrays.copyOf(arr, size);
            this.size = size;
            this.moves = moves;
            this.hash = calcHash(this.arr, size);
        }

        private static BigInteger calcHash(int[] arr, int size) {
            BigInteger hash = BigInteger.ZERO;
            for (int i = 0; i < size; i++) {
                hash = hash.multiply(BigInteger.TEN).add(BigInteger.valueOf(arr[i]));
            }
            return hash;
        }
    }
}