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
                Task tmp = new Task(s, e);

                int res = addToC(tmp);
                if (res == 1) {
                    out.append("C");
                } else if (res == -1) {
                    out.append("J");
                } else {
                    out = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + out.toString());
        }
    }

    static int addToC(Task tmp) {
        if (C == null) {
            C = tmp;
            return 1;
        } else if (tmp.e <= C.s) {
            tmp.next = C;
            C = tmp;
            return 1;
        } else if (tmp.s >= C.e) {
            if (C.addNext(tmp)) {
                return 1;
            } else if (J == null || J.addNext(tmp)) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return addToJ(tmp) ? -1 : 0;
        }
    }

    static boolean addToJ(Task tmp) {
        if (J == null) {
            J = tmp;
            return true;
        } else if (tmp.e <= J.s) {
            tmp.next = J;
            J = tmp;
            return true;
        } else if (tmp.s >= J.e) {
            return J.addNext(tmp);
        } else {
            return false;
        }
    }

    static String printChain(Task start) {
        StringBuilder out = new StringBuilder();
        while (start != null) {
            out.append(start.s).append(" ").append(start.e).append(" ");
            start = start.next;
        }
        return out.toString();
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

    public boolean addNext(Task next) {
        if (next.s >= this.e && (this.next == null || next.e <= this.next.s)) {
            next.next = this.next;
            this.next = next;
            return true;
        }
        return this.next != null && this.next.addNext(next);
    }
}