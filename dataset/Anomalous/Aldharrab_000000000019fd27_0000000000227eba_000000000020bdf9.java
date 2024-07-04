import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCases; i++) {
            int numActivities = scanner.nextInt();
            scanner.nextLine();
            String result = "Case #" + (i + 1) + ": ";
            boolean isImpossible = false;

            Integer[][] cameronSchedule = new Integer[numActivities][2];
            Integer[][] jamieSchedule = new Integer[numActivities][2];

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                scanner.nextLine();

                Integer[] currentActivity = {start, end};
                boolean assigned = false;

                for (int k = 0; k < numActivities; k++) {
                    if (cameronSchedule[k][0] == null) {
                        cameronSchedule[k] = currentActivity;
                        result += "C";
                        assigned = true;
                        break;
                    } else if ((start >= cameronSchedule[k][0] && start < cameronSchedule[k][1]) ||
                               (end > cameronSchedule[k][0] && end <= cameronSchedule[k][1]) ||
                               (start <= cameronSchedule[k][0] && end >= cameronSchedule[k][1])) {
                        continue;
                    }
                }

                if (!assigned) {
                    for (int k = 0; k < numActivities; k++) {
                        if (jamieSchedule[k][0] == null) {
                            jamieSchedule[k] = currentActivity;
                            result += "J";
                            assigned = true;
                            break;
                        } else if ((start >= jamieSchedule[k][0] && start < jamieSchedule[k][1]) ||
                                   (end > jamieSchedule[k][0] && end <= jamieSchedule[k][1]) ||
                                   (start <= jamieSchedule[k][0] && end >= jamieSchedule[k][1])) {
                            continue;
                        }
                    }
                }

                if (!assigned) {
                    result = "Case #" + (i + 1) + ": IMPOSSIBLE";
                    isImpossible = true;
                    break;
                }
            }

            System.out.println(result);
        }

        scanner.close();
    }
}