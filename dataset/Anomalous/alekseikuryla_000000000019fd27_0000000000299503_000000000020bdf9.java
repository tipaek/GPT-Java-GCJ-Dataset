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
                activities.add(new Activity(Integer.parseInt(times[0]), true, i));
                activities.add(new Activity(Integer.parseInt(times[1]), false, i));
            }

            Collections.sort(activities);

            StringBuilder schedule = new StringBuilder();
            int overlapCount = 0;
            int cEnd = -1;
            int jEnd = -1;
            boolean impossible = false;
            char[] assigned = new char[numActivities];

            for (Activity activity : activities) {
                if (activity.isStart) {
                    if (overlapCount == 2) {
                        impossible = true;
                        break;
                    }
                    overlapCount++;
                    if (cEnd == -1) {
                        cEnd = activity.id;
                        assigned[activity.id] = 'C';
                    } else {
                        jEnd = activity.id;
                        assigned[activity.id] = 'J';
                    }
                } else {
                    overlapCount--;
                    if (cEnd == activity.id) {
                        cEnd = -1;
                    } else {
                        jEnd = -1;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                for (char ch : assigned) {
                    schedule.append(ch);
                }
                System.out.println("Case #" + caseNum + ": " + schedule);
            }
        }
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
            if (this.time == other.time) {
                return this.isStart ? -1 : 1;
            }
            return this.time - other.time;
        }
    }
}