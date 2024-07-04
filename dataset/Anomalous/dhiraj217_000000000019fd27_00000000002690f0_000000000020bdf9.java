import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int currentT = 1; currentT <= T; currentT++) {
            int numActivities = sc.nextInt();
            int[][] activities = new int[numActivities][2];
            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = sc.nextInt();
                activities[i][1] = sc.nextInt();
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            StringBuilder result = new StringBuilder();
            int CEndTime = 0, JEndTime = 0;
            boolean isImpossible = false;

            for (int[] activity : activities) {
                if (CEndTime <= activity[0]) {
                    result.append('C');
                    CEndTime = activity[1];
                } else if (JEndTime <= activity[0]) {
                    result.append('J');
                    JEndTime = activity[1];
                } else {
                    isImpossible = true;
                    System.out.println("Case #" + currentT + ": IMPOSSIBLE");
                    break;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + currentT + ": " + result);
            }
        }
    }
}