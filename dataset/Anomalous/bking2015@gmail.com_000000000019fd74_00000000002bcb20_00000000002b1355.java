import java.util.*;
import java.io.*;
import java.awt.Point;

class SolutionGCJ {
    private int R, C;
    private long[][] board;

    public void solve(FastReader in, PrintWriter out) {
        int testCases = in.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            R = in.nextInt();
            C = in.nextInt();

            board = new long[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    board[i][j] = in.nextLong();
                }
            }

            List<TreeSet<Integer>> rows = new ArrayList<>();
            List<TreeSet<Integer>> cols = new ArrayList<>();

            for (int i = 0; i < R; i++) rows.add(new TreeSet<>());
            for (int i = 0; i < C; i++) cols.add(new TreeSet<>());

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    rows.get(i).add(j);
                    cols.get(j).add(i);
                }
            }

            List<Point> liveCells = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    liveCells.add(new Point(i, j));
                }
            }

            long totalSkill = 0;
            int deathCount;

            do {
                deathCount = 0;
                totalSkill += calculateTotalSkill(rows);

                Set<Point> nextRound = new HashSet<>();
                Set<Point> toDelete = new HashSet<>();

                for (Point p : liveCells) {
                    if (!rows.get(p.x).contains(p.y)) continue;
                    List<Point> neighbors = getNeighbors(p, rows, cols);
                    if (shouldDie(p, neighbors)) {
                        deathCount++;
                        toDelete.add(p);
                        nextRound.addAll(neighbors);
                    }
                }

                liveCells.clear();
                liveCells.addAll(nextRound);
                for (Point p : toDelete) {
                    rows.get(p.x).remove(p.y);
                    cols.get(p.y).remove(p.x);
                }
            } while (deathCount != 0);

            out.println(String.format("Case #%d: %d", testCase + 1, totalSkill));
        }
    }

    private List<Point> getNeighbors(Point p, List<TreeSet<Integer>> rows, List<TreeSet<Integer>> cols) {
        List<Point> neighbors = new ArrayList<>();
        int i = p.x, j = p.y;

        Integer left = rows.get(i).lower(j);
        Integer right = rows.get(i).higher(j);
        Integer up = cols.get(j).lower(i);
        Integer down = cols.get(j).higher(i);

        if (left != null) neighbors.add(new Point(i, left));
        if (right != null) neighbors.add(new Point(i, right));
        if (up != null) neighbors.add(new Point(up, j));
        if (down != null) neighbors.add(new Point(down, j));

        return neighbors;
    }

    private boolean shouldDie(Point p, List<Point> neighbors) {
        long sum = 0;
        for (Point neighbor : neighbors) {
            sum += board[neighbor.x][neighbor.y];
        }
        return sum > board[p.x][p.y] * neighbors.size();
    }

    private long calculateTotalSkill(List<TreeSet<Integer>> rows) {
        long totalSkill = 0;
        for (int i = 0; i < R; i++) {
            for (int j : rows.get(i)) {
                totalSkill += board[i][j];
            }
        }
        return totalSkill;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new SolutionGCJ().solve(in, out);
        out.flush();
        out.close();
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return str;
    }
}