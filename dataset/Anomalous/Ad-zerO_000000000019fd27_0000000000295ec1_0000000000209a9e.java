import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Solution {

    public static final long MOD = (long) Math.pow(10, 9) + 7;
    public static final double EPSILON = 0.00000000008854;
    public static final InputReader sc = new InputReader(System.in);
    public static final PrintWriter pw = new PrintWriter(System.out);

    public static void dijkstra(PriorityQueue<Pair> queue, ArrayList<ArrayList<Pair>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Arrays.fill(visited, false);
        int n = graph.size();
        long[] distances = new long[n];
        long inf = Long.MAX_VALUE;
        Arrays.fill(distances, inf);
        queue.add(new Pair(0, 0));
        distances[0] = 0;
        int[] parents = new int[n];
        parents[0] = -1;

        while (!queue.isEmpty()) {
            Pair current = queue.remove();
            if (visited[current.i]) continue;
            visited[current.i] = true;
            int u = current.i;

            for (Pair neighbor : graph.get(u)) {
                int v = neighbor.i;
                long weight = neighbor.j;
                if (distances[v] > current.j + weight) {
                    parents[v] = u;
                    distances[v] = current.j + weight;
                    queue.add(new Pair(v, distances[v]));
                }
            }
        }

        int i = n - 1;
        Stack<Integer> path = new Stack<>();
        if (distances[i] == inf) {
            pw.println(-1);
            return;
        }
        while (i != -1) {
            path.add(i + 1);
            i = parents[i];
        }
        while (!path.isEmpty()) {
            pw.print(path.pop() + " ");
        }
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    public static void computeZFunction(String s) {
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

    public static void computeHeightsBFS(int root, int[] heights, ArrayList<ArrayList<Integer>> graph, int[] parents, int[] visited) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        parents[root] = -1;
        visited[root] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.remove();
                heights[node] = level;
                for (int neighbor : graph.get(node)) {
                    if (visited[neighbor] == 0) {
                        parents[neighbor] = node;
                        visited[neighbor] = 1;
                        queue.add(neighbor);
                    }
                }
            }
            level++;
        }
    }

    public static int computeHeightsDFS(int root, int[] heights, ArrayList<ArrayList<Integer>> graph, int[] visited, int[] parents) {
        visited[root] = 1;
        for (int neighbor : graph.get(root)) {
            if (visited[neighbor] == 0) {
                parents[neighbor] = root;
                heights[root] += Math.max(1 + computeHeightsDFS(neighbor, heights, graph, visited, parents), heights[root]);
            }
        }
        return heights[root];
    }

    public static ArrayList<ArrayList<Integer>> createGraph(int nodes, int edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    public static void computeDP(int root, int[][] dp, ArrayList<ArrayList<Integer>> graph, int[] visited, int[] parents, int k) {
        visited[root] = 1;
        for (int neighbor : graph.get(root)) {
            dp[root][0] = 1;
            if (visited[neighbor] == 0) {
                parents[neighbor] = root;
                computeDP(neighbor, dp, graph, visited, parents, k);
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
            int f = 0, f1 = -1, f2 = -1;
            for (int i = 0; i < b / 2; i++) {
                pw.println(i + 1);
                pw.flush();
                int k1 = sc.nextInt();
                pw.println(b - i);
                pw.flush();
                int k2 = sc.nextInt();
                if (k1 != k2 && f1 == -1) {
                    f1 = i;
                }
                if (k1 == k2 && f2 == -1) {
                    f2 = i;
                }
                if (f == 0) {
                    a[i][0] = k1;
                    a[i][1] = k1 ^ 1;
                    a[i][2] = k2;
                    a[i][3] = k2 ^ 1;
                    a[b - i - 1][2] = k1;
                    a[b - i - 1][3] = k1 ^ 1;
                    a[b - i - 1][0] = k2;
                    a[b - i - 1][1] = k2 ^ 1;
                } else if (f == 1) {
                    a[i][1] = k1;
                    a[i][0] = k1 ^ 1;
                    a[i][3] = k2;
                    a[i][2] = k2 ^ 1;
                    a[b - i - 1][3] = k1;
                    a[b - i - 1][2] = k1 ^ 1;
                    a[b - i - 1][1] = k2;
                    a[b - i - 1][0] = k2 ^ 1;
                } else if (f == 2) {
                    a[i][0] = k2;
                    a[i][1] = k2 ^ 1;
                    a[i][2] = k1;
                    a[i][3] = k1 ^ 1;
                    a[b - i - 1][2] = k2;
                    a[b - i - 1][3] = k2 ^ 1;
                    a[b - i - 1][0] = k1;
                    a[b - i - 1][1] = k1 ^ 1;
                } else if (f == 3) {
                    a[i][1] = k2;
                    a[i][0] = k2 ^ 1;
                    a[i][3] = k1;
                    a[i][2] = k1 ^ 1;
                    a[b - i - 1][3] = k2;
                    a[b - i - 1][2] = k2 ^ 1;
                    a[b - i - 1][1] = k1;
                    a[b - i - 1][0] = k1 ^ 1;
                }
                if ((i + 1) * 2 % 10 == 0) {
                    if (f1 == -1) {
                        pw.println(1);
                        pw.flush();
                        int k = sc.nextInt();
                        f = (k == a[0][0]) ? 0 : 1;
                    } else if (f2 == -1) {
                        pw.println(f1 + 1);
                        pw.flush();
                        int k = sc.nextInt();
                        f = (k == a[f1][0]) ? 0 : 2;
                    } else {
                        int a1 = 0, a2 = 0;
                        pw.println(f1 + 1);
                        pw.flush();
                        int k = sc.nextInt();
                        if (k == a[f1][0]) {
                            a1 = 0;
                            a2 = 3;
                        } else {
                            a1 = 1;
                            a2 = 2;
                        }
                        pw.println(f2 + 1);
                        pw.flush();
                        k = sc.nextInt();
                        f = (a[f2][a1] == k) ? a1 : a2;
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < b; i++) {
                result.append(a[i][f]);
            }
            pw.println(result);
            pw.flush();
            String response = sc.nextLine();
            if (response.charAt(0) == 'N') {
                break;
            }
        }
        pw.flush();
        pw.close();
    }

    public static Comparator<Integer> descendingComparator() {
        return (o1, o2) -> o2.compareTo(o1);
    }

    public static Comparator<Pair> dijkstraComparator() {
        return (o1, o2) -> Long.compare(o1.j, o2.j);
    }

    static class TripletL implements Comparable<TripletL> {
        Long x, y, z;

        TripletL(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(TripletL o) {
            int result = x.compareTo(o.x);
            if (result == 0) result = y.compareTo(o.y);
            if (result == 0) result = z.compareTo(o.z);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof TripletL) {
                TripletL p = (TripletL) o;
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
        DecimalFormat format = new DecimalFormat(pattern.toString());
        return format.format(value);
    }

    public static Comparator<Integer[]> columnComparator(int index) {
        return (o1, o2) -> o2[index].compareTo(o1[index]);
    }

    public static Comparator<Long[]> columnLongComparator(int index) {
        return (o1, o2) -> o1[index].compareTo(o2[index]);
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
    private final byte[] buffer = new byte[8192];
    private int curChar, numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int nextChar() {
        if (numChars == -1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) return -1;
        }
        return buffer[curChar++];
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
            if (c < '0' || c > '9') throw new InputMismatchException();
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
            if (c < '0' || c > '9') throw new InputMismatchException();
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
        while (isSpaceChar(c)) c = nextChar();
        StringBuilder result = new StringBuilder();
        do {
            result.appendCodePoint(c);
            c = nextChar();
        } while (!isEndOfLine(c));
        return result.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }
}