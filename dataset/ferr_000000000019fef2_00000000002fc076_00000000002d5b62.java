import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    int targetX, targetY;

    int MOD(int a, int b) {
        return ((a % b) + b) % b;
    }

    class Pair {
        public final int X, Y, mod;

        Pair(int x, int y, int mod) {
            X = x;
            Y = y;
            this.mod = mod;
        }
    }

//    String go(int X, int Y, int mod) {
//        if (X == targetX && Y == targetY)
//            return "";
//        String a;
//        a = go(X + mod, Y, mod * 2);
//        if (a != null)
//            return "E" + a;
//        a = go(X - mod, Y, mod * 2);
//        if (a != null)
//            return "W" + a;
//        a = go(X, Y + mod, mod * 2);
//        if (a != null)
//            return "N" + a;
//        a = go(X, Y - mod, mod * 2);
//        if (a != null)
//            return "S" + a;
//        return null;
//    }

    public String solveCase() {
        targetX = nextInt();
        targetY = nextInt();
//        String ans = go(0, 0, 1);
        Queue<Pair> q = new LinkedList<>();
        Map<Pair, String> mp = new HashMap<>();
        Pair p0 = new Pair(0, 0, 1);
        mp.put(p0, "");
        q.add(p0);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.X == targetX && p.Y == targetY)
                return mp.get(p);

            if (MOD(p.X, p.mod) != MOD(targetX, p.mod) || MOD(p.Y, p.mod) != MOD(targetY, p.mod))
                continue;

            Pair p1 = new Pair(p.X + p.mod, p.Y, p.mod * 2);
            q.add(p1);
            mp.put(p1, mp.get(p) + "E");

            Pair p2 = new Pair(p.X - p.mod, p.Y, p.mod * 2);
            q.add(p2);
            mp.put(p2, mp.get(p) + "W");

            Pair p3 = new Pair(p.X, p.Y + p.mod, p.mod * 2);
            q.add(p3);
            mp.put(p3, mp.get(p) + "N");

            Pair p4 = new Pair(p.X, p.Y - p.mod, p.mod * 2);
            q.add(p4);
            mp.put(p4, mp.get(p) + "S");
        }

        return "IMPOSSIBLE";
    }

    public void solve() {
        int t = nextInt();
        for (int i = 0; i < t; ++i) {
            String ans = solveCase();
            pw.printf("Case #%d: %s\n", i + 1, ans);
        }
    }

    static final String filename = "A";
    static final boolean fromConsole = true;

    public void run() {
        try {
            if (!fromConsole) {
                in = new BufferedReader(new FileReader(filename + ".in"));
                pw = new PrintWriter(filename + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            long st = System.currentTimeMillis();
            solve();
            //pw.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - st);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    boolean hasNext() {
        try {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return st.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String next() {
        return hasNext() ? st.nextToken() : null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}