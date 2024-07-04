import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        for (int j = 1; j <= T; j++) {
            int n = sc.nextInt();
            boolean flag = false;
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(sc.nextInt(), sc.nextInt(), i);
            }

            Arrays.sort(pairs, Comparator.comparingInt(e -> e.x));

            int cameronEnd = pairs[0].y, jamieEnd = 0;
            char[] schedule = new char[n];
            schedule[pairs[0].z] = 'C';

            for (int i = 1; i < n; i++) {
                if (pairs[i].x < cameronEnd) {
                    if (pairs[i].x >= jamieEnd) {
                        schedule[pairs[i].z] = 'J';
                        jamieEnd = pairs[i].y;
                    } else {
                        flag = true;
                        break;
                    }
                } else {
                    schedule[pairs[i].z] = 'C';
                    cameronEnd = pairs[i].y;
                }
            }

            if (flag) {
                System.out.println("Case #" + j + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + j + ": " + new String(schedule));
            }
        }
    }

    static class Pair {
        int x, y, z;

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}