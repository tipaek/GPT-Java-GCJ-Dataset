import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        int caseNumber = 1;

        while (in.hasNextLine()) {
            boolean feasible = true;
            List<Task> herTasks = new ArrayList<>();
            List<Task> hisTasks = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int N = in.nextInt();
            in.nextLine();

            while (N > 0) {
                String currentTask = in.nextLine();
                Scanner taskScanner = new Scanner(currentTask);
                Task task = new Task(taskScanner.nextInt(), taskScanner.nextInt());
                N--;

                boolean assigned = false;
                boolean fits = true;

                for (Task t : herTasks) {
                    if (task.conflicts(t)) {
                        fits = false;
                        break;
                    }
                }

                if (fits) {
                    herTasks.add(task);
                    assigned = true;
                    sb.append("C");
                } else {
                    fits = true;
                    for (Task t : hisTasks) {
                        if (task.conflicts(t)) {
                            fits = false;
                            break;
                        }
                    }

                    if (fits) {
                        hisTasks.add(task);
                        assigned = true;
                        sb.append("J");
                    }
                }

                if (!assigned) {
                    feasible = false;
                }
            }

            if (!feasible) {
                System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber++ + ": " + sb);
            }

            herTasks.clear();
            hisTasks.clear();
        }
    }

    public static class Task {
        int start;
        int end;

        public Task(int s, int e) {
            start = s;
            end = e;
        }

        public boolean conflicts(Task b) {
            return (this.start < b.start && this.end > b.start) ||
                   (this.start < b.end && this.end > b.start) ||
                   (this.start <= b.start && this.end >= b.end) ||
                   (this.start >= b.start && this.end <= b.end);
        }

        @Override
        public String toString() {
            return "Start: " + start + " End: " + end;
        }
    }
}