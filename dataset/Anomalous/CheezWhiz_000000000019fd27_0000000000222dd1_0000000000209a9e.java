import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();

        int testCases = reader.nextInt();
        int bits = reader.nextInt();
        for (int t = 0; t < testCases; t++) {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= bits; i++) {
                System.out.println(i);
                System.out.flush();
                result.append(reader.next());
            }
            System.out.println(result);
            if (reader.next().equals("N")) {
                return;
            }
        }
    }

    static class FastReader {
        BufferedReader bufferedReader;
        StringTokenizer tokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(bufferedReader.readLine());
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
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}