import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            long[] array = new long[N];
            
            for (int j = 0; j < N; j++) {
                array[j] = scanner.nextLong();
            }
            
            int result = calculateMinChops(N, D, array);
            System.out.println("Case #" + (t + 1) + ": " + result);
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
        
        int minimumChops = D;
        
        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            int chops = 0;
            int slices = entry.getValue();
            
            if (slices >= D) {
                return 0;
            }
            
            for (int i = 2; i <= maxElement / entry.getKey(); i++) {
                if (frequencyMap.containsKey(i * entry.getKey())) {
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
            
            minimumChops = Math.min(minimumChops, chops);
        }
        
        return minimumChops;
    }
}