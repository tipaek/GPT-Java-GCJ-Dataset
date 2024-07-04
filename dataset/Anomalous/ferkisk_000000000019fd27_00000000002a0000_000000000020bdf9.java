import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner scanner;

    public void run() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i);
        }
    }

    private void processTestCase(int testCaseNumber) {
        int taskCount = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < taskCount; i++) {
            Task task = new Task(scanner.nextInt(), scanner.nextInt(), 'C', i);
            tasks.add(task);
        }

        List<List<Task>> allPossibleTasks = new ArrayList<>();
        generateAllTaskCombinations(allPossibleTasks, tasks, 0);

        List<Task> validTaskCombination = findValidTaskCombination(allPossibleTasks);

        System.out.print("Case #" + testCaseNumber + ": ");
        if (validTaskCombination != null) {
            for (Task task : validTaskCombination) {
                System.out.print(task.person);
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private void generateAllTaskCombinations(List<List<Task>> allTasks, List<Task> currentTasks, int index) {
        if (index >= currentTasks.size()) {
            return;
        }

        List<Task> tasksWithC = cloneTaskListWithPerson(currentTasks, index, 'C');
        List<Task> tasksWithJ = cloneTaskListWithPerson(currentTasks, index, 'J');

        allTasks.add(tasksWithC);
        allTasks.add(tasksWithJ);

        generateAllTaskCombinations(allTasks, tasksWithC, index + 1);
        generateAllTaskCombinations(allTasks, tasksWithJ, index + 1);
    }

    private List<Task> cloneTaskListWithPerson(List<Task> tasks, int index, char person) {
        List<Task> clonedTasks = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            Task clonedTask = tasks.get(i).clone();
            if (i == index) {
                clonedTask.person = person;
            }
            clonedTasks.add(clonedTask);
        }
        return clonedTasks;
    }

    private List<Task> findValidTaskCombination(List<List<Task>> allTaskCombinations) {
        for (List<Task> taskCombination : allTaskCombinations) {
            if (isValidTaskCombination(taskCombination)) {
                return taskCombination;
            }
        }
        return null;
    }

    private boolean isValidTaskCombination(List<Task> tasks) {
        for (Task task : tasks) {
            if (!isTaskAssignmentValid(tasks, task)) {
                return false;
            }
        }
        return true;
    }

    private boolean isTaskAssignmentValid(List<Task> tasks, Task currentTask) {
        for (Task task : tasks) {
            if (task.idx != currentTask.idx && task.person == currentTask.person && isOverlapping(task, currentTask)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOverlapping(Task task1, Task task2) {
        return task1.start < task2.end && task2.start < task1.end;
    }

    class Task {
        int start;
        int end;
        char person;
        int idx;

        Task(int start, int end, char person, int idx) {
            this.start = start;
            this.end = end;
            this.person = person;
            this.idx = idx;
        }

        @Override
        public Task clone() {
            return new Task(start, end, person, idx);
        }
    }
}