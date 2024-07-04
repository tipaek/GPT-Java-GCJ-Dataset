import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for (int k = 0; k < n; k++) {
            boolean possible = true;
            StringBuilder out = new StringBuilder();
            int activities = sc.nextInt();
            int[][] timings = new int[activities][2];

            for (int i = 0; i < activities; i++) {
                timings[i][0] = sc.nextInt();
                timings[i][1] = sc.nextInt();
            }

            Arrays.sort(timings, Comparator.comparingInt(o -> o[0]));

            int cEnd = -1, jEnd = -1;

            for (int[] timing : timings) {
                if (cEnd <= timing[0]) {
                    out.append("C");
                    cEnd = timing[1];
                } else if (jEnd <= timing[0]) {
                    out.append("J");
                    jEnd = timing[1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (k + 1) + ": " + out);
            } else {
                System.out.println("Case #" + (k + 1) + ": IMPOSSIBLE");
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