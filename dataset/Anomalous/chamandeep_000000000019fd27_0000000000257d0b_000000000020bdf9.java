import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = reader.nextInt();
            int[][] intervals = new int[n][4];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = reader.nextInt();
                intervals[i][1] = reader.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

            int endTimeC = -1;
            int endTimeJ = -1;
            boolean impossible = false;
            StringBuilder result = new StringBuilder();

            for (int[] interval : intervals) {
                if (interval[0] >= endTimeJ) {
                    endTimeJ = interval[1];
                    interval[3] = 0;
                } else if (interval[0] >= endTimeC) {
                    endTimeC = interval[1];
                    interval[3] = 1;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                Arrays.sort(intervals, Comparator.comparingInt(o -> o[2]));
                for (int[] interval : intervals) {
                    result.append(interval[3] == 0 ? "J" : "C");
                }
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
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