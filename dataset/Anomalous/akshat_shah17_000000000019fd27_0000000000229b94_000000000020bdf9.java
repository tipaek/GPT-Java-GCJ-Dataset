import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[] c = new int[1440];
            int[] j = new int[1440];
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int jIndex = 0; jIndex < n; jIndex++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean assigned = false;

                // Try to assign to Cameron
                if (canAssign(c, start, end)) {
                    schedule.append('C');
                    Arrays.fill(c, start, end, 1);
                    assigned = true;
                }

                // If not assigned to Cameron, try to assign to Jamie
                if (!assigned && canAssign(j, start, end)) {
                    schedule.append('J');
                    Arrays.fill(j, start, end, 1);
                    assigned = true;
                }

                // If neither can take the task, mark as impossible
                if (!assigned) {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
    }

    private static boolean canAssign(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k] != 0) {
                return false;
            }
        }
        return true;
    }
}