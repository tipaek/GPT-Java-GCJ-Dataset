import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int testCaseIndex = 0; testCaseIndex < testCaseCount; testCaseIndex++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            long[] array = new long[N];
            
            for (int j = 0; j < N; j++) {
                array[j] = scanner.nextLong();
            }
            
            int result = calculateMinChops(N, D, array);
            System.out.println("Case #" + (testCaseIndex + 1) + ": " + result);
        }
    }

    private static int calculateMinChops(int N, int D, long[] array) {
        TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
        long maxElement = 0;
        
        for (long element : array) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
            maxElement = Math.max(maxElement, element);
        }
        
        int minChops = D;
        
        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() >= D) {
                return 0;
            }
        }
        
        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            int chops = 0;
            int slices = entry.getValue();
            
            for (int multiplier = 2; multiplier <= maxElement / entry.getKey(); multiplier++) {
                long multipliedValue = multiplier * entry.getKey();
                
                if (frequencyMap.containsKey(multipliedValue)) {
                    if (slices + multiplier < D) {
                        chops += multiplier - 1;
                        slices += multiplier;
                    } else if (slices + multiplier == D) {
                        chops += multiplier - 1;
                        slices += multiplier;
                        break;
                    } else {
                        chops += D - slices;
                        slices = D;
                        break;
                    }
                }
            }
            
            if (slices < D) {
                chops += D - slices;
            }
            
            minChops = Math.min(minChops, chops);
        }
        
        return minChops;
    }
}