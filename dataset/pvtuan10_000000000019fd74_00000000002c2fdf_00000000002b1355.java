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

        int t = in.nextInt();
        for (int tt = 1; tt <= t;tt++) {
            out.print("Case #" + tt + ": ");
            int m = in.nextInt(), n = in.nextInt();
            long[][] grid = new long[m][n];
            for (int i = 0;i < m;i++) {
                for (int j = 0;j < n;j++) {
                    grid[i][j] = in.nextLong();
                }
            }
            boolean[][] visited = new boolean[m][n];
            long ans = 0;
            boolean ok = true;
            boolean[][] temp = new boolean[m][n];
            while (ok) {
                for (int i = 0;i < m;i++) {
                    for (int j = 0;j < n;j++) {
                        temp[i][j] = visited[i][j];
                    }
                }
                for (int i = 0;i < m;i++) {
                    for (int j = 0;j < n;j++) {
                        if (visited[i][j]) continue;
                        ans += grid[i][j];
                        double neighbors = avgNeighbors(grid, i, j, visited);
                        if (neighbors == 0) {
                            ok = false;
                        }
                        if ((double) grid[i][j] < neighbors) {
//                            System.out.println(i + " " + j);
                            temp[i][j] = true;
                        }
                    }
                }
                for (int i = 0;i < m;i++) {
                    for (int j = 0;j < n;j++) {
                        visited[i][j] = temp[i][j];
                    }
                }
            }
            out.println(ans);
        }
        out.close();
    }

    static double avgNeighbors(long[][] grid, int r, int c, boolean[][] visited) {
        int count = 0;
        double sum = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = r - 1;i >= 0;i--) {
            if (!visited[i][c]) {
                count++;
                sum += grid[i][c];
                break;
            }
        }
        for (int i = r + 1;i < m;i++) {
            if (!visited[i][c]) {
                count++;
                sum += grid[i][c];
                break;
            }
        }
        for (int i = c - 1;i >= 0;i--) {
            if (!visited[r][i]) {
                count++;
                sum += grid[r][i];
                break;
            }
        }
        for (int i = c + 1;i < n;i++) {
            if (!visited[r][i]) {
                count++;
                sum += grid[r][i];
                break;
            }
        }

        return count == 0 ? 0 : (double) sum / count;
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