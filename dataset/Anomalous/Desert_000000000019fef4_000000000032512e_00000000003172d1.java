import java.io.*;
import java.util.*;

public class Solution {

    private String getAnswer(int n, int d, long[] arr) {
        Map<Long, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        Arrays.sort(arr);

        for (long num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(num));
        }

        if (d == 2) {
            return maxFrequency == 2 ? "0" : "1";
        }

        if (maxFrequency == 3) {
            return "0";
        }

        for (long num : arr) {
            if (frequencyMap.containsKey(num * 2) && frequencyMap.get(num * 2) >= 1) {
                return "1";
            }
        }

        for (long num : arr) {
            if (frequencyMap.get(num) >= 2 && num < arr[arr.length - 1]) {
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
            out.println(String.format("Case #%d: %s", i + 1, new Solution().getAnswer(n, d, arr)));
        }

        out.close();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        private String next() {
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
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}