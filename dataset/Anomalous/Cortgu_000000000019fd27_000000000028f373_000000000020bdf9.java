import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int N;
    private static boolean[][] overlapGraph;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt(); // Number of cases
            for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
                N = scanner.nextInt();
                Task[] tasks = new Task[N];
                overlapGraph = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    tasks[i] = new Task(i, start, end);
                    for (int j = 0; j < i; j++) {
                        if (tasks[j].overlaps(tasks[i])) {
                            overlapGraph[i][j] = true;
                            overlapGraph[j][i] = true;
                        }
                    }
                }

                String result = solveCase(tasks);
                System.out.println("Case #" + caseNo + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String solveCase(Task[] tasks) {
        if (hasCycleOfLength3()) {
            return "IMPOSSIBLE";
        } else {
            List<Task> taskList = Arrays.asList(tasks);
            Collections.sort(taskList);

            Parent[] assignments = new Parent[N];
            Parent currentParent = Parent.C;
            Task previousTask = null;
            for (Task task : taskList) {
                if (previousTask == null) {
                    assignments[task.id] = currentParent;
                } else {
                    if (overlapGraph[previousTask.id][task.id]) {
                        currentParent = (currentParent == Parent.C) ? Parent.J : Parent.C;
                    }
                    assignments[task.id] = currentParent;
                }
                previousTask = task;
            }

            StringBuilder resultBuilder = new StringBuilder();
            for (Parent assignment : assignments) {
                resultBuilder.append(assignment);
            }
            return resultBuilder.toString();
        }
    }

    private static boolean hasCycleOfLength3() {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 2; i++) {
            if (findCycleOfLength3(visited, 2, i, i)) {
                return true;
            }
            visited[i] = true;
        }
        return false;
    }

    private static boolean findCycleOfLength3(boolean[] visited, int length, int currentTask, int initialTask) {
        visited[currentTask] = true;

        if (length == 0) {
            visited[currentTask] = false;
            return overlapGraph[currentTask][initialTask];
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && overlapGraph[currentTask][i]) {
                if (findCycleOfLength3(visited, length - 1, i, initialTask)) {
                    return true;
                }
            }
        }
        visited[currentTask] = false;
        return false;
    }

    private enum Parent {
        J, C;
    }

    private static class Task implements Comparable<Task> {
        private final int id;
        private final int start;
        private final int end;

        public Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Task other) {
            return (other.start < this.end && other.end > this.start);
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }
}