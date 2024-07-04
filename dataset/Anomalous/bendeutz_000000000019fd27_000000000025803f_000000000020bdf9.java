import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int i = 0; i < numberOfCases; i++) {
            int caseNumber = i + 1;
            int activities = scanner.nextInt();
            int[][] activitySchedule = new int[activities][2];

            for (int j = 0; j < activities; j++) {
                activitySchedule[j][0] = scanner.nextInt();
                activitySchedule[j][1] = scanner.nextInt();
            }

            String solution = findSchedule(activitySchedule);
            System.out.println("Case #" + caseNumber + ": " + solution);
        }
    }

    private static String findSchedule(int[][] activitySchedule) {
        StringBuilder solution = new StringBuilder("C");
        int lastActivityC = 0;
        int lastActivityJ = -1;

        for (int j = 1; j < activitySchedule.length; j++) {
            if (lastActivityJ == -1) { // J hasn't done anything yet
                if (!checkOverlap(activitySchedule[lastActivityC], activitySchedule[j])) {
                    solution.append("C");
                    lastActivityC = j;
                } else {
                    solution.append("J");
                    lastActivityJ = j;
                }
            } else { // Both C and J have done something
                if (!checkOverlap(activitySchedule[lastActivityC], activitySchedule[j])) {
                    solution.append("C");
                    lastActivityC = j;
                } else if (!checkOverlap(activitySchedule[lastActivityJ], activitySchedule[j])) {
                    solution.append("J");
                    lastActivityJ = j;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        return solution.toString();
    }

    private static boolean checkOverlap(int[] activityA, int[] activityB) {
        return activityA[1] > activityB[0] && activityA[0] < activityB[1];
    }
}