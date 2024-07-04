import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();

        int tests = reader.nextInt();

        for (int test = 1; test <= tests; test++) {
            String[] s = reader.nextLine().split(" ");
            int tx = Integer.parseInt(s[0]);
            int ty = Integer.parseInt(s[1]);

            String moves = s[2];

            int x = 0;
            int y = 0;

            if (x == tx && y == ty) {
                System.out.println("Case #" + test + ": 0");
                continue;
            }

            int time = 0;
            int bestTime = Integer.MAX_VALUE;
            for (int i = 0; i < moves.length(); i++) {
                time++;
                char c = moves.charAt(i);
                switch (c) {
                    case 'N':
                        ty++;
                        break;
                    case 'S':
                        ty--;
                        break;
                    case 'W':
                        tx--;
                        break;
                    case 'E':
                        tx++;
                        break;
                }

                int timeToGetThere = Math.abs(tx - x) + Math.abs(ty - y);
                if (timeToGetThere <= time) {
                    bestTime = Math.min(bestTime, time);
                }
            }

            if (bestTime == Integer.MAX_VALUE) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + bestTime);
            }
        }
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
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
