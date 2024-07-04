import java.util.*;
import java.io.*;


public class Solution {

    public static final String DIR_S = "S";
    public static final String DIR_N = "N";
    public static final String DIR_W = "W";
    public static final String DIR_E = "E";

    private static final boolean DEBUG = false;
    private static final double BORDER = 1e9+1;

    private static class Jump {

        public long x = 0;
        public long y = 0;
        public int steps = 0;
        public final String dir;
        public Jump prevJump;

        public Jump(long x, long y, String dir, int steps, Jump jump) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.steps = steps;
            prevJump = jump;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Jump jump = (Jump) o;
            return x == jump.x &&
                    y == jump.y &&
                    steps == jump.steps;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, steps);
        }

        public String toString() {
            return String.format("Jump(%d,%d,%d)", x, y, steps);
        }
    }

    private static Jump min(Jump ... jumps) {
        Jump minJump = jumps[0];
        for (int i=1;i<jumps.length;i++) {
            if (minJump.steps > jumps[i].steps) {
                minJump = jumps[i];
            }
        }

        return minJump;
    }

    private static Jump jump(final Jump destJump, Set<Jump> hist, final long MAX_JUMPS) {
        Jump nextJumps[] = new Jump[] {
                new Jump(0, 1, DIR_N, 1, null),
                new Jump(0, -1, DIR_S,1, null),
                new Jump(-1, 0, DIR_W, 1, null),
                new Jump(1, 0, DIR_E,1, null)
        };

        Jump minJump = null;

        Queue<Jump> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(nextJumps));

        while (!queue.isEmpty()) {
            Jump prevJump = queue.poll();

            if (hist.contains(prevJump)) {
                continue;
            }

            if (prevJump.steps > MAX_JUMPS) {
                continue;
            }

            if (prevJump.x == destJump.x && prevJump.y == destJump.y) {
                if (minJump == null) {
                    minJump = prevJump;
                } else if (prevJump.steps < minJump.steps) {
                    minJump = prevJump;
                }

                continue;
            }

            long d = (long) Math.pow(2, prevJump.steps);

            queue.add(new Jump(prevJump.x, prevJump.y + d, DIR_N, prevJump.steps + 1, prevJump));
            queue.add(new Jump(prevJump.x, prevJump.y - d, DIR_S,prevJump.steps + 1, prevJump));
            queue.add(new Jump(prevJump.x - d, prevJump.y, DIR_W, prevJump.steps + 1, prevJump));
            queue.add(new Jump(prevJump.x + d, prevJump.y, DIR_E,prevJump.steps + 1, prevJump));
        }

        return minJump;
    }

    private static double log2(long n) {
        return Math.log(n) / Math.log(2);
    }

    private static String solve(MyScanner in, PrintWriter out) {
        long x = in.nextLong();
        long y = in.nextLong();

        int MAX_JUMPS = 1 + (int) log2(Math.abs(x) + Math.abs(y));

        final Jump destJump = new Jump(x, y, "", 0, null);

        Set<Jump> hist = new HashSet<>();

        Jump ansJump = jump(destJump, hist, MAX_JUMPS);

        if (ansJump == null) {
            return "IMPOSSIBLE";
        }

        StringBuilder sb = new StringBuilder();

        while (ansJump != null) {
            sb.append(ansJump.dir);
            ansJump = ansJump.prevJump;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();

        for (int i=1;i<=t;++i) {
            out.printf("Case #%d: %s\n", i, solve(sc, out));
        }

        out.close();
    }

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

}