import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String moves = scanner.next();
                int result = calculateMinimumTime(x, y, moves);
                System.out.println("Case #" + caseNumber + ": " + (result == -1 ? "IMPOSSIBLE" : result));
            }
        }
    }

    private static int calculateMinimumTime(int x, int y, String moves) {
        Map<Character, int[]> directions = new HashMap<>();
        directions.put('E', new int[]{1, 0});
        directions.put('W', new int[]{-1, 0});
        directions.put('N', new int[]{0, 1});
        directions.put('S', new int[]{0, -1});

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            x += directions.get(move)[0];
            y += directions.get(move)[1];
            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                return i + 1;
            }
        }
        return -1;
    }

    private static void runTests() {
        for (int i = 0; i < 10000; i++) {
            performSingleTest();
        }
    }

    private static void performSingleTest() {
        Random random = new Random();
        int randomValue = random.nextInt();
    }

    private static final long MOD = 1000000007;

    private static long addMod(long a, long b) {
        long result = a + b;
        if (result < 0) {
            result += MOD;
        }
        return result % MOD;
    }

    private static long multiplyMod(long a, long b) {
        return (a * b) % MOD;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static String arrayToString(int[] array) {
        return Arrays.stream(array)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(" "));
    }

    private static long[] readLongArray(Scanner scanner, int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextLong();
        }
        return array;
    }

    private static char[] readCharArray(Scanner scanner, int size) {
        return scanner.next().toCharArray();
    }

    private static String[] readStringArray(Scanner scanner, int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.next();
        }
        return array;
    }

    private static Map<Integer, List<Integer>> readEdges(Scanner scanner, int size, boolean directed) {
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