import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            List<Pair> tasks = read(sc, n);
            tasks.sort((p1, p2) -> {
                int res = Integer.compare(p1.s, p2.s);
                if (res != 0) {
                    return res;
                }
                res = Integer.compare(p1.e, p2.e);
                if (res != 0) {
                    return res;
                }
                return Integer.compare(p1.ind, p2.ind);
            });
            int ca = -1;
            int ja = -1;
            boolean impossible = false;
            for (int j = 0; j < n; j++) {
                Pair task = tasks.get(j);
                if (ca <= task.s) {
                    task.who = 'C';
                    ca = task.e;
                } else if (ja <= task.s) {
                    task.who = 'J';
                    ja = task.e;
                } else {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                print(i, "IMPOSSIBLE");
            } else {
                tasks.sort((t1, t2) -> Integer.compare(t1.ind, t2.ind));
                StringBuilder s = new StringBuilder(n);
                for (int j = 0; j < n; j++) {
                    s.append(tasks.get(j).who);
                }
                print(i, s.toString());
            }
        }
        sc.close();
    }

    private static List<Pair> read(Scanner sc, int n) {
        List<Pair> tasks = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            tasks.add(new Pair(s, e, i));
        }
        return tasks;
    }

    private static void print(int caseNum, String s) {
        System.out.println("Case #" + caseNum + ": " + s);
    }

    private static class Pair {
        public final int s;
        public final int e;
        public final int ind;
        public char who;

        public Pair(int s, int e, int ind) {
            this.s = s;
            this.e = e;
            this.ind = ind;
        }

    }
}
