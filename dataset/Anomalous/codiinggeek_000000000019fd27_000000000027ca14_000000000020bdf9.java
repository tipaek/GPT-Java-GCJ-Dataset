import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        FastReader reader = new FastReader();
        int t = reader.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = reader.nextInt();
            int[][] intervals = new int[2][n];
            int[][] originalIntervals = new int[2][n];

            for (int i = 0; i < n; i++) {
                intervals[0][i] = reader.nextInt();
                intervals[1][i] = reader.nextInt();
                originalIntervals[0][i] = intervals[0][i];
                originalIntervals[1][i] = intervals[1][i];
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (intervals[0][i] > intervals[0][j]) {
                        swap(intervals, i, j);
                    }
                }
            }

            char[] schedule = new char[n];
            char[] finalSchedule = new char[n];
            int cEnd = intervals[1][0];
            int jEnd = 0;
            schedule[0] = 'C';

            int i;
            for (i = 1; i < n; i++) {
                if (intervals[0][i] >= cEnd) {
                    cEnd = intervals[1][i];
                    schedule[i] = 'C';
                } else if (intervals[0][i] >= jEnd) {
                    jEnd = intervals[1][i];
                    schedule[i] = 'J';
                } else {
                    break;
                }
            }

            if (i == n) {
                boolean[] matched = new boolean[n];
                for (int k = 0; k < n; k++) {
                    matched[k] = false;
                }
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        if (!matched[y] && originalIntervals[0][x] == intervals[0][y] && originalIntervals[1][x] == intervals[1][y]) {
                            matched[y] = true;
                            finalSchedule[x] = schedule[y];
                            break;
                        }
                    }
                }
                System.out.print("Case #" + caseNum + ": ");
                System.out.println(new String(finalSchedule));
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static void swap(int[][] arr, int i, int j) {
        int temp0 = arr[0][i];
        int temp1 = arr[1][i];
        arr[0][i] = arr[0][j];
        arr[1][i] = arr[1][j];
        arr[0][j] = temp0;
        arr[1][j] = temp1;
    }
}