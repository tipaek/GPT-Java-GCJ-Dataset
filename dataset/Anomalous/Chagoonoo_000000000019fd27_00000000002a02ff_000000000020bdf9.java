import java.util.*;

public class Solution {

    private static Task C = null;
    private static Task J = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            C = null;
            J = null;

            List<Task> tasks = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end, j));
            }
            Collections.sort(tasks);
            char[] result = new char[tasks.size()];
            String finalOutput = null;

            for (int j = 0; j < n; j++) {
                Task currentTask = tasks.get(j);
                int response = assignTaskToC(currentTask);
                if (response == 1) {
                    result[currentTask.getIndex()] = 'C';
                } else if (response == -1) {
                    result[currentTask.getIndex()] = 'J';
                } else {
                    finalOutput = "IMPOSSIBLE";
                    break;
                }
            }

            if (finalOutput == null) {
                if (J == null) {
                    result[result.length - 1] = 'J';
                }
                finalOutput = String.valueOf(result);
            }
            System.out.println("Case #" + (i + 1) + ": " + finalOutput);
        }
        scanner.close();
    }

    private static int assignTaskToC(Task task) {
        if (C == null) {
            C = task;
            return 1;
        } else if (task.getEnd() <= C.getStart()) {
            task.setNext(C);
            C = task;
            return 1;
        } else if (task.getStart() >= C.getEnd()) {
            if (C.addNextTask(task)) {
                return 1;
            } else if (J != null && J.addNextTask(task)) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return assignTaskToJ(task) ? -1 : 0;
        }
    }

    private static boolean assignTaskToJ(Task task) {
        if (J == null) {
            J = task;
            return true;
        } else if (task.getEnd() <= J.getStart()) {
            task.setNext(J);
            J = task;
            return true;
        } else if (task.getStart() >= J.getEnd()) {
            return J.addNextTask(task);
        } else {
            return false;
        }
    }
}

class Task implements Comparable<Task> {

    private final int start;
    private final int end;
    private final int index;
    private Task next;

    public Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getIndex() {
        return index;
    }

    public void setNext(Task next) {
        this.next = next;
    }

    public boolean addNextTask(Task nextTask) {
        if (nextTask.getStart() >= this.end && (this.next == null || nextTask.getEnd() <= this.next.getStart())) {
            nextTask.setNext(this.next);
            this.next = nextTask;
            return true;
        }
        return this.next != null && this.next.addNextTask(nextTask);
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}