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

            int[] cSchedule = new int[1500];
            int[] jSchedule = new int[1500];
            int cIndex = 0, jIndex = 0;
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder("C");

            for (int j = intervals[0][0]; j < intervals[0][1]; j++) {
                cSchedule[cIndex++] = j;
            }

            for (int j = 1; j < n; j++) {
                boolean canAssignC = true, canAssignJ = true;

                for (int k = 0; k < cIndex; k++) {
                    if (intervals[j][0] <= cSchedule[k] && intervals[j][1] > cSchedule[k]) {
                        canAssignC = false;
                        break;
                    }
                }

                for (int k = 0; k < jIndex; k++) {
                    if (intervals[j][0] <= jSchedule[k] && intervals[j][1] > jSchedule[k]) {
                        canAssignJ = false;
                        break;
                    }
                }

                if (canAssignC) {
                    result.append('C');
                    for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                        cSchedule[cIndex++] = l;
                    }
                } else if (canAssignJ) {
                    result.append('J');
                    for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                        jSchedule[jIndex++] = l;
                    }
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", ts);
            } else {
                System.out.printf("Case #%d: %s\n", ts, result.toString());
            }
            ts++;
        }
    }
}