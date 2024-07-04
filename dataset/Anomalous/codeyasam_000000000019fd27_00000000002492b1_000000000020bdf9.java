import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesCount = scanner.nextInt();
        for (int i = 1; i <= testCasesCount; i++) {
            int activitiesCount = scanner.nextInt();
            List<int[]> activitiesTime = retrieveActivitiesTime(activitiesCount, scanner);
            String output = assignTasks(activitiesTime);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String assignTasks(List<int[]> activitiesTime) {
        if (activitiesTime.isEmpty()) return "";

        StringBuilder result = new StringBuilder("C");
        int[] firstActivity = activitiesTime.get(0);
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(new Task(firstActivity[0], firstActivity[1]));

        for (int i = 1; i < activitiesTime.size(); i++) {
            int[] currentActivity = activitiesTime.get(i);
            int[] previousActivity = activitiesTime.get(i - 1);
            String assignment = "";

            if (cameron.hasOverlap(currentActivity) && jamie.hasOverlap(currentActivity)) {
                return "IMPOSSIBLE";
            } else if (cameron.hasOverlap(currentActivity)) {
                assignment = "J";
            } else if (jamie.hasOverlap(currentActivity)) {
                assignment = "C";
            } else if (currentActivity[0] == previousActivity[1]) {
                assignment = result.substring(result.length() - 1);
            } else {
                assignment = "C";
            }

            Task task = new Task(currentActivity[0], currentActivity[1]);
            if (assignment.equals("J")) {
                jamie.addTask(task);
            } else {
                cameron.addTask(task);
            }

            result.append(assignment);
        }

        return result.toString();
    }

    private static List<int[]> retrieveActivitiesTime(int activitiesCount, Scanner scanner) {
        List<int[]> activitiesTime = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            activitiesTime.add(new int[] {startTime, endTime});
        }
        return activitiesTime;
    }

    static class Person {

        private final String name;
        private final List<Task> tasks;

        public Person(String name) {
            this.name = name;
            this.tasks = new ArrayList<>();
        }

        public void addTask(Task task) {
            tasks.add(task);
        }

        public boolean hasOverlap(int[] taskTime) {
            for (Task task : tasks) {
                if (task.hasOverlap(taskTime)) return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Task {

        private final int startTime;
        private final int endTime;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean hasOverlap(int[] otherTaskTime) {
            int otherStart = otherTaskTime[0];
            int otherEnd = otherTaskTime[1];

            return (otherStart < endTime && otherEnd > startTime);
        }
    }
}