import java.util.*;

public class Solution {

    private static Task C = null;
    private static Task J = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int taskCount = scanner.nextInt();
            C = null;
            J = null;
            
            List<Task> tasks = new ArrayList<>();
            for (int j = 0; j < taskCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end, j));
            }
            
            Collections.sort(tasks);
            char[] schedule = new char[tasks.size()];
            String result = null;
            
            for (Task task : tasks) {
                int assignment = assignTask(task);
                if (assignment == 1) {
                    schedule(task.index) = 'C';
                } else if (assignment == -1) {
                    schedule(task.index) = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            
            if (result == null) {
                result = new String(schedule);
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int assignTask(Task task) {
        if (C == null) {
            C = task;
            return 1;
        }
        
        if (task.e <= C.s) {
            task.next = C;
            C = task;
            return 1;
        } else if (task.s >= C.e) {
            if (C.addNext(task)) {
                return 1;
            } else if (J != null && J.addNext(task)) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return addToJ(task) ? -1 : 0;
        }
    }

    private static boolean addToJ(Task task) {
        if (J == null) {
            J = task;
            return true;
        }
        
        if (task.e <= J.s) {
            task.next = J;
            J = task;
            return true;
        } else if (task.s >= J.e) {
            return J.addNext(task);
        } else {
            return false;
        }
    }
}

class Task implements Comparable<Task> {
    int s;
    int e;
    int index;
    Task next;

    public Task(int s, int e, int index) {
        this.s = s;
        this.e = e;
        this.index = index;
    }

    public boolean addNext(Task next) {
        if (next.s >= this.e && (this.next == null || next.e <= this.next.s)) {
            next.next = this.next;
            this.next = next;
            return true;
        }
        
        return this.next != null && this.next.addNext(next);
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.s, other.s);
    }
}