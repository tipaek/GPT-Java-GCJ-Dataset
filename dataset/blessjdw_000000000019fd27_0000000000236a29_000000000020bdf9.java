import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int[] taskC = new int[60 * 24];
            int[] taskJ = new int[60 * 24];
            int N = in.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int n = 1; n <= N; n++) {
                int from = in.nextInt();
                int to = in.nextInt();
                if (sb.length() > 0) continue;
                if (check(taskC, from, to)) {
                    fill(taskC, from, to, n);
                } else if (check(taskJ, from, to)) {
                    fill(taskJ, from, to, n);
                } else {
                    sb.append("IMPOSSIBLE");
                }
            }
            if (sb.length() == 0) {
                Set<Integer> setC = new HashSet<>();
                for (int num : taskC)
                    setC.add(num);
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

    public static void fill(int[] task, int from, int to, int num) {
        for (int i = from; i < to; i++) {
            task[i] = num;
        }
    }
}

