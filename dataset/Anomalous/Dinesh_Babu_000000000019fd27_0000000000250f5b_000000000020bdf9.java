import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            List<int[]> jamie = new ArrayList<>();
            List<int[]> cameron = new ArrayList<>();
            StringBuilder ans = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int[] interval = {start, end};

                if (canSchedule(cameron, interval)) {
                    cameron.add(interval);
                    ans.append("C");
                } else if (canSchedule(jamie, interval)) {
                    jamie.add(interval);
                    ans.append("J");
                } else {
                    isPossible = false;
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    sc.nextLine(); // Skip the remaining intervals for this test case
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + i + ": " + ans.toString());
            }
        }
    }

    private static boolean canSchedule(List<int[]> schedule, int[] interval) {
        for (int[] existing : schedule) {
            if (!(existing[1] <= interval[0] || existing[0] >= interval[1])) {
                return false;
            }
        }
        return true;
    }
}