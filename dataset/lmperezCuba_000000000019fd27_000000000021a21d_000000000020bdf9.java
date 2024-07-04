import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author lmperez
 */
public class Solution {

    static class Pair implements Comparable<Pair> {

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;

        @Override
        public int compareTo(Pair o) {
            if (x < o.x) {
                return -1;
            }
            if (x > o.x) {
                return 1;
            }
            if (y <= o.y) {
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
                tasks[j] = new Pair(S, E);
            }
            System.out.printf("Case #%d: %s\n", (i + 1), play(tasks));
        }
    }

    public static String play(Pair[] tasks) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(tasks);
        int C = 0, J = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].x >= C && tasks[i].x >= J) {
                if (C <= J) {
                    C = tasks[i].y;
                    sb.append("C");
                } else {
                    J = tasks[i].y;
                    sb.append("J");
                }
            } else if (tasks[i].x >= C) {
                C = tasks[i].y;
                sb.append("C");
            } else if (tasks[i].x >= J) {
                J = tasks[i].y;
                sb.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }

}
