import java.util.Scanner;

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
            StringBuilder out = new StringBuilder();
            boolean possible = true;

            for (int j = 0; j < n; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                Task task = new Task(s, e);

                int result = assignTask(task);
                if (result == 1) {
                    out.append("C");
                } else if (result == -1) {
                    out.append("J");
                } else {
                    out = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + out);
        }
    }

    static int assignTask(Task task) {
        if (canAssignToC(task)) {
            return 1;
        } else if (canAssignToJ(task)) {
            return -1;
        } else {
            return 0;
        }
    }

    static boolean canAssignToC(Task task) {
        if (C == null) {
            C = task;
            return true;
        } else if (task.e <= C.s) {
            task.next = C;
            C = task;
            return true;
        } else if (task.s >= C.e) {
            return C.addNext(task);
        } else {
            return false;
        }
    }

    static boolean canAssignToJ(Task task) {
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

class Task {
    int s;
    int e;
    Task next;

    public Task(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public boolean addNext(Task nextTask) {
        if (nextTask.s >= this.e && (this.next == null || this.next.s >= nextTask.e)) {
            nextTask.next = this.next;
            this.next = nextTask;
            return true;
        } else if (this.next != null) {
            return this.next.addNext(nextTask);
        }
        return false;
    }
}