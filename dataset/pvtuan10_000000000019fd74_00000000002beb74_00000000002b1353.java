import java.io.*;
import java.util.*;

public class Solution {
    static FastScanner in;
    static PrintWriter out;
    static final long MOD = 1000000007;
    static final int SIZE = 100;
    static boolean found;
    static List<int[]> res;

    public static void main(String[] args) throws IOException {
        // Scanner in = new Scanner(new File("input.txt"));
        // Scanner in = new Scanner(System.in);
        // System.setOut(new PrintStream(new BufferedOutputStream(new
        // FileOutputStream("output.txt")), true));
        out = new PrintWriter(System.out);
        in = new FastScanner(System.in);
//        in = new FastScanner("/home/pvtuan10/IdeaProjects/CompetitiveProgramming/src/input.txt");
//        int t = in.nextInt();
        long[][] triangle = new long[SIZE][SIZE];
        for (int i = 0;i < SIZE;i++) {
            triangle[i][i] = 1;
            triangle[i][0] = 1;
        }
        for (int i = 0;i < SIZE;i++) {
            for (int j = 0;j < i + 1;j++) {
                if (j == 0 || j == i) continue;
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        int t = in.nextInt();
        for (int tt = 1; tt <= t;tt++) {
            out.println("Case #" + tt + ": ");
            found = false;
            long s = in.nextLong();
            List<int[]> ans = new ArrayList<>();
            backtrack(triangle, s, ans, 0, 0, new boolean[SIZE][SIZE], 0);
            for (int[] pair : res) {
                out.println((pair[0] + 1) + " " + (pair[1] + 1));
            }
        }
        out.close();
    }

    static void backtrack(long[][] triangle, long sum, List<int[]> ans, int r, int c, boolean[][] visited, int count) {
        if (found) return;
        if (c > r || r >= SIZE || c < 0 || r < 0) return;
        if (sum < 0) return;
        if (count > 500) return;
        if (visited[r][c]) return;

        sum -= triangle[r][c];
        visited[r][c] = true;
        ans.add(new int[]{r, c});
        if (sum == 0 && count <= 500) {
            res = new ArrayList<>(ans);
            found = true;
            return;
        }
        backtrack(triangle, sum, ans, r - 1, c - 1, visited, count + 1);
        backtrack(triangle, sum, ans, r - 1, c, visited, count + 1);
        backtrack(triangle, sum, ans, r, c - 1, visited, count + 1);
        backtrack(triangle, sum, ans, r, c + 1, visited, count + 1);
        backtrack(triangle, sum, ans, r + 1, c, visited, count + 1);
        backtrack(triangle, sum, ans, r + 1, c + 1, visited, count + 1);
        ans.remove(ans.size() - 1);
        visited[r][c] = false;
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