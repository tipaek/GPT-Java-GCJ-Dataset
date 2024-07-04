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

            boolean[] c = new boolean[10000];
            boolean[] j = new boolean[10000];
            StringBuilder schedule = new StringBuilder();

            boolean impossible = false;
            for (int k = 0; k < n; k++) {
                int start = intervals[k][0];
                int end = intervals[k][1];

                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int l = start; l < end; l++) {
                    if (c[l]) canAssignC = false;
                    if (j[l]) canAssignJ = false;
                }

                if (canAssignC) {
                    schedule.append('C');
                    for (int l = start; l < end; l++) {
                        c[l] = true;
                    }
                } else if (canAssignJ) {
                    schedule.append('J');
                    for (int l = start; l < end; l++) {
                        j[l] = true;
                    }
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", ts);
            } else {
                System.out.printf("Case #%d: %s%n", ts, schedule.toString());
            }
            ts++;
        }
        sc.close();
    }
}