import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    private static void solve(PrintWriter pw, Scanner sc) throws IOException {
        int U = sc.nextInt();
        int[] digitFrequency = new int[26];
        boolean[] isPresentInString = new boolean[26];
        boolean[] isLeadingDigit = new boolean[26];

        Arrays.fill(digitFrequency, 9);
        for (int i = 0; i < 10000; i++) {
            long Q = sc.nextLong();
            int digitCount = countDigits(Q);
            String R = sc.next();
            markCharacters(R, isPresentInString);

            if (R.length() >= 2 || R.length() == 1) {
                isLeadingDigit[R.charAt(0) - 'A'] = true;
            }

            if (digitCount == R.length() && digitCount >= 2) {
                isLeadingDigit[R.charAt(0) - 'A'] = true;
                digitFrequency[R.charAt(0) - 'A'] = Math.min(digitFrequency[R.charAt(0) - 'A'], getFirstDigit(Q));
            }
        }

        boolean[] usedDigits = new boolean[26];
        for (int i = 0; i <= 9; i++) {
            int min = 10;
            int index = -1;
            for (int j = 0; j < 26; j++) {
                if (usedDigits[j] || !isPresentInString[j] || (i == 0 && isLeadingDigit[j])) continue;
                if (digitFrequency[j] >= i) {
                    if (min > digitFrequency[j] - i) {
                        min = digitFrequency[j] - i;
                        index = j;
                    }
                }
            }

            usedDigits[index] = true;
            pw.print((char) (index + 'A'));
        }
    }

    private static int countDigits(long number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    private static int getFirstDigit(long number) {
        while (number >= 10) {
            number /= 10;
        }
        return (int) number;
    }

    private static void markCharacters(String str, boolean[] isPresent) {
        for (int j = 0; j < str.length(); j++) {
            isPresent[str.charAt(j) - 'A'] = true;
        }
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer tokenizer;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public Scanner(String path) throws FileNotFoundException {
            bufferedReader = new BufferedReader(new FileReader(path));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenizer();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokenizer();
            return tokenizer.nextToken();
        }

        private void ensureTokenizer() throws IOException {
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