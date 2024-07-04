import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            String result = computeResult(n);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }

    private static String computeResult(int n) {
        if (n == 1) {
            return "1 1";
        }
        if (n == 2) {
            return "1 1\n2 1";
        }

        int x = (int) Math.sqrt((n - 1) * 2);
        int remaining = n - x * (x + 1) / 2 - 1;
        while (remaining < 0) {
            x--;
            remaining = n - x * (x + 1) / 2 - 1;
        }

        StringBuilder result = new StringBuilder("1 1\n");
        for (int i = 2; i <= x + 1; i++) {
            result.append(i).append(" 2\n");
        }
        
        for (int i = x + 2; remaining > 0; remaining--) {
            result.append(i++).append(" 1\n");
        }

        return result.toString();
    }

    static boolean compare(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static long sum(int[][] a) {
        long totalSum = 0;
        for (int[] row : a) {
            for (int value : row) {
                totalSum += value;
            }
        }
        return totalSum;
    }

    private static void test() {
        for (int i = 0; i < 10000; i++) {
            testOnce();
        }
    }

    private static void testOnce() {
        Random random = new Random();
        int n = random.nextInt();
        // Add test logic here
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
        return (b == 0) ? a : gcd(b, a % b);
    }

    static String arrayToString(int[] array) {
        return Arrays.stream(array)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(" "));
    }

    static int[] readIntArray(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    static int[][] readIntMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readIntArray(scanner, cols);
        }
        return matrix;
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