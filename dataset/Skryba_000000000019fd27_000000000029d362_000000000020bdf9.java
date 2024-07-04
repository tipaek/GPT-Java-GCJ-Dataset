import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Parenting Partnering Returns
public class Solution {

    private static final Character JAMIE = 'J';
    private static final Character CAMERON = 'C';
    public static final StringBuilder IMPOSSIBLE = new StringBuilder("IMPOSSIBLE");

    public static class Activity {
        int id;
        int start;
        int end;

        Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            List<Activity> activities = new ArrayList<>(n);
            for (int k = 0; k < n; k++) {
                activities.add(new Activity(k, in.nextInt(), in.nextInt()));
            }

            activities.sort(Comparator.comparingInt(o -> o.start));

            StringBuilder sb = new StringBuilder("Case #");
            sb.append(i).append(": ");

            int c = 0, j = 0;
            StringBuilder sbb = new StringBuilder(new String(new char[n]));
            for (Activity activity : activities) {
                if (c <= activity.start) {
                    sbb.setCharAt(activity.id, CAMERON);
                    c = activity.end;
                } else if (j <= activity.start) {
                    sbb.setCharAt(activity.id, JAMIE);
                    j = activity.end;
                } else {
                    sbb = IMPOSSIBLE;
                    break;
                }
            }
            sb.append(sbb);
            System.out.println(sb.toString());
        }
    }
}
