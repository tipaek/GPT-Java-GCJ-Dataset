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
                String result = generateResult(n);
                System.out.println("Case #" + i + ": ");
                System.out.println(result);
                System.out.flush();
            }
        }
    }

    private static String generateResult(int n) {
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

        StringBuilder sb = new StringBuilder();
        sb.append("1 1\n");
        for (int i = 2; i <= x + 1; i++) {
            sb.append(i).append(" 2\n");
        }
        while (remaining > 0) {
            sb.append(x + 1).append(" 1\n");
            x++;
            remaining--;
        }
        return sb.toString();
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
        long total = 0;
        for (int[] row : a) {
            for (int value : row) {
                total += value;
            }
        }
        return total;
    }

    private static void test() {
        for (int i = 0; i < 10000; i++) {
            testOnce();
        }
    }

    private static void testOnce() {
        Random random = new Random();
        int n = random.nextInt();
        // Add test logic here if needed
    }

    static final long MOD = 1000000007;

    static long add(long a, long b) {
        long result = a + b;
        if (result < 0) {
            result += MOD;
        }
        return result % MOD;
    }

    static long mul(long a, long b) {
        return (a * b) % MOD;
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
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

    static int[][] getIntMatrix(Scanner in, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = getIntArray(in, col);
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