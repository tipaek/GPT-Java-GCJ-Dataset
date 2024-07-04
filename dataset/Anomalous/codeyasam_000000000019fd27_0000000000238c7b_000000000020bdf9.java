import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            List<int[]> activityTimes = getActivityTimes(activityCount, scanner);
            String result = assignTasks(activityTimes);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static List<int[]> getActivityTimes(int count, Scanner scanner) {
        List<int[]> times = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            times.add(new int[] {start, end});
        }
        return times;
    }

    private static String assignTasks(List<int[]> times) {
        StringBuilder schedule = new StringBuilder("C");
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(new Task(times.get(0)[0], times.get(0)[1]));

        for (int i = 1; i < times.size(); i++) {
            int[] current = times.get(i);
            int[] previous = times.get(i - 1);
            String assignTo = "C";

            if (cameron.hasConflict(current) && jamie.hasConflict(current)) {
                return "IMPOSSIBLE";
            } else if (cameron.hasConflict(current)) {
                assignTo = "J";
            } else if (jamie.hasConflict(current)) {
                assignTo = "C";
            } else if (current[0] == previous[1]) {
                assignTo = schedule.substring(schedule.length() - 1);
            }

            Task newTask = new Task(current[0], current[1]);
            if (assignTo.equals("J")) {
                jamie.addTask(newTask);
            } else {
                cameron.addTask(newTask);
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

        public void addTask(Task task) {
            tasks.add(task);
        }

        public boolean hasConflict(int[] time) {
            for (Task task : tasks) {
                if (task.conflictsWith(time)) {
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

        public boolean conflictsWith(int[] other) {
            int otherStart = other[0];
            int otherEnd = other[1];

            return (otherStart < end && otherEnd > start);
        }
    }
}