import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Activity implements Comparable<Activity> {
    Integer start, end, id;

    public Activity(Integer start, Integer end, Integer id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public int compareTo(Activity other) {
        return this.end.compareTo(other.end);
    }

    @Override
    public String toString() {
        return "Activity{" + "start=" + start + ", end=" + end + ", id=" + id + "}\n";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = Integer.parseInt(reader.readLine());
            ArrayList<Activity> activities = new ArrayList<>();
            char[] schedule = new char[numActivities];

            for (int i = 0; i < numActivities; i++) {
                String[] input = reader.readLine().split(" ");
                activities.add(new Activity(Integer.parseInt(input[0]), Integer.parseInt(input[1]), i));
            }

            Collections.sort(activities);

            ArrayList<Activity> remainingActivities = new ArrayList<>();
            Activity lastActivity = activities.get(0);
            schedule[lastActivity.id] = 'C';

            for (int i = 1; i < activities.size(); i++) {
                if (activities.get(i).start >= lastActivity.end) {
                    lastActivity = activities.get(i);
                    schedule[lastActivity.id] = 'C';
                } else {
                    remainingActivities.add(activities.get(i));
                }
            }

            boolean isImpossible = false;
            if (!remainingActivities.isEmpty()) {
                lastActivity = remainingActivities.get(0);
                schedule[lastActivity.id] = 'J';

                for (int i = 1; i < remainingActivities.size(); i++) {
                    if (remainingActivities.get(i).start >= lastActivity.end) {
                        lastActivity = remainingActivities.get(i);
                        schedule[lastActivity.id] = 'J';
                    } else {
                        System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + caseNum + ": " + new String(schedule));
            }
        }
    }
}