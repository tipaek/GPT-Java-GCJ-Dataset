import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int t = nextInt();
        for (int ti = 1; ti <= t; ti++) {
            String inputLine = nextLine().trim();
            if (inputLine.isEmpty()) {
                inputLine = nextLine().trim();
            }
            String[] inputParts = inputLine.split(" ");
            long x = Long.parseLong(inputParts[0]);
            long y = Long.parseLong(inputParts[1]);
            String str = inputParts[2];

            long minTime = Long.MAX_VALUE;
            boolean isPossible = false;

            long distance = Math.abs(x) + Math.abs(y);
            long time = 0;
            if (distance <= time) {
                isPossible = true;
                minTime = time;
            }

            for (char c : str.toCharArray()) {
                switch (c) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }

                long currentDistance = Math.abs(x) + Math.abs(y);
                time++;

                if (currentDistance <= time) {
                    isPossible = true;
                    minTime = Math.min(time, minTime);
                }
            }

            if (isPossible) {
                System.out.printf("Case #%d: %d\n", ti, minTime);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", ti);
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static long nextLong() {
        return Long.parseLong(next());
    }

    static double nextDouble() {
        return Double.parseDouble(next());
    }

    static String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}