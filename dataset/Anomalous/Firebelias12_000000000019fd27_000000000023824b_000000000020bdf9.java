import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            StringBuilder result = new StringBuilder("CJ");

            int n = scanner.nextInt();
            int[][] activities = new int[n][2];
            for (int j = 0; j < n; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            // Sort activities by start time
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            if (n > 2) {
                for (int j = 2; j < n; j++) {
                    if (activities[j][0] < activities[j - 2][1] && activities[j][0] < activities[j - 1][1]) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else if (activities[j][0] < activities[j - 2][1]) {
                        result.append("J");
                    } else {
                        result.append("C");
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}