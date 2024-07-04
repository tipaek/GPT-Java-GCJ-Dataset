import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; ++t) {
            int[] scheduleC = new int[60 * 24 + 1];
            int[] scheduleJ = new int[60 * 24 + 1];
            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int n = 1; n <= activities; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (isAvailable(scheduleC, start, end)) {
                    assign(scheduleC, start, end, n);
                } else if (isAvailable(scheduleJ, start, end)) {
                    assign(scheduleJ, start, end, n);
                } else {
                    result.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                Set<Integer> setC = new HashSet<>();
                for (int i : scheduleC) {
                    setC.add(i);
                }
                Set<Integer> setJ = new HashSet<>();
                for (int i : scheduleJ) {
                    setJ.add(i);
                }
                for (int i = 1; i <= activities; i++) {
                    if (setC.contains(i)) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
            }
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void assign(int[] schedule, int start, int end, int activity) {
        for (int i = start; i < end; i++) {
            schedule[i] = activity;
        }
    }
}