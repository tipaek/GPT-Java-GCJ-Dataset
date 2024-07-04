import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int t = input.nextInt();
            outerLoop:
            for (int i = 1; i <= t; i++) {
                int n = input.nextInt();
                int[][] activities = new int[n][2];
                int[][] originalActivities = new int[n][2];

                for (int j = 0; j < n; j++) {
                    activities[j][0] = input.nextInt();
                    activities[j][1] = input.nextInt();
                    originalActivities[j][0] = activities[j][0];
                    originalActivities[j][1] = activities[j][1];
                }

                int[] rem = new int[n];
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (activities[j][0] > activities[k][0]) {
                            int[] temp = activities[j];
                            activities[j] = activities[k];
                            activities[k] = temp;
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (originalActivities[j][0] == activities[k][0]) {
                            rem[j] = k;
                            break;
                        }
                    }
                }

                StringBuilder schedule = new StringBuilder("C");
                int[] cameron = {activities[0][0], activities[0][1]};
                int[] jamie = {0, 0};

                for (int j = 1; j < n; j++) {
                    if (activities[j][0] < cameron[1]) {
                        if (activities[j][0] >= jamie[1]) {
                            schedule.append("J");
                            jamie[0] = activities[j][0];
                            jamie[1] = activities[j][1];
                        } else {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            continue outerLoop;
                        }
                    } else {
                        schedule.append("C");
                        cameron[0] = activities[j][0];
                        cameron[1] = activities[j][1];
                    }
                }

                StringBuilder output = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    output.append(schedule.charAt(rem[j]));
                }
                System.out.println("Case #" + i + ": " + output);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}