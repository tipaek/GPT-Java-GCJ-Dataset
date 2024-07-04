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
        int[] digitCount = new int[26];
        boolean[] hasAppeared = new boolean[26];
        boolean[] cannotBeZero = new boolean[26];

        Arrays.fill(digitCount, 9);
        for (int i = 0; i < 10000; i++) {
            long Q = sc.nextLong();
            int digitLength = getCount(Q);
            String R = sc.next();
            for (int j = 0; j < R.length(); j++) {
                hasAppeared[R.charAt(j) - 'A'] = true;
            }

            if (digitLength >= 2) {
                cannotBeZero[R.charAt(0) - 'A'] = true;
            }

            if (digitLength == R.length()) {
                if (digitLength >= 2) {
                    cannotBeZero[R.charAt(0) - 'A'] = true;
                    digitCount[R.charAt(0) - 'A'] = Math.min(digitCount[R.charAt(0) - 'A'], getFirst(Q));
                }
            }
        }

        boolean[] usedDigits = new boolean[26];
        for (int i = 0; i <= 9; i++) {
            int min = 10;
            int index = -1;
            for (int j = 0; j < 26; j++) {
                if (usedDigits[j] || !hasAppeared[j] || (i == 0 && cannotBeZero[j])) continue;
                if (digitCount[j] >= i) {
                    if (min > digitCount[j] - i) {
                        min = digitCount[j] - i;
                        index = j;
                    }
                }
            }
            usedDigits[index] = true;
            pw.print((char) (index + 'A'));
        }
    }

    public static int getCount(long number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int getFirst(long number) {
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
        private T key;
        private V value;

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