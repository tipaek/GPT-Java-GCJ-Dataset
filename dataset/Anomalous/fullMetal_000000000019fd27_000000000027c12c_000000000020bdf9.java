import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = reader.nextInt();
                intervals[i][1] = reader.nextInt();
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            int cEnd = 0;
            int jEnd = 0;

            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= cEnd) {
                    cEnd = intervals[i][1];
                    result.append('C');
                } else if (intervals[i][0] >= jEnd) {
                    jEnd = intervals[i][1];
                    result.append('J');
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                writer.println("Case #" + t + ": " + result);
            } else {
                writer.println("Case #" + t + ": Impossible");
            }
        }

        writer.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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