import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Parenting Partnering Returns
public class Solution {

    public static String solve(int[][] activities, int n) {
        ArrayList<Integer> activityIds = new ArrayList<>();
        char[] assigned = new char[n]; // C or J
        int lastActEndC = 0, lastActEndJ = 0;
        for (int i = 0; i < n; ++i) {
            activityIds.add(i);
        }

        Collections.sort(activityIds, (i1, i2) -> activities[i1][0] == activities[i2][0]? activities[i1][1] - activities[i2][1] : activities[i1][0] - activities[i2][0]);
        for (int id: activityIds) {
            int s = activities[id][0], t = activities[id][1];
            if (lastActEndC <= s) {
                assigned[id] = 'C';
                lastActEndC = t;
            } else if (lastActEndJ <= s) {
                assigned[id] = 'J';
                lastActEndJ = t;
            } else {
                return "";
            }
        }
        return new String(assigned);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        // System.out.println("num of case: " + t);
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] activities = new int[n][2];

            for (int j = 0; j < n; ++j) {
                activities[j][0]= in.nextInt();
                activities[j][1] = in.nextInt();
            }

            String ans = solve(activities, n);
            if (ans.isEmpty()) {
                ans = "IMPOSSIBLE";
            }
            System.out.print(String.format("Case #%d: %s\n", i, ans));
        }
    }
}