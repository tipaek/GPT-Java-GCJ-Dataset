import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();

        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int b = scanner.nextInt();
            System.out.println(1);
            System.out.flush();
            scanner.next();
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                System.out.flush();
                result.append(scanner.next());
            }
            System.out.println(result.toString());
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
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
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
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}