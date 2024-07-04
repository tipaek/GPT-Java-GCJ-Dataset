import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String args[]) {
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + secret());
        }
    }

    public static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int unique;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.unique = index;
        }

        @Override
        public int compareTo(Activity activity) {
            if (start < activity.start)
                return -1;
            if (start > activity.start)
                return 1;
            if (end < activity.end)
                return -1;
            if (end > activity.end)
                return 1;
            return unique - activity.unique;
        }
    }

    // IMPOSSIBLE if can't be, or N characters, i is C if Cameron, and J if Jamie...
    // If there are 2+ solutions, output anyone

    // 2 <= N <= 1000
    // 0 <= Si < Ei <= 24 * 60  // 1 FULL DAY :)

    // Look!! Si < Ei... IMPORTANT
    private static String secret() {
        int N = in.nextInt();

        List<Activity> activities = new LinkedList<>();
        String result = "";

        for (int i = 0; i < N; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            activities.add(new Activity(start, end, i));
        }

        Collections.sort(activities);

        int cEnds = -1;
        int jEnds = -1;
        char[] tavs = new char[N];

        boolean firstTime = true;
        for (Activity activity : activities) {
            if (firstTime) {
                tavs[activity.unique] = 'C';
                cEnds = activity.end;
                firstTime = false;
            } else {
                if (activity.start >= cEnds) {
                    tavs[activity.unique] = 'C';
                    cEnds = activity.end;
                } else if (activity.start >= jEnds) {
                    tavs[activity.unique] = 'J';
                    jEnds = activity.end;
                } else
                    return IMPOSSIBLE;
            }
        }

        for(char tav: tavs) {
            result += tav;
        }

        return result;
    }
}
