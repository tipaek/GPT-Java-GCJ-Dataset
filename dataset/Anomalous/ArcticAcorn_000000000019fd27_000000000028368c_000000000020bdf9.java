import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNumber = 1;
        StringBuilder output = new StringBuilder();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int jTop = 0, cTop = 0;
            boolean isPossible = true;
            StringBuilder result = new StringBuilder("J");

            int n = sc.nextInt();
            int[][] jSchedule = new int[n * 2][2];
            int[][] cSchedule = new int[n * 2][2];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (i == 0) {
                    jSchedule[jTop][0] = start;
                    jSchedule[jTop][1] = end;
                    jTop++;
                    continue;
                }

                boolean canAssignToJ = true;
                for (int[] interval : jSchedule) {
                    if (interval[0] == 0 && interval[1] == 0) break; // Skip uninitialized intervals
                    if ((start >= interval[0] && start < interval[1]) || (end > interval[0] && end <= interval[1]) || (start <= interval[0] && end >= interval[1])) {
                        canAssignToJ = false;
                        break;
                    }
                }

                boolean canAssignToC = true;
                for (int[] interval : cSchedule) {
                    if (interval[0] == 0 && interval[1] == 0) break; // Skip uninitialized intervals
                    if ((start >= interval[0] && start < interval[1]) || (end > interval[0] && end <= interval[1]) || (start <= interval[0] && end >= interval[1])) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (!canAssignToJ && !canAssignToC) {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                } else if (canAssignToC && !canAssignToJ) {
                    cSchedule[cTop][0] = start;
                    cSchedule[cTop][1] = end;
                    cTop++;
                    result.append("C");
                } else if (canAssignToJ && !canAssignToC) {
                    jSchedule[jTop][0] = start;
                    jSchedule[jTop][1] = end;
                    jTop++;
                    result.append("J");
                } else {
                    if (result.charAt(result.length() - 1) == 'J') {
                        jSchedule[jTop][0] = start;
                        jSchedule[jTop][1] = end;
                        jTop++;
                        result.append("J");
                    } else {
                        cSchedule[cTop][0] = start;
                        cSchedule[cTop][1] = end;
                        cTop++;
                        result.append("C");
                    }
                }
            }

            output.append("Case #").append(caseNumber).append(": ").append(result).append("\n");
            caseNumber++;
        }

        System.out.println(output);
    }
}