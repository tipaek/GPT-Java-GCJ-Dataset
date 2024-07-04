import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader reader = new FastReader();

    public static void main(String[] args) {
        int testCases = reader.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int N = reader.nextInt();
            String result = findMatchingSubstring(N);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String findMatchingSubstring(int N) {
        String[] strings = new String[N];
        int maxLength = 0;
        int maxPos = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            strings[i] = reader.nextLine();
            if (i >= 1 && strings[i].length() > maxLength) {
                maxLength = strings[i].length();
                maxPos = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String substring = strings[i].substring(1);
            if (isValid && !strings[maxPos].contains(substring)) {
                isValid = false;
                break;
            }
        }

        return isValid ? strings[maxPos].substring(1) : "*";
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