import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = scheduleTasks(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String scheduleTasks(Scanner input) {
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        char[] result;
        int n = input.nextInt();
        int[][] tasks = new int[n][2];
        result = new char[n];

        for (int i = 0; i < n; i++) {
            tasks[i][0] = input.nextInt();
            tasks[i][1] = input.nextInt();
        }

        tasks = sortTasks(tasks);

        if (tasks == null) {
            return "IMPOSSIBLE";
        }

        int ct = 0, jt = 0;
        for (int i = 0; i < n; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];

            if (!c[start] && (j[start] || ct - start <= jt - start)) {
                ct = end;
                fill(c, start, end);
                result[i] = 'C';
            } else if (!j[start]) {
                jt = end;
                fill(j, start, end);
                result[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return rearrangeResult(result);
    }

    static boolean[] flag;
    static boolean[] shadow;
    static boolean[] ss;
    static int[] n;
    static int[] ns;
    static int[] nss;
    static int[][] h;

    public static String rearrangeResult(char[] t) {
        char[] rearranged = new char[t.length];
        for (int[] p : h) {
            rearranged[p[0]] = t[p[1]];
        }
        return new String(rearranged);
    }

    public static int[][] sortTasks(int[][] tasks) {
        flag = new boolean[1441];
        shadow = new boolean[1441];
        ss = new boolean[1441];
        n = new int[1441];
        ns = new int[1441];
        nss = new int[1441];

        int length = tasks.length;
        int[][] sortedTasks = new int[length][2];
        h = new int[length][2];

        for (int i = 0; i < length; i++) {
            int index = tasks[i][0];
            if (!flag[index]) {
                n[index] = i;
                flag[index] = true;
            } else if (!shadow[index]) {
                ns[index] = i;
                shadow[index] = true;
            } else if (!ss[index]) {
                nss[index] = i;
                ss[index] = true;
            } else {
                return null;
            }
        }

        int p = 0;
        for (int i = 0; i < 1441; i++) {
            if (flag[i]) {
                sortedTasks[p] = tasks[n[i]];
                h[p][0] = p;
                h[p][1] = n[i];
                p++;
                if (shadow[i]) {
                    sortedTasks[p] = tasks[ns[i]];
                    h[p][0] = p;
                    h[p][1] = ns[i];
                    p++;
                    if (ss[i]) {
                        sortedTasks[p] = tasks[nss[i]];
                        h[p][0] = p;
                        h[p][1] = nss[i];
                        p++;
                    }
                }
            }
        }

        return sortedTasks;
    }

    public static void fill(boolean[] p, int a, int b) {
        Arrays.fill(p, a, b, true);
    }
}