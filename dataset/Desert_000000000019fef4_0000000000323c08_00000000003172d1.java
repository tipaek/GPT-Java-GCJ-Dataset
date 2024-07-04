import java.io.*;
import java.util.*;

public class Solution {

    private String getAns(int n, int d, long[] arr) {
        Map<Long, Integer> counts = new HashMap<>();
        int maxRep = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            long cur = arr[i];
            if (!counts.containsKey(cur)) {
                counts.put(cur, 0);
            }

            counts.put(cur, counts.get(cur) + 1);

            maxRep = Math.max(maxRep, counts.get(cur));
        }

        if (d == 2) {
            if (maxRep == 2) {
                return "0";
            } else {
                return "1";
            }
        }

        if (maxRep == 3) {
            return "0";
        }

        for (int i = 0; i < arr.length; i++) {
            long cur = arr[i];

            long next = cur * 2;
            if (counts.containsKey(next)) {
                return "1";
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (counts.get(arr[i]) >= 2) {
                if (arr[i] < arr[arr.length - 1]) {
                    return "1";
                }
            }
        }

        return "2";
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