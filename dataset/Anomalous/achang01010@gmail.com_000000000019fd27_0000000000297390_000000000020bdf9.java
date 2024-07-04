import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            StringBuilder result = new StringBuilder();
            boolean impossible = false;
            int[] schedule = new int[1440];
            boolean[] cameronSchedule = new boolean[1440];
            boolean[] jamieSchedule = new boolean[1440];

            Arrays.fill(schedule, 0);
            Arrays.fill(cameronSchedule, false);
            Arrays.fill(jamieSchedule, false);

            int numShifts = scanner.nextInt();

            for (int shiftIndex = 0; shiftIndex < numShifts; shiftIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                for (int time = start; time < end; time++) {
                    if (schedule[time] == 2) {
                        impossible = true;
                    } else {
                        schedule[time]++;
                    }
                }

                boolean canAssignToCameron = true;
                for (int time = start; time < end; time++) {
                    if (cameronSchedule[time]) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                if (canAssignToCameron) {
                    for (int time = start; time < end; time++) {
                        cameronSchedule[time] = true;
                    }
                    result.append("C");
                } else {
                    for (int time = start; time < end; time++) {
                        jamieSchedule[time] = true;
                    }
                    result.append("J");
                }
            }

            if (impossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
            }
        }

        scanner.close();
    }
}