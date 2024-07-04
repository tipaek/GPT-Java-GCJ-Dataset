import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            long l = in.nextLong();
            long r = in.nextLong();
            
            if (r > l) {
                long temp = l;
                l = r;
                r = temp;
            }
            
            long res = calculateMaxRes(l, r);
            long sum = ((1 + res) * res) / 2;
            l -= sum;
            
            long start = res + 1;
            Result result = calculateAddition(l, r, start);
            
            if (result.swapped) {
                long temp = result.leftR;
                result.leftR = result.leftL;
                result.leftL = temp;
            }
            
            out.printf("Case #%d: %d %d %d\n", testNumber, res + result.resAddition, result.leftL, result.leftR);
            out.flush();
        }
        out.close();
    }

    private static long calculateMaxRes(long l, long r) {
        long lo = 1;
        long hi = 3000000000L;
        long res = 0;
        
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
        
        return res;
    }

    private static Result calculateAddition(long l, long r, long start) {
        long lo = 1;
        long hi = 3000000000L;
        long resAddition = 0;
        long leftL = l;
        long leftR = r;
        boolean swapped = false;
        
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long countL = (mid + 1) / 2;
            long lastL = start + (countL - 1) * 2;
            long sumL = ((start + lastL) * countL) / 2;
            long countR = mid / 2;
            long sumR = 0;
            
            if (countR > 0) {
                long lastR = start + 1 + (countR - 1) * 2;
                sumR = ((start + 1 + lastR) * countR) / 2;
            }
            
            if (l >= sumL && r >= sumR) {
                resAddition = mid;
                leftL = l - sumL;
                leftR = r - sumR;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return new Result(resAddition, leftL, leftR, swapped);
    }

    static class Result {
        long resAddition;
        long leftL;
        long leftR;
        boolean swapped;
        
        Result(long resAddition, long leftL, long leftR, boolean swapped) {
            this.resAddition = resAddition;
            this.leftL = leftL;
            this.leftR = leftR;
            this.swapped = swapped;
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