import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner scanner;

    private void run() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solve(i);
        }
    }

    private void solve(int testCaseNumber) {
        int numberOfTasks = scanner.nextInt();
        Task[] tasks = new Task[numberOfTasks];

        for (int i = 0; i < numberOfTasks; i++) {
            tasks[i] = new Task(scanner.nextInt(), scanner.nextInt());
        }

        tasks = assignTasks(tasks);

        System.out.print("Case #" + testCaseNumber + ": ");
        if (tasks != null) {
            for (Task task : tasks) {
                System.out.print(task.person);
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private Task[] assignTasks(Task[] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            if (canAssign(tasks, i, 'C')) {
                tasks[i].person = 'C';
            } else if (canAssign(tasks, i, 'J')) {
                tasks[i].person = 'J';
            } else {
                return null;
            }
        }
        return tasks;
    }

    private boolean canAssign(Task[] tasks, int taskIndex, char person) {
        Task currentTask = tasks[taskIndex];
        for (int i = 0; i < tasks.length; i++) {
            if (i == taskIndex) continue;
            Task otherTask = tasks[i];
            if (otherTask.person == person && tasksOverlap(currentTask, otherTask)) {
                return false;
            }
        }
        return true;
    }

    private boolean tasksOverlap(Task task1, Task task2) {
        return (task1.start < task2.end && task1.end > task2.start);
    }

    private static class Task {
        int start;
        int end;
        char person;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}