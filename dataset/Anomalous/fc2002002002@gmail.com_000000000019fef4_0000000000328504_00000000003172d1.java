import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            long[] array = new long[N];
            
            for (int index = 0; index < N; index++) {
                array[index] = scanner.nextLong();
            }
            
            int result = calculateMinimumChops(N, D, array);
            System.out.println("Case #" + (testCase + 1) + ": " + result);
        }
    }

    private static int calculateMinimumChops(int N, int D, long[] array) {
        TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
        long maxElement = 0;
        
        for (long element : array) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
            maxElement = Math.max(maxElement, element);
        }
        
        int minimumChops = D;
        
        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            int chops = 0;
            int slices = entry.getValue();
            
            if (slices >= D) {
                return 0;
            }
        }
        
        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            int chops = 0;
            int slices = entry.getValue();
            
            for (int i = 2; i <= Math.min(maxElement / entry.getKey(), D - slices); i++) {
                if (frequencyMap.containsKey(i * entry.getKey())) {
                    if (slices + i < D) {
                        chops += (i - 1);
                        slices += i;
                    } else if (slices + i == D) {
                        chops += (i - 1);
                        slices += i;
                        break;
                    } else {
                        chops += (D - slices);
                        slices = D;
                        break;
                    }
                }
            }
            
            if (slices < D) {
                chops += (D - slices);
            }
            
            minimumChops = Math.min(minimumChops, chops);
        }
        
        return minimumChops;
    }
}