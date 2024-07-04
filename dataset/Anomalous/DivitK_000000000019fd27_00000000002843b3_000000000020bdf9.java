import java.util.Scanner;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int t = scanner.nextInt();
            int[][] intervals = new int[t][2];

            for (int j = 0; j < t; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");
            int overlapCount = 0;

            for (int k = 1; k < t; k++) {
                if ((intervals[k][0] >= intervals[k - 1][0]) && (intervals[k][0] <= intervals[k - 1][1])) {
                    schedule.append('J');
                    overlapCount++;
                } else if ((intervals[k][1] >= intervals[k - 1][0]) && (intervals[k][1] <= intervals[k - 1][1])) {
                    schedule.append('J');
                } else {
                    schedule.append('C');
                }
            }

            if (overlapCount > 1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
            }
        }

        scanner.close();
    }
}