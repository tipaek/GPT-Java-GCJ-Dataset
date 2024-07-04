import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<int[]> activityTimes = getActivityTimes(numberOfActivities, scanner);
            String result = assignTasks(activityTimes);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String assignTasks(List<int[]> activityTimes) {
        if (activityTimes.isEmpty()) return "";

        StringBuilder schedule = new StringBuilder("C");
        int[] firstActivity = activityTimes.get(0);
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(new Task(firstActivity[0], firstActivity[1]));

        for (int i = 1; i < activityTimes.size(); i++) {
            int[] currentActivity = activityTimes.get(i);
            int[] previousActivity = activityTimes.get(i - 1);
            String assignment = "";

            if (cameron.hasConflict(currentActivity) && jamie.hasConflict(currentActivity)) {
                return "IMPOSSIBLE";
            } else if (cameron.hasConflict(currentActivity)) {
                assignment = "J";
            } else if (jamie.hasConflict(currentActivity)) {
                assignment = "C";
            } else if (Objects.equals(currentActivity[0], previousActivity[1])) {
                assignment = schedule.substring(schedule.length() - 1);
            } else {
                assignment = "C";
            }

            Task newTask = new Task(currentActivity[0], currentActivity[1]);
            if (assignment.equals("J")) {
                jamie.addTask(newTask);
            } else {
                cameron.addTask(newTask);
            }

            schedule.append(assignment);
        }

        return schedule.toString();
    }

    private static List<int[]> getActivityTimes(int count, Scanner scanner) {
        List<int[]> times = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            times.add(new int[] { start, end });
        }
        return times;
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

        public boolean hasConflict(int[] time) {
            for (Task task : tasks) {
                if (task.conflictsWith(time)) return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Task {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean conflictsWith(int[] time) {
            int otherStart = time[0];
            int otherEnd = time[1];

            return (otherStart < end && otherEnd > start);
        }
    }
}