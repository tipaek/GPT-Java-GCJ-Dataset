import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = getActivities(activityCount, scanner); 
            String result = assignTasks(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String assignTasks(List<int[]> activities) {
        if (activities.isEmpty()) return "";

        StringBuilder result = new StringBuilder("C");
        int[] firstActivity = activities.get(0);
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(new Task(firstActivity[0], firstActivity[1]));

        for (int i = 1; i < activities.size(); i++) {
            int[] currentActivity = activities.get(i);
            String assignment = "";
            if (cameron.isOverlapping(currentActivity) && jamie.isOverlapping(currentActivity)) {
                return "IMPOSSIBLE";
            } else if (cameron.isOverlapping(currentActivity)) {
                assignment = "J";
            } else if (jamie.isOverlapping(currentActivity)) {
                assignment = "C";
            } else {
                assignment = "C";
            }

            Task task = new Task(currentActivity[0], currentActivity[1]);
            if ("J".equals(assignment)) {
                jamie.addTask(task);
            } else {
                cameron.addTask(task);
            }

            result.append(assignment);
        }

        return result.toString();
    }

    private static List<int[]> getActivities(int count, Scanner scanner) {
        List<int[]> activities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new int[] {start, end});
        }
        return activities;
    }

    static class Person {
        String name;
        List<Task> tasks;

        public Person(String name) {
            this.name = name;
            this.tasks = new ArrayList<>();
        }

        public void addTask(Task task) {
            tasks.add(task);
        }

        public boolean isOverlapping(int[] taskTime) {
            for (Task task : tasks) {
                if (task.isOverlapping(taskTime)) return true;
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

        public boolean isOverlapping(int[] taskTime) {
            int otherStart = taskTime[0];
            int otherEnd = taskTime[1];

            return (otherStart < end && otherEnd > start);
        }
    }
}