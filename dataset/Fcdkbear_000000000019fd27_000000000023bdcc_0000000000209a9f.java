import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            String s = in.next();
            StringBuilder result = new StringBuilder();
            int balance = 0;
            for (char c : s.toCharArray()) {
                int number = c - '0';
                if (number > balance) {
                    for (int i = 0; i < number - balance; ++i) {
                        result.append("(");
                    }
                } else {
                    for (int i = 0; i < balance - number; ++i) {
                        result.append(")");
                    }
                }
                result.append(c);
                balance = number;
            }
            for (int i = 0; i < balance; ++i) {
                result.append(")");
            }
            out.printf("Case #%d: %s\n", testNumber, result.toString());
        }
        out.close();

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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


    }
}
