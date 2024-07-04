import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            ArrayList<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities.add(new Activity(start, true, i));
                activities.add(new Activity(end, false, i));
            }

            Collections.sort(activities);

            int overlapping = 0;
            int cEnd = -1;
            int jEnd = -1;
            StringBuilder result = new StringBuilder();
            char[] schedule = new char[numActivities];

            for (Activity activity : activities) {
                if (activity.isStart) {
                    if (overlapping == 2) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                    overlapping++;
                    if (cEnd == -1) {
                        cEnd = activity.id;
                        schedule[activity.id] = 'C';
                    } else if (jEnd == -1) {
                        jEnd = activity.id;
                        schedule[activity.id] = 'J';
                    }
                } else {
                    overlapping--;
                    if (cEnd == activity.id) {
                        cEnd = -1;
                    } else if (jEnd == activity.id) {
                        jEnd = -1;
                    }
                }
            }

            if (result.length() == 0) {
                for (char ch : schedule) {
                    result.append(ch);
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }

        scanner.close();
    }

    static class Activity implements Comparable<Activity> {
        int time;
        boolean isStart;
        int id;

        Activity(int time, boolean isStart, int id) {
            this.time = time;
            this.isStart = isStart;
            this.id = id;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.time, other.time);
        }
    }
}