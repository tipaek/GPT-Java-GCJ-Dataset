import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            int minOperations = D - 1;
            long[] numbers = new long[N];
            Map<Long, Integer> frequencyMap = new HashMap<>();
            
            for (int j = 0; j < N; j++) {
                long number = scanner.nextLong();
                int count = frequencyMap.getOrDefault(number, 0);
                count++;
                frequencyMap.put(number, count);
                numbers[j] = number;
                
                if (count >= D) {
                    minOperations = 0;
                }
                
                if (D == 3 && minOperations > 1) {
                    int doubleCount = frequencyMap.getOrDefault(number * 2, 0);
                    int halfCount = 0;
                    if (number % 2 == 0) {
                        halfCount = frequencyMap.getOrDefault(number / 2, 0);
                    }
                    if (doubleCount > 0 || halfCount > 0) {
                        minOperations = 1;
                    }
                }
            }
            
            System.out.println("Case #" + (testCase + 1) + ": " + minOperations);
        }
        
        scanner.close();
    }
}