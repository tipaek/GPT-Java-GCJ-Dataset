import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            int taskCount = Integer.parseInt(scanner.nextLine());
            results[i] = "Case #" + (i + 1) + ": " + scheduleTasks(scanner, taskCount);
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    private static String scheduleTasks(Scanner scanner, int taskCount) {
        List<Task> tasks = new ArrayList<>();
        
        for (int i = 0; i < taskCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
            int startTime = Integer.parseInt(tokenizer.nextToken());
            int endTime = Integer.parseInt(tokenizer.nextToken());
            tasks.add(new Task(startTime, endTime));
        }

        List<Task> originalTasks = new ArrayList<>(tasks);
        Collections.sort(tasks);

        if (!assignTasks(tasks)) {
            return "IMPOSSIBLE";
        }

        StringBuilder schedule = new StringBuilder();
        for (Task task : originalTasks) {
            schedule.append(task.getTaskOwner());
        }

        return schedule.toString();
    }

    private static boolean assignTasks(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            if (!assignTaskOwner(tasks, i, 'C') && !assignTaskOwner(tasks, i, 'J')) {
                return false;
            }
        }
        return true;
    }

    private static boolean assignTaskOwner(List<Task> tasks, int currentIndex, char owner) {
        Task currentTask = tasks.get(currentIndex);
        for (int j = 0; j < currentIndex; j++) {
            Task previousTask = tasks.get(j);
            if (previousTask.getTaskOwner() == owner && currentTask.overlapsWith(previousTask)) {
                return false;
            }
        }
        currentTask.setTaskOwner(owner);
        return true;
    }
}

class Task implements Comparable<Task> {
    private final int startTime;
    private final int endTime;
    private char taskOwner;

    Task(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskOwner = ' ';
    }

    int getStartTime() {
        return startTime;
    }

    int getEndTime() {
        return endTime;
    }

    char getTaskOwner() {
        return taskOwner;
    }

    void setTaskOwner(char taskOwner) {
        this.taskOwner = taskOwner;
    }

    boolean overlapsWith(Task other) {
        return (this.startTime < other.endTime && this.endTime > other.startTime);
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}