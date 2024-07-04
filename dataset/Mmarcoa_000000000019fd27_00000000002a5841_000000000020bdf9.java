import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Number of test cases.

        for (int i = 0; i < t; ++i) {

            int n = in.nextInt(); // Number of activities to assign.

            List<int[]> activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                activities.add(new int[]{s, e});
            }


            StringBuilder builder = new StringBuilder();
            String result;

            List<int[]> jActivities = new ArrayList<>();
            List<int[]> cActivities = new ArrayList<>();

            boolean jOverlaps;
            boolean cOverlaps = false;

            checkActivities:
            for (int[] activity : activities) {

                jOverlaps = false;

                for (int[] jActivity : jActivities) {
                    if (overlaps(activity, jActivity)) {
                        jOverlaps = true;
                        break;
                    }
                }

                cOverlaps = false;
                if (jOverlaps) {
                    for (int[] cActivity : cActivities) {
                        if (overlaps(activity, cActivity)) {
                            cOverlaps = true;
                            break checkActivities;
                        }
                    }
                    cActivities.add(activity);
                    builder.append("J");
                } else {
                    jActivities.add(activity);
                    builder.append("C");
                }
            }

            if (cOverlaps)
                result = "IMPOSSIBLE";
            else
                result = builder.toString();

            System.out.printf("Case #%d: %s\n", i + 1, result);
        }

        in.close();
    }

    private static boolean overlaps(int[] activity, int[] partnerActivity) {
        boolean overlaps = false;

        int s1 = activity[0];
        int s2 = partnerActivity[0];
        int e1 = activity[1];
        int e2 = partnerActivity[1];

        if ((s2 <= s1 && s1 < e2) || (s1 <= s2 && s2 < e1)) {
            overlaps = true;
        }

        return overlaps;
    }
}
