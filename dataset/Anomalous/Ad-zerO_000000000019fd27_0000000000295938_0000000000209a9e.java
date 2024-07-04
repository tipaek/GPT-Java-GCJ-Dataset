import java.io.*;
import java.util.*;

public class Solution {

    public static final long MOD = 1_000_000_007L;
    public static final double EPSILON = 0.00000000008854;
    public static final InputReader sc = new InputReader(System.in);
    public static final PrintWriter pw = new PrintWriter(System.out);

    public static void dijkstra(PriorityQueue<Pair> q, ArrayList<ArrayList<Pair>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        int n = adjList.size();
        long[] distances = new long[n];
        Arrays.fill(distances, Long.MAX_VALUE);
        q.add(new Pair(0, 0));
        distances[0] = 0;
        int[] parent = new int[n];
        parent[0] = -1;

        while (!q.isEmpty()) {
            Pair current = q.poll();
            if (visited[current.i]) continue;
            visited[current.i] = true;
            int u = current.i;
            for (Pair neighbor : adjList.get(u)) {
                int v = neighbor.i;
                long weight = neighbor.j;
                if (distances[v] > current.j + weight) {
                    parent[v] = u;
                    distances[v] = current.j + weight;
                    q.add(new Pair(v, distances[v]));
                }
            }
        }

        if (distances[n - 1] == Long.MAX_VALUE) {
            pw.println(-1);
            return;
        }

        Stack<Integer> path = new Stack<>();
        for (int i = n - 1; i != -1; i = parent[i]) {
            path.push(i + 1);
        }
        while (!path.isEmpty()) {
            pw.print(path.pop() + " ");
        }
    }

    public static int countSetBits(int a) {
        int count = 0;
        while (a > 0) {
            a &= (a - 1);
            count++;
        }
        return count;
    }

    public static void zFunction(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        pw.println(Arrays.toString(z));
    }

