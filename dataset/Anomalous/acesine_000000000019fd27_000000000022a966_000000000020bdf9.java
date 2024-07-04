import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    private void solve() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] schedule = new int[24 * 60 + 1];
            int[][] activities = new int[n][2];
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i][0] = start;
                activities[i][1] = end;

                boolean hasC = false;
                boolean hasJ = false;

                for (int k = start; k < end; k++) {
                    if (schedule[k] == 1) hasC = true;
                    if (schedule[k] == 2) hasJ = true;
                    if (schedule[k] == 3) {
                        hasC = true;
                        hasJ = true;
                    }
                }

                if (hasC && hasJ) isPossible = false;

                int assign = hasC ? 2 : 1;
                for (int k = start; k < end; k++) {
                    if (schedule[k] == 0) schedule[k] = assign;
                    else schedule[k] = 3;
                }

                result.append(assign == 1 ? 'C' : 'J');
            }

            if (!isPossible) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            } else {
                for (int i = 0; i < n; i++) {
                    int assign = result.charAt(i) == 'C' ? 1 : 2;
                    for (int k = activities[i][0]; k < activities[i][1]; k++) {
                        if (schedule[k] != assign && schedule[k] != 3) {
                            throw new RuntimeException();
                        }
                    }
                }
                System.out.println(String.format("Case #%d: %s", t, result.toString()));
            }
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}