import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(in.readLine());

        for (int k = 1; k <= t1; k++) {
            int n = Integer.parseInt(in.readLine());
            int[] j = new int[1441];
            int[] c = new int[1441];
            int[][] activities = new int[n][2];

            Arrays.fill(j, 0);
            Arrays.fill(c, 0);

            for (int i = 0; i < n; i++) {
                String[] input = in.readLine().split(" ");
                activities[i][0] = Integer.parseInt(input[0]);
                activities[i][1] = Integer.parseInt(input[1]);
            }

            StringBuilder ans = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = activities[i][0];
                int end = activities[i][1];
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int m = start; m < end; m++) {
                    if (j[m] == 1) canAssignJ = false;
                    if (c[m] == 1) canAssignC = false;
                }

                if (!canAssignC && !canAssignJ) {
                    ans.setLength(0);
                    ans.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }

                if (canAssignJ) {
                    Arrays.fill(j, start, end, 1);
                    ans.append("J");
                } else {
                    Arrays.fill(c, start, end, 1);
                    ans.append("C");
                }
            }

            System.out.println("Case #" + k + ": " + ans.toString());
        }
    }
}