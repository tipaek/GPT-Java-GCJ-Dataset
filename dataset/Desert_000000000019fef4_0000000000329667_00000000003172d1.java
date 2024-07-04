import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private String getAns(int n, int d, long[] arr) {
        Arrays.sort(arr);

        Set<Long> all = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                all.add(arr[i]);
                all.add(arr[j]);
                all.add(gcd(arr[i], arr[j]));
            }
        }

        List<Long> list = new ArrayList<>(all);
        Collections.sort(list);

        int bestRes = d - 1;
        for (int i = 0; i < list.size(); i++) {
            long cur = list.get(i);
            int dLeft = d;
            int res = 0;

            int potential = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                if (arr[j] % cur == 0) {
                    long slices = arr[j] / cur;
                    if (slices <= dLeft) {
                        dLeft -= slices;
                        res += slices - 1;
                    } else {
                        potential += arr[j] / cur;
                    }
                } else {
                    potential += arr[j] / cur;
                }
            }

            if (dLeft == 0) {
                bestRes = Math.min(bestRes, res);
            } else {
                if (potential >= dLeft) {
                    res += dLeft;

                    bestRes = Math.min(bestRes, res);
                }
            }
        }

        return String.valueOf(bestRes);
    }

    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int testCount = in.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] arr = in.nextLongArr(n);

            writeTestCase(out, i + 1, new Solution().getAns(n, d, arr));
        }

        out.close();
    }

    static void writeTestCase(PrintWriter writer, int num, Object res) {
        writer.println(String.format("Case #%d: %s", num, res.toString()));
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n) {
            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextInt();
            }

            return arr;
        }

        public long[] nextLongArr(int n) {
            long[] arr = new long[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextLong();
            }

            return arr;
        }

        public double[] nextDoubleArr(int n) {
            double[] arr = new double[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextDouble();
            }

            return arr;
        }
    }
}