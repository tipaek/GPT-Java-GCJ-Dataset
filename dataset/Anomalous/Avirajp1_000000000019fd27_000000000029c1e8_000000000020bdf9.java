import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ts = 1;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }

            int[] c = new int[9999];
            int[] j = new int[9999];
            Arrays.fill(c, -1);
            Arrays.fill(j, -1);

            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int x = intervals[0][0]; x < intervals[0][1]; x++) {
                c[x] = 1;
            }
            schedule.append('C');

            for (int k = 1; k < n; k++) {
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int x = intervals[k][0]; x < intervals[k][1]; x++) {
                    if (c[x] != -1) canAssignC = false;
                    if (j[x] != -1) canAssignJ = false;
                }

                if (canAssignC) {
                    schedule.append('C');
                    for (int x = intervals[k][0]; x < intervals[k][1]; x++) {
                        c[x] = 1;
                    }
                } else if (canAssignJ) {
                    schedule.append('J');
                    for (int x = intervals[k][0]; x < intervals[k][1]; x++) {
                        j[x] = 1;
                    }
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.printf("Case #%d: %s\n", ts, schedule.toString());
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", ts);
            }

            ts++;
        }

        sc.close();
    }
}