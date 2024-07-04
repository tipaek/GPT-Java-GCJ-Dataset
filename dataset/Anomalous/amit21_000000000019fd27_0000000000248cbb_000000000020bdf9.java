import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final int INF = 10000;

    private static class Activity {
        final int startTime;
        final int endTime;
        final int index;
        char answer;

        Activity(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int testCaseCount = sc.nextInt();
        for (int testIndex = 1; testIndex <= testCaseCount; testIndex++) {
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                activities[i] = new Activity(startTime, endTime, i);
            }

            Activity[] startActivities = activities.clone();
            Activity[] endActivities = activities.clone();

            Arrays.sort(startActivities, Comparator.comparingInt(a -> a.startTime));
            Arrays.sort(endActivities, Comparator.comparingInt(a -> a.endTime));

            int start = 0, end = 0, currentParallel = 0;
            boolean possibleWithoutOverlap = true;

            while (start < n && end < n) {
                if (startActivities[start].startTime < endActivities[end].endTime) {
                    currentParallel++;
                    start++;
                } else if (startActivities[start].startTime == endActivities[end].endTime) {
                    assignAnswer(endActivities[end], currentParallel);
                    end++;
                    start++;
                } else {
                    assignAnswer(endActivities[end], currentParallel);
                    currentParallel--;
                    end++;
                }
                if (currentParallel > 2) {
                    possibleWithoutOverlap = false;
                }
            }

            while (end < n) {
                assignAnswer(endActivities[end], currentParallel);
                currentParallel--;
                end++;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.index));
            StringBuilder sb = new StringBuilder();

            if (possibleWithoutOverlap) {
                for (Activity activity : activities) {
                    sb.append(activity.answer);
                }
            } else {
                sb.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + testIndex + ": " + sb);
        }
    }

    private static void assignAnswer(Activity activity, int currentParallel) {
        if (currentParallel == 1) {
            activity.answer = 'C';
        } else if (currentParallel == 2) {
            activity.answer = 'J';
        }
    }

    private static class MyScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        MyScanner() {
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