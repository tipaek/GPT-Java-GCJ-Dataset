import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    // Returns the index of the activity with the smallest end time that hasn't been processed
    private static int getEarliestUnprocessedActivity(int[] endTimes, boolean[] processed, int n) {
        int minEndTime = 1440, minIdx = -1;
        for (int i = 0; i < n; ++i) {
            if (!processed[i] && endTimes[i] <= minEndTime) {
                minEndTime = endTimes[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCases = input.nextInt();

        int[] startTimes = new int[1000];
        int[] endTimes = new int[1000];
        boolean[] processed = new boolean[1000];

        for (int t = 1; t <= testCases; ++t) {
            int n = input.nextInt();
            for (int i = 0; i < n; ++i) {
                startTimes[i] = input.nextInt();
                endTimes[i] = input.nextInt();
                processed[i] = false;
            }

            List<Integer> jamieActivities = new ArrayList<>();
            List<Integer> cameronActivities = new ArrayList<>();
            boolean isImpossible = false;

            while (true) {
                int minIdx = getEarliestUnprocessedActivity(endTimes, processed, n);
                if (minIdx == -1) {
                    break;
                }
                processed[minIdx] = true;
                if (jamieActivities.isEmpty() || endTimes[jamieActivities.get(jamieActivities.size() - 1)] <= startTimes[minIdx]) {
                    jamieActivities.add(minIdx);
                } else if (cameronActivities.isEmpty() || endTimes[cameronActivities.get(cameronActivities.size() - 1)] <= startTimes[minIdx]) {
                    cameronActivities.add(minIdx);
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": " + IMPOSSIBLE);
            } else {
                StringBuilder result = new StringBuilder(new String(new char[n]).replace('\0', ' '));
                for (int idx : jamieActivities) {
                    result.setCharAt(idx, 'J');
                }
                for (int idx : cameronActivities) {
                    result.setCharAt(idx, 'C');
                }
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }

    // FastReader class for fast input reading
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