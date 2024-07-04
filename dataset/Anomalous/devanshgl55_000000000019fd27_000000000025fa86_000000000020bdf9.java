import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int q = 1; q <= t; q++) {
            System.out.print("Case #" + q + ": ");
            int n = sc.nextInt();
            List<int[]> cSchedule = new ArrayList<>();
            List<int[]> jSchedule = new ArrayList<>();
            StringBuilder ans = new StringBuilder();

            boolean possible = true;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                if (canSchedule(cSchedule, x, y)) {
                    cSchedule.add(new int[]{x, y});
                    ans.append("C");
                } else if (canSchedule(jSchedule, x, y)) {
                    jSchedule.add(new int[]{x, y});
                    ans.append("J");
                } else {
                    possible = false;
                    // Consume remaining inputs
                    for (int j = i + 1; j < n; j++) {
                        sc.nextInt();
                        sc.nextInt();
                    }
                    break;
                }
            }

            if (!possible) {
                ans = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println(ans.toString());
        }
    }

    private static boolean canSchedule(List<int[]> schedule, int start, int end) {
        for (int[] interval : schedule) {
            if (!(end <= interval[0] || start >= interval[1])) {
                return false;
            }
        }
        return true;
    }
}