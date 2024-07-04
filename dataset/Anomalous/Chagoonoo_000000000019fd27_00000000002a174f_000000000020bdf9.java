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
            char[] out = new char[tasks.size()];
            String finalOut = null;

            OUTER:
            for (int j = 0; j < n; j++) {
                Task tmp = tasks.get(j);
                int res = assignTask(tmp);
                switch (res) {
                    case 1:
                        out[tmp.index] = 'C';
                        break;
                    case -1:
                        out[tmp.index] = 'J';
                        break;
                    default:
                        finalOut = "IMPOSSIBLE";
                        break OUTER;
                }
            }

            if (finalOut == null) {
                finalOut = String.valueOf(out);
            }

            if (i > 0) {
                System.out.println();
            }
            System.out.print("Case #" + (i + 1) + ": " + finalOut);
        }
        sc.close();
    }

    static int assignTask(Task tmp) {
        if (C == null) {
            C = tmp;
            return 1;
        } else if (tmp.e <= C.s || tmp.s >= C.e && C.addNext(tmp)) {
            return 1;
        } else if (J == null || tmp.e <= J.s || tmp.s >= J.e && J.addNext(tmp)) {
            if (J == null) {
                J = tmp;
            }
            return -1;
        } else {
            return 0;
        }
    }

    static class Task implements Comparable<Task> {
        int s, e, index;
        Task next;

        Task(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }

        boolean addNext(Task next) {
            if (next.s >= this.e && (this.next == null || next.e <= this.next.s)) {
                next.next = this.next;
                this.next = next;
                return true;
            } else if (this.next != null) {
                return this.next.addNext(next);
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(this.s, o.s);
        }
    }
}