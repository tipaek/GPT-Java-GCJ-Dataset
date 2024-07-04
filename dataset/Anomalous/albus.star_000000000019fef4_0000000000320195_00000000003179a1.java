import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        CustomScanner sc = new CustomScanner("input.txt");
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, CustomScanner sc) throws IOException {
        int U = sc.nextInt();
        int[] digitMapping = new int[26];
        Arrays.fill(digitMapping, 9);

        for (int i = 0; i < 10000; i++) {
            long Q = sc.nextLong();
            int digitCount = getDigitCount(Q);
            String R = sc.next();

            if (Q != -1 && digitCount == R.length()) {
                digitMapping[R.charAt(0) - 'A'] = Math.min(digitMapping[R.charAt(0) - 'A'], getFirstDigit(Q));
            }
        }

        boolean[] used = new boolean[26];
        for (int i = 0; i <= 9; i++) {
            int minValue = 10;
            int index = -1;
            for (int j = 0; j < 26; j++) {
                if (used[j]) continue;
                if (digitMapping[j] >= i && minValue > digitMapping[j] - i) {
                    minValue = digitMapping[j] - i;
                    index = j;
                }
            }
            if (index != -1) {
                used[index] = true;
                pw.print((char) (index + 'A'));
            }
        }
    }

    public static int getDigitCount(long number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int getFirstDigit(long number) {
        while (number >= 10) {
            number /= 10;
        }
        return (int) number;
    }

    public static class CustomScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer tokenizer;

        public CustomScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public CustomScanner(String path) throws FileNotFoundException {
            bufferedReader = new BufferedReader(new FileReader(path));
        }

        public int nextInt() throws IOException {
            ensureTokenized();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenized();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokenized();
            return tokenizer.nextToken();
        }

        private void ensureTokenized() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
            }
        }
    }

    public static class Pair<T, V> {
        private final T key;
        private final V value;

        public Pair(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}