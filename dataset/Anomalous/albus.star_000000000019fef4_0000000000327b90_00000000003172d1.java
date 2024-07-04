import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        boolean[] isComposite = new boolean[600001];
        List<Integer> primes = generatePrimes(isComposite);

        for (int t = 1; t <= testCases; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc, primes);
            pw.println();
        }
        pw.close();
    }

    private static List<Integer> generatePrimes(boolean[] isComposite) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 600000; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                for (int j = i * 2; j <= 600000; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        return primes;
    }

    private static void solve(PrintWriter pw, Scanner sc, List<Integer> primes) throws IOException {
        int n = sc.nextInt();
        int d = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }

        Arrays.sort(array);

        int minOperations = d - 1;

        for (long num : array) {
            int operations = 0;
            int divSum = 0;
            for (long value : array) {
                if (value % num == 0) {
                    long quotient = value / num;
                    if (divSum + quotient > d) {
                        operations += d - divSum;
                        divSum = d;
                    } else {
                        divSum += quotient;
                        operations += quotient - 1;
                    }
                }
                if (divSum == d) break;
            }
            if (divSum == d) {
                minOperations = Math.min(operations, minOperations);
            }
        }
        pw.print(minOperations);
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