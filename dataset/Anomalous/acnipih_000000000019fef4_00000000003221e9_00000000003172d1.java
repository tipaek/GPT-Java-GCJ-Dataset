import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] angles = new long[n];
            for (int j = 0; j < n; j++) {
                angles[j] = scanner.nextLong();
            }
            int result = solve(n, d, angles);

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static int solve(int n, int d, long[] angles) {
        Arrays.sort(angles);
        Map<Long, Integer> angleFrequency = new HashMap<>();
        int result = 2;

        for (long angle : angles) {
            if (d == 2) {
                if (angleFrequency.containsKey(angle)) {
                    return 0;
                }
                angleFrequency.put(angle, angleFrequency.getOrDefault(angle, 0) + 1);
            } else if (d == 3) {
                int frequency = angleFrequency.getOrDefault(angle, 0);
                if (frequency == 2) {
                    return 0;
                }
                if (frequency == 1) {
                    result = Math.min(result, 1);
                }
                angleFrequency.put(angle, frequency + 1);
                if (angleFrequency.containsKey(angle / 2)) {
                    result = Math.min(result, 1);
                }
            }
        }
        
        return d == 2 ? 1 : result;
    }
}