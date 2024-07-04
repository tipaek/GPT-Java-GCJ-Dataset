import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Problem[] problems = readProblems();
        for (Problem p : problems) p.solve();
        printResults(problems);
    }

    static Problem[] readProblems() {
        Scanner scan = new Scanner(System.in);
        Problem[] problems = new Problem[scan.nextInt()];
        for (int i = 0; i < problems.length; i++) {
            Problem.Task[] tasks = new Problem.Task[scan.nextInt()];
            for (int j = 0; j < tasks.length; j++) tasks[j] = new Problem.Task(scan.nextInt(), scan.nextInt());
            problems[i] = new Problem(tasks);
        }
        return problems;
    }

    static void printResults(Problem[] problems) {
        for (int i = 0; i < problems.length; i++) {
            Problem p = problems[i];
            System.out.println(String.format("Case #%d: %s", i + 1, p.result()));
        }
    }

    static class Problem {
        Task[] tasks;

        boolean conflict;
        int[] assignment;

        static class Task {
            int start, end;

            int index;
            List<Task> intersections;

            Task(int start, int end) {
                this.start = start;
                this.end = end;
                intersections = new ArrayList<>();
            }

            boolean intersects(Task that) {
                return !(this.start >= that.end || this.end <= that.start);
            }
        }

        Problem(Task[] tasks) {
            this.tasks = tasks;
            this.assignment = new int[tasks.length];
        }

        private boolean assign(int i, int a) {
            int compare = assignment[i] * a;
            if (compare < 0) return false;
            if (compare > 0) return true;
            assignment[i] = a;
            return propagate(i);
        }

        private boolean propagate(int i) {
            for (Task task : tasks[i].intersections) if (!assign(task.index, -assignment[i])) return false;
            return true;
        }

        void solve() {
            for (int i = 0; i < tasks.length; i++) {
                tasks[i].index = i;
                for (int j = i + 1; j < tasks.length; j++) {
                    if (tasks[i].intersects(tasks[j])) {
                        tasks[i].intersections.add(tasks[j]);
                        tasks[j].intersections.add(tasks[i]);
                    }
                }
            }
            int i = 0;
            while (!conflict && i < tasks.length) {
                if (assignment[i] == 0) conflict = !assign(i, 1);
                i++;
            }
        }

        String result() {
            if (conflict) return "IMPOSSIBLE";
            StringBuilder builder = new StringBuilder();
            for (int value : assignment) {
                if (value > 0) builder.append('C');
                else builder.append('J');
            }
            return builder.toString();
        }
    }
}
