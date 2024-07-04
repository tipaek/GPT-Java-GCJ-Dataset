import java.io.*;
import java.util.*;

public class Solution {

    private String getAnswer(int n, int d, long[] arr) {
        Map<Long, Integer> frequencyMap = new HashMap<>();
        int highestFrequency = 0;
        Arrays.sort(arr);

        for (long num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            highestFrequency = Math.max(highestFrequency, frequencyMap.get(num));
        }

        if (d == 2) {
            return highestFrequency == 2 ? "0" : "1";
        }

        if (highestFrequency == 3) {
            return "0";
        }

        int maxCombo = 0;
        for (long num : arr) {
            int comboCount = frequencyMap.get(num);
            long doubleNum = num * 2;
            if (frequencyMap.containsKey(doubleNum)) {
                comboCount += 2;
            }
            maxCombo = Math.max(maxCombo, comboCount);
        }

        return maxCombo >= 3 ? "1" : "2";
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

        public long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }
}