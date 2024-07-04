package googlecodejam;

import java.util.*;

public class Solution {
    static final char DEFAULT_COLOR = 'x';
    static class Task {
        int start;
        int end;
        List<Task> neighbors;
        char color = DEFAULT_COLOR;

        public Task(int start, int end) {
            this.neighbors = new ArrayList<>();
            this.start = start;
            this.end = end;
        }

        public boolean isConnected(Task t) {
            Task earlier = null;
            Task later = null;
            if (this.start < t.start) {
                earlier = this;
                later = t;
            } else {
                earlier = t;
                later = this;
            }
            return earlier.end > later.start;
        }
    }

    public static boolean canTwoColor(Task root, Set<Task> unused) {
        Queue<Task> queue = new LinkedList<>();

        unused.remove(root);

        queue.add(root);
        root.color = 'J';

        while (!queue.isEmpty()) {
            Task curr = queue.poll();

            for(Task task: curr.neighbors) {
                if (task.color != DEFAULT_COLOR) {
                    if(task.color == curr.color) {
                        return false;
                    }
                } else {
                    task.color = curr.color == 'J' ? 'C' : 'J';
                    queue.add(task);
                    unused.remove(task);
                }
            }
        }

        return true;
    }
    public static boolean canTwoColor(List<Task> tasks) {
        Set<Task> unUsed = new HashSet<>();
        unUsed.addAll(tasks);

        while (!unUsed.isEmpty()) {
            Task root = unUsed.iterator().next();
            if (!canTwoColor(root, unUsed)) {
                return false;
            }
        }

        return true;

    }

    public static void constructRelationships(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            for (int j = 0; j < tasks.size(); j++) {
                if (i != j) {
                    if (tasks.get(i).isConnected(tasks.get(j))) {
                        tasks.get(i).neighbors.add(tasks.get(j));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cases; i++) {
            int N = Integer.parseInt(scan.nextLine());
            List<Task> tasks = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                int[] startEnd = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                tasks.add(new Task(startEnd[0], startEnd[1]));
            }

            constructRelationships(tasks);
            if (canTwoColor(tasks)) {
                StringBuilder distribution = new StringBuilder();
                for(Task task: tasks) distribution.append(task.color);
                System.out.printf("Case #%d: %s\n", (i + 1), distribution.toString());
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", (i + 1));
            }
        }
    }
}
