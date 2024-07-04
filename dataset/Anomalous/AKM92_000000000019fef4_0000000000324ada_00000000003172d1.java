import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); // Number of test cases
        
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt(); // Number of elements
            int D = sc.nextInt(); // Desired frequency
            int min = D - 1; // Initialize minimum operations
            long[] arr = new long[N]; // Array to store elements
            Map<Long, Integer> frequencyMap = new HashMap<>(); // Map to store frequencies
            
            for(int j = 0; j < N; j++) {
                long element = sc.nextLong();
                int frequency = frequencyMap.getOrDefault(element, 0) + 1;
                frequencyMap.put(element, frequency);
                arr[j] = element;
                
                if(frequency >= D) {
                    min = 0; // If frequency already meets or exceeds D, no operations needed
                }
            }
            
            if(D == 3) {
                for(int j = 0; j < N; j++) {
                    long element = arr[j];
                    int doubleFrequency = frequencyMap.getOrDefault(element * 2, 0);
                    if(doubleFrequency > 0) {
                        min = 1; // If there's an element that can pair to meet the frequency D, set min to 1
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + min);
        }
    }
}