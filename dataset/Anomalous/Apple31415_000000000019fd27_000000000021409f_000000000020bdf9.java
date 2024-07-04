import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCases; i++) {
            int numActivities = Integer.parseInt(br.readLine());
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                activities.add(new Activity(br.readLine(), j));
            }

            Collections.sort(activities);

            int camEnd = 0;
            int jamEnd = 0;
            char[] schedule = new char[numActivities];
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (camEnd <= activity.begin) {
                    camEnd = activity.end;
                    schedule[activity.index] = 'C';
                } else if (jamEnd <= activity.begin) {
                    jamEnd = activity.end;
                    schedule[activity.index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? new String(schedule) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }

    private static class Activity implements Comparable<Activity> {
        int begin;
        int end;
        int index;

        public Activity(String input, int index) {
            StringTokenizer st = new StringTokenizer(input);
            this.begin = Integer.parseInt(st.nextToken());
            this.end = Integer.parseInt(st.nextToken());
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.begin != other.begin) {
                return this.begin - other.begin;
            }
            return this.end - other.end;
        }
    }
}