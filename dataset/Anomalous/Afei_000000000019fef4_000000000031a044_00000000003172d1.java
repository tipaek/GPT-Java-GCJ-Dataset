import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            long[] array = readLongArray(scanner, n);
            int result = computeResult(n, m, array);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }

    private static int computeResult(int n, int m, long[] array) {
        TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
        for (long value : array) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        if (m == 2) {
            for (int count : frequencyMap.values()) {
                if (count > 1) {
                    return 0;
                }
            }
            return 1;
        } else if (m == 3) {
            for (int count : frequencyMap.values()) {
                if (count >= 3) {
                    return 0;
                }
            }
            for (long key : frequencyMap.keySet()) {
                if (frequencyMap.get(key) == 2 && frequencyMap.higherKey(key) != null) {
                    return 1;
                }
                if (frequencyMap.containsKey(2 * key)) {
                    return 1;
                }
            }
            return 2;
        }
        return 0;
    }

    private static long[] readLongArray(Scanner scanner, int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextLong();
        }
        return array;
    }

    private static void runTests() {
        for (int i = 0; i < 10000; i++) {
            runSingleTest();
        }
    }

    private static void runSingleTest() {
        Random random = new Random();
        int n = random.nextInt();
        // Additional test logic can be added here
    }

    static final long MOD = 1000000007;

    static long add(long a, long b) {
        long result = a + b;
        if (result < 0) {
            result += MOD;
        }
        return result % MOD;
    }

    static long multiply(long a, long b) {
        return (a * b) % MOD;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static String arrayToString(int[] array) {
        return Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    static char[] readCharArray(Scanner scanner, int size) {
        return scanner.next().toCharArray();
    }

    static String[] readStringArray(Scanner scanner, int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.next();
        }
        return array;
    }

    static Map<Integer, List<Integer>> readEdges(Scanner scanner, int size, boolean directed) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            edges.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            if (!directed) {
                edges.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
            }
        }
        return edges;
    }

    static class FastScanner implements Closeable {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(File file) {
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        @Override
        public void close() throws IOException {
            reader.close();
        }
    }
}