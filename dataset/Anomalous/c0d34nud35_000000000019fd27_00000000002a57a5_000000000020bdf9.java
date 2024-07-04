import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scan.nextInt();
            int[][] activities = new int[N][3];
            int[][] c = new int[N][2];
            int[][] j = new int[N][2];
            int cCount = 0, jCount = 0;
            boolean isImpossible = false;
            StringBuilder order = new StringBuilder();

            for (int n = 0; n < N; n++) {
                activities[n][0] = scan.nextInt();
                activities[n][1] = scan.nextInt();
                activities[n][2] = n; // original position
            }

            sortActivitiesByStartTime(activities);

            for (int[] activity : activities) {
                if (hasTime(activity[0], activity[1], c, cCount)) {
                    c[cCount++] = new int[]{activity[0], activity[1]};
                    order.append('C');
                    activity[2] = 'C' - 'A';
                } else if (hasTime(activity[0], activity[1], j, jCount)) {
                    j[jCount++] = new int[]{activity[0], activity[1]};
                    order.append('J');
                    activity[2] = 'J' - 'A';
                } else {
                    System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                System.out.print("Case #" + (t + 1) + ": ");
                for (int pos = 0; pos < N; pos++) {
                    for (int[] activity : activities) {
                        if (activity[2] == pos) {
                            System.out.print((char) (activity[2] + 'A'));
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    private static void sortActivitiesByStartTime(int[][] activities) {
        int n = activities.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (activities[j][0] > activities[j + 1][0]) {
                    int[] temp = activities[j];
                    activities[j] = activities[j + 1];
                    activities[j + 1] = temp;
                }
            }
        }
    }

    private static boolean hasTime(int start, int end, int[][] schedule, int count) {
        for (int i = 0; i < count; i++) {
            if ((start >= schedule[i][0] && start < schedule[i][1]) ||
                (end > schedule[i][0] && end <= schedule[i][1])) {
                return false;
            }
        }
        return true;
    }
}