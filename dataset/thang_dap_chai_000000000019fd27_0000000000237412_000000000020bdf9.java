import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author thangbq
 */
public class Solution {

    private static class Activity {

        int start;
        int end;
        int pos;

        public Activity(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nTestCase; ++i) {
            sb.setLength(0);
            sb.append("Case #").append(i).append(": ");
            int nActivities = in.nextInt();
            Activity[] activities = new Activity[nActivities];
            for (int j = 0; j < nActivities; j++) {
                activities[j] = new Activity(in.nextInt(), in.nextInt(), j);
            }
            Arrays.sort(activities, (a1, a2) -> {
                int b = a1.start - a2.start;
                return b == 0 ? a1.end - a2.end : b;
            });
            boolean isFailed = false;
            Activity C = null, J = null;
            char[] assigns = new char[nActivities];
            for (Activity activity : activities) {
                if (C == null || activity.start >= C.end) {
                    C = activity;
                    assigns[activity.pos] = 'C';
                    continue;
                }
                if (J == null || activity.start >= J.end) {
                    assigns[activity.pos] = 'J';
                    J = activity;
                    continue;
                }
                isFailed = true;
                break;
            }
            if (isFailed) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                for (char assign : assigns) {
                    sb.append(assign);
                }
                System.out.println(sb.toString());
            }
        }
    }
}
