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

    public static void solve(PrintWriter pw, Scanner sc) throws IOException {
        int U = sc.nextInt();
        int[] digitFrequency = new int[26];
        boolean[] seenCharacters = new boolean[26];
        boolean[] firstPositionCharacters = new boolean[26];

        Arrays.fill(digitFrequency, 9);
        for (int i = 0; i < 10000; i++) {
            long Q = sc.nextLong();
            int digitCount = getDigitCount(Q);
            String R = sc.next();
            for (int j = 0; j < R.length(); j++) {
                seenCharacters[R.charAt(j) - 'A'] = true;
            }
            if (digitCount == R.length() && digitCount >= 2) {
                firstPositionCharacters[R.charAt(0) - 'A'] = true;
                digitFrequency[R.charAt(0) - 'A'] = Math.min(digitFrequency[R.charAt(0) - 'A'], getFirstDigit(Q));
            }
        }

        boolean[] usedCharacters = new boolean[26];
        for (int i = 0; i <= 9; i++) {
            int minDifference = 10;
            int selectedIndex = -1;
            for (int j = 0; j < 26; j++) {
                if (usedCharacters[j] || !seenCharacters[j] || (i == 0 && firstPositionCharacters[j])) continue;
                if (digitFrequency[j] >= i) {
                    if (minDifference > digitFrequency[j] - i) {
                        minDifference = digitFrequency[j] - i;
                        selectedIndex = j;
                    }
                }
            }
            usedCharacters[selectedIndex] = true;
            pw.print((char) (selectedIndex + 'A'));
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