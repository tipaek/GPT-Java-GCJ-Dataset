import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= testCaseCount; caseIndex++) {
            int activityCount = scanner.nextInt();
            List<int[]> activityTimes = getActivityTimes(activityCount, scanner);
            String result = assignTasks(activityTimes);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static String assignTasks(List<int[]> activityTimes) {
        StringBuilder result = new StringBuilder("C");
        int[] firstActivity = activityTimes.get(0);
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(new Task(firstActivity[0], firstActivity[1]));

        for (int i = 1; i < activityTimes.size(); i++) {
            int[] currentActivity = activityTimes.get(i);
            String assignedPerson = "C";

            if (cameron.isOverlapping(currentActivity) && jamie.isOverlapping(currentActivity)) {
                return "IMPOSSIBLE";
            } else if (cameron.isOverlapping(currentActivity)) {
                assignedPerson = "J";
            } else if (jamie.isOverlapping(currentActivity)) {
                assignedPerson = "C";
            }

            Task task = new Task(currentActivity[0], currentActivity[1]);
            if ("J".equals(assignedPerson)) {
                jamie.addTask(task);
            } else {
                cameron.addTask(task);
            }

            result.append(assignedPerson);
        }

        return result.toString();
    }

    private static List<int[]> getActivityTimes(int activityCount, Scanner scanner) {
        List<int[]> activityTimes = new ArrayList<>();
        for (int i = 0; i < activityCount; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            activityTimes.add(new int[]{startTime, endTime});
        }
        return activityTimes;
    }
}

class Person {
    private String name;
    private List<Task> tasks;

    public Person(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean isOverlapping(int[] otherTaskTime) {
        for (Task task : tasks) {
            if (task.isOverlapping(otherTaskTime)) {
                return true;
            }
        }
        return false;
    }
}

class Task {
    private int startTime;
    private int endTime;

    public Task(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isOverlapping(int[] otherTaskTime) {
        int otherStart = otherTaskTime[0];
        int otherEnd = otherTaskTime[1];

        return (otherStart < endTime && otherEnd > startTime);
    }
}