import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                String[] patterns = getStringArray(in, n);
                String result = solvePatterns(n, patterns);
                System.out.println("Case #" + i + ": " + (result == null ? "*" : result));
            }
        }
    }

    private static String solvePatterns(int n, String[] patterns) {
        StringBuilder prefix = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder suffix = new StringBuilder();

        for (String pattern : patterns) {
            int i = 0, j = 0;

            while (i < pattern.length() && pattern.charAt(i) != '*') {
                if (prefix.length() <= i) {
                    prefix.append(pattern.charAt(i));
                } else if (prefix.charAt(i) != pattern.charAt(i)) {
                    return null;
                }
                i++;
            }

            while (j < pattern.length() && pattern.charAt(pattern.length() - 1 - j) != '*') {
                if (suffix.length() <= j) {
                    suffix.insert(0, pattern.charAt(pattern.length() - 1 - j));
                } else if (suffix.charAt(suffix.length() - 1 - j) != pattern.charAt(pattern.length() - 1 - j)) {
                    return null;
                }
                j++;
            }

            j = pattern.length() - 1 - j;
            if (i < j) {
                middle.append(pattern.substring(i, j).replace("*", ""));
            }
        }
        return prefix.append(middle).append(suffix).toString();
    }

    static boolean compareMatrices(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static long sumMatrix(int[][] a) {
        long sum = 0;
        for (int[] row : a) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum;
    }

    private static void test() {
        for (int i = 0; i < 10000; i++) {
            testOnce();
        }
    }

    private static void testOnce() {
        Random random = new Random();
        int n = random.nextInt();
    }

    static final long MOD = 1000000007;

    static long addMod(long a, long b) {
        long result = a + b;
        if (result < 0) {
            result += MOD;
        }
        return result % MOD;
    }

    static long multiplyMod(long a, long b) {
        return (a * b) % MOD;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static String arrayToString(int[] a) {
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static int[] getIntArray(Scanner in, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    static int[][] getIntMatrix(Scanner in, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = getIntArray(in, cols);
        }
        return matrix;
    }

    static char[] getCharArray(Scanner in, int size) {
        return in.next().toCharArray();
    }

    static String[] getStringArray(Scanner in, int size) {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.next();
        }
        return arr;
    }

    static Map<Integer, List<Integer>> getEdges(Scanner in, int size, boolean directed) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            edges.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            if (!directed) {
                edges.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
            }
        }
        return edges;
    }

    static class FastScanner implements Closeable {
        private BufferedReader br;
        private StringTokenizer st;

        FastScanner(File file) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }
}