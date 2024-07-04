import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static final String IMPOSSIBLE = "IMPOSSIBLE";

    // Method to find the activity index with the smallest end time
    public static int getEarliestActivityIndex(int[] endTimes, boolean[] isScheduled, int totalActivities) {
        int earliestEndTime = 1440;
        int index = -1;
        for (int i = 0; i < totalActivities; ++i) {
            if (!isScheduled[i] && endTimes[i] <= earliestEndTime) {
                earliestEndTime = endTimes[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCases = input.nextInt();

        int[] startTimes = new int[1000];
        int[] endTimes = new int[1000];
        boolean[] isScheduled = new boolean[1000];

        for (int t = 1; t <= testCases; ++t) {
            int activitiesCount = input.nextInt();
            for (int i = 0; i < activitiesCount; ++i) {
                startTimes[i] = input.nextInt();
                endTimes[i] = input.nextInt();
                isScheduled[i] = false;
            }

            List<Integer> jamieSchedule = new ArrayList<>();
            List<Integer> cameronSchedule = new ArrayList<>();
            boolean scheduleImpossible = false;

            while (true) {
                int nextActivityIndex = getEarliestActivityIndex(endTimes, isScheduled, activitiesCount);
                if (nextActivityIndex == -1) {
                    break;
                }
                isScheduled[nextActivityIndex] = true;
                if (jamieSchedule.isEmpty() || endTimes[jamieSchedule.get(jamieSchedule.size() - 1)] <= startTimes[nextActivityIndex]) {
                    jamieSchedule.add(nextActivityIndex);
                } else if (cameronSchedule.isEmpty() || endTimes[cameronSchedule.get(cameronSchedule.size() - 1)] <= startTimes[nextActivityIndex]) {
                    cameronSchedule.add(nextActivityIndex);
                } else {
                    scheduleImpossible = true;
                    break;
                }
            }

            if (scheduleImpossible) {
                System.out.println("Case #" + t + ": " + IMPOSSIBLE);
            } else {
                char[] result = new char[activitiesCount];
                for (int i : jamieSchedule) {
                    result[i] = 'J';
                }
                for (int i : cameronSchedule) {
                    result[i] = 'C';
                }
                System.out.println("Case #" + t + ": " + new String(result));
            }
        }
    }

    // FastReader class to handle input efficiently
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