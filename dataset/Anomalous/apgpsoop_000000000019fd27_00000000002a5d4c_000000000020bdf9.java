import java.util.*;
import java.io.*;

public class ScheduleSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] activities = new int[n][4];

            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
                activities[i][3] = 0; // 0 means unassigned, 1 for 'C', 2 for 'J'
                scanner.nextLine();
            }

            Arrays.sort(activities, (a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            activities[0][3] = 1; // Assign first activity to 'C'
            int cEndTime = activities[0][1];
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                if (activities[i][0] >= cEndTime) {
                    activities[i][3] = 1; // Assign to 'C'
                    cEndTime = activities[i][1];
                } else if (activities[i][0] >= activities[i - 1][1]) {
                    activities[i][3] = 2; // Assign to 'J'
                    activities[i - 1][3] = 2; // Previous activity should also be 'J'
                } else {
                    possible = false;
                    break;
                }
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));

            System.out.print("Case #" + (t + 1) + ": ");
            if (possible) {
                for (int[] activity : activities) {
                    System.out.print(activity[3] == 1 ? "C" : "J");
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}