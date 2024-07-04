import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int m = 0; m < n; m++) {
            int x = in.nextInt();
            boolean flag = true;
            int[][] intervals = new int[x][2];
            for (int i = 0; i < x; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
            }

            int[] timeline = new int[24 * 60];
            for (int i = 0; i < x; i++) {
                timeline[intervals[i][0]]++;
                timeline[intervals[i][1]]--;
            }

            int ongoingEvents = 0;
            for (int i = 0; i < 24 * 60; i++) {
                ongoingEvents += timeline[i];
                if (ongoingEvents > 2) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                int cEnd = intervals[0][1];
                int jEnd = -1;
                StringBuilder result = new StringBuilder("C");

                for (int i = 1; i < x; i++) {
                    if (intervals[i][0] >= cEnd) {
                        cEnd = -1;
                    }
                    if (intervals[i][0] >= jEnd) {
                        jEnd = -1;
                    }
                    if (cEnd == -1) {
                        cEnd = intervals[i][1];
                        result.append("C");
                    } else if (jEnd == -1) {
                        jEnd = intervals[i][1];
                        result.append("J");
                    }
                }
                System.out.println("Case #" + (m + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (m + 1) + ": IMPOSSIBLE");
            }
        }
    }
}