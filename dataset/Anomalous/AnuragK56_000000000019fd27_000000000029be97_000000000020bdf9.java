import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = sc.nextInt();
            int[][] timeSlots = new int[n][2];

            for (int i = 0; i < n; i++) {
                timeSlots[i][0] = sc.nextInt();
                timeSlots[i][1] = sc.nextInt();
            }

            // Sort the time slots by start time
            for (int i = 1; i < n; i++) {
                for (int j = i; j > 0; j--) {
                    if (timeSlots[j][0] < timeSlots[j - 1][0]) {
                        int tempStart = timeSlots[j][0];
                        int tempEnd = timeSlots[j][1];
                        timeSlots[j][0] = timeSlots[j - 1][0];
                        timeSlots[j][1] = timeSlots[j - 1][1];
                        timeSlots[j - 1][0] = tempStart;
                        timeSlots[j - 1][1] = tempEnd;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (cameronEnd <= timeSlots[i][0]) {
                    result.append('C');
                    cameronEnd = timeSlots[i][1];
                } else if (jamieEnd <= timeSlots[i][0]) {
                    result.append('J');
                    jamieEnd = timeSlots[i][1];
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + result);
        }
    }
}