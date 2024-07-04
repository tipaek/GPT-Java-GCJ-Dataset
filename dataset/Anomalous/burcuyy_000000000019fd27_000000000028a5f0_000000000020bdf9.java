import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activities = scanner.nextInt();
            int[] startTimes = new int[activities];
            int[] endTimes = new int[activities];
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < activities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();

                boolean cameronAvailable = true;
                boolean jamieAvailable = true;

                for (int j = 0; j < i; j++) {
                    if (schedule.charAt(j) == 'C') {
                        if (cameronAvailable && isOverlapping(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                            cameronAvailable = false;
                        }
                    } else {
                        if (jamieAvailable && isOverlapping(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                            jamieAvailable = false;
                        }
                    }
                }

                if (cameronAvailable) {
                    schedule.append('C');
                } else if (jamieAvailable) {
                    schedule.append('J');
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + schedule);
        }
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < start2 && end1 > start2) || (start1 >= start2 && start1 < end2);
    }
}