import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int t = input.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = input.nextInt();
                int[][] activities = new int[n][2];
                int[][] originalActivities = new int[n][2];
                int[] rem = new int[n];

                for (int j = 0; j < n; j++) {
                    activities[j][0] = input.nextInt();
                    activities[j][1] = input.nextInt();
                    originalActivities[j][0] = activities[j][0];
                    originalActivities[j][1] = activities[j][1];
                }

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
                int[] c = {activities[0][0], activities[0][1]};
                int[] jActivity = {0, 0};

                boolean impossible = false;
                for (int j = 1; j < n; j++) {
                    if (activities[j][0] < c[1]) {
                        if (activities[j][0] >= jActivity[1]) {
                            schedule.append("J");
                            jActivity[0] = activities[j][0];
                            jActivity[1] = activities[j][1];
                        } else {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                    } else {
                        schedule.append("C");
                        c[0] = activities[j][0];
                        c[1] = activities[j][1];
                    }
                }

                if (!impossible) {
                    StringBuilder output = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        output.append(schedule.charAt(rem[j]));
                    }
                    System.out.println("Case #" + i + ": " + output);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            input.close();
        }
    }
}