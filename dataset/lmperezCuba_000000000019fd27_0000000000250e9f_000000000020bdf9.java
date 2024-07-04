import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author lmperez
 */
public class Solution {

    static class Pair implements Comparable<Pair> {

        int s, e , index;

        public Pair(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            if (s < o.s) {
                return -1;
            }
            if (s > o.s) {
                return 1;
            }
            if (e <= o.e) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), S, E;
        for (int i = 0; i < T; i++) {
            int N;
            N = sc.nextInt();
            Pair[] tasks = new Pair[N];
            for (int j = 0; j < N; j++) {
                S = sc.nextInt();
                E = sc.nextInt();
                tasks[j] = new Pair(S, E, j);
            }
            System.out.printf("Case #%d: %s\n", (i + 1), play(tasks));
        }
    }

    public static String play(Pair[] tasks) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(tasks);
        int C = 0, J = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].s >= C && tasks[i].s >= J) {
                if (C <= J) {
                    C = tasks[i].e;
                    sb.append("C");
                } else {
                    J = tasks[i].e;
                    sb.append("J");
                }
            } else if (tasks[i].s >= C) {
                C = tasks[i].e;
                sb.append("C");
            } else if (tasks[i].s >= J) {
                J = tasks[i].e;
                sb.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return printUnordered(tasks, sb.toString());
    }
    
    public static String printUnordered(Pair[] tasks, String s) {
        char [] sol = new char[s.length()];
        for (int i = 0; i < tasks.length; i++) {
            Pair task = tasks[i];
            sol[task.index] = s.charAt(i);
        }
        return new String(sol);
    }

}
