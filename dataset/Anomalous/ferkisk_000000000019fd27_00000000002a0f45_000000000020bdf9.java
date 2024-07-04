import java.util.*;

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
        int taskCount = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < taskCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            tasks.add(new Task(start, end, 'C', i));
        }

        List<List<Task>> allTaskCombinations = new ArrayList<>();
        generateTaskCombinations(allTaskCombinations, tasks, 0);

        List<Task> validCombination = null;
        for (List<Task> taskCombination : allTaskCombinations) {
            if (isValidCombination(taskCombination)) {
                validCombination = taskCombination;
                break;
            }
        }

        System.out.print("Case #" + testCaseNumber + ": ");
        if (validCombination != null) {
            validCombination.stream().sorted(Comparator.comparingInt(task -> task.index))
                    .forEach(task -> System.out.print(task.person));
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private void generateTaskCombinations(List<List<Task>> allTaskCombinations, List<Task> currentTasks, int index) {
        if (index == currentTasks.size()) {
            allTaskCombinations.add(new ArrayList<>(currentTasks));
            return;
        }

        Task currentTask = currentTasks.get(index);
        Task taskWithC = new Task(currentTask.start, currentTask.end, 'C', currentTask.index);
        Task taskWithJ = new Task(currentTask.start, currentTask.end, 'J', currentTask.index);

        currentTasks.set(index, taskWithC);
        generateTaskCombinations(allTaskCombinations, currentTasks, index + 1);

        currentTasks.set(index, taskWithJ);
        generateTaskCombinations(allTaskCombinations, currentTasks, index + 1);
    }

    private boolean isValidCombination(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            for (int j = i + 1; j < tasks.size(); j++) {
                Task task1 = tasks.get(i);
                Task task2 = tasks.get(j);

                if (task1.person == task2.person && tasksOverlap(task1, task2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean tasksOverlap(Task task1, Task task2) {
        return task1.start < task2.end && task2.start < task1.end;
    }

    static class Task {
        int start;
        int end;
        char person;
        int index;

        Task(int start, int end, char person, int index) {
            this.start = start;
            this.end = end;
            this.person = person;
            this.index = index;
        }
    }
}