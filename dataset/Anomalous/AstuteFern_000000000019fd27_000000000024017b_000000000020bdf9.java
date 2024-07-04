import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];

            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");

            for (int i = 0; i < numActivities - 1; i++) {
                if (startTimes[i] > startTimes[i + 1] || endTimes[i] < endTimes[i + 1]) {
                    if (endTimes[i] == startTimes[i + 1]) {
                        schedule.append(schedule.charAt(schedule.length() - 1));
                    } else {
                        if (schedule.charAt(schedule.length() - 1) == 'C') {
                            schedule.append('J');
                        } else {
                            schedule.append('C');
                        }
                    }
                }
            }

            if (schedule.length() != numActivities) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + schedule.toString());
        }
    }
}