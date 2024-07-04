import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    // 0 1 2 3 4
    // 1 1 0 4 4
    // 0 2 2 3 0

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int[] taskC = new int[60 * 24 + 1];
            int[] taskJ = new int[60 * 24 + 1];
            int N = in.nextInt();
            StringBuilder sb = new StringBuilder();
            boolean ok = false;
            for (int i = 1; i <= N; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                if (check(taskC, from, to)) {
                    ok = true;
                    book(taskC, from, to, i);
                } else if (check(taskJ, from, to)) {
                    ok = true;
                    book(taskJ, from, to, i);
                } else {
                    sb.append("IMPOSSIBLE");
                    ok = false;
                    break;
                }
            }
            if (ok) {
                Set<Integer> setC = new HashSet<>();
                for (int i = 0; i < taskC.length; i++) {
                    setC.add(taskC[i]);
                }
                Set<Integer> setJ = new HashSet<>();
                for (int i = 0; i < taskJ.length; i++) {
                    setJ.add(taskJ[i]);
                }
                for (int i = 1; i <= N; i++) {
                    if (setC.contains(i)) sb.append("C");
                    else sb.append("J");
                }
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }

    public static boolean check(int[] task, int from, int to) {
        for (int i = from; i < to; i++) {
            if (task[i] > 0) return false;
        }
        return true;
    }

    public static void book(int[] task, int from, int to, int num) {
        for (int i = from; i < to; i++) {
            task[i] = num;
        }
    }
}

