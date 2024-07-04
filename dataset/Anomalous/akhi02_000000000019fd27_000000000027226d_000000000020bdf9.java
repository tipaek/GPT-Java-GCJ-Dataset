import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                tasks.add(new Task(start, end, i));
            }

            // Sort tasks by start time
            tasks.sort(Comparator.comparingInt(task -> task.start));

            List<Task> C = new ArrayList<>();
            List<Task> J = new ArrayList<>();
            char[] assignment = new char[N];
            boolean possible = true;

            // Assign the first two tasks to C and J
            C.add(tasks.get(0));
            assignment[tasks.get(0).index] = 'C';
            J.add(tasks.get(1));
            assignment[tasks.get(1).index] = 'J';

            // Assign remaining tasks
            for (int i = 2; i < tasks.size(); i++) {
                Task currentTask = tasks.get(i);

                if (currentTask.start >= C.get(C.size() - 1).end) {
                    C.add(currentTask);
                    assignment[currentTask.index] = 'C';
                } else if (currentTask.start >= J.get(J.size() - 1).end) {
                    J.add(currentTask);
                    assignment[currentTask.index] = 'J';
                } else {
                    System.out.println("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println(new String(assignment));
            }
        }
    }

    static class Task {
        int start, end, index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}