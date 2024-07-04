import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int t = input.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = input.nextInt();
                int[][] activities = new int[n][2];
                int[][] originalOrder = new int[n][2];
                int[] rem = new int[n];

                for (int j = 0; j < n; j++) {
                    activities[j][0] = input.nextInt();
                    activities[j][1] = input.nextInt();
                    originalOrder[j][0] = activities[j][0];
                    originalOrder[j][1] = activities[j][1];
                }

                Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (originalOrder[j][0] == activities[k][0] && originalOrder[j][1] == activities[k][1]) {
                            rem[j] = k;
                            break;
                        }
                    }
                }

                StringBuilder schedule = new StringBuilder("C");
                int[] c = {activities[0][0], activities[0][1]};
                int[] j = {0, 0};

                boolean possible = true;
                for (int idx = 1; idx < n && possible; idx++) {
                    if (activities[idx][0] >= c[1]) {
                        schedule.append("C");
                        c[0] = activities[idx][0];
                        c[1] = activities[idx][1];
                    } else if (activities[idx][0] >= j[1]) {
                        schedule.append("J");
                        j[0] = activities[idx][0];
                        j[1] = activities[idx][1];
                    } else {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        possible = false;
                    }
                }

                if (possible) {
                    char[] result = new char[n];
                    for (int idx = 0; idx < n; idx++) {
                        result[rem[idx]] = schedule.charAt(idx);
                    }
                    System.out.println("Case #" + i + ": " + new String(result));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}