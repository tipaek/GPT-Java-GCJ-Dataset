import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int i = 0; i < testCaseCount; i++) {
            int arraySize = scanner.nextInt();
            int requiredSlices = scanner.nextInt();
            long[] array = new long[arraySize];
            
            for (int j = 0; j < arraySize; j++) {
                array[j] = scanner.nextLong();
            }
            
            int result = calculateMinChops(arraySize, requiredSlices, array);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int calculateMinChops(int arraySize, int requiredSlices, long[] array) {
        TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
        long maxElement = 0;
        
        // Populate frequency map and find the maximum element
        for (long element : array) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
            maxElement = Math.max(maxElement, element);
        }
        
        int minChops = Integer.MAX_VALUE;
        
        // Iterate through the frequency map
        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            int chops = 0;
            int slices = entry.getValue();
            
            if (slices >= requiredSlices) {
                return 0;
            }
            
            for (int i = 2; i <= maxElement / entry.getKey(); i++) {
                long multipliedKey = i * entry.getKey();
                if (frequencyMap.containsKey(multipliedKey)) {
                    if (slices + i < requiredSlices) {
                        chops += i - 1;
                        slices += i;
                    } else if (slices + i == requiredSlices) {
                        chops += i - 1;
                        slices += i;
                        break;
                    } else {
                        chops += requiredSlices - slices;
                        slices = requiredSlices;
                        break;
                    }
                }
            }
            
            if (slices < requiredSlices) {
                chops += requiredSlices - slices;
            }
            
            minChops = Math.min(minChops, chops);
        }
        
        return minChops;
    }
}