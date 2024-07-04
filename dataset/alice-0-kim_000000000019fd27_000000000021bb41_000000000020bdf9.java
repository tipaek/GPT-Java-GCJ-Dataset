import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[] lastAt = new int[2];
            String initials = "CJ";
            int who = 0; // Cameron's turn
            int cnt = 0;
            char[] res = new char[N];
            int[][] sched = new int[N][3];
            for (int i = 0; i < N; i++) {
                sched[i] = new int[]{in.nextInt(), in.nextInt(), i};
            }
            Arrays.sort(sched, (s1, s2) -> s1[1] - s2[1]);
            res[sched[0][2]] = 'C'; cnt++;
            lastAt[0] = sched[0][1];
            for (int i = 1; i < N; i++) {
                if (sched[i-1][1] <= sched[i][0]) {
                    res[sched[i][2]] = initials.charAt(who); cnt++;
                } else {
                    who = (who + 1) % 2;
                    if (lastAt[who] <= sched[i][0]) {
                        res[sched[i][2]] = initials.charAt(who); cnt++;
                    }
                }
            }
            System.out.printf("Case #%d: %s\n", t, cnt == N ? new String(res) : "IMPOSSIBLE");
        }
    }
}