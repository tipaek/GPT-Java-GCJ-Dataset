import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] angles = new long[n];
            for (int i = 0; i < n; i++) {
                angles[i] = scanner.nextLong();
            }
            int result = findMinimumChanges(n, d, angles);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static int findMinimumChanges(int n, int d, long[] angles) {
        Arrays.sort(angles);
        Map<Long, Integer> angleCount = new HashMap<>();
        int minChanges = 2;

        for (int i = 0; i < n; i++) {
            long angle = angles[i];
            int count = angleCount.getOrDefault(angle, 0);

            if (d == 2) {
                if (angleCount.containsKey(angle)) {
                    return 0;
                }
                angleCount.put(angle, count + 1);
            } else if (d == 3) {
                if (count == 2) {
                    return 0;
                }
                if (count == 1 && n > 2) {
                    minChanges = Math.min(minChanges, 1);
                }
                angleCount.put(angle, count + 1);

                if (angle % 2 == 0 && angleCount.containsKey(angle / 2)) {
                    minChanges = Math.min(minChanges, 1);
                }
            }
        }

        return d == 2 ? 1 : minChanges;
    }
}