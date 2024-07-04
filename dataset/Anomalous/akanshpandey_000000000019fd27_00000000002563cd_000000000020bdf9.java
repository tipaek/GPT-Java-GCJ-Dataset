import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][3];
            char[] schedule = new char[activityCount];

            for (int j = 0; j < activityCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            System.out.print("Case #" + caseNumber + ": ");
            boolean isImpossible = false;
            int cameronEndTime = -1;
            int jamieEndTime = -1;

            for (int j = 0; j < activityCount; j++) {
                int nextActivityIndex = -1;

                for (int k = 0; k < activityCount; k++) {
                    if (activities[k][2] == 0) {
                        if (nextActivityIndex == -1 || 
                            activities[k][0] < activities[nextActivityIndex][0] || 
                            (activities[k][0] == activities[nextActivityIndex][0] && activities[k][1] < activities[nextActivityIndex][1])) {
                            nextActivityIndex = k;
                        }
                    }
                }

                if (activities[nextActivityIndex][0] >= cameronEndTime) {
                    schedule[nextActivityIndex] = 'C';
                    cameronEndTime = activities[nextActivityIndex][1];
                } else if (activities[nextActivityIndex][0] >= jamieEndTime) {
                    schedule[nextActivityIndex] = 'J';
                    jamieEndTime = activities[nextActivityIndex][1];
                } else {
                    isImpossible = true;
                    break;
                }
                activities[nextActivityIndex][2] = 1;
            }

            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(schedule));
            }
        }
        scanner.close();
    }
}