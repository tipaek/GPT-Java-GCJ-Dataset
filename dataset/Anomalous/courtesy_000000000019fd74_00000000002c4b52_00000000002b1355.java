import java.io.*;
import java.util.*;

public class Solution {

    public static FastReader fr = new FastReader();
    public static OutputWriter op = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int T = fr.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int R = fr.nextInt();
            int C = fr.nextInt();
            int[][] A = new int[R][C];
            Dan[][] dan = new Dan[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    A[i][j] = fr.nextInt();
                }
            }
            long ans = 0;
            long tot = 0;
            List<Pair> elL = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    tot += A[i][j];
                    Dan d = new Dan();
                    if (i > 0) d.addNeighbor(A[i - 1][j]);
                    if (i + 1 < R) d.addNeighbor(A[i + 1][j]);
                    if (j > 0) d.addNeighbor(A[i][j - 1]);
                    if (j + 1 < C) d.addNeighbor(A[i][j + 1]);
                    dan[i][j] = d;
                    if (d.shouldEliminate(A[i][j])) {
                        elL.add(new Pair(i, j));
                    }
                }
            }
            ans += tot;
            while (!elL.isEmpty()) {
                Set<Pair> aff = new HashSet<>();
                for (Pair p : elL) {
                    adjustNeighbors(A, dan, aff, p);
                    tot -= A[p.x][p.y];
                    A[p.x][p.y] = 0;
                }
                ans += tot;
                elL.clear();
                for (Pair p : aff) {
                    if (dan[p.x][p.y].shouldEliminate(A[p.x][p.y])) {
                        elL.add(p);
                    }
                }
            }
            System.out.println("Case #" + cs + ": " + ans);
        }
    }

    private static void adjustNeighbors(int[][] A, Dan[][] dan, Set<Pair> aff, Pair p) {
        Pair[] neighbors = {findNeighbor(A, p.x, p.y, -1, 0), findNeighbor(A, p.x, p.y, 1, 0),
                            findNeighbor(A, p.x, p.y, 0, -1), findNeighbor(A, p.x, p.y, 0, 1)};
        for (int i = 0; i < 2; i++) {
            if (neighbors[i] != null) {
                dan[neighbors[i].x][neighbors[i].y].removeNeighbor(A[p.x][p.y]);
                aff.add(neighbors[i]);
            }
        }
        for (int i = 2; i < 4; i++) {
            if (neighbors[i] != null) {
                dan[neighbors[i].x][neighbors[i].y].removeNeighbor(A[p.x][p.y]);
                aff.add(neighbors[i]);
            }
        }
    }

    private static Pair findNeighbor(int[][] A, int x, int y, int dx, int dy) {
        int nx = x + dx, ny = y + dy;
        while (nx >= 0 && nx < A.length && ny >= 0 && ny < A[0].length) {
            if (A[nx][ny] > 0) return new Pair(nx, ny);
            nx += dx;
            ny += dy;
        }
        return null;
    }

    static class Dan {
        int count;
        long total;

        void addNeighbor(int value) {
            count++;
            total += value;
        }

        void removeNeighbor(int value) {
            count--;
            total -= value;
        }

        boolean shouldEliminate(int value) {
            return count > 0 && total > count * value;
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return x == other.x && y == other.y;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
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
    }
}