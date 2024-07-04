import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static InputReader input = new InputReader(System.in);
    static PrintWriter output = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = input.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = input.nextInt();
            int d = input.nextInt();
            long[] numbers = new long[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = input.nextLong();
            }
            Arrays.sort(numbers);

            if (d == 2) {
                boolean foundPair = false;
                for (int i = 0; i < n - 1; i++) {
                    if (numbers[i] == numbers[i + 1]) {
                        foundPair = true;
                        break;
                    }
                }
                output.println("Case #" + caseNum + ": " + (foundPair ? 0 : 1));
            } else {
                boolean foundTriple = false;
                boolean foundDouble = false;
                for (int i = 0; i < n - 2; i++) {
                    if (numbers[i] == numbers[i + 1] && numbers[i + 1] == numbers[i + 2]) {
                        foundTriple = true;
                        break;
                    }
                }
                for (int i = 0; i < n - 1; i++) {
                    if (numbers[i] == numbers[i + 1] || Arrays.binarySearch(numbers, 2 * numbers[i]) >= 0) {
                        foundDouble = true;
                        break;
                    }
                }
                if (foundTriple) {
                    output.println("Case #" + caseNum + ": " + 0);
                } else if (foundDouble) {
                    output.println("Case #" + caseNum + ": " + 1);
                } else {
                    output.println("Case #" + caseNum + ": " + 2);
                }
            }
        }
        output.close();
    }
}