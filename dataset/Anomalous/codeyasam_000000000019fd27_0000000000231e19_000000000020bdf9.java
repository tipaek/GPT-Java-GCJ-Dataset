import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesCount = scanner.nextInt();
        for (int i = 1; i <= testCasesCount; i++) {
            int activitiesCount = scanner.nextInt();
            List<int[]> activities = getActivities(activitiesCount, scanner);
            String result = assignTasks(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static List<int[]> getActivities(int activitiesCount, Scanner scanner) {
        List<int[]> activities = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new int[]{start, end});
        }
        return activities;
    }

    private static String assignTasks(List<int[]> activities) {
        StringBuilder schedule = new StringBuilder("C");
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(new Task(activities.get(0)[0], activities.get(0)[1]));

        for (int i = 1; i < activities.size(); i++) {
            int[] current = activities.get(i);
            String assignment = "C";

            if (cameron.isOverlapping(current) && jamie.isOverlapping(current)) {
                return "IMPOSSIBLE";
            } else if (cameron.isOverlapping(current)) {
                assignment = "J";
            } else if (jamie.isOverlapping(current)) {
                assignment = "C";
            } else if (current[0] == activities.get(i - 1)[1]) {
                assignment = schedule.substring(schedule.length() - 1);
            }

            if ("J".equals(assignment)) {
                jamie.addTask(new Task(current[0], current[1]));
            } else {
                cameron.addTask(new Task(current[0], current[1]));
            }

            schedule.append(assignment);
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

        public void addTask(Task task) {
            tasks.add(task);
        }

        public boolean isOverlapping(int[] taskTime) {
            for (Task task : tasks) {
                if (task.isOverlapping(taskTime)) {
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

        public boolean isOverlapping(int[] taskTime) {
            int otherStart = taskTime[0];
            int otherEnd = taskTime[1];

            return (otherStart < end && otherEnd > start);
        }
    }
}