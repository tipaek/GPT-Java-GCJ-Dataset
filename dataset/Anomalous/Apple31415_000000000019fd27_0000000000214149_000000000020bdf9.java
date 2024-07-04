import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCases; i++) {
            int numActivities = Integer.parseInt(br.readLine());
            TreeMap<Activity, Integer> activityMap = new TreeMap<>();

            for (int j = 0; j < numActivities; j++) {
                Activity activity = new Activity(br.readLine());
                activityMap.put(activity, j);
            }

            int cameronEndTime = 0;
            int jamieEndTime = 0;
            boolean isImpossible = false;
            char[] schedule = new char[numActivities];

            Iterator<Activity> iterator = activityMap.keySet().iterator();
            for (int j = 0; j < numActivities; j++) {
                Activity currentActivity = iterator.next();

                if (cameronEndTime <= currentActivity.begin) {
                    cameronEndTime = currentActivity.end;
                    schedule[activityMap.get(currentActivity)] = 'C';
                } else if (jamieEndTime <= currentActivity.begin) {
                    jamieEndTime = currentActivity.end;
                    schedule[activityMap.get(currentActivity)] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : new String(schedule);
            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }

    public static class Activity implements Comparable<Activity> {
        int begin;
        int end;

        public Activity(String input) {
            StringTokenizer st = new StringTokenizer(input);
            this.begin = Integer.parseInt(st.nextToken());
            this.end = Integer.parseInt(st.nextToken());
        }

        @Override
        public int compareTo(Activity other) {
            if (this.begin != other.begin) {
                return this.begin - other.begin;
            } else {
                return this.end - other.end;
            }
        }
    }
}