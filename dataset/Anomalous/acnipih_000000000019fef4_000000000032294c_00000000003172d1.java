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
            for (int j = 0; j < n; j++) {
                angles[j] = scanner.nextLong();
            }
            int result = calculateMinRotations(n, d, angles);

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static int calculateMinRotations(int n, int d, long[] angles) {
        Arrays.sort(angles);
        Map<Long, Integer> angleCountMap = new HashMap<>();
        int minRotations = 2;

        for (int i = 0; i < n; i++) {
            long currentAngle = angles[i];
            int count = angleCountMap.getOrDefault(currentAngle, 0);

            if (d == 2) {
                if (count > 0) return 0;
                angleCountMap.put(currentAngle, count + 1);
            } else if (d == 3) {
                if (count == 2) return 0;
                if (count == 1 && n > 2) minRotations = Math.min(minRotations, 1);
                angleCountMap.put(currentAngle, count + 1);
                if (angleCountMap.containsKey(currentAngle / 2)) minRotations = Math.min(minRotations, 1);
            }
        }

        if (d == 2) return 1;
        return minRotations;
    }
}