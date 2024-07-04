import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 1; i <= T; ++i) {
            int N = input.nextInt();
            int[][] activities = new int[N][2];
            for (int j = 0; j < N; ++j) {
                activities[j][0] = input.nextInt();
                activities[j][1] = input.nextInt();
            }
            String res = solve(activities);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    public static String solve(int[][] nums) {
        StringBuilder sb = new StringBuilder();
        int cEnd = 0, jEnd = 0;
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] activity : nums) {
            if (activity[0] >= cEnd) {
                sb.append("C");
                cEnd = activity[1];
            } else if (activity[0] >= jEnd) {
                sb.append("J");
                jEnd = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }
}