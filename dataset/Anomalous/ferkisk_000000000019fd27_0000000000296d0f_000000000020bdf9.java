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
            processTestCase(i);
        }
    }

    private void processTestCase(int testCaseNumber) {
        int taskCount = scanner.nextInt();
        Task[] tasks = new Task[taskCount];

        for (int i = 0; i < taskCount; i++) {
            tasks[i] = new Task(scanner.nextInt(), scanner.nextInt());
        }

        boolean isPossible = assignTasks(tasks);

        System.out.print("Case #" + testCaseNumber + ": ");
        if (isPossible) {
            for (Task task : tasks) {
                System.out.print(task.assignedPerson);
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private boolean assignTasks(Task[] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            if (!assignTask(tasks, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean assignTask(Task[] tasks, int index) {
        if (isAssignable(tasks, index, 'C')) {
            tasks[index].assignedPerson = 'C';
            return true;
        } else if (isAssignable(tasks, index, 'J')) {
            tasks[index].assignedPerson = 'J';
            return true;
        }
        return false;
    }

    private boolean isAssignable(Task[] tasks, int index, char person) {
        Task currentTask = tasks[index];
        for (int i = 0; i < tasks.length; i++) {
            if (i != index && tasks[i].assignedPerson == person && tasksOverlap(currentTask, tasks[i])) {
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
        char assignedPerson;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}