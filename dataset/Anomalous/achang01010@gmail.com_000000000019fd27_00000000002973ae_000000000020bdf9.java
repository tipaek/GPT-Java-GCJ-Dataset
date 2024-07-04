import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int[] schedule = new int[1440];
            boolean[] cameronSchedule = new boolean[1440];
            boolean[] jamieSchedule = new boolean[1440];
            boolean impossible = false;
            StringBuilder result = new StringBuilder();

            int shifts = scanner.nextInt();

            for (int s = 0; s < shifts; s++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                for (int time = start; time < end; time++) {
                    if (schedule[time] == 2) {
                        impossible = true;
                        break;
                    } else {
                        schedule[time]++;
                    }
                }

                if (impossible) {
                    break;
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
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }

        scanner.close();
    }
}