import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Task {
        int s, e, n;
        boolean check;
        public Task(int s, int e, int n) {
            this.s = s;
            this.e = e;
            this.n = n;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            Task[] tasks = new Task[N];
            for (int n = 1; n <= N; n++) {
                int s = in.nextInt();
                int e = in.nextInt();
                tasks[n-1] = new Task(s, e, n);
            }
            Arrays.sort(tasks, (a, b) -> {
                if (a.s == b.s) return a.e < b.e ? -1 : 1;
                return a.s < b.s ? -1 : 1;
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tasks.length-2; i++) {
                if (tasks[i+2].s < Math.min(tasks[i].e, tasks[i+1].e)) {
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            if (sb.length() == 0) {
                Task p = tasks[0];
                p.check = true;
                for (int i = 1; i < tasks.length; i++) {
                    if (tasks[i].s < p.e) {
                        continue;
                    }
                    p = tasks[i];
                    p.check = true;
                }
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < tasks.length; i++) {
                    if (tasks[i].check) {
                        set.add(tasks[i].n);
                    }
                }
                for (int n = 1; n <= N; n++) {
                    if (set.contains(n))
                        sb.append("C");
                    else
                        sb.append("J");
                }
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}

