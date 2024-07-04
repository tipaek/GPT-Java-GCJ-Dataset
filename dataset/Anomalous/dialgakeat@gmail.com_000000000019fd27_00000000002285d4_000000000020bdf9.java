import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activities = scanner.nextInt();
            boolean isImpossible = false;
            boolean[] cameronSchedule = new boolean[1440];
            boolean[] jamieSchedule = new boolean[1440];
            StringBuilder schedule = new StringBuilder();

            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;

                for (int time = start; time < end; time++) {
                    if (cameronSchedule[time]) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                if (canAssignToCameron) {
                    Arrays.fill(cameronSchedule, start, end, true);
                } else {
                    for (int time = start; time < end; time++) {
                        if (jamieSchedule[time]) {
                            canAssignToJamie = false;
                            break;
                        }
                    }
                    if (canAssignToJamie) {
                        Arrays.fill(jamieSchedule, start, end, true);
                    }
                }

                if (canAssignToCameron) {
                    schedule.append('C');
                } else if (canAssignToJamie) {
                    schedule.append('J');
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + schedule);
        }

        scanner.close();
    }
}