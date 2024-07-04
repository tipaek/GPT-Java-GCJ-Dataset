import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = in.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                int u = in.nextInt();
                long[] m = new long[10000];
                String[] s = new String[10000];
                for (int j = 0; j < 10000; j++) {
                    m[j] = in.nextLong();
                    s[j] = in.next();
                }
                String result = findSolution(u, m, s);
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static String findSolution(int u, long[] m, String[] s) {
        Set<Character> allChars = new HashSet<>();
        Set<Character> initialChars = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            for (char c : s[i].toCharArray()) {
                allChars.add(c);
            }
            if (s[i].length() > 1) {
                initialChars.add(s[i].charAt(0));
            }
        }

        Map<Character, Integer> minValues = new HashMap<>();
        Map<Character, Integer> maxValues = new HashMap<>();
        for (char c : allChars) {
            maxValues.put(c, 9);
            minValues.put(c, initialChars.contains(c) ? 1 : 0);
        }

        for (int i = 0; i < 10000; i++) {
            char firstChar = s[i].charAt(0);
            if (m[i] >= 10 && s[i].length() == 2) {
                maxValues.put(firstChar, Math.min(maxValues.get(firstChar), (int) m[i] / 10));
            }
            if (m[i] < 10 && s[i].length() == 1) {
                maxValues.put(firstChar, Math.min(maxValues.get(firstChar), (int) m[i]));
            }
        }

        char[] code = new char[10];
        for (char c : minValues.keySet()) {
            if (minValues.get(c) == 0) {
                code[0] = c;
                maxValues.remove(c);
                break;
            }
        }

        for (char c : maxValues.keySet()) {
            code[maxValues.get(c)] = c;
        }

        return String.valueOf(code);
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

    static long add(long a, long b) {
        long result = a + b;
        return (result < 0 ? result + MOD : result) % MOD;
    }

    static long multiply(long a, long b) {
        return (a * b) % MOD;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static String arrayToString(int[] array) {
        return Arrays.stream(array)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(" "));
    }

    static long[] readLongArray(Scanner in, int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextLong();
        }
        return array;
    }

    static char[] readCharArray(Scanner in, int size) {
        return in.next().toCharArray();
    }

    static String[] readStringArray(Scanner in, int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.next();
        }
        return array;
    }

    static Map<Integer, List<Integer>> readEdges(Scanner in, int size, boolean directed) {
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