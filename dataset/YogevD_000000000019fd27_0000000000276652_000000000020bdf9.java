import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        Character c;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return start - o.start;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            Activity[] activities = new Activity[N];
            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end);
            }
            Arrays.sort(activities);
            System.out.print("Case #" + (t + 1) + ": ");
            try {
                nestingDepth(activities);
                for (Activity activity : activities) {
                    System.out.print(activity.c);
                }
                System.out.println();
            } catch (Exception ex) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void nestingDepth(Activity[] activities) {

        Activity cActivity = null;
        Activity jActivity = null;

        for (Activity activity : activities) {
            if (cActivity == null || cActivity.end <= activity.start) {
                activity.c = 'C';
                cActivity = activity;
            } else if (jActivity == null || jActivity.end <= activity.start) {
                activity.c = 'J';
                jActivity = activity;
            } else {
                throw new RuntimeException();
            }
        }
    }
}