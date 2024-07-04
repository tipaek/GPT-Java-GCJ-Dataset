import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int numCases = in.nextInt();
        outer:
        for (int currCase = 0; currCase < numCases; currCase++) {

            int[][] cj = new int[2][24 * 60 + 2];

            int numActivities = in.nextInt();

            Activity[] acts = new Activity[numActivities];
            for (int i = 0; i < numActivities; i++) {
                acts[i] = new Activity(in.nextInt(), in.nextInt(), i);
            }

            int[] shortcut = new int[24 * 60 + 1];
            for (Activity a : acts) {
                for (int i = a.start; i < a.end; i++) {
                    shortcut[i]++;
                    if (shortcut[i] > 2) {
                        System.out.printf("Case #%d: %s%n", currCase + 1, "IMPOSSIBLE");
                        continue outer;
                    }
                }
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

    static boolean rec(Activity[] acts, char[] activities, int index, int[][] cj) {
        if (index == activities.length) {
            return true;
        }

        Activity a = acts[index];
        for (int person = 0; person < 2; person++) {
            boolean can = true;
            if(sum(cj[person], a.end - 1) - sum(cj[person], a.start) != 0) {
                can = false;
            }

            if (can) {
                add(cj[person], a.end - 1, 1);
                activities[a.dex] = person == 0 ? 'C' : 'J';

                if (rec(acts, activities, index + 1, cj)) {
                    return true;
                }

                activities[a.dex] = 'N';
                add(cj[person], a.end - 1, -1);
            }
        }

        return false;

    }

    static int sum(int[] tree, int k) {
        int s = 0;
        while (k >= 1) {
            s += tree[k];
            k -= k & -k;
        }
        return s;
    }

    static void add(int[] tree, int k, int x) {
        while(k < tree.length) {
            tree[k] += x;
            k += k & -k;
        }
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