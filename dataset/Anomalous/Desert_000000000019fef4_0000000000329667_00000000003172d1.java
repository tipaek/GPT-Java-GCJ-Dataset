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

        int minimumOperations = d - 1;
        for (long current : sortedValues) {
            int remainingSlices = d;
            int operations = 0;
            int potentialSlices = 0;

            for (int j = arr.length - 1; j >= 0; j--) {
                if (arr[j] % current == 0) {
                    long slices = arr[j] / current;
                    if (slices <= remainingSlices) {
                        remainingSlices -= slices;
                        operations += slices - 1;
                    } else {
                        potentialSlices += slices;
                    }
                } else {
                    potentialSlices += arr[j] / current;
                }
            }

            if (remainingSlices == 0) {
                minimumOperations = Math.min(minimumOperations, operations);
            } else if (potentialSlices >= remainingSlices) {
                operations += remainingSlices;
                minimumOperations = Math.min(minimumOperations, operations);
            }
        }

        return String.valueOf(minimumOperations);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader inputReader = new InputReader(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        int testCount = inputReader.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = inputReader.nextInt();
            int d = inputReader.nextInt();
            long[] arr = inputReader.nextLongArray(n);

            writeTestCase(writer, i + 1, new Solution().getAnswer(n, d, arr));
        }

        writer.close();
    }

    private static void writeTestCase(PrintWriter writer, int caseNumber, String result) {
        writer.printf("Case #%d: %s%n", caseNumber, result);
    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
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
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }
}