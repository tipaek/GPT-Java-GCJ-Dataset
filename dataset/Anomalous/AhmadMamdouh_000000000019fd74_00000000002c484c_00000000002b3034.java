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
        int testCaseNumber = 1;

        while (testCases-- > 0) {
            int n = inputReader.nextInt();
            String[] strings = new String[n];
            String longestSuffix = "";
            int maxLength = -1;

            for (int i = 0; i < n; i++) {
                strings[i] = inputReader.next().substring(1);
                if (strings[i].length() > maxLength) {
                    longestSuffix = strings[i];
                    maxLength = strings[i].length();
                }
            }

            boolean isSuffix = true;
            for (String str : strings) {
                if (!longestSuffix.endsWith(str)) {
                    isSuffix = false;
                    break;
                }
            }

            if (isSuffix) {
                System.out.printf("Case #%d: %s\n", testCaseNumber++, longestSuffix);
            } else {
                System.out.printf("Case #%d: *\n", testCaseNumber++);
            }
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileReader fileReader) {
            reader = new BufferedReader(fileReader);
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