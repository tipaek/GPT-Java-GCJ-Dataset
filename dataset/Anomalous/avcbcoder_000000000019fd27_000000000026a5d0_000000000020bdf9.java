import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    public static void solve() throws Exception {
        int n = scanner.nextInt();
        Task[] tasks = new Task[n];
        
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            tasks[i] = new Task(start, end, i);
        }

        Arrays.sort(tasks);

        boolean possible = assignTasks(0, tasks, 0, 0);

        if (!possible) {
            System.out.println("IMPOSSIBLE");
        } else {
            char[] result = new char[n];
            for (Task task : tasks) {
                result[task.id] = task.assignedToC ? 'C' : 'J';
            }
            System.out.println(new String(result));
        }
    }

    private static boolean assignTasks(int index, Task[] tasks, int endTimeC, int endTimeJ) {
        if (index >= tasks.length) {
            return true;
        }

        Task currentTask = tasks[index];
        
        if (endTimeC <= currentTask.start) {
            boolean canAssignC = assignTasks(index + 1, tasks, currentTask.end, endTimeJ);
            if (canAssignC) {
                currentTask.assignedToC = true;
                return true;
            }
        }

        if (endTimeJ <= currentTask.start) {
            boolean canAssignJ = assignTasks(index + 1, tasks, endTimeC, currentTask.end);
            if (canAssignJ) {
                currentTask.assignedToC = false;
                return true;
            }
        }

        return false;
    }

    public static class Task implements Comparable<Task> {
        int start, end, id;
        boolean assignedToC = false;

        Task(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Task other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }

        @Override
        public String toString() {
            return "{" + start + " " + end + "}";
        }
    }

    private static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    private static final Scanner scanner = new Scanner(System.in);
}