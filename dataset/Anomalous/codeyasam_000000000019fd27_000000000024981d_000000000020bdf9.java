import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = getActivities(activityCount, scanner);
            String result = assignTasks(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static List<int[]> getActivities(int count, Scanner scanner) {
        List<int[]> activities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new int[]{start, end});
        }
        return activities;
    }

    private static String assignTasks(List<int[]> activities) {
        if (activities.isEmpty()) return "";

        StringBuilder schedule = new StringBuilder("C");
        int[] firstActivity = activities.get(0);
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(firstActivity);

        for (int i = 1; i < activities.size(); i++) {
            int[] currentActivity = activities.get(i);
            int[] previousActivity = activities.get(i - 1);
            String assignTo = "";

            if (cameron.hasConflict(currentActivity) && jamie.hasConflict(currentActivity)) {
                return "IMPOSSIBLE";
            } else if (cameron.hasConflict(currentActivity)) {
                assignTo = "J";
            } else if (jamie.hasConflict(currentActivity)) {
                assignTo = "C";
            } else if (currentActivity[0] == previousActivity[1]) {
                assignTo = schedule.substring(schedule.length() - 1);
            } else {
                assignTo = "C";
            }

            if (assignTo.equals("C")) {
                cameron.addTask(currentActivity);
            } else {
                jamie.addTask(currentActivity);
            }

            schedule.append(assignTo);
        }

        return schedule.toString();
    }

    static class Person {
        String name;
        List<Task> tasks;

        public Person(String name) {
            this.name = name;
            this.tasks = new ArrayList<>();
        }

        public void addTask(int[] taskTime) {
            tasks.add(new Task(taskTime[0], taskTime[1]));
        }

        public boolean hasConflict(int[] taskTime) {
            for (Task task : tasks) {
                if (task.isConflicting(taskTime)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Task {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isConflicting(int[] otherTask) {
            int otherStart = otherTask[0];
            int otherEnd = otherTask[1];

            return (otherStart < end && otherEnd > start);
        }
    }
}