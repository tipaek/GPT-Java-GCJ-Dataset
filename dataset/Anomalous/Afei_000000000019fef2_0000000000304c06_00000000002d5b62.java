import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String result = findPath(x, y);
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static String findPath(int x, int y) {
        Map<Integer, String> directionMap = new HashMap<>();
        if (x >= 0) {
            directionMap.put(1, "E");
            directionMap.put(-1, "W");
        } else {
            directionMap.put(-1, "E");
            directionMap.put(1, "W");
        }
        if (y >= 0) {
            directionMap.put(2, "N");
            directionMap.put(-2, "S");
        } else {
            directionMap.put(-2, "N");
            directionMap.put(2, "S");
        }
        return findPath(Math.abs(x), Math.abs(y), directionMap);
    }

    private static String findPath(long x, long y, Map<Integer, String> directionMap) {
        if (x % 2 == y % 2) {
            return "IMPOSSIBLE";
        }
        
        StringBuilder path = new StringBuilder();
        long[] coordinates = {x, y};
        int[] steps = new int[35];
        int lastStep = (y % 2 == 1) ? 1 : 0;

        for (int i = 0; (1L << i) <= Math.max(Long.highestOneBit(coordinates[0]), Long.highestOneBit(coordinates[1])); i++) {
            long mask = 1L << i;
            if ((coordinates[0] & mask) != 0 && (coordinates[1] & mask) == 0) {
                lastStep = 0;
                steps[i] = lastStep + 1;
            } else if ((coordinates[1] & mask) != 0 && (coordinates[0] & mask) == 0) {
                lastStep = 1;
                steps[i] = lastStep + 1;
            } else if ((coordinates[1] & mask) == 0 && (coordinates[0] & mask) == 0) {
                steps[i] = lastStep + 1;
                coordinates[lastStep] ^= mask;
                steps[i - 1] *= -1;
            } else {
                coordinates[lastStep] += mask;
                steps[i - 1] *= -1;
                lastStep = 1 - lastStep;
                steps[i] = lastStep + 1;
            }
        }

        for (int i = 0; (1L << i) <= Math.max(Long.highestOneBit(coordinates[0]), Long.highestOneBit(coordinates[1])); i++) {
            path.append(directionMap.get(steps[i]));
        }

        return path.toString();
    }

    private static void runTests() {
        for (int i = 0; i < 10000; i++) {
            runSingleTest();
        }
    }

    private static void runSingleTest() {
        Random random = new Random();
        int n = random.nextInt();
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