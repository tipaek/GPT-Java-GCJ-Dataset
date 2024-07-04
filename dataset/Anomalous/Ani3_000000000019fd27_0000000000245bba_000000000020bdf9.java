import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for (int k = 0; k < n; k++) {
            int activities = sc.nextInt();
            int[][] timings = new int[activities][2];
            for (int i = 0; i < activities; i++) {
                timings[i][0] = sc.nextInt();
                timings[i][1] = sc.nextInt();
            }

            Arrays.sort(timings, Comparator.comparingInt(o -> o[0]));

            StringBuilder out = new StringBuilder();
            boolean possible = true;
            int cEnd = -1, jEnd = -1;

            for (int i = 0; i < activities; i++) {
                int start = timings[i][0];

                if (cEnd <= start) {
                    out.append("C");
                    cEnd = timings[i][1];
                } else if (jEnd <= start) {
                    out.append("J");
                    jEnd = timings[i][1];
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