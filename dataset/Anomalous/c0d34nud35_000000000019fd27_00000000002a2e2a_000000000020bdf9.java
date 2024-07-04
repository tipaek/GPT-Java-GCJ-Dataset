import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scan.nextInt();
            int[][] activities = new int[N][2];
            for (int n = 0; n < N; n++) {
                activities[n][0] = scan.nextInt();
                activities[n][1] = scan.nextInt();
            }

            // Sort activities by starting time
            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

            StringBuilder order = new StringBuilder();
            int[][] c = new int[N][2];
            int[][] j = new int[N][2];
            int cCount = 0, jCount = 0;
            boolean isPossible = true;

            for (int[] activity : activities) {
                if (hasTime(activity, c, cCount)) {
                    c[cCount++] = activity;
                    order.append('C');
                } else if (hasTime(activity, j, jCount)) {
                    j[jCount++] = activity;
                    order.append('J');
                } else {
                    System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + (t + 1) + ": " + order);
            }
        }
    }

    static boolean hasTime(int[] activity, int[][] schedule, int count) {
        for (int i = 0; i < count; i++) {
            if ((activity[0] < schedule[i][1] && activity[1] > schedule[i][0])) {
                return false;
            }
        }
        return true;
    }
}