import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int x = 1; x <= T; x++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            long[] A = new long[N];
            
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextLong();
            }
            
            int result = calculateResult(N, D, A);
            System.out.println("Case #" + x + ": " + result);
        }
    }
    
    private static int calculateResult(int N, int D, long[] A) {
        int result = -1;
        
        if (D == 2) {
            result = checkPairs(N, A);
        } else if (D == 3) {
            result = checkTriplets(N, A);
            if (result == -1) {
                result = checkPairsWithDivisibility(N, A);
            }
        }
        
        if (result == -1) {
            result = D == 2 ? 1 : 2;
        }
        
        return result;
    }
    
    private static int checkPairs(int N, long[] A) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] == A[j]) {
                    return 0;
                }
            }
        }
        return -1;
    }
    
    private static int checkTriplets(int N, long[] A) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (A[i] == A[j] && A[j] == A[k]) {
                        return 0;
                    }
                }
            }
        }
        return -1;
    }
    
    private static int checkPairsWithDivisibility(int N, long[] A) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] != A[j] && (A[i] % A[j] == 0 || A[j] % A[i] == 0)) {
                    return 1;
                }
            }
        }
        return -1;
    }
}