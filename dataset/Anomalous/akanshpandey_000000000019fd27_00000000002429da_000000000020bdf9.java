import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            char[] schedule = new char[numActivities];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            System.out.print("Case #" + caseNum + ": ");
            boolean isImpossible = false;
            int cameronEnd = 0, jamieEnd = 0;

            for (int i = 0; i < numActivities; i++) {
                if (activities[i][0] >= cameronEnd) {
                    schedule[i] = 'C';
                    cameronEnd = activities[i][1];
                } else if (activities[i][0] >= jamieEnd) {
                    schedule[i] = 'J';
                    jamieEnd = activities[i][1];
                } else {
                    isImpossible = true;
                    break;
                }
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