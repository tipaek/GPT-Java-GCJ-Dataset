import java.io.*;
import java.util.*;

public class Solution {
    private static final HashMap<Character, Integer> directionMap = new HashMap<>();
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final long MOD = 1000000007;
    private static PrintWriter out;

    static {
        directionMap.put('N', 0);
        directionMap.put('E', 1);
        directionMap.put('S', 2);
        directionMap.put('W', 3);
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();

        Solution solution = new Solution();
        for (int tt = 1; tt <= t; tt++) {
            String result = solution.solve(sc);
            out.println("Case #" + tt + ": " + result);
        }
        out.close();
    }

    public String solve(MyScanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String path = sc.next();
        int stepCount = 1;

        for (char direction : path.toCharArray()) {
            int dirIndex = directionMap.get(direction);
            x += directions[dirIndex][0];
            y += directions[dirIndex][1];

            if (Math.abs(x) + Math.abs(y) <= stepCount) {
                return String.valueOf(stepCount);
            }
            stepCount++;
        }
        return "IMPOSSIBLE";
    }

    public static class MyScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
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
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}