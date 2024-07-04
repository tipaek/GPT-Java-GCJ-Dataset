import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner in;

    private void run() {
        in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            solve(i);
        }
    }

    private void solve(int test) {
        int N = in.nextInt();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Task t = new Task(in.nextInt(), in.nextInt(), 'C', i);
            tasks.add(t);
        }

        List<List<Task>> allTasks = new ArrayList<>();
        generateOptions(allTasks, tasks, 0);

        List<Task> validResult = null;
        for (List<Task> taskList : allTasks) {
            if (isValid(taskList)) {
                validResult = taskList;
                break;
            }
        }

        System.out.print("Case #" + test + ": ");
        if (validResult != null) {
            validResult.forEach(task -> System.out.print(task.person));
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private void generateOptions(List<List<Task>> allTasks, List<Task> current, int idx) {
        if (idx == current.size()) {
            allTasks.add(new ArrayList<>(current));
            return;
        }

        Task originalTask = current.get(idx);
        Task taskC = originalTask.clone();
        taskC.person = 'C';
        Task taskJ = originalTask.clone();
        taskJ.person = 'J';

        current.set(idx, taskC);
        if (isValidPartial(current, idx)) {
            generateOptions(allTasks, current, idx + 1);
        }

        current.set(idx, taskJ);
        if (isValidPartial(current, idx)) {
            generateOptions(allTasks, current, idx + 1);
        }

        current.set(idx, originalTask);
    }

    private boolean isValid(List<Task> tasks) {
        for (Task task : tasks) {
            if (!isValidPartial(tasks, tasks.indexOf(task))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPartial(List<Task> tasks, int idx) {
        Task task = tasks.get(idx);
        for (int i = 0; i < tasks.size(); i++) {
            if (i == idx) continue;
            Task other = tasks.get(i);
            if (other.person == task.person && tasksOverlap(task, other)) {
                return false;
            }
        }
        return true;
    }

    private boolean tasksOverlap(Task t1, Task t2) {
        return t1.start < t2.end && t1.end > t2.start;
    }

    private static class Task {
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

        Task clone() {
            return new Task(start, end, person, idx);
        }

        @Override
        public String toString() {
            return String.valueOf(person);
        }
    }
}