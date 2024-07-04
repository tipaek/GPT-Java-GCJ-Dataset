import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            byte[] scheduleJ = new byte[1440];
            byte[] scheduleC = new byte[1440];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] times = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(times[0]);
                intervals[i][1] = Integer.parseInt(times[1]);
            }

            Arrays.fill(scheduleJ, (byte) 0);
            Arrays.fill(scheduleC, (byte) 0);

            for (int i = 0; i < n; i++) {
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                    if (scheduleC[j] != 0) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        scheduleC[j] = 1;
                    }
                    result.append("C");
                } else {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (scheduleJ[j] != 0) {
                            canAssignJ = false;
                            break;
                        }
                    }

                    if (canAssignJ) {
                        for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                            scheduleJ[j] = 1;
                        }
                        result.append("J");
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.print("Case #" + caseNumber + ": " + result.toString());
            if (caseNumber != t) {
                System.out.println();
            }
        }
    }
}