import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTests = scanner.nextInt();
        for (int testNum = 1; testNum <= numTests; testNum++) {
            int numActivities = scanner.nextInt();
            ArrayList<Activity> activityList = new ArrayList<>(numActivities);
            for (int j = 0; j < numActivities; j++) {
                activityList.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            System.out.println(String.format("Case #%d: %s", testNum, getResult(activityList)));
        }

    }

    private static String getResult(List<Activity> activityList) {
        PriorityQueue<Activity> activities = new PriorityQueue<>(
                (a1, a2) -> {
                    if (a1.getEnd() != a2.getEnd()) {
                        return a1.getEnd().compareTo(a2.getEnd());
                    } else {
                        return a1.getStart().compareTo(a2.getStart());
                    }
                }
        );
        activities.addAll(activityList);

        Activity p1 = null;
        Activity p2 = null;

        StringBuffer result = new StringBuffer();
        while (!activities.isEmpty()) {
            Activity current = activities.poll();
            if (p1 == null || p1.getEnd() <= current.getStart()) {
                p1 = current;
                current.setAssignment('C');
            } else if (p2 == null || p2.getEnd() <= current.getStart()) {
                p2 = current;
                current.setAssignment('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        activityList.forEach((a) -> result.append(a.getAssignment()));
        return result.toString();
    }

    private static class Activity {
        private Integer start;
        private Integer end;
        private Character assignment;

        public Activity(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        public Integer getStart() {
            return start;
        }

        public Integer getEnd() {
            return end;
        }

        public Character getAssignment() {
            return assignment;
        }

        public Activity setAssignment(Character assignment) {
            this.assignment = assignment;
            return this;
        }
    }
}
