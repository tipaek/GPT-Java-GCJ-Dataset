import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    static void solve() throws Exception {
        List<Long> slices = new ArrayList<>();

        int N = in.nextInt();
        int D = in.nextInt();

        for (int i = 0; i < N; i++) {
            slices.add(Long.parseLong(in.next()));
        }
        Collections.sort(slices);

        long minRes = Long.MAX_VALUE;

        for (int d = 1; d <= D; d++) {
            for (int n = 0; n < N; n++) {
                long target = slices.get(n);
                List<Long> good = new ArrayList<>();
                List<Long> bad = new ArrayList<>();

                for (int i = 0; i < N; i++) {
                    long value = slices.get(i) * d / target;
                    if ((slices.get(i) * d) % target == 0) {
                        good.add(value);
                    } else {
                        bad.add(value);
                    }
                }

                int min = 0;
                int remain = D;
                Collections.sort(good);
                Collections.sort(bad);
                for (long item : good) {
                    if (remain < item) {
                        min += remain;
                        remain = 0;
                        break;
                    } else if (remain == item) {
                        min += remain - 1;
                        remain = 0;
                        break;
                    } else {
                        remain -= item;
                    }
                }

                if (remain > 0) {
                    for (long item : bad) {
                        if (remain <= item) {
                            min += remain;
                            remain = 0;
                            break;
                        } else {
                            remain -= item;
                        }
                    }
                }

                if (remain <= 0) {
                    minRes = Math.min(minRes, min);
                }
            }
        }
        out.println(minRes);
    }

    static int[] arrTransform(int[] arr, int i, int j, int size) {
        int[] result = new int[size];
        System.arraycopy(arr, j + 1, result, j + 1, size - (j + 1));
        System.arraycopy(arr, i + 1, result, 0, j - i);
        System.arraycopy(arr, 0, result, j - i, j + 1);
        return result;
    }

    static class Node {
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
    }

    static void printResult(Node n) {
        out.println(n.moves);
        out.println(n.solution);
    }

    static BigInteger calcHash(int[] arr, int size) {
        BigInteger hash = BigInteger.ZERO;
        for (int i = 0; i < size; i++) {
            hash = hash.multiply(BigInteger.TEN).add(BigInteger.valueOf(arr[i]));
        }
        return hash;
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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
}