import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            int[] startTimes = new int[activityCount];
            int[] endTimes = new int[activityCount];
            StringBuilder assignment = new StringBuilder();
            boolean isPossible = true;

            for (int i = 0; i < activityCount; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;

                if (isPossible) {
                    for (int j = 0; j < i; j++) {
                        if (assignment.charAt(j) == 'C') {
                            if (cameronAvailable) {
                                if ((startTimes[i] < endTimes[j] && endTimes[i] > startTimes[j])) {
                                    cameronAvailable = false;
                                }
                            }
                        } else {
                            if (jamieAvailable) {
                                if ((startTimes[i] < endTimes[j] && endTimes[i] > startTimes[j])) {
                                    jamieAvailable = false;
                                }
                            }
                        }
                    }

                    if (cameronAvailable) {
                        assignment.append('C');
                    } else if (jamieAvailable) {
                        assignment.append('J');
                    } else {
                        assignment = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                    }
                }
            }
            System.out.println("Case #" + testCase + ": " + assignment);
        }
    }
}