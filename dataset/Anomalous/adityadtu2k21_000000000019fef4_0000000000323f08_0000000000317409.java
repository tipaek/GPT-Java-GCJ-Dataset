import java.util.*;
import java.io.*;

public class Solution {
    static String M;
    static HashMap<String, Integer> dp;

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        int tc = scn.nextInt();

        for (int t = 1; t <= tc; t++) {
            int x = scn.nextInt();
            int y = scn.nextInt();
            M = scn.next();
            dp = new HashMap<>();
            int ans = dfs(x, y, 0);
            System.out.print("Case #" + t + ": ");
            if (ans != Integer.MAX_VALUE) {
                System.out.println(ans);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static int dfs(int x, int y, int cur) {
        String key = x + " " + y + " " + cur;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (cur >= M.length() && (x != 0 || y != 0)) {
            dp.put(key, Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        if (x == 0 && y == 0) {
            return cur;
        }

        char dir = M.charAt(cur);
        int nextX = x, nextY = y;

        if (dir == 'N' || dir == 'S') {
            nextY += (dir == 'N') ? 1 : -1;
        } else {
            nextX += (dir == 'E') ? 1 : -1;
        }

        int move = -1;
        if (Math.abs(nextX) > Math.abs(nextY)) {
            move = (nextX > 0) ? dfs(nextX - 1, nextY, cur + 1) : dfs(nextX + 1, nextY, cur + 1);
        } else {
            move = (nextY > 0) ? dfs(nextX, nextY - 1, cur + 1) : dfs(nextX, nextY + 1, cur + 1);
        }

        int directMove = dfs(nextX, nextY, cur + 1);
        dp.put(key, Math.min(move, directMove));
        return dp.get(key);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        String nextLine() {
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