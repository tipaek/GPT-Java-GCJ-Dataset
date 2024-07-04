import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scan.nextInt();
            int[] times1 = new int[24*60 + 1];
            int[] times2 = new int[24*60 + 1];
            for (int i = 1; i <= N; i++) {
                times1[scan.nextInt()] = i;
                times2[scan.nextInt()] = i;
            }

            boolean flag = true;
            Queue<Character> qu = new ArrayDeque<>();
            qu.add('C'); //1
            qu.add('J'); //-1
            char[] assignments = new char[N + 1];

            for (int j = 0; j <= 24*60; j++) {
                if (times1[j] == 0 && times2[j] == 0) continue;
                if (times2[j] != 0) qu.add(assignments[times2[j]]);
                if (times1[j] != 0) {
                    if (qu.isEmpty()) { flag = false; break; }
                    else assignments[times1[j]] = qu.remove();
                }
            }

            if (flag) {
                String out = new String(assignments);
                System.out.println("Case #" + (t + 1) + ": " + out);
            }
            else System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
        }
    }
}