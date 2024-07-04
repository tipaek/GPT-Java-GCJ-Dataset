import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numTests = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        for (int testCase = 1; testCase <= numTests; testCase++) {
            int numActivities = scanner.nextInt();
            scanner.nextLine(); // Move to the next line

            int[][] activities = new int[numActivities][2];
            int[] startTimes = new int[numActivities];

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt() - 1;
                scanner.nextLine(); // Move to the next line
            }

            Arrays.sort(startTimes);

            int[] timeSlots = new int[1441];
            for (int[] activity : activities) {
                for (int t = activity[0]; t <= activity[1]; t++) {
                    timeSlots[t]++;
                }
            }

            boolean isImpossible = false;
            for (int t = 0; t <= 1440; t++) {
                if (timeSlots[t] > 2) {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int startTime : startTimes) {
                    if (timeSlots[startTime] == 1) {
                        if (result.length() == 0 || result.charAt(result.length() - 1) == 'C') {
                            result.append('J');
                        } else {
                            result.append('C');
                        }
                    } else {
                        if (result.length() == 0 || result.charAt(result.length() - 1) == 'C') {
                            result.append('J');
                        } else {
                            result.append('C');
                        }
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}