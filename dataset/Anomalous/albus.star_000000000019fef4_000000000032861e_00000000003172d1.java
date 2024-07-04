import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int TEST_CASE = sc.nextInt();
        boolean[] isNotPrime = new boolean[600001];
        List<Integer> primes = new ArrayList<>();
        
        // Sieve of Eratosthenes to find all primes up to 600000
        for (int i = 2; i <= 600000; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = 2 * i; j <= 600000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int t = 1; t <= TEST_CASE; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc, primes);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, Scanner sc, List<Integer> primes) throws IOException {
        int n = sc.nextInt();
        int d = sc.nextInt();
        int minOperations = d - 1;
        long[] array = new long[n];
        
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong() * d;
        }

        Arrays.sort(array);
        
        for (long value : array) {
            minOperations = Math.min(minOperations, calculateMinOperations(array, value, d));
        }

        for (int prime : primes) {
            minOperations = Math.min(minOperations, calculateMinOperations(array, prime * d, d));
        }

        pw.print(minOperations);
    }

    private static int calculateMinOperations(long[] array, long target, int d) {
        int operations = 0;
        int currentD = 0;
        
        for (long value : array) {
            if (value % target == 0) {
                long div = value / target;
                if (currentD + div > d) {
                    operations += d - currentD;
                    currentD = d;
                } else {
                    currentD += div;
                    operations += div - 1;
                }
            }
            if (currentD == d) {
                break;
            }
        }
        
        return currentD == d ? operations : d - 1;
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