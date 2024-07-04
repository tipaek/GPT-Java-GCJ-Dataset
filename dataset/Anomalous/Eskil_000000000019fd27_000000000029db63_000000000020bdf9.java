import java.util.*;
import java.io.*;

public class Solution {

    public static class Activity implements Comparable<Activity> {
        int start, end, index;
        String person;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
            this.person = null;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            Activity[] activities = new Activity[N];

            for (int j = 0; j < N; j++) {
                String[] parts = reader.readLine().split(" ");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                activities[j] = new Activity(j, start, end);
            }

            Arrays.sort(activities);

            int cFree = -1, jFree = -1;
            boolean possible = true;

            for (Activity activity : activities) {
                if (cFree <= activity.start) {
                    cFree = activity.end;
                    activity.person = "C";
                } else if (jFree <= activity.start) {
                    jFree = activity.end;
                    activity.person = "J";
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.person);
                }
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            }
        }
    }
}