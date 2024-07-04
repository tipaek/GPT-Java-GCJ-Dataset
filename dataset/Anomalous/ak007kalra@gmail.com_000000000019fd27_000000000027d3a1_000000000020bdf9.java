import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int t = input.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = input.nextInt();
                int[][] activities = new int[n][2];
                int[][] original = new int[n][2];
                int[] rem = new int[n];

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 2; k++) {
                        activities[j][k] = input.nextInt();
                        original[j][k] = activities[j][k];
                    }
                }

                boolean impossible = false;
                for (int j = 0; j < n; j++) {
                    if (activities[j][1] <= activities[j][0]) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
                if (impossible) continue;

                // Sort activities by start time
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (activities[j][0] > activities[k][0]) {
                            int[] temp = activities[j];
                            activities[j] = activities[k];
                            activities[k] = temp;
                        }
                    }
                }

                // Map original indices to sorted indices
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (original[j][0] == activities[k][0] && original[j][1] == activities[k][1]) {
                            rem[j] = k;
                            break;
                        }
                    }
                }

                StringBuilder schedule = new StringBuilder("C");
                int[] c = {activities[0][0], activities[0][1]};
                int[] j = {0, 0};

                for (int m = 1; m < n; m++) {
                    if (activities[m][0] < c[1]) {
                        if (activities[m][0] >= j[1]) {
                            schedule.append("J");
                            j[0] = activities[m][0];
                            j[1] = activities[m][1];
                        } else {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                    } else {
                        schedule.append("C");
                        c[0] = activities[m][0];
                        c[1] = activities[m][1];
                    }
                }
                if (impossible) continue;

                StringBuilder output = new StringBuilder();
                for (int m = 0; m < n; m++) {
                    output.append(schedule.charAt(rem[m]));
                }
                System.out.println("Case #" + i + ": " + output.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}