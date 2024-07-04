
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();

            Activity[] activities = new Activity[N];
            for (int i = 0; i < N; i++) {
                activities[i] = new Activity(i, in.nextInt(), in.nextInt());
            }

            Arrays.sort(activities);

            char[] schedule = new char[N];
            Activity cameron = null;
            Activity jamie = null;


            boolean impossible = false;
            for (int i = 0; i < activities.length; i++) {
                Activity currentActivity = activities[i];
                //cleanup done activities
                if (cameron == null || cameron.end <= currentActivity.start) {
                    cameron = null;
                }
                if (jamie == null || jamie.end <= currentActivity.start) {
                    jamie = null;
                }

                //assign activity to free person
                if (cameron == null) {
                    cameron = currentActivity;
                    schedule[currentActivity.index] = 'C';
                    continue;
                }

                if (jamie == null) {
                    jamie = currentActivity;
                    schedule[currentActivity.index] = 'J';
                    continue;
                }

                // cannot assign to any person
                impossible = true;
                break;
            }

            String ans = impossible ? "IMPOSSIBLE " : String.valueOf(schedule);
            System.out.printf("Case #%d: %s\n", testCase, ans);
        }
    }

    static class Activity implements Comparable<Activity> {
        int index, start, end;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            int cmp = Integer.compare(this.start, o.start);

            if (cmp == 0) return Integer.compare(this.end, end);

            return cmp;
        }
    }
}