    public static void heightBfs(int root, int[] height, ArrayList<ArrayList<Integer>> adjList, int[] parent, int[] visited) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(root);
        parent[root] = -1;
        visited[root] = 1;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.poll();
                height[node] = level;
                for (int neighbor : adjList.get(node)) {
                    if (visited[neighbor] == 0) {
                        parent[neighbor] = node;
                        visited[neighbor] = 1;
                        queue.add(neighbor);
                    }
                }
            }
            level++;
        }
    }

    public static int heightDfs(int root, int[] height, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] parent) {
        visited[root] = 1;
        for (int neighbor : adjList.get(root)) {
            if (visited[neighbor] == 0) {
                parent[neighbor] = root;
                height[root] = Math.max(height[root], 1 + heightDfs(neighbor, height, adjList, visited, parent));
            }
        }
        return height[root];
    }

    public static ArrayList<ArrayList<Integer>> createGraph(int n, int m) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    public static void dfs(int root, int[][] dp, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] parent, int k) {
        visited[root] = 1;
        dp[root][0] = 1;
        for (int neighbor : adjList.get(root)) {
            if (visited[neighbor] == 0) {
                parent[neighbor] = root;
                dfs(neighbor, dp, adjList, visited, parent, k);
                dp[root][1]++;
                for (int j = 1; j < k; j++) {
                    dp[root][j + 1] += dp[neighbor][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int q = sc.nextInt();
        int b = sc.nextInt();

        for (int p = 1; p <= q; p++) {
            int[][] a = new int[b][4];
            int flipState = 0;
            int firstMismatch = -1;
            int firstMatch = -1;
            int t = 0;

            for (int i = 0; i < b / 2; i++) {
                pw.println(i + 1);
                pw.flush();
                int k1 = sc.nextInt();
                pw.println(b - i);
                pw.flush();
                int k2 = sc.nextInt();
                if (k1 != k2 && firstMismatch == -1) {
                    firstMismatch = i;
                }
                if (k1 == k2 && firstMatch == -1) {
                    firstMatch = i;
                }
                updateArray(a, i, k1, k2, b, flipState);
                t += 2;

                if (t % 10 == 0) {
                    flipState = determineFlipState(a, firstMismatch, firstMatch, flipState);
                    t += 2;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < b; i++) {
                result.append(a[i][flipState]);
            }
            pw.println(result.toString());
            pw.flush();
            String response = sc.nextLine();
            if (response.charAt(0) == 'N') {
                break;
            }
        }
        pw.flush();
        pw.close();
    }

    private static void updateArray(int[][] a, int i, int k1, int k2, int b, int flipState) {
        if (flipState == 0) {
            setArrayValues(a, i, k1, k2, b, 0, 1, 2, 3);
        } else if (flipState == 1) {
            setArrayValues(a, i, k1, k2, b, 1, 0, 3, 2);
        } else if (flipState == 2) {
            setArrayValues(a, i, k2, k1, b, 0, 1, 2, 3);
        } else if (flipState == 3) {
            setArrayValues(a, i, k2, k1, b, 1, 0, 3, 2);
        }
    }

    private static void setArrayValues(int[][] a, int i, int k1, int k2, int b, int idx0, int idx1, int idx2, int idx3) {
        a[i][idx0] = k1;
        a[i][idx1] = k1 ^ 1;
        a[i][idx2] = k2;
        a[i][idx3] = k2 ^ 1;
        a[b - i - 1][idx2] = k1;
        a[b - i - 1][idx3] = k1 ^ 1;
        a[b - i - 1][idx0] = k2;
        a[b - i - 1][idx1] = k2 ^ 1;
    }

    private static int determineFlipState(int[][] a, int firstMismatch, int firstMatch, int currentFlipState) {
        if (firstMismatch == -1) {
            pw.println(1);
            pw.flush();
            int k = sc.nextInt();
            return (k == a[0][0]) ? 0 : 1;
        } else if (firstMatch == -1) {
            pw.println(firstMismatch + 1);
            pw.flush();
            int k = sc.nextInt();
            return (k == a[firstMismatch][0]) ? 0 : 2;
        } else {
            int a1, a2;
            pw.println(firstMismatch + 1);
            pw.flush();
            int k = sc.nextInt();
            if (k == a[firstMismatch][0]) {
                a1 = 0;
                a2 = 3;
            } else {
                a1 = 1;
                a2 = 2;
            }
            pw.println(firstMatch + 1);
            pw.flush();
            k = sc.nextInt();
            return (a[firstMatch][a1] == k) ? a1 : a2;
        }
    }

    public static Comparator<Integer> descendingComparator() {
        return Comparator.reverseOrder();
    }

    public static Comparator<Pair> ascendingPairComparator() {
        return Comparator.comparingLong(o -> o.j);
    }

    static class Triplet implements Comparable<Triplet> {
        Long x, y, z;

        Triplet(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Triplet o) {
            int result = x.compareTo(o.x);
            if (result == 0) result = y.compareTo(o.y);
            if (result == 0) result = z.compareTo(o.z);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Triplet) {
                Triplet p = (Triplet) o;
                return x.equals(p.x) && y.equals(p.y) && z.equals(p.z);
            }
            return false;
        }

        @Override
        public String toString() {
            return x + " " + y + " " + z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }

    public static String formatDouble(double value, int precision) {
        StringBuilder pattern = new StringBuilder("#0.");
        for (int i = 0; i < precision; i++) {
            pattern.append('0');
        }
        DecimalFormat formatter = new DecimalFormat(pattern.toString());
        return formatter.format(value);
    }

    public static Comparator<Integer[]> columnComparator(int index) {
        return (o1, o2) -> o2[index].compareTo(o1[index]);
    }

    public static Comparator<Long[]> longColumnComparator(int index) {
        return Comparator.comparing(o -> o[index]);
    }

    public static Comparator<Integer[]> pairComparator() {
        return (o1, o2) -> {
            int result = o1[0].compareTo(o2[0]);
            if (result == 0) result = o1[1].compareTo(o2[1]);
            return result;
        };
    }

    public static Comparator<Integer[]> tripletComparator() {
        return (o1, o2) -> {
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int p = k + 1; p < 3; p++) {
                            if ((o1[i].equals(o2[k]) && o1[j].equals(o2[p])) || (o1[j].equals(o2[k]) && o1[i].equals(o2[p]))) {
                                // Do nothing
                            }
                        }
                    }
                }
            }
            int result = o1[0].compareTo(o2[0]);
            if (result == 0) result = o1[1].compareTo(o2[1]);
            if (result == 0) result = o1[2].compareTo(o2[2]);
            return result;
        };
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int[] scanIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static long[] scanLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }
        return array;
    }

    public static String[] scanStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLine();
        }
        return array;
    }
}

class Pair {
    int i;
    long j;

    Pair(int i, long j) {
        this.i = i;
        this.j = j;
    }
}

class InputReader {
    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private int nextChar() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
            numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = nextChar();
        while (isSpaceChar(c)) {
            c = nextChar();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = nextChar();
        }
        int result = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            result = result * 10 + c - '0';
            c = nextChar();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public long nextLong() {
        int c = nextChar();
        while (isSpaceChar(c)) {
            c = nextChar();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = nextChar();
        }
        long result = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            result = result * 10 + c - '0';
            c = nextChar();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public String readString() {
        int c = nextChar();
        while (isSpaceChar(c)) {
            c = nextChar();
        }
        StringBuilder result = new StringBuilder();
        do {
            result.appendCodePoint(c);
            c = nextChar();
        } while (!isSpaceChar(c));
        return result.toString();
    }

    public String nextLine() {
        int c = nextChar();
        while (isSpaceChar(c)) {
            c = nextChar();
        }
        StringBuilder result = new StringBuilder();
        do {
            result.appendCodePoint(c);
            c = nextChar();
        } while (!isEndOfLine(c));
        return result.toString();
    }

    private boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }
}