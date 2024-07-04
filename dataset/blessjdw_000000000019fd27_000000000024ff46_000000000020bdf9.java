import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Task {
        int s, e, n;
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
                Task a = tasks[i];
                Task b = tasks[i+1];
                Task c = tasks[i+2];
                int maxStart = Math.max(Math.max(a.s, b.s), c.s);
                int minEnd = Math.min(Math.min(a.e, b.e), c.e);
                if (maxStart < minEnd) {
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            if (sb.length() == 0) {
                Set<Integer> taskC = new HashSet<>();
                for (int i = 0; i < tasks.length; i++) {
                    if (i % 2 == 0) {
                        taskC.add(tasks[i].n);
                    }
                }
                for (int n = 1; n <= N; n++) {
                    if (taskC.contains(n)) {
                        sb.append("C");
                    } else {
                        sb.append("J");
                    }
                }
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}

