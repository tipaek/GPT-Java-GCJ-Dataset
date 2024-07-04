import java.util.*;

public class Solution {

    static Task C = null;
    static Task J = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            C = null;
            J = null;

            List<Task> tasks = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                tasks.add(new Task(s, e, j));
            }
            Collections.sort(tasks);
            char[] out = new char[n];
            String finalOut = null;

            for (Task task : tasks) {
                int res = addToC(task);
                if (res == 1) {
                    out(task.index) = 'C';
                } else if (res == -1) {
                    out(task.index) = 'J';
                } else {
                    finalOut = "IMPOSSIBLE";
                    break;
                }
            }

            if (finalOut == null) {
                finalOut = String.valueOf(out);
            }
            if (i > 0) {
                System.out.println("");
            }
            System.out.print("Case #" + (i + 1) + ": " + finalOut);
        }
    }

    static int addToC(Task task) {
        if (C == null) {
            C = task;
            return 1;
        } else if (task.e <= C.s) {
            task.next = C;
            C = task;
            return 1;
        } else if (task.s >= C.e) {
            if (C.addNext(task)) {
                return 1;
            } else if (J.addNext(task)) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return addToJ(task) ? -1 : 0;
        }
    }

    static boolean addToJ(Task task) {
        if (J == null) {
            J = task;
            return true;
        } else if (task.e <= J.s) {
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

    int s, e, index;
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