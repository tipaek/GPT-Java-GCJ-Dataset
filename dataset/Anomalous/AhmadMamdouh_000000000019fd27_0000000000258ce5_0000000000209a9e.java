import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int testCases = inputReader.nextInt();
        int base = inputReader.nextInt();

        while (testCases-- > 0) {
            if (base == 10) {
                int[] numbers = new int[10];
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println((i + 1));
                    numbers[i] = inputReader.nextInt();
                }
                for (int number : numbers) {
                    System.out.print(number);
                }
                System.out.println();
            }
            String response = inputReader.next();
            if (response.startsWith("N")) {
                return;
            }
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            tokenizer = null;
        }

        public InputReader(FileReader fileReader) {
            reader = new BufferedReader(fileReader);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
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
}