import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    Random rnd = new Random(123);

    Point randPoint() {
        return new Point(rnd.nextInt(MAX * 2) - MAX, rnd.nextInt(MAX * 2) - MAX);
    }

    enum Ans {
        HIT,
        MISS;
    }

    Ans ask(Point p) throws SolFoundEx {
        out.println(p.x + " " + p.y);
        out.flush();
        String s = in.next();
        if (s.equals("CENTER")) {
            throw new SolFoundEx();
        }
        if (s.equals("HIT")) {
            return Ans.HIT;
        }
        if (s.equals("MISS")) {
            return Ans.MISS;
        }
        throw new AssertionError();
    }

    static class SolFoundEx extends Throwable {

    }

    int findMinX(Point p) throws SolFoundEx {
        int left = -MAX - 1, right = p.x;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (ask(new Point(mid, p.y)) == Ans.HIT) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    int findMaxX(Point p) throws SolFoundEx {
        int left = p.x, right = MAX + 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (ask(new Point(mid, p.y)) == Ans.HIT) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int findMinY(Point p) throws SolFoundEx {
        int left = -MAX - 1, right = p.y;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (ask(new Point(p.x, mid)) == Ans.HIT) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    int findMaxY(Point p) throws SolFoundEx {
        int left = p.y, right = MAX + 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (ask(new Point(p.x, mid)) == Ans.HIT) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    void solveOneCase() throws SolFoundEx {
        while (true) {
            Point p = randPoint();
            Ans curAns = ask(p);
            if (curAns == Ans.MISS) {
                continue;
            }
            int xSum = findMinX(p) + findMaxX(p);
            if (xSum % 2 != 0) {
                throw new AssertionError();
            }
            int ySum = findMinY(p) + findMaxY(p);
            if (ySum % 2!= 0) {
                throw new AssertionError();
            }
            Point center = new Point(xSum / 2, ySum / 2);
            ask(center);
            throw new AssertionError("should be center!");
        }
    }

    void solve() {
        int tc = in.nextInt();
        int minR = in.nextInt();
        int maxR = in.nextInt();
        for (int t = 0; t < tc; t++) {
            try {
                solveOneCase();
            } catch (SolFoundEx e) {

            }
        }
    }

    final int MAX = (int) 1e9;

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void run() {
        try {
            in = new FastScanner(new File("Solution.in"));
            out = new PrintWriter(new File("Solution.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        new Solution().runIO();
    }
}