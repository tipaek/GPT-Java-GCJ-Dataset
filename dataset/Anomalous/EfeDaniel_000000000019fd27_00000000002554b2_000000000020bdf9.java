import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int taskCount = scanner.nextInt();
            Task[] tasks = new Task[taskCount];
            for (int i = 0; i < taskCount; i++) {
                tasks[i] = new Task(i, scanner.nextInt(), scanner.nextInt());
            }
            System.out.println(String.format("Case #%d: %s", caseNumber, findSchedule(taskCount, tasks)));
        }
    }

    private static String findSchedule(int taskCount, Task[] tasks) {
        Task.sortByStartTime(tasks);
        int endTimeC = -1, endTimeJ = -1;
        StringBuilder result = new StringBuilder();

        for (Task task : tasks) {
            endTimeC = updateEndTime(endTimeC, task);
            endTimeJ = updateEndTime(endTimeJ, task);

            if (endTimeC < 0) {
                endTimeC = task.endTime;
                task.assignedTo = "C";
            } else if (endTimeJ < 0) {
                endTimeJ = task.endTime;
                task.assignedTo = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        Task.sortById(tasks);
        for (Task task : tasks) {
            result.append(task.assignedTo);
        }

        return result.toString();
    }

    private static int updateEndTime(int personEndTime, Task task) {
        return personEndTime <= task.startTime ? -1 : personEndTime;
    }
}

class Task {
    int id;
    int startTime;
    int endTime;
    String assignedTo;

    Task(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    static void sortByStartTime(Task[] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt((Task task) -> task.startTime)
                                     .thenComparingInt(task -> task.endTime));
    }

    static void sortById(Task[] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(task -> task.id));
    }
}