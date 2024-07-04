import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();

        for (int z = 1; z <= t1; z++) {
            StringBuilder result = new StringBuilder();
            int n = sc.nextInt();
            int[][] cameronActivities = new int[n][2];
            int[][] jamieActivities = new int[n][2];
            int cameronCount = 0, jamieCount = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean cameronAvailable = true, jamieAvailable = true;

                // Check Cameron's schedule
                for (int h = 0; h < cameronCount; h++) {
                    if ((cameronActivities[h][1] > start && cameronActivities[h][0] <= start) ||
                        (cameronActivities[h][1] >= end && cameronActivities[h][0] < end)) {
                        cameronAvailable = false;
                        break;
                    }
                }

                // Check Jamie's schedule
                for (int h = 0; h < jamieCount; h++) {
                    if ((jamieActivities[h][1] > start && jamieActivities[h][0] <= start) ||
                        (jamieActivities[h][1] >= end && jamieActivities[h][0] < end)) {
                        jamieAvailable = false;
                        break;
                    }
                }

                if (cameronAvailable) {
                    result.append('C');
                    cameronActivities[cameronCount][0] = start;
                    cameronActivities[cameronCount][1] = end;
                    cameronCount++;
                } else if (jamieAvailable) {
                    result.append('J');
                    jamieActivities[jamieCount][0] = start;
                    jamieActivities[jamieCount][1] = end;
                    jamieCount++;
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + z + ": " + (possible ? result.toString() : "IMPOSSIBLE"));
        }

        sc.close();
    }
}