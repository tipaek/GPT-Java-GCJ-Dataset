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

    static void solve(InputReader in, PrintWriter out) throws Exception {
        int n = in.nextInt();
        List<Node> holes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(in.next());
            long y = Long.parseLong(in.next());
            holes.add(new Node(BigInteger.valueOf(x), BigInteger.valueOf(y)));
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                BigInteger xDiff = holes.get(i).x.subtract(holes.get(j).x);
                BigInteger yDiff = holes.get(i).y.subtract(holes.get(j).y);

                int num = 0;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < k; l++) {
                        if (k != i && k != j && l != i && l != j) {
                            BigInteger xDiff2 = holes.get(k).x.subtract(holes.get(l).x);
                            BigInteger yDiff2 = holes.get(k).y.subtract(holes.get(l).y);
                            if (isParallel(xDiff, xDiff2, yDiff, yDiff2)) {
                                num++;
                            }
                        }
                    }
                }
                ans = Math.max(ans, num);
            }
        }

        out.println(Math.min(n, 2 * (ans + 1) + 2));
    }

    static boolean isParallel(BigInteger x1, BigInteger x2, BigInteger y1, BigInteger y2) {
        return x1.multiply(y2).equals(x2.multiply(y1));
    }

    static class Node {
        public BigInteger x;
        public BigInteger y;

        public Node(BigInteger x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return "";
                    } else {
                        tokenizer = new StringTokenizer(line);
                    }
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
}