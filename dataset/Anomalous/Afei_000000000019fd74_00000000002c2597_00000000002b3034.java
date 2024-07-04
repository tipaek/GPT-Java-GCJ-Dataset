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
        StringBuilder suffix = new StringBuilder();

        for (String pattern : patterns) {
            if (!matchPrefix(prefix, pattern) || !matchSuffix(suffix, pattern)) {
                return null;
            }
        }
        return prefix.append(suffix).toString();
    }

    private static boolean matchPrefix(StringBuilder prefix, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '*') break;

            if (prefix.length() <= i) {
                prefix.append(c);
            } else if (prefix.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }

    private static boolean matchSuffix(StringBuilder suffix, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(pattern.length() - 1 - i);
            if (c == '*') break;

            if (suffix.length() <= i) {
                suffix.insert(0, c);
            } else if (suffix.charAt(suffix.length() - 1 - i) != c) {
                return false;
            }
        }
        return true;
    }

    private static int[][] readIntMatrix(Scanner in, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = getIntArray(in, cols);
        }
        return matrix;
    }

    private static int[] getIntArray(Scanner in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    private static String[] getStringArray(Scanner in, int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.next();
        }
        return array;
    }

    private static long mod = 1000000007;

    private static long addMod(long a, long b) {
        long result = (a + b) % mod;
        return result < 0 ? result + mod : result;
    }

    private static long mulMod(long a, long b) {
        return (a * b) % mod;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static String arrayToString(int[] array) {
        return Arrays.stream(array)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(" "));
    }

    private static Map<Integer, List<Integer>> readEdges(Scanner in, int size, boolean directed) {
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