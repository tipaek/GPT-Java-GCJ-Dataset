import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final FastReader scanner = new FastReader();

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            String result = findLongestCommonSubstring(n);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String findLongestCommonSubstring(int n) {
        String[] strings = new String[n];
        int maxLength = 0;
        int maxPos = -1;
        boolean isCommonSubstring = true;

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
            if (i >= 1 && maxLength < strings[i].length()) {
                maxLength = strings[i].length();
                maxPos = i;
            }
        }

        for (int i = 0; i < n; i++) {
            String substring = strings[i].substring(1);
            if (isCommonSubstring && !strings[maxPos].contains(substring)) {
                isCommonSubstring = false;
                break;
            }
        }

        return isCommonSubstring ? strings[maxPos].substring(1) : "*";
    }

    private static class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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

        public String nextLine() {
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