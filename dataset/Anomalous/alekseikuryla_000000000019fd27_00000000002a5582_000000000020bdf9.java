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

            StringBuilder result = new StringBuilder();
            int overlapping = 0;
            boolean cBusy = false;
            boolean jBusy = false;
            char[] schedule = new char[numActivities];

            for (Activity activity : activities) {
                if (activity.isStart) {
                    if (overlapping == 2) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                    overlapping++;
                    if (!cBusy) {
                        cBusy = true;
                        schedule[activity.id] = 'C';
                    } else {
                        jBusy = true;
                        schedule[activity.id] = 'J';
                    }
                } else {
                    overlapping--;
                    if (schedule[activity.id] == 'C') {
                        cBusy = false;
                    } else {
                        jBusy = false;
                    }
                }
            }

            if (result.length() == 0) {
                for (char c : schedule) {
                    result.append(c);
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
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
                return Boolean.compare(other.isStart, this.isStart);
            }
            return this.time - other.time;
        }
    }
}