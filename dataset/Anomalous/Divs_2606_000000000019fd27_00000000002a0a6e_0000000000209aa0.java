import java.io.*;
import java.util.*;

public class Solution {

    public static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar, numChars;
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') return result * Math.pow(10, nextInt());
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') return result * Math.pow(10, nextInt());
                    if (c < '0' || c > '9') throw new InputMismatchException();
                    m /= 10;
                    result += (c - '0') * m;
                    c = read();
                }
            }
            return result * sign;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    static long gcd(long a, long b) {
        return (a == 0) ? b : gcd(b % a, a);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[col]));
    }

    public static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return (first == null ? 0 : first.hashCode() * 31) + (second == null ? 0 : second.hashCode());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int compareTo(Pair<U, V> other) {
            int cmpU = first.compareTo(other.first);
            return (cmpU != 0) ? cmpU : second.compareTo(other.second);
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", first, second);
        }
    }

    static boolean solutionFound;
    static int[][] ans = new int[60][60];
    static boolean[][] rowSet = new boolean[60][60];
    static boolean[][] colSet = new boolean[60][60];
    static int n, k, t;

    static void solve(int r, int c, int m) {
        if (r == n && c == n + 1 && m == k && !solutionFound) {
            solutionFound = true;
            System.out.println("Case #" + t + ": POSSIBLE");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            return;
        } else if (r > n) {
            return;
        } else if (c > n) {
            solve(r + 1, 1, m);
            return;
        }

        for (int i = 1; i <= n && !solutionFound; i++) {
            if (!rowSet[r][i] && !colSet[c][i]) {
                rowSet[r][i] = colSet[c][i] = true;
                if (r == c) {
                    m += i;
                }
                ans[r][c] = i;
                solve(r, c + 1, m);
                rowSet[r][i] = colSet[c][i] = false;
                if (r == c) {
                    m -= i;
                }
                ans[r][c] = 0;
            }
        }
    }

    static LinkedList<Integer>[] list = new LinkedList[100001];
    static int ans1 = 0, ans2 = 0, max1 = -1;
    static int[] dist = new int[100001];
    static int[] visited = new int[100001];
    static ArrayList<Integer>[] adj = new ArrayList[100001];

    static void bfs(int n, char[] ch) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            int x = ch[u] - '0';
            if (u == n - 1) {
                break;
            }
            for (int i = 0; i < adj[x].size(); i++) {
                if (dist[adj[x].get(i)] == -1) {
                    dist[adj[x].get(i)] = dist[u] + 1;
                    queue.add(adj[x].get(i));
                }
            }
            adj[x].clear();
            if (u > 0 && dist[u - 1] == -1) {
                queue.add(u - 1);
                dist[u - 1] = dist[u] + 1;
            }
            if (dist[u + 1] == -1) {
                queue.add(u + 1);
                dist[u + 1] = dist[u] + 1;
            }
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inReader = new InputReader(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        int d = inReader.nextInt();
        solutionFound = false;
        for (t = 1; t <= d; t++) {
            n = inReader.nextInt();
            k = inReader.nextInt();
            solve(1, 1, 0);
            if (!solutionFound) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
            solutionFound = false;
        }
        writer.close();
    }
}