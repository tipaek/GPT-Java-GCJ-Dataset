import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();

        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            System.out.println(1);
            System.out.flush();
            scanner.next();

            StringBuilder bitString = new StringBuilder();
            for (int i = 1; i <= bitLength; i++) {
                System.out.println(i);
                System.out.flush();
                bitString.append(scanner.next());
            }

            System.out.println(bitString.toString());
            if (scanner.next().equals("N")) {
                return;
            }
        }
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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

        String nextLine() {
            String line = "";
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}