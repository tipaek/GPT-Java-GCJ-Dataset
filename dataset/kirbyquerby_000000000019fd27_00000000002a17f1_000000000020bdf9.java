import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int numCases = in.nextInt();
        outer:
        for (int currCase = 0; currCase < numCases; currCase++) {

            boolean[][] cj = new boolean[2][24 * 60 + 1];

            int numActivities = in.nextInt();

            Activity[] acts = new Activity[numActivities];
            for (int i = 0; i < numActivities; i++) {
                acts[i] = new Activity(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(acts);

            char[] activities = new char[numActivities];
            Arrays.fill(activities, 'N');

            boolean success = rec(acts, activities, 0, cj);

            if (!success) {
                System.out.printf("Case #%d: %s%n", currCase + 1, "IMPOSSIBLE");

            } else {
                System.out.printf("Case #%d: %s%n", currCase + 1, String.valueOf(activities));
            }


        }


    }

    static boolean rec(Activity[] acts, char[] activities, int index, boolean[][] cj) {
        if (index == activities.length) {
            return true;
        }

        Activity a = acts[index];
        for (int person = 0; person < 2; person++) {
            boolean can = true;
            for (int j = a.start; j < a.end; j++) {
                if (cj[person][j]) {
                    can = false;
                    break;
                }
            }

            if (can) {
                for (int j = a.start; j < a.end; j++) {
                    cj[person][j] = true;
                }
                activities[a.dex] = person == 0 ? 'C' : 'J';

                if (rec(acts, activities, index + 1, cj)) {
                    return true;
                }

                activities[a.dex] = 'N';
                for (int j = a.start; j < a.end; j++) {
                    cj[person][j] = false;
                }
            }
        }

        return false;

    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int dex;

        Activity(int s, int e, int dex) {
            start = s;
            end = e;
            this.dex = dex;
        }

        @Override
        public int compareTo(Activity o) {
            if (end != o.end) {
                return end - o.end;
            }
            return start - o.start;
        }
    }
}