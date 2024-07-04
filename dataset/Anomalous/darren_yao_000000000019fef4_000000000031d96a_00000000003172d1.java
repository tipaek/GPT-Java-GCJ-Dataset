import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

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

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static InputReader inputReader = new InputReader(System.in);
    static PrintWriter printWriter = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = inputReader.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int arrayLength = inputReader.nextInt();
            int d = inputReader.nextInt();
            long[] array = new long[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                array[i] = inputReader.nextLong();
            }
            Arrays.sort(array);
            handleTestCase(testCase, array, d);
        }
        printWriter.close();
    }

    private static void handleTestCase(int testCase, long[] array, int d) {
        if (d == 2) {
            boolean hasDuplicate = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] == array[i + 1]) {
                    hasDuplicate = true;
                    break;
                }
            }
            printWriter.println("Case #" + testCase + ": " + (hasDuplicate ? 0 : 1));
        } else {
            boolean hasTriple = false;
            boolean hasDouble = false;
            for (int i = 0; i < array.length - 2; i++) {
                if (array[i] == array[i + 1] && array[i + 1] == array[i + 2]) {
                    hasTriple = true;
                    break;
                }
            }
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] == array[i + 1] || Arrays.binarySearch(array, 2 * array[i]) >= 0) {
                    hasDouble = true;
                    break;
                }
            }
            if (hasTriple) {
                printWriter.println("Case #" + testCase + ": " + 0);
            } else if (hasDouble) {
                printWriter.println("Case #" + testCase + ": " + 1);
            } else {
                printWriter.println("Case #" + testCase + ": " + 2);
            }
        }
    }
}