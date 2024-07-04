/*
 * Created by cravuri on 4/3/20
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] events = new int[2 * N][3];
            for (int i = 0; i < N; i++) {
                events[2 * i][0] = sc.nextInt();
                events[2 * i][1] = i;
                events[2 * i][2] = 1;

                events[2 * i + 1][0] = sc.nextInt();
                events[2 * i + 1][1] = i;
                events[2 * i + 1][2] = -1;
            }
            Arrays.sort(events, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[2] - o2[2];
                    }
                    return o1[0] - o2[0];
                }
            });
            int[] avail = new int[2];
            avail[0] = -1;
            avail[1] = -1;
            boolean poss = true;
            char[] assign = new char[N];
            for (int i = 0; i < events.length; i++) {
                if (events[i][2] == 1) {
                    if (avail[0] == -1) {
                        avail[0] = events[i][1];
                        assign[events[i][1]] = 'C';
                    } else if (avail[1] == -1) {
                        avail[1] = events[i][1];
                        assign[events[i][1]] = 'J';
                    } else {
                        poss = false;
                        break;
                    }
                } else {
                    if (avail[0] == events[i][1]) {
                        avail[0] = -1;
                    } else {
                        avail[1] = -1;
                    }
                }
            }
            if (poss) {
                System.out.println("Case #" + t + ": " + String.valueOf(assign));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

}
