import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        boolean[] isNotPrime = new boolean[600001];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= 600000; i++) {
            if (isNotPrime[i]) continue;
            primes.add(i);
            for (int j = i * 2; j <= 600000; j += i) {
                isNotPrime[j] = true;
            }
        }

        for (int t = 1; t <= testCaseCount; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc, primes);
            pw.println();
        }
        pw.close();
    }

    private static void solve(PrintWriter pw, Scanner sc, List<Integer> primes) throws IOException {
        int n = sc.nextInt();
        int d = sc.nextInt();
        int minOperations = d - 1;
        long[] array = new long[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong() * d;
        }

        Arrays.sort(array);

        for (long value : array) {
            minOperations = Math.min(minOperations, calculateOperations(array, value, d));
        }

        for (int prime : primes) {
            minOperations = Math.min(minOperations, calculateOperations(array, prime, d));
        }

        pw.print(minOperations);
    }

    private static int calculateOperations(long[] array, long divisor, int d) {
        int cnt = 0;
        int dd = 0;

        for (long value : array) {
            if (value % divisor == 0) {
                long quotient = value / divisor;
                if (dd + quotient > d) {
                    cnt += d - dd;
                    dd = d;
                } else {
                    dd += quotient;
                    cnt += quotient - 1;
                }
            }
            if (dd == d) {
                break;
            }
        }

        return dd == d ? cnt : Integer.MAX_VALUE;
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