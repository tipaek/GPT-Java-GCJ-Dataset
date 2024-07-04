import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][4];
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(activity -> activity[0]));

            int endC = -1, endJ = -1;
            for (int i = 0; i < n; i++) {
                if (activities[i][0] >= endC) {
                    activities[i][3] = 1;
                    endC = activities[i][1];
                } else if (activities[i][0] >= endJ) {
                    activities[i][3] = 2;
                    endJ = activities[i][1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            } else {
                Arrays.sort(activities, Comparator.comparingInt(activity -> activity[2]));
                StringBuilder result = new StringBuilder();
                for (int[] activity : activities) {
                    result.append(activity[3] == 1 ? 'C' : 'J');
                }
                System.out.printf("Case #%d: %s%n", t, result.toString());
            }
        }
    }
}