import java.util.*;

public class Solution {
    public static void solve(int caseNumber, int N, int D, long[] A) {
        Arrays.sort(A);
        long threshold = N > D ? A[A.length - D] : A[0];
        Map<Long, Integer> frequencyMap = new HashMap<>();
        
        long mode = A[0];
        int modeCount = 1;
        
        for (long value : A) {
            int count = frequencyMap.getOrDefault(value, 0) + 1;
            frequencyMap.put(value, count);
            
            if (count > modeCount && value < threshold) {
                mode = value;
                modeCount = count;
            }
        }
        
        int cutsNeeded = Math.max(0, D - modeCount);
        if (frequencyMap.getOrDefault(mode * 2, 0) > 0 && cutsNeeded > 1) {
            cutsNeeded--;
        }
        
        System.out.println("Case #" + caseNumber + ": " + cutsNeeded);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int N = input.nextInt();
            int D = input.nextInt();
            long[] A = new long[N];
            
            for (int i = 0; i < N; i++) {
                A[i] = input.nextLong();
            }
            
            solve(caseNumber, N, D, A);
        }
    }
}