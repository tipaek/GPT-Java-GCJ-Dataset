import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static boolean switched = false;

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
            
            String solution = assignActivities(activitySchedule);
            System.out.println("Case #" + caseNumber + ": " + solution);
        }
    }

    private static String assignActivities(int[][] activitySchedule) {
        StringBuilder solution = new StringBuilder();
        String currentPerson = "C";
        solution.append(currentPerson);
        
        int lastActivityC = 0;
        int lastActivityJ = 0;

        for (int j = 1; j < activitySchedule.length; j++) {
            switched = false;
            if (lastActivityJ == 0) {
                if (!checkOverlap(activitySchedule[j - 1], activitySchedule[j])) {
                    solution.append(currentPerson);
                    lastActivityC = j;
                } else {
                    currentPerson = "J";
                    solution.append(currentPerson);
                    lastActivityJ = j;
                }
            } else {
                if (!checkOverlap(activitySchedule[lastActivityC], activitySchedule[j])) {
                    currentPerson = "C";
                    solution.append(currentPerson);
                    lastActivityC = j;
                } else if (!checkOverlap(activitySchedule[lastActivityJ], activitySchedule[j])) {
                    currentPerson = "J";
                    solution.append(currentPerson);
                    lastActivityJ = j;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return solution.toString();
    }

    private static boolean checkOverlap(int[] activityA, int[] activityB) {
        if (activityA[0] < activityB[0] && activityA[1] > activityB[0]) {
            return true;
        } else if (activityB[0] < activityA[0] && activityB[1] > activityA[0]) {
            return true;
        } else if (!switched) {
            switched = true;
            return checkOverlap(activityB, activityA);
        }
        return false;
    }
}