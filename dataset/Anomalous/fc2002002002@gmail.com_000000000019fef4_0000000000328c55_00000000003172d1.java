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
        
        for (long num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxElement = Math.max(maxElement, num);
        }
        
        int minChops = D;
        
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
            
            for (int i = 2; i <= Math.min(maxElement / entry.getKey(), D); i++) {
                long multipliedKey = i * entry.getKey();
                
                if (frequencyMap.containsKey(multipliedKey)) {
                    if (slices + i < D) {
                        chops += i - 1;
                        slices += i;
                    } else if (slices + i == D) {
                        chops += i - 1;
                        slices += i;
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