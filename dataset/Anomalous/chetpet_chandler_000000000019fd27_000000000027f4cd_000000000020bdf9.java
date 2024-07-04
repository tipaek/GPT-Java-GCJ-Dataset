import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][2];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

            int cEnd = 0, jEnd = 0;
            boolean impossible = false;

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];

                if (start >= cEnd) {
                    result.append('C');
                    cEnd = end;
                } else if (start >= jEnd) {
                    result.append('J');
                    jEnd = end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + result);
        }

        scanner.close();
    }
}