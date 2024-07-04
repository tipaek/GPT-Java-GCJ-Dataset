import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int t = input.nextInt();
            testCases: for (int i = 1; i <= t; i++) {
                int n = input.nextInt();
                int[][] activities = new int[n][2];
                int[][] originalActivities = new int[n][2];

                for (int j = 0; j < n; j++) {
                    activities[j][0] = input.nextInt();
                    activities[j][1] = input.nextInt();
                    originalActivities[j][0] = activities[j][0];
                    originalActivities[j][1] = activities[j][1];
                }

                // Sort activities based on start time
                Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

                int[] rem = new int[n];
                int y = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (originalActivities[j][0] == activities[k][0] && originalActivities[j][1] == activities[k][1]) {
                            rem[y++] = k;
                            break;
                        }
                    }
                }

                StringBuilder schedule = new StringBuilder("C");
                int[] cameron = { activities[0][0], activities[0][1] };
                int[] jamie = { 0, 0 };

                for (int j = 1; j < n; j++) {
                    if (activities[j][0] < cameron[1]) {
                        if (activities[j][0] >= jamie[1]) {
                            schedule.append("J");
                            jamie[0] = activities[j][0];
                            jamie[1] = activities[j][1];
                        } else {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            continue testCases;
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