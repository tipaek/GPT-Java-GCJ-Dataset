import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            long l = in.nextLong();
            long r = in.nextLong();
            boolean swapped = false;
            if (r > l) {
                swapped = true;
                long tmp = r;
                r = l;
                l = tmp;
            }
            long res = 0;
            long lo = 1;
            long hi = 3000000000L;
            while (lo <= hi) {
                long mid = (lo + hi) / 2;
                long sum = ((1 + mid) * mid) / 2;
                if (l - sum >= r) {
                    res = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            long sum = ((1 + res) * res) / 2;
            l -= sum;
            if (l == r) {
                swapped = false;
            }
            long start = res + 1;
            lo = 1;
            hi = 3000000000L;
            long resAddition = 0;
            long leftL = l;
            long leftR = r;
            while (lo <= hi) {
                long mid = (lo + hi) / 2;
                long countL = (mid + 1) / 2;
                long lastL = start + (countL - 1) * 2;
                long sumL = ((start + lastL) * (countL)) / 2;
                long countR = mid / 2;
                long sumR = 0;
                if (countR > 0) {
                    long lastR = start + 1 + (countR - 1) * 2;
                    sumR = ((start + 1 + lastR) * (countR)) / 2;
                }
                if ((l >= sumL) && (r >= sumR)) {
                    resAddition = mid;
                    leftL = l - sumL;
                    leftR = r - sumR;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (swapped) {
                long temp = leftR;
                leftR = leftL;
                leftL = temp;
            }
            out.printf("Case #%d: %d %d %d\n", testNumber, res + resAddition, leftL, leftR);
            out.flush();
        }
        out.close();

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


    }
}
