import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int T = io.nextInt();
        for (int i = 1; i <= T; ++i) {
            solve(io, i);
        }
        io.close();
    }

    private static void solve(Kattio io, int t) {
        int X = io.nextInt();
        int Y = io.nextInt();
        String M = io.next();
        int[][] starts = new int[M.length() + 1][2];
        for (int i = 0; i < M.length(); ++i) {
            char d = M.charAt(i);
            if (d == 'N') {
                ++Y;
            } else if (d == 'S') {
                --Y;
            } else if (d == 'E') {
                ++X;
            } else {
                --X;
            }
            int[] pos = {X, Y};
            starts[i + 1] = pos;
        }
        int best = -1;
        for (int i = 1; i <= M.length(); ++i) {
            int[] pos = starts[i];
            boolean canGo = goToStart(pos[0], pos[1], i);
            int steps = canGo ? i : -1;
            best = best == -1 ? steps : steps == -1 ? best : Math.min(best, steps);
        }
        io.println("Case #" + t + ": " + (best == -1 ? "IMPOSSIBLE" : best));
    }

    private static boolean goToStart(int x, int y, int steps) {
        return Math.abs(x) + Math.abs(y) <= steps;
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public String next() {
        return nextToken();
    }

    public String nextLine() {
        try {
            return r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
