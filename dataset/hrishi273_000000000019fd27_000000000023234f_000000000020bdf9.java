
import java.util.*;

public class Solution {
    private static final char[] parents = new char[] {'C', 'J'};

    public static String getSchedule(int[][] activities) {
        Arrays.sort(activities, (int[] a, int[] b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        char[] retval = new char[activities.length];

        int[] overlapCount = new int[2];
        int[] end = new int[2];

        int parentIndex = 0;
        retval[activities[0][2]] = parents[parentIndex];
        end[parentIndex] = activities[0][1];

        //System.out.println(Arrays.toString(end) + " " + activities[0][0] + " " + activities[0][1] + " " + parentIndex + " " + Arrays.toString(overlapCount));
        for (int i = 1; i < activities.length; i++) {
            int k = 2;
            while (k-- != 0) {
                if (end[parentIndex] > activities[i][0]) {
                    overlapCount[parentIndex]++;
                    parentIndex = (parentIndex + 1) % parents.length;
                } else {
                    overlapCount[parentIndex] = 0;
                    break;
                }
            }

            for (int j = 0; j < parents.length; j++)
                if (overlapCount[j] == 2)
                    return "IMPOSSIBLE";

            retval[activities[i][2]] = parents[parentIndex];
            end[parentIndex] = activities[i][1];

            //System.out.println(Arrays.toString(end) + " " + activities[i][0] + " " + activities[i][1] + " " + parentIndex + " " + Arrays.toString(overlapCount));

        }

        return new String(retval);
    }

    public static void main(String[] args) {
        int t, n;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            int[][] activities = new int[n][3];

            for (int i = 0; i < n; i++) {
                activities[i][0] = sc.nextInt();
                activities[i][1] = sc.nextInt();
                activities[i][2] = i;
            }

            System.out.println("Case #" + tc + ": " + getSchedule(activities));
        }
    }
}