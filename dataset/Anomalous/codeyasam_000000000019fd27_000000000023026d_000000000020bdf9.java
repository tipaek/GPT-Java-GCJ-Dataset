import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesCount = scanner.nextInt();
        for (int i = 1; i <= testCasesCount; i++) {
            int activitiesCount = scanner.nextInt();
            List<int[]> activitiesTime = getActivitiesTime(activitiesCount, scanner);
            String result = assignTasks(activitiesTime);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(List<int[]> activitiesTime) {
        StringBuilder schedule = new StringBuilder("C");
        int[] firstActivityTime = activitiesTime.get(0);
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(new Task(firstActivityTime[0], firstActivityTime[1]));

        for (int i = 1; i < activitiesTime.size(); i++) {
            int[] currentActivityTime = activitiesTime.get(i);
            int[] previousActivityTime = activitiesTime.get(i - 1);
            String assignedPerson = "C";

            if (cameron.isOverlapping(currentActivityTime) && jamie.isOverlapping(currentActivityTime)) {
                return "IMPOSSIBLE";
            } else if (cameron.isOverlapping(currentActivityTime)) {
                assignedPerson = "J";
            } else if (jamie.isOverlapping(currentActivityTime)) {
                assignedPerson = "C";
            } else if (currentActivityTime[0] == previousActivityTime[1]) {
                assignedPerson = schedule.substring(schedule.length() - 1);
            }

            Task task = new Task(currentActivityTime[0], currentActivityTime[1]);
            if ("J".equals(assignedPerson)) {
                jamie.addTask(task);
            } else {
                cameron.addTask(task);
            }

            schedule.append(assignedPerson);
        }

        return schedule.toString();
    }

    private static List<int[]> getActivitiesTime(int activitiesCount, Scanner scanner) {
        List<int[]> activitiesTime = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            activitiesTime.add(new int[] {startTime, endTime});
        }
        return activitiesTime;
    }
}

class Person {

    private String initial;
    private List<Task> tasks;

    public Person(String initial) {
        this.initial = initial;
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

    @Override
    public String toString() {
        return initial;
    }
}

class Task {

    private int startTime;
    private int endTime;

    public Task(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isOverlapping(int[] taskTime) {
        int otherStart = taskTime[0];
        int otherEnd = taskTime[1];

        return (otherStart < endTime && otherEnd > startTime);
    }
}