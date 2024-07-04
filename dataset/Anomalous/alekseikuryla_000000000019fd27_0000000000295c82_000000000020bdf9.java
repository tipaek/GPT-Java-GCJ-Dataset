import java.util.ArrayList;
import java.util.PriorityQueue;
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
                activities.add(new Activity(Integer.parseInt(times[0]), Integer.parseInt(times[1])));
            }

            PriorityQueue<Activity> activityQueue = new PriorityQueue<>(activities);
            StringBuilder result = new StringBuilder();

            if (numActivities >= 1) {
                result.append("C");
            }
            if (numActivities >= 2) {
                result.append("J");
            }
            if (numActivities > 2) {
                Activity cameronActivity = activityQueue.poll();
                Activity jamieActivity = activityQueue.poll();

                while (!activityQueue.isEmpty()) {
                    Activity nextActivity = activityQueue.poll();

                    if (cameronActivity.endTime > jamieActivity.endTime) {
                        if (cameronActivity.endTime <= nextActivity.startTime) {
                            result.append("C");
                            cameronActivity = nextActivity;
                        } else if (jamieActivity.endTime <= nextActivity.startTime) {
                            result.append("J");
                            jamieActivity = nextActivity;
                        } else {
                            result = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    } else {
                        if (jamieActivity.endTime <= nextActivity.startTime) {
                            result.append("J");
                            jamieActivity = nextActivity;
                        } else if (cameronActivity.endTime <= nextActivity.startTime) {
                            result.append("C");
                            cameronActivity = nextActivity;
                        } else {
                            result = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }

    static class Activity implements Comparable<Activity> {
        int startTime;
        int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.endTime, other.endTime);
        }
    }
}