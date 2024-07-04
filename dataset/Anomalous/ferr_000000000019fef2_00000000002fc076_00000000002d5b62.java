import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private int targetX, targetY;
    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            setupIO();
            solve();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void setupIO() throws IOException {
        if (fromConsole) {
            in = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader(filename + ".in"));
            pw = new PrintWriter(filename + ".out");
        }
        st = new StringTokenizer("");
    }

    private void solve() {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            String result = solveCase();
            pw.printf("Case #%d: %s\n", i + 1, result);
        }
    }

    private String solveCase() {
        targetX = nextInt();
        targetY = nextInt();
        Queue<Pair> queue = new LinkedList<>();
        Map<Pair, String> paths = new HashMap<>();
        Pair initial = new Pair(0, 0, 1);
        paths.put(initial, "");
        queue.add(initial);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.X == targetX && current.Y == targetY) {
                return paths.get(current);
            }

            if (isValidMove(current)) {
                addNewPosition(queue, paths, current, current.X + current.mod, current.Y, "E");
                addNewPosition(queue, paths, current, current.X - current.mod, current.Y, "W");
                addNewPosition(queue, paths, current, current.X, current.Y + current.mod, "N");
                addNewPosition(queue, paths, current, current.X, current.Y - current.mod, "S");
            }
        }

        return "IMPOSSIBLE";
    }

    private void addNewPosition(Queue<Pair> queue, Map<Pair, String> paths, Pair current, int newX, int newY, String direction) {
        Pair newPair = new Pair(newX, newY, current.mod * 2);
        if (!paths.containsKey(newPair)) {
            queue.add(newPair);
            paths.put(newPair, paths.get(current) + direction);
        }
    }

    private boolean isValidMove(Pair current) {
        return MOD(current.X, current.mod) == MOD(targetX, current.mod) && MOD(current.Y, current.mod) == MOD(targetY, current.mod);
    }

    private int MOD(int a, int b) {
        return ((a % b) + b) % b;
    }

    private boolean hasNext() {
        try {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String next() {
        return hasNext() ? st.nextToken() : null;
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    private long nextLong() {
        return Long.parseLong(next());
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }

    private static final String filename = "A";
    private static final boolean fromConsole = true;

    private static class Pair {
        final int X, Y, mod;

        Pair(int x, int y, int mod) {
            this.X = x;
            this.Y = y;
            this.mod = mod;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return X == pair.X && Y == pair.Y && mod == pair.mod;
        }

        @Override
        public int hashCode() {
            return Objects.hash(X, Y, mod);
        }
    }
}