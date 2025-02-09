import java.io.*;
import java.util.*;

public class Solution {
    public void solve() {
        real();
    }

    private void real() {
        int numberTests = reader.nextInt();

        for (int t = 1; t <= numberTests; t++) {
            int n = reader.nextInt();
            int k = reader.nextInt();

            int[][] a = latinSquare(n, k);
            if (a == null) {
                writer.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                writer.printf("Case #%d: POSSIBLE\n", t);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++)
                        writer.printf("%d ", a[i][j]);
                    writer.println();
                }
            }
        }
    }

    private void test() {
        long startTime = System.currentTimeMillis();

        int n = 50;
        int min = 50, max = min;
//        int min = n, max = n * n;

        for (int k = min; k <= max; k++) {
            System.out.println("searching: " + k);
            int[][] a = latinSquare(n, k);
            if (a == null) {
                System.out.println("-> not found: " + n + " " + k);
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++)
                        System.out.printf("%d ", a[i][j]);
                    System.out.println();
                }
            }
        }

        long finishTime = System.currentTimeMillis();
        double runTime = (finishTime - startTime) / 1000.0;
        System.out.printf("Runtime: %.2f seconds\n", runTime);
    }

    private int[][] latinSquare(int n, int k) {
        this.n = n;
        this.m = n * n;
        if (k == n + 1 || k == m - 1) return null;

        a = new int[n][n];
        colHas = new boolean[n][n + 1];
        rowHas = new boolean[n][n + 1];

        heap = new MinHeap(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                heap.insert(i, j, n);
            }
        }

        if (!find(0, k)) return null;
        return a;
    }

    private boolean find(int idx, int sum) {
        if (sum < 0) return false;
        if (idx >= n && sum > 0) return false;
        if (idx >= m) return sum == 0;

        Cell next = (idx < n) ? new Cell(idx, idx, n) : heap.poll();
        int r = next.row;
        int c = next.col;

        int[] range = valueRange(r, c, idx >= n ? 0 : n - idx, sum);
        int[] crows = new int[n];
        int[] ccols = new int[n];

        for (int val = range[0]; val <= range[1]; val++) {
            if (rowHas[r][val] || colHas[c][val]) continue;

            a[r][c] = val;
            rowHas[r][val] = true;
            colHas[c][val] = true;

            int nr =0;
            for (int i = 0; i < n; i++) {
                if (a[i][c] != 0 || rowHas[i][val]) continue;
                heap.increase(i, c, -1);
                crows[nr++] = i;
            }

            int nc = 0;
            for (int j = 0; j < n; j++) {
                if (a[r][j] != 0 || colHas[j][val]) continue;
                heap.increase(r, j, -1);
                ccols[nc++] = j;
            }

            int nextSum = (r == c) ? sum - val : sum;
            if (find(idx + 1, nextSum)) return true;

            for (int x = 0; x < nr; x++) heap.increase(crows[x], c, +1);
            for (int x = 0; x < nc; x++) heap.increase(r, ccols[x], +1);

            a[r][c] = 0;
            rowHas[r][val] = false;
            colHas[c][val] = false;
        }

        if (idx >= n) heap.insert(next);
        return false;
    }

    private int[] valueRange(int r, int c, int rem, int sum) {
        if (r != c) return new int[]{1, n};
        int min = Math.max(1, sum - (rem - 1) * n);
        int max = Math.min(n, sum - (rem - 1) * 1);
        return new int[]{min, max};
    }

    private int n;
    private int m;
    private int[][] a;
    private boolean[][] colHas;
    private boolean[][] rowHas;
    private MinHeap heap;

    private static class Cell {
        int row;
        int col;
        int priority;

        public Cell(int row, int col, int priority) {
            this.row = row;
            this.col = col;
            this.priority = priority;
        }
    }

    private static class MinHeap {
        private Cell[] data;
        private int[][] index;
        int size;

        public MinHeap(int n) {
            size = 0;
            data = new Cell[n * n];
            index = new int[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(index[i], -1);
        }

        public void insert(Cell e) {
            insert(e.row, e.col, e.priority);
        }

        public void insert(int row, int col, int priority) {
            index[row][col] = size;
            data[size++] = new Cell(row, col, priority);
            siftUp(size - 1);
        }

        public Cell poll() {
            Cell e = data[0];
            swap(0, size - 1);
            size--;
            index[e.row][e.col] = -1;
            siftDown(0);
            return e;
        }

        public void increase(int row, int col, int delta) {
            int i = index[row][col];
            Cell e = data[i];
            e.priority += delta;
            siftDown(i);
            siftUp(i);
        }

        private int compare(Cell e1, Cell e2) {
            return Integer.compare(e1.priority, e2.priority);
        }

        private void siftUp(int c) {
            while (c > 0) {
                int p = c >> 1;
                if (compare(data[p], data[c]) <= 0) return;
                swap(c, p);
                c = p;
            }
        }

        private void siftDown(int p) {
            for (int c = p << 1; c < size; c = p << 1) {
                if (c + 1 < size && compare(data[c + 1], data[c]) < 0) c++;
                if (compare(data[p], data[c]) <= 0) return;
                swap(p, c);
                p = c;
            }
        }

        private void swap(int i1, int i2) {
            Cell e1 = data[i1];
            Cell e2 = data[i2];
            set(i1, e2);
            set(i2, e1);
        }

        private void set(int i, Cell e) {
            data[i] = e;
            index[e.row][e.col] = i;
        }
    }

    private InputReader reader;
    private PrintWriter writer;

    public Solution(InputReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        Solution solution = new Solution(reader, writer);
        solution.solve();

        writer.flush();
    }

    static class InputReader {
        private static final int BUFFER_SIZE = 1 << 20;

        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
            tokenizer = null;
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }
    }
}