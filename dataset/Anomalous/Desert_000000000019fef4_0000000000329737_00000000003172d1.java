import java.io.*;
import java.util.*;

public class Solution {

    private String getAnswer(int n, int d, long[] arr) {
        Arrays.sort(arr);

        Set<Long> uniqueValues = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                uniqueValues.add(arr[i]);
                uniqueValues.add(arr[j]);
                uniqueValues.add(gcd(arr[i], arr[j]));
            }
        }

        List<Long> sortedValues = new ArrayList<>(uniqueValues);
        Collections.sort(sortedValues);

        int minimumResult = d - 1;
        for (long current : sortedValues) {
            int remainingD = d;
            int result = 0;
            int potentialSlices = 0;

            for (int j = arr.length - 1; j >= 0; j--) {
                if (arr[j] % current == 0) {
                    long slices = arr[j] / current;
                    if (slices <= remainingD) {
                        remainingD -= slices;
                        result += slices - 1;
                    }
                } else {
                    potentialSlices += arr[j] / current;
                }
            }

            if (remainingD == 0) {
                minimumResult = Math.min(minimumResult, result);
            } else if (potentialSlices >= remainingD) {
                result += remainingD;
                minimumResult = Math.min(minimumResult, result);
            }
        }

        return String.valueOf(minimumResult);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader inputReader = new InputReader(inputStream);
        PrintWriter outputWriter = new PrintWriter(outputStream);

        int testCount = inputReader.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = inputReader.nextInt();
            int d = inputReader.nextInt();
            long[] array = inputReader.nextLongArray(n);

            outputTestCase(outputWriter, i + 1, new Solution().getAnswer(n, d, array));
        }

        outputWriter.close();
    }

    private static void outputTestCase(PrintWriter writer, int testCaseNumber, Object result) {
        writer.println(String.format("Case #%d: %s", testCaseNumber, result.toString()));
    }

    static class InputReader {
        private final BufferedReader reader;
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
    }
}