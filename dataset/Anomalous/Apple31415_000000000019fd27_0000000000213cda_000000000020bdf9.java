import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfActivities = Integer.parseInt(reader.readLine());
            List<Activity> activities = new ArrayList<>();
            
            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                activities.add(new Activity(reader.readLine(), activityIndex));
            }

            Collections.sort(activities);

            int cameronEndTime = 0;
            int jamieEndTime = 0;
            char[] schedule = new char[numberOfActivities];
            boolean isImpossible = false;
            
            for (Activity activity : activities) {
                if (cameronEndTime <= activity.startTime) {
                    cameronEndTime = activity.endTime;
                    schedule[activity.originalIndex] = 'C';
                } else if (jamieEndTime <= activity.startTime) {
                    jamieEndTime = activity.endTime;
                    schedule[activity.originalIndex] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : new String(schedule);
            System.out.printf("Case #%d: %s%n", caseIndex + 1, result);
        }
    }

    static class Activity implements Comparable<Activity> {
        int startTime;
        int endTime;
        int originalIndex;

        Activity(String input, int index) {
            StringTokenizer tokenizer = new StringTokenizer(input);
            this.startTime = Integer.parseInt(tokenizer.nextToken());
            this.endTime = Integer.parseInt(tokenizer.nextToken());
            this.originalIndex = index;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.startTime, other.startTime);
        }
    }
}