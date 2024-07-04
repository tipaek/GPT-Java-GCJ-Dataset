import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numTests = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        for (int test = 1; test <= numTests; test++) {
            int numActivities = scanner.nextInt();
            scanner.nextLine(); // Move to the next line

            int[][] activities = new int[numActivities][2];
            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt(); // Start time
                activities[i][1] = scanner.nextInt() - 1; // End time (adjusted)
                scanner.nextLine(); // Move to the next line
            }

            int[] timeTable = new int[1441];
            for (int[] activity : activities) {
                for (int t = activity[0]; t <= activity[1]; t++) {
                    timeTable[t]++;
                }
            }

            boolean impossible = false;
            for (int t = 0; t < 1440; t++) {
                if (timeTable[t] > 2) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }

            int[] startTimes = new int[numActivities];
            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = activities[i][0];
            }
            Arrays.sort(startTimes);

            StringBuilder schedule = new StringBuilder();
            boolean[] lastParent = {true, true}; // C and J availability

            for (int startTime : startTimes) {
                if (timeTable[startTime] == 1) {
                    if (schedule.length() == 0 || schedule.charAt(schedule.length() - 1) == 'C') {
                        schedule.append('J');
                    } else {
                        schedule.append('C');
                    }
                } else {
                    if (schedule.length() == 0 || schedule.charAt(schedule.length() - 1) == 'C') {
                        schedule.append('J');
                    } else {
                        schedule.append('C');
                    }
                }
            }

            System.out.println("Case #" + test + ": " + schedule.toString());
        }
    }
}