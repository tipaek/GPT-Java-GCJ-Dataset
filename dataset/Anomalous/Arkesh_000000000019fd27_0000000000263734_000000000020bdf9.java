import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        if (T < 1 || T > 100) return;
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            if (N < 2 || N > 1000) return;
            
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];
            int[] indices = new int[N];
            
            for (int j = 0; j < N; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
                indices[j] = j;
                if (startTimes[j] < 0 || startTimes[j] > 1440 || endTimes[j] < 0 || endTimes[j] > 1440 || startTimes[j] > endTimes[j]) {
                    return;
                }
            }
            
            // Sort by start times
            for (int k = 0; k < N - 1; k++) {
                for (int z = k + 1; z < N; z++) {
                    if (startTimes[z] < startTimes[k]) {
                        swap(startTimes, k, z);
                        swap(endTimes, k, z);
                        swap(indices, k, z);
                    }
                }
            }
            
            char[] assignments = new char[N];
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (int j = 0; j < N; j++) {
                if (startTimes[j] >= cEnd) {
                    assignments[indices[j]] = 'C';
                    cEnd = endTimes[j];
                } else if (startTimes[j] >= jEnd) {
                    assignments[indices[j]] = 'J';
                    jEnd = endTimes[j];
                } else {
                    possible = false;
                    break;
                }
            }
            
            String result = possible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}