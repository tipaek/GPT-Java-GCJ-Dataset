import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int numCases = in.nextInt();
        in.nextLine();
        outer:
        for (int currCase = 0; currCase < numCases; currCase++) {

            boolean[][] cj = new boolean[2][24 * 60 + 1];

            int numActivities = in.nextInt();

            Activity[] acts = new Activity[numActivities];
            for (int i = 0; i < numActivities; i++) {
                acts[i] = new Activity(in.nextInt(), in.nextInt());
            }
            Arrays.sort(acts);

            char[] activities = new char[numActivities];
            Arrays.fill(activities, 'N');

            for (int i = 0; i < numActivities; i++) {

                int start = acts[i].start;
                int end = acts[i].end;

                primary:
                for (int k = 0; k < 2; k++) {
                    for (int j = start; j < end; j++) {
                        if (cj[k][j]) {
                            continue primary;
                        }
                    }
                    for (int j = start; j < end; j++) {
                        cj[k][j] = true;
                    }
                    activities[i] = k == 0 ? 'C' : 'J';
                    break primary;
                }
            }

            for (int i = 0; i < numActivities; i++) {
                if(activities[i] == 'N') {
                    System.out.printf("Case #%d: %s%n", currCase + 1, "IMPOSSIBLE");
                    continue outer;
                }
            }

            System.out.printf("Case #%d: %s%n", currCase + 1, String.valueOf(activities));

        }


    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        Activity(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Activity o) {
            return end - o.end;
        }
    }
}