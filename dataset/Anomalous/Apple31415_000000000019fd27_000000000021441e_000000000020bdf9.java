import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Iterator;

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

            int cameronTime = 0;
            int jamieTime = 0;
            boolean isImpossible = false;
            char[] result = new char[numActivities];
            Iterator<Activity> iterator = activityMap.keySet().iterator();

            for (int j = 0; j < numActivities; j++) {
                Activity activity = iterator.next();
                if (cameronTime <= activity.begin) {
                    cameronTime = activity.end;
                    result[activityMap.get(activity)] = 'C';
                } else if (jamieTime <= activity.begin) {
                    jamieTime = activity.end;
                    result[activityMap.get(activity)] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String answer = isImpossible ? "IMPOSSIBLE" : new String(result);
            System.out.printf("Case #%d: %s%n", i + 1, answer);
        }
    }

    public static class Activity implements Comparable<Activity> {
        int begin;
        int end;
        int count;
        static int counter = 0;

        public Activity(String input) {
            StringTokenizer st = new StringTokenizer(input);
            this.begin = Integer.parseInt(st.nextToken());
            this.end = Integer.parseInt(st.nextToken());
            this.count = counter++;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.begin != other.begin) {
                return this.begin - other.begin;
            } else if (this.end != other.end) {
                return this.end - other.end;
            } else {
                return this.count - other.count;
            }
        }
    }
}