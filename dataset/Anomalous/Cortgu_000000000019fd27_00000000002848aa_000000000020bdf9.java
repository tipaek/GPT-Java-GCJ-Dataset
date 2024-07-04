import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static int N;
    private static boolean[][] overlapGraph;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = in.nextInt(); // Number of cases
            for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
                N = in.nextInt();
                Task[] tasks = new Task[N];
                overlapGraph = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    int S = in.nextInt();
                    int E = in.nextInt();
                    Task task = new Task(S, E);
                    tasks[i] = task;
                    for (int j = 0; j < i; j++) {
                        if (tasks[j].overlaps(task)) {
                            overlapGraph[i][j] = true;
                            overlapGraph[j][i] = true;
                        }
                    }
                }

                // Solve Case
                String result = "";
                if (containsCycleOfLen3()) {
                    result = "IMPOSSIBLE";
                } else {
                    Map<Parent, Set<Integer>> tasksByParent = new HashMap<>();
                    tasksByParent.put(Parent.C, new HashSet<>());
                    tasksByParent.put(Parent.J, new HashSet<>());

                    Parent currentParent = Parent.C;
                    tasksByParent.get(currentParent).add(0);
                    result += currentParent;
                    for (int i = 1; i < N; i++) {
                        boolean overlapsAnyOfCurrentParent = false;
                        for (int task : tasksByParent.get(currentParent)) {
                            if (overlapGraph[i][task]) {
                                overlapsAnyOfCurrentParent = true;
                                break;
                            }
                        }
                        if (overlapsAnyOfCurrentParent) {
                            currentParent = (currentParent == Parent.C) ? Parent.J : Parent.C;
                        }
                        tasksByParent.get(currentParent).add(i);
                        result += currentParent;
                    }
                }
                System.out.println("Case #" + caseNo + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static boolean containsCycleOfLen3() {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 2; i++) {
            if (dfsCycleCheck(visited, 2, i, i)) {
                return true;
            }
            visited[i] = true;
        }
        return false;
    }

    private static boolean dfsCycleCheck(boolean[] visited, int length, int task, int initial) {
        visited[task] = true;

        if (length == 0) {
            visited[task] = false;
            return overlapGraph[task][initial];
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && overlapGraph[task][i] && dfsCycleCheck(visited, length - 1, i, initial)) {
                return true;
            }
        }
        visited[task] = false;
        return false;
    }

    private enum Parent {
        J, C
    }

    private static class Task {
        private int start;
        private int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Task other) {
            return (other.start <= this.start && other.end > this.start) ||
                   (other.start < this.end && other.end >= this.end) ||
                   (other.start >= this.start && other.end <= this.end) ||
                   (other.start <= this.start && other.end >= this.end);
        }
    }
}