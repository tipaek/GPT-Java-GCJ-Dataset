import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + helper(in));
        }
    }

    private static String helper(Scanner in) {
        int cnt = in.nextInt();
        int[][] activities = new int[cnt][3];

        for (int i = 0; i < cnt; i++) {
            activities[i][0] = in.nextInt();
            activities[i][1] = in.nextInt();
            activities[i][2] = i;
        }

        Arrays.sort(activities, (a, b) -> {
            return a[0] - b [0];
        });

        char[] ans = new char[cnt];

        int cend = 0, jend = 0;

        for (int[] activity : activities) {
            if (activity[0] >= cend) {
                ans[activity[2]] = 'C';
                cend = activity[1];
            } else if (activity[0] >= jend) {
                ans[activity[2]] = 'J';
                jend = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(ans);
    }
}