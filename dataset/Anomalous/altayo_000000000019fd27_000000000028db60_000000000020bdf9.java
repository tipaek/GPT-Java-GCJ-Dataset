import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfActivities = scanner.nextInt();
            int cEnd = -1, jEnd = -1;
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start >= cEnd) {
                    cEnd = end;
                    schedule.append('C');
                } else if (start >= jEnd) {
                    jEnd = end;
                    schedule.append('J');
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? schedule.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }

        scanner.close();
    }
}