import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 1; i <= T; ++i) {
            int N = input.nextInt();
            Pair[] activities = new Pair[N];
            for (int j = 0; j < N; ++j) {
                activities[j] = new Pair(input.nextInt(), input.nextInt(), j);
            }
            String res = solve(activities);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    public static String solve(Pair[] nums) {
        char[] res = new char[nums.length];
        int cEnd = 0, jEnd = 0;
        Arrays.sort(nums, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        for (Pair activity : nums) {
            if (activity.start >= cEnd) {
                res[activity.index] = 'C';
                cEnd = activity.end;
            } else if (activity.start >= jEnd) {
                res[activity.index] = 'J';
                jEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(res);
    }

    public static class Pair {
        int start;
        int end;
        int index;

        public Pair(int a, int b, int c) {
            start = a;
            end = b;
            index = c;
        }
    }
}
