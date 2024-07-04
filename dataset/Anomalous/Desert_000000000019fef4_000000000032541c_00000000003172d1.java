import java.io.*;
import java.util.*;

public class Solution {

    private String determineAnswer(int n, int d, long[] arr) {
        Map<Long, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        Arrays.sort(arr);

        for (long value : arr) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(value));
        }

        if (d == 2) {
            return maxFrequency >= 2 ? "0" : "1";
        }

        if (maxFrequency >= 3) {
            return "0";
        }

        for (long value : arr) {
            if (frequencyMap.containsKey(value * 2)) {
                return "1";
            }
        }

        for (long value : arr) {
            if (frequencyMap.get(value) >= 2 && value < arr[arr.length - 1]) {
                return "1";
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
            long[] arr = in.nextLongArray(n);
            String result = new Solution().determineAnswer(n, d, arr);
            writeTestCase(out, i + 1, result);
        }
        out.close();
    }

    static void writeTestCase(PrintWriter writer, int caseNumber, String result) {
        writer.printf("Case #%d: %s%n", caseNumber, result);
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }
}