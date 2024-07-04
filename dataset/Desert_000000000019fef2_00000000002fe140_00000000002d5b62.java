import java.io.*;
import java.util.*;

public class Solution {

    private String getAns(long x, long y) {
        for (int i = 0; i < 40; i++) {
            long cur = 1L << i;
            StringBuilder res = new StringBuilder();
            if (ok(x, y, cur, res)) {
                return res.reverse().toString();
            }
        }

        return "IMPOSSIBLE";
    }
    
    private boolean ok(long curX, long curY, long cur, StringBuilder res) {
        if (curX == 0 && curY == 0 && cur == 0) {
            return true;
        }
        
        if (!check(curX, cur)) {
            return false;
        }
        
        if (!check(curY, cur)) {
            return false;
        }

        boolean xOk;
        if (curX >= 0) {
            res.append("E");
            xOk = ok(curX - cur, curY, cur / 2, res);
        } else {
            res.append("W");
            xOk = ok(curX + cur, curY, cur / 2, res);
        }

        if (xOk) {
            return true;
        } else {
            res.delete(res.length() - 1, res.length());
        }
        
        boolean yOk = false;
        if (curY >= 0) {
            res.append("N");
            yOk = ok(curX, curY - cur, cur / 2, res);
        } else {
            res.append("S");
            yOk = ok(curX, curY + cur, cur / 2, res);
        }
        
        if (yOk) {
            return true;
        } else {
            res.delete(res.length() - 1, res.length());
        }
        
        return false;
    }
    
    private boolean check(long curN, long curPow) {
        long curAbs = Math.abs(curN);
        if (curAbs > curPow * 2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int testCount = in.nextInt();
        for (int i = 0; i < testCount; i++) {
            long x = in.nextLong();
            long y = in.nextLong();

            writeTestCase(out, i + 1, new Solution().getAns(x, y));
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