import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 1; t <= testCases; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    private static void solve(PrintWriter pw, Scanner sc) throws IOException {
        int U = sc.nextInt();
        int[] digitConstraints = new int[26];
        boolean[] isUsed = new boolean[26];
        boolean[] cannotBeZero = new boolean[26];

        Arrays.fill(digitConstraints, 9);
        for (int i = 0; i < 10000; i++) {
            long Q = sc.nextLong();
            int digitCount = getDigitCount(Q);
            String R = sc.next();

            for (char c : R.toCharArray()) {
                isUsed[c - 'A'] = true;
            }

            if (R.length() >= 2 || R.length() == 1) {
                cannotBeZero[R.charAt(0) - 'A'] = true;
            }

            if (digitCount == R.length() && digitCount >= 2) {
                cannotBeZero[R.charAt(0) - 'A'] = true;
                digitConstraints[R.charAt(0) - 'A'] = Math.min(digitConstraints[R.charAt(0) - 'A'], getFirstDigit(Q));
            }
        }

        boolean[] assignedDigits = new boolean[26];
        for (int i = 0; i <= 9; i++) {
            int minDifference = 10;
            int selectedIndex = -1;
            for (int j = 0; j < 26; j++) {
                if (assignedDigits[j] || !isUsed[j] || (i == 0 && cannotBeZero[j])) continue;
                if (i != 0 && cannotBeZero[j]) continue;
                if (digitConstraints[j] >= i && minDifference > digitConstraints[j] - i) {
                    minDifference = digitConstraints[j] - i;
                    selectedIndex = j;
                }
            }
            assignedDigits[selectedIndex] = true;
            pw.print((char) (selectedIndex + 'A'));
        }
    }

    private static int getDigitCount(long number) {
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

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer tokenizer;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public Scanner(String filePath) throws FileNotFoundException {
            bufferedReader = new BufferedReader(new FileReader(filePath));
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