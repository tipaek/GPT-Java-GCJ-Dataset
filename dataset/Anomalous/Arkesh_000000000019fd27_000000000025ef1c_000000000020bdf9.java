import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        if (T < 1 || T > 100) {
            return;
        }

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            if (N < 2 || N > 1000) {
                return;
            }

            int[] startTimes = new int[N];
            int[] endTimes = new int[N];
            for (int j = 0; j < N; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
                if (startTimes[j] < 0 || startTimes[j] > 1440 || endTimes[j] < 0 || endTimes[j] > 1440 || startTimes[j] > endTimes[j]) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    continue;
                }
            }

            // Sorting activities by start time
            int[] sortedIndices = new int[N];
            for (int j = 0; j < N; j++) {
                sortedIndices[j] = j;
            }
            Arrays.sort(sortedIndices, (a, b) -> Integer.compare(startTimes[a], startTimes[b]));

            int C_end = 0;
            int J_end = 0;
            char[] schedule = new char[N];

            boolean possible = true;
            for (int j : sortedIndices) {
                if (startTimes[j] >= C_end) {
                    schedule[j] = 'C';
                    C_end = endTimes[j];
                } else if (startTimes[j] >= J_end) {
                    schedule[j] = 'J';
                    J_end = endTimes[j];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}