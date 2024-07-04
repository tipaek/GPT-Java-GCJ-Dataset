import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int currentT = 1;
        while(currentT <= T) {
            int numActivities = sc.nextInt();
            int[][] activities = new int[numActivities][2];
            for (int i=0; i < numActivities; i++) {
                activities[i][0] = sc.nextInt();
                activities[i][1] = sc.nextInt();
            }

            Arrays.sort(activities, (a, b) -> {
                return a[0] - b[0];
            });

            StringBuilder result = new StringBuilder("");
            int CEndTime = 0;
            int JEndTime = 0;
            boolean isImpossible = false;
            for (int i=0; i < numActivities; i++) {
                if (CEndTime <= activities[i][0]) {
                    result.append('C');
                    CEndTime = activities[i][1];
                } else if (JEndTime <= activities[i][0]) {
                    result.append('J');
                    JEndTime = activities[i][1];
                } else {
                    isImpossible = true;
                    System.out.println("Case #" + currentT++ + ": " + "IMPOSSIBLE");
                    break;
                }
            }
            if (!isImpossible) {
                System.out.println("Case #" + currentT++ + ": " + result);
            }
        }
    }
}
