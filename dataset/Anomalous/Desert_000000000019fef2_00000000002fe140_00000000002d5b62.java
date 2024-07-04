import java.io.*;
import java.util.*;

public class Solution {

    private String findPath(long x, long y) {
        for (int i = 0; i < 40; i++) {
            long stepSize = 1L << i;
            StringBuilder path = new StringBuilder();
            if (canReach(x, y, stepSize, path)) {
                return path.reverse().toString();
            }
        }
        return "IMPOSSIBLE";
    }
    
    private boolean canReach(long x, long y, long stepSize, StringBuilder path) {
        if (x == 0 && y == 0 && stepSize == 0) {
            return true;
        }
        
        if (!isValid(x, stepSize) || !isValid(y, stepSize)) {
            return false;
        }

        boolean reachedX;
        if (x >= 0) {
            path.append("E");
            reachedX = canReach(x - stepSize, y, stepSize / 2, path);
        } else {
            path.append("W");
            reachedX = canReach(x + stepSize, y, stepSize / 2, path);
        }

        if (reachedX) {
            return true;
        } else {
            path.deleteCharAt(path.length() - 1);
        }
        
        boolean reachedY;
        if (y >= 0) {
            path.append("N");
            reachedY = canReach(x, y - stepSize, stepSize / 2, path);
        } else {
            path.append("S");
            reachedY = canReach(x, y + stepSize, stepSize / 2, path);
        }
        
        if (reachedY) {
            return true;
        } else {
            path.deleteCharAt(path.length() - 1);
        }
        
        return false;
    }
    
    private boolean isValid(long coordinate, long stepSize) {
        return Math.abs(coordinate) <= stepSize * 2;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader reader = new InputReader(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        int testCount = reader.nextInt();
        for (int i = 0; i < testCount; i++) {
            long x = reader.nextLong();
            long y = reader.nextLong();

            writeResult(writer, i + 1, new Solution().findPath(x, y));
        }

        writer.close();
    }

    static void writeResult(PrintWriter writer, int caseNumber, Object result) {
        writer.println(String.format("Case #%d: %s", caseNumber, result.toString()));
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public double[] nextDoubleArray(int n) {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextDouble();
            }
            return array;
        }
    }
}