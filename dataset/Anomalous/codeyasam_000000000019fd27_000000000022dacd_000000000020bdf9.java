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
        StringBuilder result = new StringBuilder("C");
        int[] firstActivity = activitiesTime.get(0);
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(new Task(firstActivity[0], firstActivity[1]));
        
        for (int i = 1; i < activitiesTime.size(); i++) {
            int[] currentActivity = activitiesTime.get(i);
            int[] previousActivity = activitiesTime.get(i - 1);
            String assignment = "C";
            if (currentActivity[0] == previousActivity[1]) {
                assignment = result.substring(result.length() - 1);
            } else if (cameron.isOverlapping(currentActivity) && jamie.isOverlapping(currentActivity)) {
                return "IMPOSSIBLE";
            } else if (cameron.isOverlapping(currentActivity)) {
                assignment = "J";
            } else if (jamie.isOverlapping(currentActivity)) {
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

    private String name;
    private List<Task> tasks;

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

    @Override
    public String toString() {
        return name;
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

        return (otherStart < endTime && otherEnd > endTime) ||
               (otherStart > startTime && otherEnd < endTime) ||
               (otherStart < startTime && otherEnd > startTime);
    }
}