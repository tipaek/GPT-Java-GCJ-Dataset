import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    private void solve() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] schedule = new int[24 * 60 + 1];
            int[] count = new int[schedule.length];
            boolean possible = true;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean hasCameron = false;
                boolean hasJamie = false;

                for (int k = start; k < end; k++) {
                    count[k]++;
                    if (schedule[k] == 1) hasCameron = true;
                    if (schedule[k] == 2) hasJamie = true;
                    if (schedule[k] == 3) {
                        hasCameron = true;
                        hasJamie = true;
                    }
                }

                if (hasCameron && hasJamie) possible = false;

                int assignment = hasCameron ? 2 : 1;
                for (int k = start; k < end; k++) {
                    if (schedule[k] == 0) schedule[k] = assignment;
                    else schedule[k] = 3;
                }

                result.append(assignment == 1 ? 'C' : 'J');
            }

            if (!possible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            } else {
                for (int i = 0; i < count.length; i++) {
                    if (count[i] >= 3) throw new RuntimeException();
                }
                System.out.printf("Case #%d: %s%n", t, result);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}