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
            StringBuilder s = new StringBuilder("C");
            int[][] sched = new int[N][2];
            for (int i = 0; i < N; i++) {
                sched[i] = new int[]{in.nextInt(), in.nextInt()};
            }
            Arrays.sort(sched, (s1, s2) -> s1[1] - s2[1]);
            lastAt[0] = sched[0][1];
            for (int i = 1; i < N; i++) {
                if (sched[i-1][1] <= sched[i][0]) {
                    s.append(initials.charAt(who));
                } else {
                    who = (who + 1) % 2;
                    if (lastAt[who] <= sched[i][0]) {
                        s.append(initials.charAt(who));
                    }
                }
            }
            System.out.printf("Case #%d: %s\n", t, s.length() == N ? s.toString() : "IMPOSSIBLE");
        }
    }
}