import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(in.readLine());

        for (int k = 1; k <= t1; k++) {
            int n = Integer.parseInt(in.readLine());
            int[] j = new int[1441];
            int[] c = new int[1441];
            int[][] activities = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] timeRange = in.readLine().split(" ");
                activities[i][0] = Integer.parseInt(timeRange[0]);
                activities[i][1] = Integer.parseInt(timeRange[1]);
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

            StringBuilder ans = new StringBuilder();
            boolean isPossible = true;

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                boolean canAssignJ = true;
                boolean canAssignC = true;

                for (int m = start; m < end; m++) {
                    if (j[m] == 1) canAssignJ = false;
                    if (c[m] == 1) canAssignC = false;
                }

                if (!canAssignJ && !canAssignC) {
                    ans = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }

                if (canAssignJ) {
                    for (int m = start; m < end; m++) j[m] = 1;
                    ans.append("J");
                } else {
                    for (int m = start; m < end; m++) c[m] = 1;
                    ans.append("C");
                }
            }

            System.out.println("Case #" + k + ": " + ans);
        }
    }
}