import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][2];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

            int cStart = activities[0][0];
            int cEnd = activities[0][1];
            result.append('C');

            int jStart = -1;
            int jEnd = -1;

            boolean possible = true;

            for (int i = 1; i < n; i++) {
                int start = activities[i][0];
                int end = activities[i][1];

                if ((start >= cStart && start < cEnd) || (end > cStart && end <= cEnd)) {
                    if ((start >= jStart && start < jEnd) || (end > jStart && end <= jEnd)) {
                        result = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                        break;
                    } else {
                        jStart = start;
                        jEnd = end;
                        result.append('J');
                    }
                } else {
                    cStart = start;
                    cEnd = end;
                    result.append('C');
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }

        scanner.close();
    }
}