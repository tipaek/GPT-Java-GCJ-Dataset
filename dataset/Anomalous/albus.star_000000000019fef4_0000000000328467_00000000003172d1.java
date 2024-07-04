import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        boolean[] isPrime = new boolean[600001];
        List<Integer> primes = new ArrayList<>();
        
        for (int i = 2; i <= 600000; i++) {
            if (isPrime[i]) continue;
            primes.add(i);
            for (int j = 2; i * j <= 600000; j++) {
                isPrime[i * j] = true;
            }
        }

        for (int t = 1; t <= testCaseCount; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc, primes);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, Scanner sc, List<Integer> primes) throws IOException {
        int n = sc.nextInt();
        int d = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }

        Arrays.sort(array);
        int minSteps = d - 1;

        for (int i = 0; i < n; i++) {
            minSteps = Math.min(minSteps, calculateMinSteps(array, n, d, array[i]));
        }

        for (int prime : primes) {
            minSteps = Math.min(minSteps, calculateMinSteps(array, n, d, prime));
        }

        pw.print(minSteps);
    }

    private static int calculateMinSteps(long[] array, int n, int d, long divisor) {
        int steps = 0;
        int count = 0;

        for (int j = 0; j < n; j++) {
            if (array[j] % divisor == 0) {
                long quotient = array[j] / divisor;
                if (count + quotient > d) {
                    steps += d - count;
                    count = d;
                } else {
                    count += quotient;
                    steps += quotient - 1;
                }
            }
            if (count == d) {
                break;
            }
        }

        return count == d ? steps : Integer.MAX_VALUE;
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