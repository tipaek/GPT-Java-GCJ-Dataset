import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            List<Long> angles = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                angles.add(scanner.nextLong());
            }
            int result = calculateMinimumAdjustments(n, d, angles);

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static int calculateMinimumAdjustments(int n, int d, List<Long> angles) {
        long totalSum = angles.stream().mapToLong(Long::longValue).sum();
        angles.add(360 * 1_000_000_000L - totalSum);
        Collections.sort(angles);

        Map<Long, Integer> angleFrequency = new HashMap<>();
        int minAdjustments = 2;

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
                if (frequency == 1 && angles.size() > 2) {
                    minAdjustments = Math.min(minAdjustments, 1);
                }
                angleFrequency.put(angle, frequency + 1);
                if (angle % 2 == 0 && angleFrequency.containsKey(angle / 2)) {
                    minAdjustments = Math.min(minAdjustments, 1);
                }
            }
        }

        return (d == 2) ? 1 : minAdjustments;
    }
}