import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            handleTestCase();
        }
    }

    private static void handleTestCase() {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        double[] slices = new double[n];
        Map<Double, Integer> sliceCount = new HashMap<>();
        int maxSlices = 1;

        for (int i = 0; i < n; i++) {
            slices[i] = scanner.nextDouble();
            sliceCount.put(slices[i], sliceCount.getOrDefault(slices[i], 0) + 1);
            maxSlices = Math.max(maxSlices, sliceCount.get(slices[i]));
        }

        if (maxSlices >= d) {
            System.out.println(0);
        } else if (d == 2 || maxSlices == 2) {
            System.out.println(1);
        } else {
            if (hasMatchingPairs(slices)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }

    private static boolean hasMatchingPairs(double[] slices) {
        int n = slices.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (slices[i] == slices[j] / 2 || slices[i] == slices[j] * 2) {
                    return true;
                }
            }
        }
        return false;
    }
}