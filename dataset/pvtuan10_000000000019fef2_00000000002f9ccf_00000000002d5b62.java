import java.io.*;
import java.util.*;

public class Solution {
    static FastScanner in;
    static PrintWriter out;
    static final long MOD = 1000000007;
    static final int SIZE = 101;
    static int min;
    static String ans;

    public static void main(String[] args) throws IOException {
        // Scanner in = new Scanner(new File("input.txt"));
        // Scanner in = new Scanner(System.in);
        // System.setOut(new PrintStream(new BufferedOutputStream(new
        // FileOutputStream("output.txt")), true));
        out = new PrintWriter(System.out);
        in = new FastScanner(System.in);
//        in = new FastScanner("/home/pvtuan10/IdeaProjects/CompetitiveProgramming/src/input.txt");
        int t = in.nextInt();
        for (int tt = 1;tt <= t;tt++) {
            out.print("Case #" + tt + ": ");
            int x = in.nextInt();
            int y = in.nextInt();
            if ((x + y) % 2 == 0) {
                out.println("IMPOSSIBLE");
            } else {
                min = Integer.MAX_VALUE;
                dfs(0, 0, x, y, 0, new StringBuilder(), new HashMap<>());
                out.println(ans);
            }
        }
        out.close();
    }

    static void dfs(int x, int y, int targetX, int targetY, int depth, StringBuilder sb, Map<Integer, Set<Integer>> visited) {
//        System.out.println(sb.toString());
        if (x == targetX && y == targetY) {
            if (depth < min) {
                min = depth;
                ans = sb.toString();
            }
        }

        if (depth > 31) return;
        if (x <= -SIZE || x >= SIZE || y <= -SIZE || y >= SIZE) return;
        if (visited.getOrDefault(x, new HashSet<>()).contains(y)) return;

        if (!visited.containsKey(x)) {
            visited.put(x, new HashSet<>());
        }
        visited.get(x).add(y);
        int next = (int)Math.pow(2, depth);
        int len = sb.length();

        dfs(x + next, y, targetX, targetY, depth + 1, sb.append("E"), visited);
        sb.setLength(len);
        dfs(x - next, y, targetX, targetY, depth + 1, sb.append("W"), visited);
        sb.setLength(len);
        dfs(x, y + next, targetX, targetY, depth + 1, sb.append("N"), visited);
        sb.setLength(len);
        dfs(x, y - next, targetX, targetY, depth + 1, sb.append("S"), visited);
        sb.setLength(len);

        visited.get(x).remove(y);
    }
}

class UF {
    private int[] parents;
    private int[] rank;

    public UF(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;
        rank = new int[n];
    }

    private int find(int i) {
        if (parents[i] != i) {
            parents[i] = find(parents[i]);
        }
        return parents[i];
    }

    public boolean union(int i, int j) {
        int a = find(i), b = find(j);
        if (a == b)
            return false;
        if (rank[a] < rank[b]) {
            parents[a] = b;
        } else if (rank[a] > rank[b]) {
            parents[b] = a;
        } else {
            parents[a] = b;
            rank[b]++;
        }

        return true;
    }
}

class Pair implements Comparable<Pair> {
    int i;
    int j;
    int k;

    public Pair(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.i, other.i);
    }
}

class FastScanner {

    BufferedReader br;
    StringTokenizer tokenizer;

    FastScanner(String fileName) throws FileNotFoundException {
        this(new FileInputStream(new File(fileName)));
    }

    FastScanner(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    String nextLine() throws IOException {
        tokenizer = null;
        return br.readLine();
    }

    String next() throws IOException {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    char nextChar() throws IOException {
        return next().charAt(0);
    }
}