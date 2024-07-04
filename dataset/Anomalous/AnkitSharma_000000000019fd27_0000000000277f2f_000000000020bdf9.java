import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            int[][] activities = new int[activitiesCount][2];

            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            boolean possible = true;

            for (int i = 0; i < activitiesCount; i++) {
                int start = activities[i][0];
                int end = activities[i][1];
                boolean canAssignToC = true;
                boolean canAssignToJ = true;

                for (int time = start; time < end; time++) {
                    if (cSchedule[time]) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    for (int time = start; time < end; time++) {
                        cSchedule[time] = true;
                    }
                    result.append("C");
                } else {
                    for (int time = start; time < end; time++) {
                        if (jSchedule[time]) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        for (int time = start; time < end; time++) {
                            jSchedule[time] = true;
                        }
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}