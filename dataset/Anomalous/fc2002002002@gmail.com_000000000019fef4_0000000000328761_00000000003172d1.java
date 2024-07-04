import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            long[] array = new long[N];
            for (int j = 0; j < N; j++) {
                array[j] = scanner.nextLong();
            }
            int result = calculateMinChops(N, D, array);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        scanner.close();
    }

    private static int calculateMinChops(int N, int D, long[] array) {
        TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
        long maxElement = 0;
        for (long value : array) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
            maxElement = Math.max(maxElement, value);
        }

        int minChops = D;
        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            int currentChops = 0;
            int slices = entry.getValue();
            if (slices >= D) return 0;

            for (int i = 2; i <= Math.min(maxElement / entry.getKey(), D); i++) {
                if (frequencyMap.containsKey(i * entry.getKey())) {
                    if (slices + i < D) {
                        currentChops += i - 1;
                        slices += i;
                    } else if (slices + i == D) {
                        currentChops += i - 1;
                        slices += i;
                        break;
                    } else {
                        currentChops += D - slices;
                        slices = D;
                        break;
                    }
                }
            }

            if (slices < D) {
                currentChops += D - slices;
            }

            minChops = Math.min(minChops, currentChops);
        }
        return minChops;
    }
}