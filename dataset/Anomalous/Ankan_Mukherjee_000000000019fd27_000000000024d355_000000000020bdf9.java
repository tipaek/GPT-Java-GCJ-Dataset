import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            byte[] J = new byte[1440];
            byte[] C = new byte[1440];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] times = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(times[0]);
                intervals[i][1] = Integer.parseInt(times[1]);
            }

            Arrays.fill(J, (byte) 0);
            Arrays.fill(C, (byte) 0);

            for (int i = 0; i < n; i++) {
                boolean canAssignToJ = true;
                boolean canAssignToC = true;

                for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                    if (J[j] != 0) {
                        canAssignToJ = false;
                        break;
                    }
                }

                if (canAssignToJ) {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        J[j] = 1;
                    }
                    result.append("J");
                } else {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (C[j] != 0) {
                            canAssignToC = false;
                            break;
                        }
                    }

                    if (canAssignToC) {
                        for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                            C[j] = 1;
                        }
                        result.append("C");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}